package com.github.ums.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.common.exception.CustomException;
import com.github.common.exception.bo.ResultEnum;

@RestController
public class TestController {

	@RequestMapping("/ums")
	public Object test(int a, int b) {
		if(a ==0)
		throw new CustomException(ResultEnum.ADD_ERROR, "");
		return a + b;
	}
}
