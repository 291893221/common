package com.demo.controller;

import com.demo.model.SysRole;
import com.demo.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/sys/role")
@Api("角色管理")
public class SysRoleController {

	@Autowired
	private SysRoleService sysRoleService;

	/**
	 * http://localhost/sys/role/insert
	 * http://localhost/swagger-ui.html
	 * @return String
	 */
	@PostMapping
	@ApiOperation("新增")
	@ApiParam(name = "SysRole", value = "角色对象")
	public SysRole insert(SysRole record) {
		log.info("sysRole {}", record);
		sysRoleService.insert(record);
		return record;
	}
}
