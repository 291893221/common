package com.github.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键编号", example = "1")
	private Long id;

	@ApiModelProperty(value = "页码", example = "1")
	private Integer pageNum = 1;

	@ApiModelProperty(value = "每页显示条数", example = "10")
	private Integer pageSize = 10;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "更新时间")
	private Date updateTime;

	@ApiModelProperty(value = "是否删除（0:未删除,1:已删除）", example = "0")
	private Integer isDelete;

	@ApiModelProperty(value = "状态(0:禁用,1:正常)", example = "1")
	private Integer status;

	@ApiModelProperty(value = "描述信息")
	private String describe;

	@ApiModelProperty(value = "排序编号", example = "1")
	private Long sort;
}