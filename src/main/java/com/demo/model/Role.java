package com.demo.model;

import lombok.Data;

@Data
/*
@Data
该注解使用在类上，该注解会提供getter、setter、equals、canEqual、hashCode、toString方法。
*/
public class Role extends PageEntity {

    private Integer id;

    private String roleName;

}