//package com.xx.test.util;
//
//import com.sun.deploy.net.HttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.util.EntityUtils;
//import org.apache.tomcat.util.codec.binary.Base64;
//import org.springframework.http.HttpEntity;
//import org.springframework.util.StringUtils;
//
//import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;
//
//public class HttpUtil {
//    public static String doPost(String url, String body) {
//        String charset = "utf-8";
//        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        HttpPost httpPost = null;
//        String result = null;
//        StringEntity stringEntity = null;
//        try {
//            if(!StringUtils.isEmpty(body)){
//                stringEntity = new StringEntity(body, Charset.forName("UTF-8"));
//            }
//            httpPost = new HttpPost(url);
//            httpPost.setHeader("Content-type", "application/json;charset=UTF-8");
//            httpPost.setHeader("Accept", "application/json");
//            httpPost.setEntity(stringEntity);
//            HttpResponse response = httpClient.execute(httpPost);
//            if (response != null) {
//                HttpEntity resEntity = response.getEntity();
//                if (resEntity != null) {
//                    result = EntityUtils.toString(resEntity, charset);
//                }
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return result;
//    }
//
//    public static String doPostBase64(String url, String body) {
//        String charset = "utf-8";
//        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        HttpPost httpPost = null;
//        String result = null;
//        StringEntity stringEntity = null;
//        try {
//            if(!StringUtils.isEmpty(body)){
//                byte[] authEncBytes = Base64.encodeBase64(body.getBytes(StandardCharsets.UTF_8));
//                String authStringEnc = new String(authEncBytes);
//                stringEntity = new StringEntity(authStringEnc);
//            }
//            httpPost = new HttpPost(url);
//            httpPost.setHeader("Content-type", "application/json;charset=UTF-8");
//            httpPost.setHeader("Accept", "application/json");
//            httpPost.setEntity(stringEntity);
//            HttpResponse response = httpClient.execute(httpPost);
//            if (response != null) {
//                HttpEntity resEntity = response.getEntity();
//                if (resEntity != null) {
//                    result = EntityUtils.toString(resEntity, charset);
//                }
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return result;
//    }
//
//    public static String doPostGb2312(String url, String body) {
//        String charset = "GB2312";
//        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        HttpPost httpPost = null;
//        String result = null;
//        StringEntity stringEntity = null;
//        try {
//            if(!StringUtils.isEmpty(body)){
//                stringEntity = new StringEntity(body, Charset.forName("GB2312"));
//            }
//            httpPost = new HttpPost(url);
//            httpPost.setHeader("Content-type", "application/json;charset=GB2312");
//            httpPost.setHeader("Accept", "application/json");
//            httpPost.setEntity(stringEntity);
//            HttpResponse response = httpClient.execute(httpPost);
//            if (response != null) {
//                HttpEntity resEntity = response.getEntity();
//                if (resEntity != null) {
//                    result = EntityUtils.toString(resEntity, charset);
//                }
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return result;
//    }
//
//    public static void main(String[] args){
//
//        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/service/get_corp_token");
//        OapiServiceGetCorpTokenRequest req = new OapiServiceGetCorpTokenRequest();
//        req.setAuthCorpid("ding8616c1004720326035c2f4657eb6378f");
//        OapiServiceGetCorpTokenResponse execute = null;
//        try {
//            execute = client.execute(req,"suitebc1ptkerxrfwjvyz",
//                    "7MDQkwgMskfXJnOAlsyHZy4lpzUlnQw8GSBjoawWw2N6XKAyJhlYAhnjyTAi-pi-", "");
//
//            System.out.println(execute.getErrcode());
//            System.out.println(execute.getMessage());
//            System.out.println(execute.getAccessToken());
//
//            DingTalkClient client2 = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/getuserinfo");
//            OapiUserGetuserinfoRequest request = new OapiUserGetuserinfoRequest();
//            request.setCode("fd7a1c0dd2993a478a72cac6cc243a9d");
//            request.setHttpMethod("GET");
//            OapiUserGetuserinfoResponse response = null;
//            try {
//                response = client2.execute(request, execute.getAccessToken());
//                System.out.println(response.getErrmsg());
//                System.out.println(response.getUserid());
//            } catch (ApiException e) {
//                e.printStackTrace();
//            }
//        } catch (ApiException e) {
//            e.printStackTrace();
//        }
//    }
//}
