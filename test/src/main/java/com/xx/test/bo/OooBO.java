package com.xx.test.bo;

import lombok.Data;

import java.io.Serializable;

@Data
public class OooBO implements Serializable {
    private static final long serialVersionUID = 2056980652942243035L;

    private Long id;
    private String name;
}
