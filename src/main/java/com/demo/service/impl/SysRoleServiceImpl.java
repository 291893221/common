package com.demo.service.impl;

import com.demo.dao.SysRoleMapper;
import com.demo.model.SysRole;
import com.demo.service.SysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(SysRole record) {
        return sysRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(SysRole record) {
        return 0;
    }

    @Override
    public SysRole selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(SysRole record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SysRole record) {
        return 0;
    }
}
