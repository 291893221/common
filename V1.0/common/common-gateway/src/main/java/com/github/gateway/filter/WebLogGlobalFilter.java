package com.github.gateway.filter;

import java.net.URI;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class WebLogGlobalFilter implements GlobalFilter, Ordered {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("--------------------------------------------------<Log In WebLogFilter Start>--------------------------------------------------");
		ServerHttpRequest request = exchange.getRequest();
		String requestId = request.getId();
		log.info("requestId: " + requestId);
		URI uri = request.getURI();
		log.info("uri: " + uri);
		HttpHeaders headers = request.getHeaders();
		Set<String> keySet = headers.keySet();
		log.info("keySet: " + keySet.size());
		log.info("------------HttpHeaders-------------");
		Set<Entry<String, List<String>>> entrySet = headers.entrySet();
		entrySet.forEach((e) -> log.info(e.getKey() + ": " + e.getValue()));
		log.info("------------QueryParams-------------");
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
