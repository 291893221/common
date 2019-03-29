package com.demo.dao;

import com.demo.model.PageEntity;

import java.util.List;

public interface BaseMapper<T extends PageEntity> {
    int deleteByPrimaryKey(Integer id);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

    List<T> list(T t);

	T selectBySelective(T record);
}