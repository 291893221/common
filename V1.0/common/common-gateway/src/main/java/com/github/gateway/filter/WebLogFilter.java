package com.github.gateway.filter;

import java.net.URI;
import java.util.Arrays;
import java.util.Set;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class WebLogFilter implements GlobalFilter, Ordered {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("--------------------------------------------------<Log In WebLogFilter Start>--------------------------------------------------");
		ServerHttpRequest request = exchange.getRequest();
		URI uri = request.getURI();
		log.info("uri: " + uri);
		HttpHeaders headers = request.getHeaders();
		Set<String> keySet = headers.keySet();
		log.info(""+keySet.size());
		MultiValueMap<String, String> queryParams = request.getQueryParams();
		// 记录下请求内容
		queryParams.forEach((k, v) -> {
			log.info(k + ": " + v);
		});
		log.info("--------------------------------------------------<Log In WebLogFilter End>--------------------------------------------------");
		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		return 1;
	}

}
