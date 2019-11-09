package com.xing.utils.entity.mock;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * TestEntity
 *
 * @author : xingshukui
 * @date : 2019-11-09 14:58
 * @desc :
 *
 * 模拟数据
 */
@Data
public class TestEntity {

    private Integer id;

    private Long age;

    private String name;

    private BigDecimal money;

    private List<String> list;
}
