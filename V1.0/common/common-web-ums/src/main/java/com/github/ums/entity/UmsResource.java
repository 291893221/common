package com.github.ums.entity;

import com.github.common.entity.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Mybatis Generator 2019/05/17
 */
@ApiModel(value = "com.github.entity.UmsResource")
@Data
public class UmsResource extends BaseEntity {

	@ApiModelProperty(value = "资源相对路径")
	private String resourceUrl;

	@ApiModelProperty(value = "资源名称")
	private String resourceName;

	@ApiModelProperty(value = "资源权限(c:create创建,r:read查询,u:update修改,d:delete删除)")
	private String resourcePermission;

	@ApiModelProperty(value = "图标")
	private String resourceIcon;

	@ApiModelProperty(value = "资源类型(1:模块目录,2:功能菜单,3:操作按钮)", example = "1")
	private Integer resourceType;

	@ApiModelProperty(value = "上级id", example = "1")
	private Long pid;

}