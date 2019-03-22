package com.demo.controller;

import com.demo.model.User;
import com.demo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public User insert(User user) {
        userService.insert(user);
        logger.info("user {}", user);
        return user;
    }

    /**
     * http://localhost/demo/user/select?pageNum=3&pageSize=10
     * @param user id
     * @return user
     */
    @RequestMapping("/select")
    @ResponseBody
    public PageInfo<User> select(User user) {
        return userService.select(user);
    }

    /**
     * http://localhost/demo/user/selectByPrimaryKey?id=10
     * @param id
     * @return
     */
    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public User selectByPrimaryKey(Integer id) {
        return userService.selectByPrimaryKey(id);
    }

    /**
     * http://localhost/demo/user/deleteByPrimaryKey?id=10
     * @param id
     * @return
     */
    @RequestMapping("/deleteByPrimaryKey")
    @ResponseBody
    public int deleteByPrimaryKey(Integer id) {
        return userService.deleteByPrimaryKey(id);
    }
}
