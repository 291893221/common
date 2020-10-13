package com.github.ums;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring4all.swagger.EnableSwagger2Doc;

@SpringBootApplication
@MapperScan("com.github.ums.mapper")
@EnableSwagger2Doc
@RestController
public class UmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UmsApplication.class, args);
	}

	@RequestMapping("/test")
	public Object test(int a, int b) {
		return a+b;
	}
}
