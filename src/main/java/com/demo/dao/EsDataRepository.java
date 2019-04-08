package com.demo.dao;

import com.demo.model.EsDataEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsDataRepository extends ElasticsearchRepository<EsDataEntity, Integer> {
}
