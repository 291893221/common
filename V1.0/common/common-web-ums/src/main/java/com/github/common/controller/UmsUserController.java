package com.github.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.common.entity.UmsUser;
import com.github.common.service.UmsUserService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

/**
 * http://localhost:8080/ums/user
 */
@Slf4j
@RestController
@RequestMapping("/ums/user")
@Api(tags = "用户管理")
public class UmsUserController extends BaseController<UmsUser> {

	@Autowired
	private UmsUserService umsUserService;

}
