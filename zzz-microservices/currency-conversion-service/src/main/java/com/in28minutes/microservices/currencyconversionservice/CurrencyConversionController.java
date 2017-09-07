package com.in28minutes.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CurrencyConversionController {

	@Autowired
	CurrencyExchangeServiceProxy proxy;

	@HystrixCommand(fallbackMethod="getDefaultConversionResponse")
	@GetMapping("/currency-converter-direct/from/{from}/to/{to}/amount/{amount}")
	public CurrencyConversionBean conversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal amount) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}",
				CurrencyConversionBean.class, uriVariables);

		return new CurrencyConversionBean(responseEntity.getBody().getId(),from, to, amount, responseEntity.getBody().getInputAmount().multiply(amount));
	}
	
	public CurrencyConversionBean getDefaultConversionResponse(String from, String to,
			 BigDecimal amount){
		return new CurrencyConversionBean(0L,from, to, BigDecimal.ONE, BigDecimal.ONE.multiply(amount));
	}

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/amount/{amount}")
	public CurrencyConversionBean conversionFeign(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("amount") BigDecimal amount) {
		CurrencyConversionBean result = proxy.findByCurrencyFromAndCurrencyTo(from, to);

		return new CurrencyConversionBean(result.getId(),from, to, amount, result.getInputAmount().multiply(amount));
	}

}
