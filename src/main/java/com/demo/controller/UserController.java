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
@RequestMapping(value = "/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * http://localhost/demo/user/insert
     *
     * @return String
     */
    @RequestMapping(value = "/insert")
    @ResponseBody
    public String insert() {
        User user = new User();
        user.setName("test");
        user.setPassword("test");
        userService.insert(user);
        logger.info("test {}", user);
        return "test";
    }

    /**
     * http://localhost/demo/user/select
     *      *
     * @param user
     * @return
     */
    @RequestMapping(value = "/select")
    @ResponseBody
    public List<User> selectByPrimaryKey(User user) {
        List<User> list = userService.select(user);
        return list;
    }
}
