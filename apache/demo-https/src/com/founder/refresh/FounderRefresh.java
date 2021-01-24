package com.founder.refresh;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

public class FounderRefresh {

	
	public static void refresh(List<String> urls, List<String> dirs){

		String url = "https://r.chinacache.com/content/refresh";
		
		try {
			String json = convertJSON(urls, dirs);
			sendHttpsRequestByPost(url,json);
			/*
			//1.获得httpclient
			HttpClient httpClient = new DefaultHttpClient();
			//2.request对象
			HttpPost httpPost = new HttpPost(url);
			
			//为request对象赋值，请求头和请求正文
			//httpPost.setHearder("","");//设置请求头
			StringEntity requestEntity = new StringEntity(json,"UTF-8");
			requestEntity.setContentEncoding("UTF-8");
			requestEntity.setContentType("application/json");
			httpPost.setEntity(requestEntity);

			//3.执行httpclient得到response对象
			//CloseableHttpResponse response = httpClient.execute(httpPost);
			HttpResponse response = httpClient.execute(httpPost);
			//解析response对象，响应正文
			HttpEntity entity = response.getEntity();
			String content = EntityUtils.toString(entity);
			System.out.println(content);
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static String convertJSON(List<String> urls, List<String> dirs) throws Exception{
		//封装callback
		List<String> emails = new ArrayList<String>();
		emails.add("651806859@qq.com");
		RefreshCallBack refreshCallBack = new RefreshCallBack(emails);
		//封装task
		RefreshTask refreshTask = new RefreshTask(urls,dirs,refreshCallBack);
		//最后的封装
		RefreshModel refreshModel = new RefreshModel();
		refreshModel.setTask(refreshTask);
		
		ObjectMapper mapper = new ObjectMapper();
    
		//mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, Boolean.TRUE);

		String json = mapper.writeValueAsString(refreshModel);

	    System.out.println("Java2Json: "+json);
		
		return json;
	}
	
	public static final String sendHttpsRequestByPost(String url, String json) {
		String responseContent = null;
		HttpClient httpClient = new DefaultHttpClient();
		//创建TrustManager
		X509TrustManager xtm = new X509TrustManager() {
			public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
			public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		//这个好像是HOST验证
		X509HostnameVerifier hostnameVerifier = new X509HostnameVerifier() {
			
			public boolean verify(String hostname, SSLSession session) {
				return false;
			}
			public void verify(String arg0, SSLSocket arg1) throws IOException {}
			public void verify(String arg0, X509Certificate arg1) throws SSLException {}
			public void verify(String arg0, String[] arg1, String[] arg2) throws SSLException {}
		};
		try {
			//TLS1.0与SSL3.0基本上没有太大的差别，可粗略理解为TLS是SSL的继承者，但它们使用的是相同的SSLContext
			SSLContext ctx = SSLContext.getInstance("TLS");
			//使用TrustManager来初始化该上下文，TrustManager只是被SSL的Socket所使用
			ctx.init(null, new TrustManager[] { xtm }, null);
			//创建SSLSocketFactory
			SSLSocketFactory socketFactory = new SSLSocketFactory(ctx);
			socketFactory.setHostnameVerifier(hostnameVerifier);
			//通过SchemeRegistry将SSLSocketFactory注册到我们的HttpClient上
			httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", socketFactory, 443));
			
			HttpPost httpPost = new HttpPost(url);
			StringEntity requestEntity = new StringEntity(json,"UTF-8");
			requestEntity.setContentEncoding("UTF-8");
			requestEntity.setContentType("application/json");
			httpPost.setEntity(requestEntity);
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			String content = EntityUtils.toString(entity);
			System.out.println(content);
			//以下为传递参数Map时的写法
//			HttpPost httpPost = new HttpPost(url);
//			List<NameValuePair> formParams = new ArrayList<NameValuePair>(); // 构建POST请求的表单参数
//			for (Map.Entry<String, String> entry : params.entrySet()) {
//				formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
//			}
//			httpPost.setEntity(new UrlEncodedFormEntity(formParams, "UTF-8"));
//			HttpResponse response = httpClient.execute(httpPost);
//			HttpEntity entity = response.getEntity(); // 获取响应实体
//			if (entity != null) {
//				responseContent = EntityUtils.toString(entity, "UTF-8");
//			}
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			// 关闭连接,释放资源
			httpClient.getConnectionManager().shutdown();
		}
		return responseContent;
	}
	
	
}
