package com.github.common.controller.vo;

import com.github.common.exception.bo.ResultEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
@ApiModel("统一返回格式")
public class ResultVo<T> {

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
	private T data;

	public ResultVo(ResultEnum resultEnum, T data) {
		this.code = resultEnum.getCode();
		this.message = resultEnum.getMessage();
		this.data = data;
	}

	public ResultVo(T data) {
		this(ResultEnum.SUCCESS, data);
	}

}