package com.currency.conversion.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.currency.conversion.bean.CurrencyConversion;
import com.currency.conversion.service.CurrencyExchangeProxy;


@RestController
public class CurrencyConversionController {

	/*
	 * @Autowired Environment env;
	 */
	
	@GetMapping("/getConversionCurrency/{from}/to/{to}/{quantity}")
	public CurrencyConversion getConversionCurrency(@PathVariable String from,
			@PathVariable String to, @PathVariable Integer quantity)
	{
		//String property = env.getProperty("local.server.port");
		Map<String,String> data = new HashMap<String,String>();
		data.put("from", from);
		data.put("to", to);
		ResponseEntity<CurrencyConversion> response = new RestTemplate().getForEntity("http://localhost:8000/exchange/{from}/to/{to}", CurrencyConversion.class,data);
		CurrencyConversion cc = response.getBody();
		//cc.setEnvironment(property);
		cc.setQuantity(new BigDecimal(quantity));
		cc.setTotalCalculateAmount(cc.getQuantity().multiply(cc.getRate()));
		
		return cc;
	}
	
	@Autowired
	CurrencyExchangeProxy currencyExchangeService;
	@GetMapping("/getConversionCurrencyFeign/{from}/to/{to}/{quantity}")
	public CurrencyConversion getConversionCurrencyFeign(@PathVariable String from,
			@PathVariable String to, @PathVariable Integer quantity)
	{
//		String property = env.getProperty("local.server.port");
		CurrencyConversion cc = currencyExchangeService.getExchangeValue(from, to);
		cc.setQuantity(new BigDecimal(quantity));
		cc.setTotalCalculateAmount(cc.getQuantity().multiply(cc.getRate()));
		
		return cc;
	}
	
}
