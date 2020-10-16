package com.github.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring4all.swagger.EnableSwagger2Doc;

@SpringBootApplication
@MapperScan("com.github.common.mapper")
@EnableSwagger2Doc
public class CommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonApplication.class, args);
	}

}
