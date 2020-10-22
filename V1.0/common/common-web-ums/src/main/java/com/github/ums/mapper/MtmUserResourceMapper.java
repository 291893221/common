package com.github.ums.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.ums.entity.MtmUserResource;

/**
 * Created by Mybatis Generator 2019/05/17
 */
@Mapper
public interface MtmUserResourceMapper {
	int deleteByPrimaryKey(@Param("userId") Long userId, @Param("resourceId") Long resourceId);

	int insert(MtmUserResource record);

	int insertSelective(MtmUserResource record);
}