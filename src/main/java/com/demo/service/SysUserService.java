package com.demo.service;

import com.demo.dao.SysUserMapper;
import com.demo.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class SysUserService extends BaseService<SysUser> {
	@Resource
	private SysUserMapper sysUserMapper;

}
