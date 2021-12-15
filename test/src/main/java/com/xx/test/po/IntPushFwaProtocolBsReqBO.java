package com.xx.test.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class IntPushFwaProtocolBsReqBO implements Serializable {
    private static final long serialVersionUID = 18351297425751569L;
    /**
     * 协议ID
     */
    private Long protocolId;
}
