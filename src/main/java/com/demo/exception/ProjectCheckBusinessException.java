package com.demo.exception;

import java.util.Map;

public class ProjectCheckBusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private ProjectCheckExceptionCode projectCheckExceptionCode;
	private String exceptionCode;
	private String exceptionMessage;
	private Map<String, Object> errorData;

	public ProjectCheckBusinessException(String exceptionMessage) {
		super();
		this.exceptionMessage = exceptionMessage;
	}

	public ProjectCheckBusinessException(ProjectCheckExceptionCode projectCheckExceptionCode) {
		super();
		this.projectCheckExceptionCode = projectCheckExceptionCode;
		this.exceptionCode = projectCheckExceptionCode.getExceptionCode();
		this.exceptionMessage = projectCheckExceptionCode.getExceptionMessage();
	}

	public ProjectCheckExceptionCode getProjectCheckExceptionCode() {
		return projectCheckExceptionCode;
	}

	public void setProjectCheckExceptionCode(ProjectCheckExceptionCode projectCheckExceptionCode) {
		this.projectCheckExceptionCode = projectCheckExceptionCode;
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
