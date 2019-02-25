package com.demo.controller;

import com.demo.model.User;
import com.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * http://localhost/demo/user/test
     *
     * @return String
     */
    @RequestMapping(value = "/test")
    @ResponseBody
    public String test() {
        User user = new User();
        user.setName("test");
        user.setPassword("test");
        userService.insert(user);
        logger.info("test {}", user);
        return "test";
    }
}
