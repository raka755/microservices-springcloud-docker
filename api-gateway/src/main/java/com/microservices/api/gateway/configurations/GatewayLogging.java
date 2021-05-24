package com.microservices.api.gateway.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class GatewayLogging  implements GlobalFilter{

	private Logger logger = LoggerFactory.getLogger(GatewayLogging.class);
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		logger.info("Request from : "+exchange.getRequest().getPath());
		
		return chain.filter(exchange);
	}

}
