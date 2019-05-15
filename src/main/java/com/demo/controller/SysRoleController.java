package com.demo.controller;

import com.demo.model.SysRole;
import com.demo.service.SysRoleService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * http://localhost/swagger-ui.html
 * http://localhost/sys/role
 */
@Slf4j
@RestController
@RequestMapping("/sys/role")
@Api("角色管理")
public class SysRoleController {

	@Autowired
	private SysRoleService sysRoleService;

	@PostMapping
	@ApiOperation("新增")
	@ApiParam(name = "SysRole", value = "角色对象")
	public SysRole insert(SysRole record) {
		log.info("sysRole {}", record);
		sysRoleService.insertSelective(record);
		return record;
	}

	@DeleteMapping
	@ApiOperation("删除")
	@ApiParam(name = "id", value = "主键id")
	public int delete(Integer id) {
		log.info("id {}", id);
		return sysRoleService.deleteByPrimaryKey(id);
	}

	@GetMapping
	@ApiOperation("查询")
	@ApiParam(name = "SysRole", value = "角色对象")
	public PageInfo<SysRole> selectBySelective(SysRole record) {
		log.info("sysRole {}", record);
		return sysRoleService.selectPage(record);
	}

	@PutMapping
	@ApiOperation("修改")
	@ApiParam(name = "SysRole", value = "角色对象")
	public SysRole updateByPrimaryKeySelective(SysRole record) {
		log.info("sysRole {}", record);
		sysRoleService.updateByPrimaryKeySelective(record);
		return record;
	}
}
