package com.microservices.microservices.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.microservices.bean.HelloWorld;

@RestController
public class MicroservicesController {
	
	@RequestMapping("/hello-world")
	public String helloWorld()
	{
		return "Hello word !";
	}

	@RequestMapping("/hello-world-bean")
	public HelloWorld getHelloWorldBean()
	{
		return new HelloWorld("Testing The Rest Call");
	}
	
	@RequestMapping("/hello-world-bean/{name}")
	public HelloWorld getHelloWorldBean(@PathVariable("name") String name)
	{
		return new HelloWorld("Hello "+name);
	}
	
}
