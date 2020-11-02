package com.github.common.exception.bo;

import lombok.Getter;

@Getter
public enum ResultEnum {

	/**
	 * 未知异常
	 */
	UNKNOWN_EXCEPTION(100, "未知异常"),

	/**
	 * 添加失败
	 */
	ADD_ERROR(103, "添加失败"),

	/**
	 * 更新失败
	 */
	UPDATE_ERROR(104, "更新失败"),

	/**
	 * 删除失败
	 */
	DELETE_ERROR(105, "删除失败"),

	/**
	 * 查找失败
	 */
	GET_ERROR(106, "查找失败"), 
	
	SUCCESS(100, "请求成功"),

	;

	private Integer code;

	private String message;
	
	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	ResultEnum(Exception e) {
		this.code = 900;
		this.message = e.getMessage();
	}

}