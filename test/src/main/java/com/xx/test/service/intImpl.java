package com.xx.test.service;

import com.xx.test.po.IntPushFwaProtocolBsReqBO;
import com.xx.test.po.IntPushFwaProtocolBsRspBO;

public class intImpl implements intService{


    @Override
    public IntPushFwaProtocolBsRspBO intPushFwaProtocolBs(IntPushFwaProtocolBsReqBO reqBO) {
        IntPushFwaProtocolBsRspBO rspBO = new IntPushFwaProtocolBsRspBO();
        rspBO.setCode("1");
        rspBO.setMessage("好好好");
        int i = 1/0;
        return rspBO;
    }
}
