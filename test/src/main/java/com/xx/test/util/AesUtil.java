package com.xx.test.util;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;
/**
 * 标题: AesUtil
 * 说明: 加密解密工具类
 * 时间: 2021/12/7 16:46
 * @author 郑冬
 **/

public class AesUtil {
    public static String decrypt(String encryptCode, String original_key){
        String aes_decode = null;
        try {
            byte[] raw = Hex.decodeHex(original_key.toCharArray());
            SecretKey key = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] byte_content = Base64.decodeBase64(encryptCode
                    .getBytes("utf-8"));
            System.out.println("byte_content.length" + byte_content.length);
            byte[] byte_decode = cipher.doFinal(byte_content);
            aes_decode = new String(byte_decode, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aes_decode;
    }

    public static String encrypt(String jsonStr, String original_key){
        byte[] raw;
        String aes_encode = null;
        try {
            raw = Hex.decodeHex(original_key.toCharArray());
            SecretKey key = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] byte_encode = jsonStr.getBytes("utf-8");
            byte[] byte_AES = cipher.doFinal(byte_encode);
            aes_encode = new String(Base64.encodeBase64URLSafeString(byte_AES));
            return aes_encode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aes_encode;
    }
}
