package com.demo.model;

import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.io.Serializable;

@Data
public class PageEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiParam(hidden = true)
	private Integer pageNum = 1;

	@ApiParam(hidden = true)
	private Integer pageSize = 10;

}
