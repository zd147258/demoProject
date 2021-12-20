package com.xx.test.service.impl;

import com.xx.test.bo.OooListServiceReqBO;
import com.xx.test.bo.OooListServiceRspBO;
import com.xx.test.bo.OooServiceReqBO;
import com.xx.test.bo.OooServiceRspBO;

/**
 * 标题: OooService
 * 说明: //TODO
 * 时间: 2021/12/9 10:44
 * @author 郑冬
 **/
public interface OooService {
    /**
     *
     * @param reqBO
     * @return
     */
    OooServiceRspBO selectOoo(OooServiceReqBO reqBO);

    /**
     *
     * @param reqBO
     * @return
     */
    OooListServiceRspBO selectListOoo(OooListServiceReqBO reqBO);
}
