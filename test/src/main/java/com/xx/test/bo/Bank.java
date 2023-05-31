package com.xx.test.bo;

import lombok.Data;

import java.util.Date;

@Data
public class Bank {
    private AccountBO account;
    private String time;
}
