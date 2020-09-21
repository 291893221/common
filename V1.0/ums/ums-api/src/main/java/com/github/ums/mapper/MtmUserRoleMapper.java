package com.github.ums.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.ums.entity.MtmUserRole;

/**
 * Created by Mybatis Generator 2019/05/17
 */
@Mapper
public interface MtmUserRoleMapper {
	int deleteByPrimaryKey(@Param("userId") Long userId, @Param("roleId") Long roleId);

	int insert(MtmUserRole record);

	int insertSelective(MtmUserRole record);
}