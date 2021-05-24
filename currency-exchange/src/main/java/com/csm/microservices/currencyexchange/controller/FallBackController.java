package com.csm.microservices.currencyexchange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class FallBackController {
	
	Logger logger = LoggerFactory.getLogger(FallBackController.class);
	@GetMapping("/fallback-check")
	@Retry(name = "fallback-check",fallbackMethod = "hardCodeResponse")
	public String getFallbackResponse() 
	{
		logger.info("Api calling.");
		ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:0909/kill", String.class);
		return response.getBody();
	}
	
	public String hardCodeResponse(Exception e)
	{
		return "fallback-resaponse-after retrying";
	}
	

}
