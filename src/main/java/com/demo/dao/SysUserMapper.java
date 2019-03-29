package com.demo.dao;

import com.demo.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Mybatis Generator 2019/03/26
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser>{

	SysUser selectByUsername(String username);
}