package com.xx.test.bo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AccountBO {
    private String accountName;
    private BigDecimal mount;
    private Date time;
}
