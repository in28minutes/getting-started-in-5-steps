package com.in28minutes.microservices.currencyexchange.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	ExchangeValue findByCurrencyFromAndCurrencyTo(Currency from, Currency to);
}