package com.github.ums.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.common.annotation.NoRepeatSubmit;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestController {
	/**
	 * http://localhost:8080/
	 */
	@GetMapping("/")
	@NoRepeatSubmit
	public Object test(String a) {
		log.info("entity {}", a);
		return a;
	}
}
