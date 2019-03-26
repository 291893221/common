package com.demo.dao;

import com.demo.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
* Created by Mybatis Generator 2019/03/26
*/
@Mapper
public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser selectByName(String username);
}