package com.xx.test.bo;

import com.xx.test.base.bo.UmcRspBaseBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 标题：UmcGetPicVfCodeAbilityRspBO
 * 说明：生成验证码图片服务
 * 时间：2019/11/7 13:15
 *
 * 注意：
 * <p>
 * 作者 luoyou
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UmcGetPicVfCodeAbilityRspBO extends UmcRspBaseBO {
    private static final long serialVersionUID = 9029028337603315104L;

    /**
     * 验证码图片base64串
     */
    private String picVfCode;

    /**
     * 验证码
     */
    private String vfCode;
}
