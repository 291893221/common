package com.github.ums.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.common.service.BaseService;
import com.github.ums.entity.UmsRole;
import com.github.ums.mapper.UmsRoleMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UmsRoleService extends BaseService<UmsRole> {

	@Resource
	private UmsRoleMapper umsRoleMapper;

}