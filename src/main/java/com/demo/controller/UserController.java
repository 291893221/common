package com.demo.controller;

import com.demo.model.User;
import com.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * http://localhost/demo/user/insert?username=zhangsan&password=123456
     * @return String
     */
    @RequestMapping("/insert")
    @ResponseBody
    public User insert(String username, String password) {
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        userService.insert(user);
        logger.info("user {}", user);
        return user;
    }

    /**
     * http://localhost/demo/user/select
     * @param user id
     * @return user
     */
    @RequestMapping("/select")
    @ResponseBody
    public List<User> select(User user) {
        return userService.select(user);
    }
}
