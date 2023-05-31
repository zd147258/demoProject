package com.xx.test.controller;

import com.alibaba.fastjson.JSON;
import com.xx.test.bo.*;
import com.xx.test.service.impl.OooService;
import com.xx.test.service.impl.UmcGetPicVfCodeAbilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/test")
@ResponseBody
public class Controller {

    @Autowired
    private OooService oooService;
    @Autowired
    private UmcGetPicVfCodeAbilityService umcGetPicVfCodeAbilityService;

    @RequestMapping(value = "/selectOoo", method = RequestMethod.POST)
    public OooServiceRspBO selectOoo(@RequestBody OooServiceReqBO reqBO){
        log.info("reqBO:{}", JSON.toJSONString(reqBO));
        return oooService.selectOoo(reqBO);
    }

    @RequestMapping(value = "/selectListOoo", method = RequestMethod.POST)
    public OooListServiceRspBO selectListOoo(@RequestBody OooListServiceReqBO reqBO){
        log.info("reqBO:{}", JSON.toJSONString(reqBO));
        return oooService.selectListOoo(reqBO);
    }
}
