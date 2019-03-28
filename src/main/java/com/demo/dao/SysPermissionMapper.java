package com.demo.dao;

import com.demo.model.SysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Created by Mybatis Generator 2019/03/28
*/
@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission>{

	List<SysPermission> list(SysPermission sysPermission);
}