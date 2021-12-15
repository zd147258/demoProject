package com.xx.test.bo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
@Data
public class RspBaseBO implements Serializable {
    private static final long serialVersionUID = -2112522353567625738L;
    @JSONField(
            serialize = false
    )
    private String code;
    @JSONField(
            serialize = false
    )
    private String message;
}
