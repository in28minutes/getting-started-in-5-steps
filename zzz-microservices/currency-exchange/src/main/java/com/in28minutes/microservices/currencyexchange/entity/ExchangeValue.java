package com.in28minutes.microservices.currencyexchange.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class ExchangeValue {
	
	@Id
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Currency currencyFrom;
	
	@Enumerated(EnumType.STRING)
	private Currency currencyTo;

	private BigDecimal inputAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Currency getCurrencyFrom() {
		return currencyFrom;
	}

	public void setCurrencyFrom(Currency currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	public Currency getCurrencyTo() {
		return currencyTo;
	}

	public void setCurrencyTo(Currency currencyTo) {
		this.currencyTo = currencyTo;
	}

	public BigDecimal getInputAmount() {
		return inputAmount;
	}

	public void setInputAmount(BigDecimal inputAmount) {
		this.inputAmount = inputAmount;
	}
}
