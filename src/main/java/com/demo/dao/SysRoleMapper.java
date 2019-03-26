package com.demo.dao;

import com.demo.model.SysRole;
import org.apache.ibatis.annotations.Mapper;

/**
* Created by Mybatis Generator 2019/03/26
*/
@Mapper
public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}