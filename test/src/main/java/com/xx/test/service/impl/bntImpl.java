package com.xx.test.service.impl;

import com.xx.test.po.IntPushFwaProtocolBsReqBO;
import com.xx.test.po.IntPushFwaProtocolBsRspBO;

public class bntImpl implements bntService{


    @Override
    public IntPushFwaProtocolBsRspBO bntPushFwaProtocolBs(IntPushFwaProtocolBsReqBO reqBO) {
        IntPushFwaProtocolBsRspBO rspBO = new IntPushFwaProtocolBsRspBO();
        rspBO.setCode("1");
        rspBO.setMessage("好好好");
        String s = null;
//        s.equals("wewq");
        return rspBO;
    }
}
