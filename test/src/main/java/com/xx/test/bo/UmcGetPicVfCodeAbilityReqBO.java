package com.xx.test.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 标题：UmcGetPicVfCodeAbilityReqBO
 * 说明：生成验证码图片服务
 * 时间：2019/11/7 13:15
 *
 * 注意：
 * <p>
 * 作者 luoyou
 */
@Data
public class UmcGetPicVfCodeAbilityReqBO implements Serializable{
    private static final long serialVersionUID = 575620455315951900L;

    /**
     * 验证码长度
     */
    private Integer vfCodeLength;

    private String ip;

    private Integer picWidth;

    private Integer picHeight;

    private String vfCode;

    private String picVfCodeKey;
}
