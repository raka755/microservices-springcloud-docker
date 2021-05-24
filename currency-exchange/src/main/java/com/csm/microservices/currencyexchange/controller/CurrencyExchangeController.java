package com.csm.microservices.currencyexchange.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.csm.microservices.currencyexchange.bean.CurrencyExchange;
import com.csm.microservices.currencyexchange.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	Environment env;
	// if more than one currency exchange is runnimg, to identify from which port the data is comming
	
	@Autowired
	CurrencyExchangeRepository exchangeRepo;
	
	@GetMapping("/exchange/{from}/to/{to}")
	public CurrencyExchange getExchangeValue(@PathVariable String from,@PathVariable String to)
	{
		String property = env.getProperty("local.server.port");
		//new CurrencyExchange(from,to,new BigDecimal(60.89),200L,property)
		CurrencyExchange ce = exchangeRepo.findByFromAndTo(from, to);
		ce.setProperty(property); 
		return ce;
	}
}
