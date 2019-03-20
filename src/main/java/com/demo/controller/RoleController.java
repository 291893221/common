package com.demo.controller;

import com.demo.model.Role;
import com.demo.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

    private Logger logger = LoggerFactory.getLogger(RoleController.class);

    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * http://localhost/demo/role/insert
     * @return String
     */
    @RequestMapping(value = "/insert")
    @ResponseBody
    public String insert() {
        Role role = new Role();
        role.setRoleName("游客");
        logger.info("role {}", role);
        roleService.insert(role);
        return "role";
    }
}
