package com.xx.test.service.impl;


import com.xx.test.bo.UmcGetPicVfCodeAbilityReqBO;
import com.xx.test.bo.UmcGetPicVfCodeAbilityRspBO;

/**
 * 标题：UmcGetPicVfCodeAbilityService
 * 说明：生成验证码图片服务
 * 时间：2019/11/7 13:14
 *
 * 注意：
 * <p>
 * 作者 luoyou
 */
public interface UmcGetPicVfCodeAbilityService {
    /**
     * 生成验证码图片
     * @param reqBO
     * @return
     */
    UmcGetPicVfCodeAbilityRspBO getPicVfCode(UmcGetPicVfCodeAbilityReqBO reqBO);

    UmcGetPicVfCodeAbilityRspBO checkVfCode(UmcGetPicVfCodeAbilityReqBO reqBO);
}
