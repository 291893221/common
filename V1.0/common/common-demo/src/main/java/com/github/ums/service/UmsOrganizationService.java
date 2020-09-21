package com.github.ums.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.common.service.BaseService;
import com.github.ums.entity.UmsOrganization;
import com.github.ums.mapper.UmsOrganizationMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UmsOrganizationService extends BaseService<UmsOrganization> {

	@Resource
	private UmsOrganizationMapper umsOrganizationMapper;

}
