package com.demo.controller;

import com.demo.model.SysUser;
import com.demo.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/sys/user")
@Api("用户管理")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;

	/**
	 * http://localhost/sys/user/insert?username=zhangsan&password=123456
	 *
	 * @return String
	 */
	@RequestMapping("/insert")
	@ResponseBody
	@ApiOperation("新增")
	@ApiParam(name = "SysUser", value = "用户对象")
	public SysUser insert(SysUser record) {
		sysUserService.insert(record);
		log.info("sysUser {}", record);
		return record;
	}

}
