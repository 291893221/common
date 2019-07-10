package com.demo.exception;

public enum BusinessExceptionCodeEnum implements BusinessExceptionCode {
	PARAMETER_EMPTY("P01", "参数为空"), //
	PARAMETER_TYPE_ERROR("P02", "参数类型错误"), //
	PARAMETER_TYPE_CONVERT_ERROR("P03", "参数类型转换异常"), //
	PARAMETER_COMPARE_ERROR("P04", "参数比较异常"), //
	PARAMETER_ERROR("P05", "参数错误"), //

	BUSINESS_NOT_CONTAINS("B01", "不包含"),//
	;

	private String exceptionCode;
	private String exceptionMessage;

	private BusinessExceptionCodeEnum(String exceptionCode, String exceptionMessage) {
		this.exceptionCode = exceptionCode;
		this.exceptionMessage = exceptionMessage;
	}

	@Override
	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	@Override
	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

}
