package com.demo.service;

import com.demo.DemoApplicationTests;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisServiceTest extends DemoApplicationTests {

    private Logger logger = LoggerFactory.getLogger(RedisServiceTest.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void set() {
        redisTemplate.opsForValue().set("hello", "world");
    }

    @Test
    public void get() {
        Object demo = redisTemplate.opsForValue().get("demo");
        logger.info(demo.toString());
    }
}