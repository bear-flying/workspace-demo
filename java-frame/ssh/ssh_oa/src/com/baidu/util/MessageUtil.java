package com.baidu.util;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * 给手机发信息
 * 中国网建（http://www.smschinese.cn/default.shtml）发送手机信息
 * 用户名wangxiaohong
 * 密码973958
 * 需要设置用户信息修改----短信中文后缀修改
 */
public class MessageUtil {
	public static void sendMsg(String phone,String content){
		try {
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");
			post.addRequestHeader("Content-Type",
					"application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码
			NameValuePair[] data = { new NameValuePair("Uid", "wangxiaohong"),//本站用户名
					new NameValuePair("Key", "ea03cb96a699850b2b6c"),//接口安全秘钥
					new NameValuePair("smsMob", phone),//目标手机号
					new NameValuePair("smsText",content) };//发送内容
			post.setRequestBody(data);
			
			client.executeMethod(post);
			Header[] headers = post.getResponseHeaders();
			int statusCode = post.getStatusCode();
			System.out.println("statusCode:" + statusCode);
			for (Header h : headers) {
				System.out.println(h.toString());
			}
			String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
			System.out.println(result); // 打印返回消息状态
			post.releaseConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 原代码
	 */
	public static void main(String[] args) throws Exception {

		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码
		NameValuePair[] data = { new NameValuePair("Uid", "wangxiaohong"),
				new NameValuePair("Key", "ea03cb96a699850b2b6c"),
				new NameValuePair("smsMob", "18010471740"),
				new NameValuePair("smsText", "乐爷，你好叼哦！") };
		post.setRequestBody(data);
		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:" + statusCode);
		for (Header h : headers) {
			System.out.println(h.toString());
		}
		String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
		System.out.println(result); // 打印返回消息状态
		post.releaseConnection();
	}
	
	/**
	 * 	操作结果
	 *  statusCode:200
	 *	Cache-Control: no-cache
	 *  Content-Length: 1
	 *	Content-Type: text/html
	 *	Expires: Thu, 24 Dec 2015 23:39:56 GMT
	 *  Server: Microsoft-IIS/7.5
	 *	Set-Cookie: CHNET=Temp%5Fusername=201512267395623577; expires=Thu, 20-Sep-2018 23:39:56 GMT; path=/
	 *  Set-Cookie: ASPSESSIONIDCACBABBS=PFJFOJMCOEHHLMHIOECOOGGI; path=/
	 *  X-Powered-By: ASP.NET
	 *	Date: Fri, 25 Dec 2015 23:39:56 GMT
	 *  1（表示发送的条数）
	 */
	

}
