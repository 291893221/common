package com.github.ums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.common.controller.BaseController;
import com.github.ums.entity.UmsResource;
import com.github.ums.service.UmsResourceService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

/**
 * http://localhost:8080/ums/resource
 */
@Slf4j
@RestController
@RequestMapping("/ums/resource")
@Api(tags = "资源管理")
public class UmsResourceController extends BaseController<UmsResource> {

	@Autowired
	private UmsResourceService umsResourceService;

}
