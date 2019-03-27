package com.demo.service;

import com.demo.model.User;
import com.github.pagehelper.PageInfo;

public interface UserService {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	PageInfo<User> select(User user);
}
