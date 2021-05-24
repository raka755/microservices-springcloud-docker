package com.csm.microservices.currencyexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.csm.microservices.currencyexchange.bean.CurrencyExchange;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	@Query("FROM CurrencyExchange where cFrom =?1 and cTo= ?2")
	CurrencyExchange findByFromAndTo(String from,String to);
}
