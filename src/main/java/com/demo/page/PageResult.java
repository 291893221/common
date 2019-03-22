package com.demo.page;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {

    private Integer total = 0;

    private List<T> rows = null;
}
