package com.demo.service;

import com.demo.dao.SysUserMapper;
import com.demo.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }

    public SysUser selectByUsername(String username) {
        return sysUserMapper.selectByUsername(username);
    }
}
