package com.demo.service.impl;

import com.demo.dao.SysUserMapper;
import com.demo.model.SysUser;
import com.demo.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUser record) {
        return 0;
    }

    @Override
    public SysUser selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SysUser record) {
        return 0;
    }
}
