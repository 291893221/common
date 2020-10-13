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

	;

	private Integer code;

	private String message;

	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * 通过状态码获取枚举对象
	 * 
	 * @param code 状态码
	 * @return 枚举对象
	 */
	public static ResultEnum getByCode(int code) {
		for (ResultEnum resultEnum : ResultEnum.values()) {
			if (code == resultEnum.getCode()) {
				return resultEnum;
			}
		}
		return null;
	}

}