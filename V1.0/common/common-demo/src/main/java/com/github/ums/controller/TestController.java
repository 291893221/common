package com.github.ums.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.ums.entity.UmsUser;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestController {
	@GetMapping("/test")
	@ApiOperation(value = "测试", notes = "测试")
	public Object insert(String a) {
		log.info("a : {}", a);
		UmsUser umsUser = new UmsUser();
		umsUser.setId(1l);
		umsUser.setDescribe(a);
		umsUser.setUsername("hello");
		
		ArrayList<UmsUser> arrayList = new ArrayList<UmsUser>();
		arrayList.add(umsUser);
		arrayList.add(umsUser);
		arrayList.add(umsUser);
		arrayList.add(umsUser);
		arrayList.add(umsUser);
		arrayList.add(umsUser);
		arrayList.add(umsUser);
		arrayList.add(umsUser);
		arrayList.add(umsUser);
		arrayList.add(umsUser);
		return arrayList;
	}
}
