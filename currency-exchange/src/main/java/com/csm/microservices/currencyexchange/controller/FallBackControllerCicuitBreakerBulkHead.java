package com.csm.microservices.currencyexchange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class FallBackControllerCicuitBreakerBulkHead {
	
	Logger logger = LoggerFactory.getLogger(FallBackControllerCicuitBreakerBulkHead.class);
	@GetMapping("/fallback-check-bulkhead")
	//@CircuitBreaker(name = "default",fallbackMethod = "hardCodeResponse")
//	@Bulkhead(name="default")
	@RateLimiter(name="default")
	public String getFallbackResponse() 
	{
		logger.info("Api calling.");
		/*
		 * ResponseEntity<String> response = new
		 * RestTemplate().getForEntity("http://localhost:0909/kill", String.class);
		 * return response.getBody();
		 */
		return "Responded";
	}
	
	public String hardCodeResponse(Exception e)
	{
		return "fallback-resaponse-after retrying";
	}
	

}
