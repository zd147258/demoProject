package com.xx.test.po;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private Integer num;
    private BigDecimal price;
    private String name;
    private String category;
}
