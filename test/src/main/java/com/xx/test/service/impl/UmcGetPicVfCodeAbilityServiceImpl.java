package com.xx.test.service.impl;

import com.xx.test.bo.UmcGetPicVfCodeAbilityReqBO;
import com.xx.test.bo.UmcGetPicVfCodeAbilityRspBO;
import com.xx.test.config.service.RedisService;
import com.xx.test.constant.UmcRspConstant;
import com.xx.test.util.UmcBusinessException;
import com.xx.test.util.VerifyCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 标题：UmcGetPicVfCodeAbilityServiceImpl
 * 说明：生成验证码图片服务
 * 时间：2019/11/7 13:17
 *
 * 注意：
 * <p>
 * 作者 luoyou
 */
@Slf4j
@Service
public class UmcGetPicVfCodeAbilityServiceImpl implements UmcGetPicVfCodeAbilityService {
    /**
     * 验证码默认长度
     */
    private static final Integer DEFUALT_CODE_LENGTH = 4;
    /**
     * 图片默认高度
     */
    private static final Integer PIC_WIGTH = 80;
    /**
     * 图片默认长度
     */
    private static final Integer PIC_HEIGHT = 30;

    private Base64 base64 = new Base64();
    @Autowired
    private RedisService cacheClient;

    @Value("${picVfCodeExpTime}")
    private String picVfCodeExpTime;

    private static final String VF_CODE_KEY = "picVfCode";
    @Override
    public UmcGetPicVfCodeAbilityRspBO getPicVfCode(UmcGetPicVfCodeAbilityReqBO reqBO) {
        if(StringUtils.isBlank(reqBO.getIp())){
            throw new UmcBusinessException(UmcRspConstant.RESP_CODE_PARAM_VERIFY_ERROR, "入参[ip]不能为空");
        }
        UmcGetPicVfCodeAbilityRspBO rspBO = new UmcGetPicVfCodeAbilityRspBO();
        if(null == reqBO.getVfCodeLength()){
            reqBO.setVfCodeLength(DEFUALT_CODE_LENGTH);
        }
        // 生成code
        String code = VerifyCodeUtils.generateVerifyCode(reqBO.getVfCodeLength());
        if(log.isDebugEnabled()){
            log.debug("获取图片验证码:{}", code);
        }
        if(null == reqBO.getPicHeight() || null == reqBO.getPicWidth()){
            reqBO.setPicHeight(PIC_HEIGHT);
            reqBO.setPicWidth(PIC_WIGTH);
        }
        ByteArrayOutputStream fos = new ByteArrayOutputStream();
        try {
//            Object obj = cacheClient.get(reqBO.getIp());
//            if(null != obj){
//                Object objCode = cacheClient.get(String.valueOf(obj) + "_" + reqBO.getIp());
//                if(null != objCode){
//                    cacheClient.delete(String.valueOf(obj) + "_" + reqBO.getIp());
//                }
//                cacheClient.delete(reqBO.getIp());
//            }
            VerifyCodeUtils.outputImage(reqBO.getPicWidth(), reqBO.getPicHeight(), fos, code);
            rspBO.setPicVfCode(base64.encodeToString(fos.toByteArray()));
            rspBO.setVfCode(code);
//            cacheClient.set(reqBO.getIp(), code, Integer.parseInt(picVfCodeExpTime));
//            cacheClient.set(code + "_"+ reqBO.getIp(), code, Integer.parseInt(picVfCodeExpTime));
            cacheClient.setex(VF_CODE_KEY + code, Integer.parseInt(picVfCodeExpTime), code);
            fos.close();
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new UmcBusinessException(UmcRspConstant.RESP_CODE_GENERATING_VERIFICATION_CODE_PICTURE, "获取验证码图片失败");
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                log.error(e.getMessage());
                throw new UmcBusinessException(UmcRspConstant.RESP_CODE_GENERATING_VERIFICATION_CODE_PICTURE, "关闭字节流失败");
            }
        }
        rspBO.setRespDesc(UmcRspConstant.RESP_DESC_SUCCESS);
        rspBO.setRespCode(UmcRspConstant.RESP_CODE_SUCCESS);
        return rspBO;
    }

    @Override
    public UmcGetPicVfCodeAbilityRspBO checkVfCode(UmcGetPicVfCodeAbilityReqBO reqBO) {
        initParam(reqBO);
//        Object obj = cacheClient.get(reqBO.getIp());
//        if(null == obj){
//            throw new UmcBusinessException(UmcRspConstant.RESP_CODE_GENERATING_VERIFICATION_CODE_PICTURE, "验证码失效");
//        }
//        if(log.isDebugEnabled()){
//            log.debug("obj:{}", obj);
//        }
//        Object objCode = cacheClient.get(String.valueOf(obj) + "_" + reqBO.getIp());
//        if(null == objCode || !reqBO.getVfCode().equals(String.valueOf(objCode))){
//            throw new UmcBusinessException(UmcRspConstant.RESP_CODE_GENERATING_VERIFICATION_CODE_PICTURE, "验证码失效");
//        }
        Object obj = cacheClient.get(VF_CODE_KEY + reqBO.getVfCode());
        if(null == obj || !reqBO.getVfCode().equals(String.valueOf(obj))){
            throw new UmcBusinessException(UmcRspConstant.RESP_CODE_GENERATING_VERIFICATION_CODE_PICTURE, "验证码失效");
        }
        if(log.isDebugEnabled()){
            log.debug("key:{}", String.valueOf(obj) + "_" + reqBO.getIp());
        }
//        cacheClient.delete(reqBO.getIp());
//        cacheClient.delete(String.valueOf(obj) + "_" + reqBO.getIp());
        cacheClient.del(VF_CODE_KEY + reqBO.getVfCode());
        UmcGetPicVfCodeAbilityRspBO rspBO = new UmcGetPicVfCodeAbilityRspBO();
        rspBO.setRespCode(UmcRspConstant.RESP_CODE_SUCCESS);
        rspBO.setRespDesc(UmcRspConstant.RESP_DESC_SUCCESS);
        return rspBO;
    }

    private void initParam(UmcGetPicVfCodeAbilityReqBO reqBO){
        if(null == reqBO){
            throw new UmcBusinessException(UmcRspConstant.RESP_CODE_PARAM_VERIFY_ERROR, "入参对象为空");
        }
        if(StringUtils.isBlank(reqBO.getVfCode())){
            throw new UmcBusinessException(UmcRspConstant.RESP_CODE_PARAM_VERIFY_ERROR, "入参验证码为空");
        }
        if(StringUtils.isBlank(reqBO.getIp())){
            throw new UmcBusinessException(UmcRspConstant.RESP_CODE_PARAM_VERIFY_ERROR, "入参ip为空");
        }
    }
}
