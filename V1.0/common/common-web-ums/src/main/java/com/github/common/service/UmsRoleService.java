package com.github.common.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.common.entity.UmsRole;
import com.github.common.mapper.UmsRoleMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UmsRoleService extends BaseService<UmsRole> {

	@Resource
	private UmsRoleMapper umsRoleMapper;

}