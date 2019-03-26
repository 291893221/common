package com.demo.controller;

import com.demo.model.SysUserRole;
import com.demo.service.SysUserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/sys/userRole")
public class SysUserRoleController {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * http://localhost/demo/sys/userRole/insert?userId=3&roleId=1
     * @return String
     */
    @RequestMapping("/insert")
    @ResponseBody
    public SysUserRole insert(SysUserRole record) {
        sysUserRoleService.insert(record);
        log.info("SysUserRole {}", record);
        return record;
    }

}
