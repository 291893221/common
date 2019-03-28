package com.demo.model.ext;

import com.demo.model.SysPermission;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class SysPermissionExt extends SysPermission {

    private List<String> permissionList;

    public List<String> getPermissionList() {
        return Arrays.asList(super.getPermission().trim().split(","));
    }

    public void setPermissionList(List<String> permissionList) {
        this.permissionList = permissionList;
    }

}