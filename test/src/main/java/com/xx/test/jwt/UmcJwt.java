//package com.xx.test.jwt;
//
//import com.nimbusds.jose.*;
//import com.nimbusds.jose.crypto.MACSigner;
//import com.nimbusds.jose.crypto.MACVerifier;
//import net.minidev.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
//import org.springframework.stereotype.Component;
//import org.springframework.util.Assert;
//
//import javax.annotation.PostConstruct;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// *
// *@author liubq
// */
//@Component
//public class UmcJwt {
//
//    private final static Logger logger = LoggerFactory.getLogger(OAuth2ResourceServerProperties.Jwt.class);
//
//
//    /**
//     * 秘钥
//     */
//    private static byte[] SECRET;
//
//    @Value("${app.secret}")
//    private String secret;
//    @PostConstruct
//    public void init() {
//        Assert.notNull(secret, "secret is null");
//        logger.info("token解析秘钥 secret ={}",secret);
//        if (SECRET == null) {
//            SECRET = secret.getBytes();
//        }
//    }
//
//    public static void initSecret(String secret) {
//        Assert.notNull(secret, "secret is null");
//        SECRET = secret.getBytes();
//    }
//
//    /**
//     * 初始化head部分的数据为
//     * {
//     * "alg":"HS256",
//     * "type":"JWT"
//     * }
//     */
//    private static final JWSHeader header = new JWSHeader(JWSAlgorithm.HS256, JOSEObjectType.JWT, null, null, null, null, null, null, null, null, null, null, null);
//
//    /**
//     * 生成token，该方法只在用户登录成功后调用
//     *
//     * @param payload （Map集合 可以存储用户id，token生成时间，token过期时间等自定义字段）
//     * @return token字符串, 若失败则返回null
//     */
//    public static String createToken(Map<String, Object> payload) {
//        String tokenString = null;
//        // 创建一个 JWS object
//        JWSObject jwsObject = new JWSObject(header, new Payload(new JSONObject(payload)));
//        try {
//            // 将jwsObject 进行HMAC签名
//            jwsObject.sign(new MACSigner(SECRET));
//            tokenString = jwsObject.serialize();
//        } catch (JOSEException e) {
//            logger.error("签名失败:", e);
//        }
//        return tokenString;
//    }
//
//
//    /**
//     * 校验token是否合法，返回Map集合,集合中主要包含    state状态码   data鉴权成功后从token中提取的数据
//     * 该方法在过滤器中调用，每次请求API时都校验
//     *
//     * @param token,expTime
//     * @return Map<String, Object>
//     */
//    public static Map<String, Object> validToken(String token,Long expTime) {
//        Map<String, Object> resultMap = new HashMap<String, Object>();
//        if(expTime==null){
//            expTime=0L;
//        }
//        try {
//            JWSObject jwsObject = JWSObject.parse(token);
//            Payload payload = jwsObject.getPayload();
//            JWSVerifier verifier = new MACVerifier(SECRET);
//            if (jwsObject.verify(verifier)) {
//                JSONObject jsonOBj = payload.toJSONObject();
//                // token校验成功（此时没有校验是否过期）
//                resultMap.put("state", UmcTokenState.VALID.toString());
//                long curTime = System.currentTimeMillis();
//                // 过期了
//                if (curTime > expTime) {
//                    resultMap.clear();
//                    resultMap.put("state", UmcTokenState.EXPIRED.toString());
//                }
//                // 若payload包含ext字段，则校验是否过期
////                if (jsonOBj.containsKey("ext")) {
////                    long extTime = Long.valueOf(jsonOBj.get("ext").toString());
////                    long curTime = System.currentTimeMillis();
////                    // 过期了
////                    if (curTime > extTime) {
////                        resultMap.clear();
////                        resultMap.put("state", UmcTokenState.EXPIRED.toString());
////                    }
////                }
//                resultMap.put("data", jsonOBj);
//
//            } else {
//                // 校验失败
//                resultMap.put("state", UmcTokenState.INVALID.toString());
//            }
//
//        } catch (Exception e) {
//            // token格式不合法导致的异常
//            resultMap.clear();
//            resultMap.put("state", UmcTokenState.INVALID.toString());
//            logger.error("", e);
//        }
//        return resultMap;
//    }
//
//
//}
//
