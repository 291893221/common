package com.github.common.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.common.entity.UmsResource;
import com.github.common.mapper.UmsResourceMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UmsResourceService extends BaseService<UmsResource> {

	@Resource
	private UmsResourceMapper umsResourceMapper;

}
