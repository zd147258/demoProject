package com.xx.test.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class OooBO implements Serializable {
    private static final long serialVersionUID = 2056980652942243035L;

    private Long id;
    private String name;
    private String idStr;
    private Map<Long, Long> testMap;
    private Map<String, String> tradingUnitQryMap = new HashMap<>();
}
