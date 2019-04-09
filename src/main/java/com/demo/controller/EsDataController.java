package com.demo.controller;

import com.demo.dao.EsDataRepository;
import com.demo.model.EsDataEntity;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/es_data")
public class EsDataController {
	@Autowired
	private EsDataRepository esDataRepository;

	/**
	 * http://localhost/es_data/save?id=1&title=test&data=txt
	 */
	@RequestMapping("/save")
	@ResponseBody
	public EsDataEntity save(EsDataEntity esDataEntity) {
		log.info("EsDataEntity : {}" + esDataEntity);
		return esDataRepository.save(esDataEntity);
	}

	/**
	 * http://localhost/es_data/saveAll?id=100&title=saveAll&data=all
	 */
	@RequestMapping("/saveAll")
	@ResponseBody
	public Iterable<EsDataEntity> saveAll(EsDataEntity esDataEntity) {
		log.info("EsDataEntity : {}" + esDataEntity);
		List<EsDataEntity> esDatas = new ArrayList<>();
		esDatas.add(esDataEntity);
		esDatas.add(esDataEntity);
		esDatas.add(esDataEntity);
		return esDataRepository.saveAll(esDatas);
	}

	/**
	 * http://localhost/es_data/findAll
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Iterable<EsDataEntity> findAll() {
		return esDataRepository.findAll();
	}

	/**
	 * http://localhost/es_data/findAllSort
	 */
	@RequestMapping("/findAllSort")
	@ResponseBody
	public Iterable<EsDataEntity> findAllSort() {
		return esDataRepository.findAll(Sort.by("id").ascending());
	}

	/**
	 * http://localhost/es_data/search?title=test
	 */
	@RequestMapping("/search")
	@ResponseBody
	public Page<EsDataEntity> search(EsDataEntity esDataEntity) {
		NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
		nativeSearchQueryBuilder.withQuery(QueryBuilders.matchQuery("title",esDataEntity.getTitle()));
		Page<EsDataEntity> search = esDataRepository.search(nativeSearchQueryBuilder.build());
		long totalElements = search.getTotalElements();
		log.info("totalElements : {}",totalElements);
		return search;
	}

	/**
	 * http://localhost/es_data/deleteById?id=1
	 */
	@RequestMapping("/deleteById")
	@ResponseBody
	public void deleteById(Integer id) {
		esDataRepository.deleteById(id);
	}

	/**
	 * http://localhost/es_data/deleteAll
	 */
	@RequestMapping("/deleteAll")
	@ResponseBody
	public void deleteAll() {
		esDataRepository.deleteAll();
	}
}
