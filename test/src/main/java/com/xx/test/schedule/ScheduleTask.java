package com.xx.test.schedule;

import com.alibaba.fastjson.JSON;
import com.xx.test.bo.OooServiceReqBO;
import com.xx.test.bo.OooServiceRspBO;
import com.xx.test.service.OooService;
import com.xx.test.service.OooServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
@Slf4j
public class ScheduleTask {

/*    @Scheduled(cron = "0/5 * * * * ?")
    public void demo1() {
        log.info("demo1-------------start");
        for (int i = 0; i < 10; i++) {
            log.info("demo1");
        }
        log.info("demo1-------------end");
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void demo2() {
        log.info("demo2-------------start");
        for (int i = 0; i < 10; i++) {
            log.info("demo2");
        }
        log.info("demo2-------------end");
    }*/

//    @Scheduled(cron = "0/10 * * * * ?")
//    public void demo3() {
//        OooService oooService = new OooServiceImpl();
//        OooServiceReqBO oooServiceReqBO = new OooServiceReqBO();
//        oooServiceReqBO.setId(1L);
//        OooServiceRspBO rspBO = oooService.selectOoo(oooServiceReqBO);
//        log.info("OooServiceRspBO:{}", JSON.toJSONString(rspBO));
//    }
}
