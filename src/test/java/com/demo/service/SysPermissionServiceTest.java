package com.demo.service;

import com.demo.DemoApplicationTests;
import com.demo.model.SysPermission;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class SysPermissionServiceTest extends DemoApplicationTests {
	@Autowired
	private SysPermissionService sysPermissionService;

	@Test
	public void insert() {
		SysPermission record = new SysPermission();
		record.setId(1);
		record.setUrl("/admin");
		record.setRoleId(1);
		record.setPermission("c,r,u,d");
		sysPermissionService.insert(record);
	}

	@Test
	public void list() {
		SysPermission sysPermission = new SysPermission();
		sysPermission.setRoleId(1);
		List<SysPermission> sysPermissions = sysPermissionService.list(sysPermission);
		sysPermissions.stream().forEach(p->
			log.info("Test list : " + p.toString())
		);
	}
}