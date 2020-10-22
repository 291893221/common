package com.github.ums.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.github.ums.entity.OtoUserExt;

/**
 * Created by Mybatis Generator 2019/05/17
 */
@Mapper
public interface OtoUserExtMapper {
	int insert(OtoUserExt record);

	int insertSelective(OtoUserExt record);
}