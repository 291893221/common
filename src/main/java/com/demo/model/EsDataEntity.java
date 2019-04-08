package com.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "demo", type = "es_data")
public class EsDataEntity {
	@Id
	private Integer id;
	@Field(type = FieldType.Text, analyzer = "ik_max_word")
	private String title;
	@Field
	private String data;
}
