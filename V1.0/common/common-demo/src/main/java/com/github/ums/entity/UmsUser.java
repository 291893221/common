package com.github.ums.entity;

import com.github.common.entity.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Mybatis Generator 2019/05/21
 */
@ApiModel(value = "com.github.entity.UmsUser")
@Data
@EqualsAndHashCode(callSuper=false)
public class UmsUser extends BaseEntity {

	@ApiModelProperty(value = "登陆帐号")
	private String username;

	@ApiModelProperty(value = "登陆密码(MD5加密)")
	private String password;

	@ApiModelProperty(value = "用户姓名")
	private String nickname;

	@ApiModelProperty(value = "是否锁定（0:未锁定,1:已锁定）", example = "0")
	private Integer isLocked;

	@ApiModelProperty(value = "是否管理员（0:普通账号,1:管理员）", example = "0")
	private Integer isAdmin;

}