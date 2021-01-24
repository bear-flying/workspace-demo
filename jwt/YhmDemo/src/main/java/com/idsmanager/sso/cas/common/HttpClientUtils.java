package com.idsmanager.sso.cas.common;


import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

import java.security.KeyStore;

/**
 * @ClassName HttpClientUtils
 * @Author HaominYang
 * @Date 2018/12/13 17:15
 **/
public class HttpClientUtils {
    public  synchronized HttpClient warpClient(){
        HttpClient client = new DefaultHttpClient();
        try {

            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);

            SSLSocketFactory sf = new SSLSocketFactoryNew(trustStore);
            sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);  //允许所有主机的验证

            HttpParams params = new BasicHttpParams();
            HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(params, HTTP.DEFAULT_CONTENT_CHARSET);
            HttpProtocolParams.setUseExpectContinue(params, true);

            // 设置连接管理器的超时
            ConnManagerParams.setTimeout(params, 10000);
            // 设置连接超时
            HttpConnectionParams.setConnectionTimeout(params, 10000);
            // 设置socket超时
            HttpConnectionParams.setSoTimeout(params, 10000);
            // 设置http https支持
            SchemeRegistry schReg = new SchemeRegistry();
            schReg.register(new Scheme("https", sf, 443));

            ClientConnectionManager conm = client.getConnectionManager();
            conm.getSchemeRegistry().register(new Scheme("https", sf, 443));
            client= new DefaultHttpClient(conm, params);

        } catch (Exception e) {
            e.printStackTrace();
            return new DefaultHttpClient();
        }
        return client;
    }
}
