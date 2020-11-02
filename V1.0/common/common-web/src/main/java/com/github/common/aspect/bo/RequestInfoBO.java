package com.github.common.aspect.bo;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;

import lombok.Data;

@Data
public class RequestInfoBO {
	private String ip;
	private String url;
	private String httpMethod;
	private String classMethod;
	private Object requestParams;
	private Object result;
	private Long timeCost;
	private RuntimeException exception;
	public RequestInfoBO(HttpServletRequest request, JoinPoint joinPoint) {
		super();
		this.ip = request.getRemoteAddr();
		this.url = request.getRequestURL().toString();
		this.httpMethod = request.getMethod();
		this.classMethod = joinPoint.getSignature().getDeclaringTypeName() +"."+ joinPoint.getSignature().getName();
		this.requestParams = Arrays.toString(joinPoint.getArgs());
	}
}
