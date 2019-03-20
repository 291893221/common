package com.demo.controller;

import com.demo.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisService redisService;

    /**
     * http://localhost/demo/redis/set?key=demo&value=helloworld
     * @param key
     * @param value
     */
    @RequestMapping("/set")
    public void set(String key, String value) {
        logger.info("redis set {} {}", key, value);
        redisService.set(key, value);
    }

    /**
     * http://localhost/demo/redis/get?key=demo
     * @param key
     * @return
     */
    @RequestMapping("/get")
    public String get(String key) {
        return redisService.get(key);
    }
}
