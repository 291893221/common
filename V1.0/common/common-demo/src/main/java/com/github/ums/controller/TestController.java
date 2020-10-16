package com.github.ums.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/ums")
	public Object test(int a, int b) {
		return a + b;
	}
}
