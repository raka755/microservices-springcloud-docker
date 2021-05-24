package com.currency.conversion.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.currency.conversion.bean.CurrencyConversion;

@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {

	@GetMapping("/exchange/{from}/to/{to}")
	public CurrencyConversion getExchangeValue(@PathVariable String from,@PathVariable String to);
}
