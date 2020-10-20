package com.github.ums.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestController {
	@GetMapping("/test")
	@ApiOperation(value = "测试", notes = "测试")
	public Object insert(String a) {
		log.info("a : {}", a);
		return a;
	}
}
