//package com.xx.test.util;
//
//import com.alibaba.fastjson.JSON;
//import com.sun.deploy.net.HttpResponse;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.conn.ClientConnectionManager;
//import org.apache.http.conn.scheme.Scheme;
//import org.apache.http.conn.scheme.SchemeRegistry;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//import org.springframework.http.HttpEntity;
//
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLSocketFactory;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;
//import java.security.cert.CertificateException;
//import java.security.cert.X509Certificate;
//import java.util.Iterator;
//import java.util.Map;
//
//public class SSLClient {
//    public SSLClient() throws Exception {
//        super();
//        //传输协议需要根据自己的判断
//        SSLContext ctx = SSLContext.getInstance("TLS");
//        X509TrustManager tm = new X509TrustManager() {
//            @Override
//            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
//            }
//
//            @Override
//            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
//            }
//
//            @Override
//            public X509Certificate[] getAcceptedIssuers() {
//                return null;
//            }
//        };
//        ctx.init(null, new TrustManager[]{tm}, null);
//        SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
//        ClientConnectionManager ccm = this.getConnectionManager();
//        SchemeRegistry sr = ccm.getSchemeRegistry();
//        sr.register(new Scheme("https", 443, ssf));
//    }
//
//
//
//    public static String doPost(String url) {
//        String charset = "utf-8";
//        org.apache.http.client.HttpClient httpClient = null;
//        HttpPost httpPost = null;
//        String result = null;
//        try {
//            httpClient = new SSLClient();
//            httpPost = new HttpPost(url);
//            HttpResponse response = httpClient.execute(httpPost);
//            if (response != null) {
//                HttpEntity resEntity = response.getEntity();
//                if (resEntity != null) {
//                    result = EntityUtils.toString(resEntity, charset);
//                }
//            }
//        } catch (Exception ex) {
//            log.error("POST请求异常:{}", ex.getMessage());
//        }
//        return result;
//    }
//
//    public static String doPost(String url, Map<String,String> map) {
//        String charset = "utf-8";
//        org.apache.http.client.HttpClient httpClient = null;
//        HttpPost httpPost = null;
//        String result = null;
//        try {
//            httpClient = new SSLClient();
//            httpPost = new HttpPost(url);
//            //设置参数
//            if(null != map) {
//                List<NameValuePair> list = new ArrayList<NameValuePair>();
//                Iterator iterator = map.entrySet().iterator();
//                while (iterator.hasNext()) {
//                    Map.Entry<String, String> elem = (Map.Entry<String, String>) iterator.next();
//                    list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
//                }
//                if (list.size() > 0) {
//                    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
//                    entity.setContentType("application/x-www-form-urlencoded");
////                httpPost.setHeader("Accept", "text/plain;charset=utf-8");
//                    httpPost.setHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
//                    httpPost.setEntity(entity);
//                }
//            }
//            HttpResponse response = httpClient.execute(httpPost);
//            if (response != null) {
//                HttpEntity resEntity = response.getEntity();
//                if (resEntity != null) {
//                    result = EntityUtils.toString(resEntity, charset);
//                }
//            }
//        } catch (Exception ex) {
//            log.error("POST请求异常:{}", ex.getMessage());
//        }
//        return result;
//    }
//
//
//
//
//    public static String doPost(String url, String body) {
//        String charset = "utf-8";
//        org.apache.http.client.HttpClient httpClient = null;
//        HttpPost httpPost = null;
//        String result = null;
//        try {
//            httpClient = new SSLClient();
//            httpPost = new HttpPost(url);
//            StringEntity entity = new StringEntity(body, charset);
//            entity.setContentType("application/json");
//            httpPost.setHeader("Content-type", "application/json; charset=utf-8");
//            httpPost.setEntity(entity);
//            HttpResponse response = httpClient.execute(httpPost);
//            if (response != null) {
//                HttpEntity resEntity = response.getEntity();
//                if (resEntity != null) {
//                    result = EntityUtils.toString(resEntity, charset);
//                }
//            }
//        } catch (Exception ex) {
//            log.error("POST请求异常:{}", ex.getMessage());
//        }
//        return result;
//    }
//
//    public static String doPost(String url, String body, String headKey, String headValue) {
//        String charset = "utf-8";
//        org.apache.http.client.HttpClient httpClient = null;
//        HttpPost httpPost = null;
//        String result = null;
//        try {
//            httpClient = new SSLClient();
//            httpPost = new HttpPost(url);
//            StringEntity entity = new StringEntity(body, charset);
//            entity.setContentType("application/json");
//            httpPost.setHeader("Content-type", "application/json; charset=utf-8");
//            if(!StringUtils.isBlank(headKey) && !StringUtils.isBlank(headValue)){
//                httpPost.setHeader(headKey, headValue);
//            }
//            httpPost.setEntity(entity);
//            HttpResponse response = httpClient.execute(httpPost);
//            if (response != null) {
//                HttpEntity resEntity = response.getEntity();
//                if (resEntity != null) {
//                    result = EntityUtils.toString(resEntity, charset);
//                }
//            }
//        } catch (Exception ex) {
//            log.error("POST请求异常:{}", ex.getMessage());
//        }
//        return result;
//    }
//
//    public static void main(String[] args){
//        UmcExternalCreateTbAccountRspBO  rspBO = new UmcExternalCreateTbAccountRspBO();
//        String json  = JSON.toJSONString(rspBO);
//        rspBO.setCode(json);
//        System.out.println(rspBO);
//    }
//}
