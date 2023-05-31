package com.xx.test.bo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class DetailBO implements Serializable {
    private static final long serialVersionUID = 3259881070088193446L;
    private Long id;
    private Integer num;
    private BigDecimal price;
    private String name;
}
