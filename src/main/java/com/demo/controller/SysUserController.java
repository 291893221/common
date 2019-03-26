package com.demo.controller;

import com.demo.model.SysUser;
import com.demo.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * http://localhost/demo/sys/user/insert?username=zhangsan&password=123456
     * @return String
     */
    @RequestMapping("/insert")
    @ResponseBody
    public SysUser insert(SysUser sysUser) {
        sysUserService.insert(sysUser);
        log.info("sysUser {}", sysUser);
        return sysUser;
    }

}
