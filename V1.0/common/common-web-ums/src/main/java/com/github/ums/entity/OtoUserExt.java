package com.github.ums.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Mybatis Generator 2019/05/17
 */
@ApiModel(value = "com.github.entity.OtoUserExt")
@Data
public class OtoUserExt {
	@ApiModelProperty(value = "登录帐号")
	private String username;

	@ApiModelProperty(value = "手机号")
	private String phone;

	@ApiModelProperty(value = "邮箱")
	private String email;

	@ApiModelProperty(value = "0:女,1:男", example = "1")
	private Integer sex;
}