package com.github.ums;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring4all.swagger.EnableSwagger2Doc;

@SpringBootApplication
@MapperScan("com.github.ums.mapper")
@EnableSwagger2Doc
public class UmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UmsApplication.class, args);
	}

}
