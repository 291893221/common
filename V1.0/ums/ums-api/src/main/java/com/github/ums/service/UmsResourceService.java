package com.github.ums.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.common.service.BaseService;
import com.github.ums.entity.UmsResource;
import com.github.ums.mapper.UmsResourceMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UmsResourceService extends BaseService<UmsResource> {

	@Resource
	private UmsResourceMapper umsResourceMapper;

}
