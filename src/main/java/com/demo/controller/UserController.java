package com.demo.controller;

import com.demo.model.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * http://localhost/demo/user/test
     *
     * @return
     */
    @RequestMapping(value = "/test")
    @ResponseBody
    public String test() {
        User user = new User();
        user.setName("test");
        user.setPassword("test");
        userService.insert(user);
        return "test";
    }
}
