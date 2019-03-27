package com.demo.service;

import com.demo.DemoApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

@Slf4j
public class RedisServiceTest extends DemoApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void set() {
		redisTemplate.opsForValue().set("demo", "hello world");
	}

	@Test
	public void get() {
		Object demo = redisTemplate.opsForValue().get("demo");
		log.info(demo.toString());
	}
}