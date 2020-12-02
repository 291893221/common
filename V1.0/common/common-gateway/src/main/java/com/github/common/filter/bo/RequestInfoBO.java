package com.github.common.filter.bo;

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
}
