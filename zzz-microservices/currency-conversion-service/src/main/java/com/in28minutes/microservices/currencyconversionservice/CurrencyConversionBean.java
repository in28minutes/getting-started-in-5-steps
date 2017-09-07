package com.in28minutes.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversionBean {
	private String fromCurrency;
	private String toCurrency;
	private BigDecimal inputAmount;
	private BigDecimal outputAmount;
	private Long id;

	public CurrencyConversionBean() {
		
	}
	
	public CurrencyConversionBean(Long id,String from, String to, BigDecimal inputValue, BigDecimal outputValue) {
		super();
		this.id = id;
		this.fromCurrency = from;
		this.toCurrency = to;
		this.inputAmount = inputValue;
		this.outputAmount = outputValue;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public BigDecimal getInputAmount() {
		return inputAmount;
	}

	public BigDecimal getOutputAmount() {
		return outputAmount;
	}

	public Long getId() {
		return id;
	}
}
