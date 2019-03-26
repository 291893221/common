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


    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }


    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }


    public int insertSelective(SysUser record) {
        return 0;
    }


    public SysUser selectByPrimaryKey(Integer id) {
        return null;
    }


    public int updateByPrimaryKeySelective(SysUser record) {
        return 0;
    }


    public int updateByPrimaryKey(SysUser record) {
        return 0;
    }
}
