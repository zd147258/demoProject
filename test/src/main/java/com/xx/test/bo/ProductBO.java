package com.xx.test.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductBO implements Serializable {
    private String category;
    private List<DetailBO> details;
}
