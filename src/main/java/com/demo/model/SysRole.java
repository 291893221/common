package com.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Mybatis Generator 2019/03/26
 */
@Data
@ApiModel("SysRole | 角色类")
public class SysRole extends PageEntity {

	@ApiModelProperty("主键id")
	private Integer id;
	@ApiModelProperty("角色名称")
	private String roleName;
}