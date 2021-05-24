package com.csm.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csm.microservices.bean.Limits;
import com.csm.microservices.configurations.LimitConfiguration;

@RestController
public class LimitiController {

	@Autowired
	private LimitConfiguration limitConfiguiration;
	
	@GetMapping("/limits")
	public Limits getLimits()
	{
		return new Limits(limitConfiguiration.getMinimum(),limitConfiguiration.getMaximum());
	}
}
