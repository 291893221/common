package com.demo.dao;

import com.demo.model.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "users")
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    @CacheEvict(key ="users",allEntries=true)
    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Cacheable(value="users")
    List<User> select(User user);
}