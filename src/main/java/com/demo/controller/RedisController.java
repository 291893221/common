package com.demo.controller;

import com.demo.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    /**
     * http://localhost/demo/redis/set?key=demo&value=helloworld
     * @param key
     * @param value
     */
    @RequestMapping("/set")
    public void set(String key, String value) {
        log.info("redis set {} {}", key, value);
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
