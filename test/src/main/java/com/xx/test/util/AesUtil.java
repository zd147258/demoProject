package com.xx.test.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 标题：AesUtil
 * 说明：aes ecb加解密
 * 时间：2020/2/24 18:44
 *
 * 注意：
 * <p>
 * 作者 luoyou
 */
public class AesUtil {
    private static String iv = "0123456789ABCDEF";//偏移量字符串必须是16位 当模式是CBC的时候必须设置偏移量
    private static String Algorithm = "AES";
    private static String AlgorithmProvider = "AES/ECB/PKCS5Padding"; // 算法/模式/补码方式

    public static byte[] generatorKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(Algorithm);
        keyGenerator.init(256);//默认128，获得无政策权限后可为192或256
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey.getEncoded();
    }

    public static IvParameterSpec getIv() throws UnsupportedEncodingException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes("utf-8"));
        System.out.println("偏移量："+byteToHexString(ivParameterSpec.getIV()));
        return ivParameterSpec;
    }

    public static byte[] encrypt(String src, byte[] key) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        SecretKey secretKey = new SecretKeySpec(key, Algorithm);
        //IvParameterSpec ivParameterSpec = getIv();
        Cipher cipher = Cipher.getInstance(AlgorithmProvider);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] cipherBytes = cipher.doFinal(src.getBytes(Charset.forName("utf-8")));
        return cipherBytes;
    }

    public static byte[] decrypt(String src, byte[] key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key, Algorithm);

        //IvParameterSpec ivParameterSpec = getIv();
        Cipher cipher = Cipher.getInstance(AlgorithmProvider);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] hexBytes = hexStringToBytes(src);
        byte[] plainBytes = cipher.doFinal(hexBytes);
        return plainBytes;
    }

    /**
     * 将byte转换为16进制字符串
     * @param src
     * @return
     */
    public static String byteToHexString(byte[] src) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xff;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                sb.append("0");
            }
            sb.append(hv);
        }
        return sb.toString();
    }

    /**
     * 将16进制字符串装换为byte数组
     * @param hexString
     * @return
     */
    public static byte[] hexStringToBytes(String hexString) {
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] b = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            b[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return b;
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static String encryptStr(String strCode, String key){
        try {
            byte[] keyByte = key.getBytes("utf-8");
            return byteToHexString(encrypt(strCode, keyByte));
        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }


    public static String decryptStr(String strCode, String key){
        try {
            byte[] keyByte = key.getBytes("utf-8");
            return new String(decrypt(strCode, keyByte), "utf-8");
        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    public static void main(String[] args) {
        String strCode = "1qaz2wsx";
        String key = "12345678901234561234567890123456";
        try {
            String ec = encryptStr(strCode, key);
            System.out.println("加密："+ec);
            System.out.println("解密："+ decryptStr(ec, key));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String decrypt(String encryptCode, String original_key){
        String aes_decode = null;
        try {
            byte[] raw = Hex.decodeHex(original_key.toCharArray());
            SecretKey key = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] byte_content = Base64.decodeBase64(encryptCode
                    .getBytes(StandardCharsets.UTF_8));
            byte[] byte_decode = cipher.doFinal(byte_content);
            aes_decode = new String(byte_decode, StandardCharsets.UTF_8);
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
            byte[] byte_encode = jsonStr.getBytes(StandardCharsets.UTF_8);
            byte[] byte_AES = cipher.doFinal(byte_encode);
            aes_encode = Base64.encodeBase64URLSafeString(byte_AES);
            return aes_encode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aes_encode;
    }
}
