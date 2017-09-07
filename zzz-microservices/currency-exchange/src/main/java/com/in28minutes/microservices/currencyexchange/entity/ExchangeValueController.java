package com.in28minutes.microservices.currencyexchange.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeValueController {

	@Autowired
	ExchangeValueRepository repository;

	@Autowired
	Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue exchangeService(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = repository.findByCurrencyFromAndCurrencyTo(Currency.valueOf(from), Currency.valueOf(to));
		exchangeValue.setId(Long.parseLong(environment.getProperty("local.server.port")));
		return exchangeValue;
	}

}
