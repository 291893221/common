package com.github.ums.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.common.service.BaseService;
import com.github.ums.entity.UmsUser;
import com.github.ums.mapper.UmsUserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UmsUserService extends BaseService<UmsUser> {

	@Resource
	private UmsUserMapper umsUserMapper;

}
