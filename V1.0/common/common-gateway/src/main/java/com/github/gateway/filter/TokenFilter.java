package com.github.gateway.filter;

import java.net.URI;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class TokenFilter implements GlobalFilter, Ordered {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("--------------------------------------------------<Log In TokenFilter Start>--------------------------------------------------");
		ServerHttpRequest request = exchange.getRequest();
		MultiValueMap<String, String> queryParams = request.getQueryParams();
		String token = queryParams.getFirst("token");
		log.info("token: " + token);
		if (token == null || token.isEmpty()) {
			exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
			return exchange.getResponse().setComplete();
		}
		log.info("--------------------------------------------------<Log In TokenFilter End>--------------------------------------------------");
		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		return 2;
	}

}
