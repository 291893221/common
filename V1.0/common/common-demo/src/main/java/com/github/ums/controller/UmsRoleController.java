package com.github.ums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.common.controller.BaseController;
import com.github.ums.entity.UmsRole;
import com.github.ums.service.UmsRoleService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

/**
 * http://localhost:8080/ums/role
 */
@Slf4j
@RestController
@RequestMapping("/ums/role")
@Api(tags = "角色管理")
public class UmsRoleController extends BaseController<UmsRole> {

	@Autowired
	private UmsRoleService umsRoleService;

}
