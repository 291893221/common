package com.github.common.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("统一返回格式")
public class ResultVo {

	/**
	 * 状态码
	 */
	@ApiModelProperty("状态码")
	private Integer code;

	/**
	 * 提示信息
	 */
	@ApiModelProperty("提示信息")
	private String message;

	/**
	 * 数据列表
	 */
	@ApiModelProperty("数据列表")
	private Object data;

}