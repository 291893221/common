package com.demo.service;

import com.demo.dao.SysPermissionMapper;
import com.demo.model.SysPermission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class SysPermissionService {
	@Resource
	private SysPermissionMapper sysPermissionMapper;

	public int insert(SysPermission record) {
		return sysPermissionMapper.insert(record);
	}
}
