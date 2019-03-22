package com.demo.page;

import lombok.Data;

@Data
public class PageParameter {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

}
