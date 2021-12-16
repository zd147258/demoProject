package com.xx.test.service;

import java.util.Map;

public interface DictionaryService {
    /**
     * 返回编码  key: code
     * value: title
     *
     * @param sysCode
     * @param pCode
     * @return
     */
    Map<String, String> queryBypCodeBackMap(String sysCode, String pCode);
}

