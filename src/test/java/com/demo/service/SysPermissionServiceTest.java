package com.demo.service;

import com.demo.DemoApplicationTests;
import com.demo.model.SysPermission;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
}