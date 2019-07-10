package com.demo.exception;

import java.util.Map;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private BusinessExceptionCode businessExceptionCode;
	private String exceptionCode;
	private String exceptionMessage;
	private Map<String, Object> errorData;

	public BusinessException(String exceptionMessage) {
		super();
		this.exceptionMessage = exceptionMessage;
	}

	public BusinessException(BusinessExceptionCode businessExceptionCode) {
		super();
		this.businessExceptionCode = businessExceptionCode;
		this.exceptionCode = businessExceptionCode.getExceptionCode();
		this.exceptionMessage = businessExceptionCode.getExceptionMessage();
	}

	public BusinessExceptionCode getBusinessExceptionCode() {
		return businessExceptionCode;
	}

	public void setBusinessExceptionCode(BusinessExceptionCode businessExceptionCode) {
		this.businessExceptionCode = businessExceptionCode;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public Map<String, Object> getErrorData() {
		return errorData;
	}

	public void setErrorData(Map<String, Object> errorData) {
		this.errorData = errorData;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
