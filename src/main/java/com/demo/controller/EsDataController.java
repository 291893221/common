package com.demo.controller;

import com.demo.dao.EsDataRepository;
import com.demo.model.EsDataEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/es_data")
public class EsDataController {
	@Autowired
	private EsDataRepository esDataRepository;

	/**
	 * http://localhost/es_data/createIndex?id=1&title=test&data=txt
	 */
	@RequestMapping("/createIndex")
	@ResponseBody
	public EsDataEntity createIndex(EsDataEntity esDataEntity) {
		log.info("EsDataEntity : {}" + esDataEntity);
		return esDataRepository.save(esDataEntity);
	}
}
