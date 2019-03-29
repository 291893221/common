package com.demo.model;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
* Created by Mybatis Generator 2019/03/28
*/
@Data
public class SysPermission extends PageEntity {
    private Integer id;

    private String url;

    private Integer roleId;

    private String permission;

    //将 permission 按逗号分割为了 list
    private List permissions;

    public List getPermissions() {
        return Arrays.asList(this.permission.trim().split(","));
    }

    public void setPermissions(List permissions) {
        this.permissions = permissions;
    }
}