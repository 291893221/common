package com.demo.dao;

import com.demo.model.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 2019/03/26
*/
@Mapper
public interface SysUserRoleMapper {
    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);
}