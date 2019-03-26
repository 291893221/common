package com.demo.controller;

import com.demo.model.Role;
import com.demo.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * http://localhost/demo/role/insert
     * @return String
     */
    @RequestMapping("/insert")
    @ResponseBody
    public String insert() {
        Role role = new Role();
        role.setRoleName("游客");
        log.info("role {}", role);
        roleService.insert(role);
        return "role";
    }
}
