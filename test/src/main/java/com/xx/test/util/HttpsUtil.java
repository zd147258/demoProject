package com.xx.test.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 标题: HttpsUtil
 * 说明: https工具类
 * 时间: 2021/12/7 17:14
 * @author 郑冬
 **/
@Slf4j
public class HttpsUtil {
    /**
     * 连接超时
     */
    private static int CONNECTION_TIMEOUT = 10000;
    /**
     * 读取超时
     */
    private static int READ_TIMEOUT = 30000;


    public static String buildQuery(Map params, String charset) throws Exception {
        if ((params == null) || (params.isEmpty())) {
            return null;
        }

        StringBuffer query = new StringBuffer();
        Set entries = params.entrySet();
        Iterator it = entries.iterator();
        boolean hasParam = false;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String name = (String) entry.getKey();
            String value = (String) entry.getValue();
            if (!StringUtils.isEmpty(new String[] { name, value })) {
                if (hasParam) {
                    query.append("&");
                } else {
                    hasParam = true;
                }
                query.append(name).append("=").append(value);
            }

        }

        System.out.println("query==>"+ query);
        log.debug("请求参数==>{}", query);
        return query.toString();
    }



    public static String doPost(String url, Map params, String charset, int connectTimeout, int readTimeout)
            throws Exception {
        String ctype = "application/x-www-form-urlencoded;charset=" + charset;
        String query = buildQuery(params, charset);
        byte[] content = new byte[0];
        if (query != null) {
            content = query.getBytes(charset);
        }
        return doPost(url, ctype, content, connectTimeout, readTimeout);
    }


    private static HttpsURLConnection getConnection(URL url, String method, String ctype) throws IOException {
        HttpsURLConnection conn = null;

        conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod(method);
        conn.setDoInput(true);
        if ("POST".equals(method)) {
            conn.setDoOutput(true);
        }
        return conn;
    }

    public static String doPost(String url, String ctype, byte[] content, int connectTimeout, int readTimeout) throws IOException, KeyManagementException, NoSuchAlgorithmException {

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, new TrustManager[] { new TrustAnyTrustManager() },
                new java.security.SecureRandom());
        HttpsURLConnection conn = null;
        OutputStream out = null;
        String rsp = null;
        try {
            conn = getConnection(new URL(url), "POST", ctype);

            System.setProperty("sun.net.client.defaultConnectTimeout", String.valueOf(connectTimeout));
            System.setProperty("sun.net.client.defaultReadTimeout", String.valueOf(readTimeout));

            out = conn.getOutputStream();
            out.write(content);
            out.flush();
            rsp = getResponseAsString(conn);
            log.debug("msg==>{}", rsp);
            System.out.println("msg==>"+ rsp);
        } finally {
            if (out != null) {
                out.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rsp;
    }

    private static String getResponseCharset(String ctype) {
        String charset = "UTF-8";
        if (!StringUtils.isEmpty(ctype)) {
            String[] params = ctype.split(";");
            int len = params.length;
            for (int i = 0; i < len; i++) {
                String param = params[i];
                param = param.trim();
                if (param.startsWith("charset")) {
                    String[] pair = param.split("=", 2);
                    if ((pair.length != 2) || (StringUtils.isEmpty(pair[1]))) {
                        break;
                    }
                    charset = pair[1].trim();

                    break;
                }
            }
        }
        return charset;
    }

    private static String getStreamAsString(InputStream stream, String charset) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, charset));
            StringWriter writer = new StringWriter();

            char[] chars = new char['A'];
            int count = 0;
            while ((count = reader.read(chars)) > 0) {
                writer.write(chars, 0, count);
            }
            return writer.toString();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    protected static String getResponseAsString(HttpURLConnection conn) throws IOException {
        log.debug("ResponseCode==>{}", conn.getResponseCode());
        System.out.println("ResponseCode==>"+ conn.getResponseCode());
        String charset = getResponseCharset(conn.getContentType());
        InputStream es = conn.getErrorStream();
        if (es == null) {
            InputStream input = conn.getInputStream();
            return getStreamAsString(input, charset);
        }
        String msg = getStreamAsString(es, charset);
        if (StringUtils.isEmpty(msg)) {
            throw new IOException(conn.getResponseCode() + ":" + conn.getResponseMessage());
        }
        return msg;
    }

    private static class TrustAnyTrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[] {};
        }
    }

    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
}
