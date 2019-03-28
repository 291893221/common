package com.demo.model;

import lombok.Data;

/**
* Created by Mybatis Generator 2019/03/28
*/
@Data
public class SysPermission {
    private Integer id;

    private String url;

    private Integer roleId;

    private String permission;
}