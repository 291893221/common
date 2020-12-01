package com.github.ums.controller;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.common.annotation.NoRepeatSubmit;

import lombok.Data;
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
	
	@Test
	public void junit() {
		User a = new User();
		a.setId("1");
		var list = Arrays.asList(a);
		list.stream().peek(e -> log.info("a : {}", e));
	}
}
@Data
class User {
	String id;
}
