package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	//@RequestMapping(method=RequestMethod.GET, value = "/currency-exchange/from/{from}/to/{to}")
	@RequestMapping(method=RequestMethod.GET, value = "/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	CurrencyConversionBean findByCurrencyFromAndCurrencyTo(@PathVariable("from") String from,
			@PathVariable("to") String to);
}