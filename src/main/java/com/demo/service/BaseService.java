package com.demo.service;

import com.demo.dao.BaseMapper;
import com.demo.model.PageEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseService<T extends PageEntity> {

	@Autowired
	private BaseMapper<T> m;

	public int deleteByPrimaryKey(Integer id) {
		return m.deleteByPrimaryKey(id);
	}

	public int insert(T t) {
		return m.insert(t);
	}

	public int insertSelective(T t) {
		return m.insertSelective(t);
	}

	public PageEntity selectByPrimaryKey(Integer id) {
		return m.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(T t) {
		return m.updateByPrimaryKeySelective(t);
	}

	public int updateByPrimaryKey(T t) {
		return m.updateByPrimaryKey(t);
	}

	public PageInfo<T> selectPage(T t) {
		PageHelper.startPage(t.getPageNum(), t.getPageSize());
		List<T> list = m.list(t);
		return new PageInfo(list);
	}
}
