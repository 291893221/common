package com.demo.dao;

import com.demo.DemoApplicationTests;
import com.demo.model.EsDataEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class EsDataRepositoryTest extends DemoApplicationTests {
	@Autowired
	private EsDataRepository esDataRepository;

	@Test
	public void createIndex() {
		EsDataEntity esDataEntity = new EsDataEntity();
		esDataEntity.setId(0);
		esDataEntity.setTitle("title");
		esDataEntity.setData("data");
		esDataRepository.save(esDataEntity);
	}
}