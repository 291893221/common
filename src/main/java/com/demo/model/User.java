package com.demo.model;

import com.demo.page.PageParameter;
import lombok.Data;

import java.io.Serializable;

@Data
public class User extends PageParameter implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String password;

}