package com.github.common.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.common.entity.UmsOrganization;
import com.github.common.mapper.UmsOrganizationMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UmsOrganizationService extends BaseService<UmsOrganization> {

	@Resource
	private UmsOrganizationMapper umsOrganizationMapper;

}
