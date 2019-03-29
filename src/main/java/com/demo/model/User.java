package com.demo.model;

import lombok.Data;

@Data
public class User extends PageEntity {
	private Integer id;

	private String name;

	private String password;
}