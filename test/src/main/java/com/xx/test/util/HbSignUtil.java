package com.xx.test.util;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;

/**
 * 标题: HbSignUtil
 * 说明: 华泊sign签名
 * 时间: 2021/12/7 17:13
 * @author 郑冬
 **/
public class HbSignUtil {
    /**
     * 把参数名为key值为value拼接请求串，按照key的字母排序再生成字符串后进行md5 32位大写 加密编码格式utf-8
     */
    public static String getSignMp(Map<String, Object> params, String appSecret) throws IOException {
        // 第一步：检查参数是否已经排序
        String[] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        // 第二步：把所有参数名和参数值串在一起
        StringBuilder query = new StringBuilder("");
        for (String key : keys) {
            Object value = params.get(key);
            if ((null != key) && !"".equals(key) && (null != value) && !"".equals(value)) {
                query.append(key).append(value);
            }
        }
        query.append(appSecret);
        // 第三步：使用MD5加密 ,对字符串采用UTF-8编码后，用MD5进行摘要。
        byte[] data = query.toString().getBytes("UTF-8");
        byte[] bytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            bytes = md.digest(data);
        } catch (GeneralSecurityException gse) {
            throw new IOException(gse.toString());
        }
        // 第四步：把二进制转化为大写的十六进制
        StringBuilder sign = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }
}
