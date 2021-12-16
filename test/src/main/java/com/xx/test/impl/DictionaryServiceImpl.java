package com.xx.test.impl;

import com.alibaba.fastjson.JSON;
import com.xx.test.dao.SysDicDictionaryMapper;
import com.xx.test.po.SysDicDictionaryPO;
import com.xx.test.service.DictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private SysDicDictionaryMapper sysDicDictionaryMapper;

    @Override
    public Map<String, String> queryBypCodeBackMap(String sysCode, String pCode) {
        Map<String, String> sysDicMap = new HashMap<>();
        SysDicDictionaryPO qryParam = new SysDicDictionaryPO();
        qryParam.setPCode(pCode);
        qryParam.setSysCode(sysCode);
        List<SysDicDictionaryPO> sysDicList = sysDicDictionaryMapper.getList(qryParam);
        log.info("sysDicList:{}", JSON.toJSONString(sysDicList));
        if (!CollectionUtils.isEmpty(sysDicList)){
            for (SysDicDictionaryPO po : sysDicList){
                sysDicMap.put(po.getCode(), po.getTitle());
            }
        }
        log.info("sysDicMap:{}", JSON.toJSONString(sysDicMap));
        return sysDicMap;
    }
}
