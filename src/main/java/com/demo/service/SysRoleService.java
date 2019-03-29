package com.demo.service;

import com.demo.dao.SysRoleMapper;
import com.demo.model.SysRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class SysRoleService extends BaseService<SysRole>{
	@Resource
	private SysRoleMapper sysRoleMapper;

}
