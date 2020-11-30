package com.github.common.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

@Configuration
public class UrlCache {
	@Bean
	public Cache<String, Integer> getCache() {
		return CacheBuilder.newBuilder().expireAfterWrite(10L, TimeUnit.SECONDS).build();
	}
}
