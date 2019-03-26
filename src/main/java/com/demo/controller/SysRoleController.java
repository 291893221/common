package com.demo.controller;

import com.demo.model.SysRole;
import com.demo.service.SysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/sys/role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * http://localhost/demo/sys/role/insert?roleName=游客
     * @return String
     */
    @RequestMapping("/insert")
    @ResponseBody
    public String insert(SysRole record) {
        log.info("sysRole {}", record);
        sysRoleService.insert(record);
        return "sysRole";
    }
}
