package com.demo.service;

import com.demo.dao.SysUserRoleMapper;
import com.demo.model.SysUserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class SysUserRoleService {
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;
    public int insert(SysUserRole record){
        return sysUserRoleMapper.insert(record);
    }

    public List<SysUserRole> listByUserId(Integer id) {
        return sysUserRoleMapper.listByUserId(id);
    }
}
