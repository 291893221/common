package com.github.ums;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.spring4all.swagger.EnableSwagger2Doc;

@SpringBootApplication
@MapperScan({"com.github.common.mapper","com.github.ums.mapper"})
@EnableSwagger2Doc
@ComponentScan(basePackages = {"com.github.common","com.github.ums"})
public class UmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UmsApplication.class, args);
	}

}
