package com.github.ums.entity;

import com.github.common.entity.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Mybatis Generator 2019/05/17
 */
@ApiModel(value = "com.github.entity.UmsRole")
@Data
public class UmsRole extends BaseEntity {

	@ApiModelProperty(value = "角色编码")
	private String rolecode;

	@ApiModelProperty(value = "角色名称")
	private String rolename;

}