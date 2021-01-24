package com.javase.others;

import java.net.*;
class URLDemo {
	public static void main(String[] args) throws MalformedURLException{
		URL url = new URL("http://192.168.1.254/myweb/demo.html?name=haha&age=30");
		System.out.println("getProtocol() :"+url.getProtocol());//获取此 URL 的协议名称。
		System.out.println("getHost() :"+url.getHost());//获取此 URL的主机名（如果适用）
		System.out.println("getPort() :"+url.getPort());//获取此 URL的端口号。 
		System.out.println("getPath() :"+url.getPath());//获取此 URL的路径部分。
		System.out.println("getFile() :"+url.getFile());//获取此 URL的文件名。
		System.out.println("getQuery() :"+url.getQuery());//获取此 URL的查询部。

		/*int port = getPort();
		if(port==-1)
			port = 80;

		getPort()==-1
		*/
	}
}
/*
String getFile() 
         获取此 URL 的文件名。 
String getHost() 
         获取此 URL 的主机名（如果适用）。 
String getPath() 
         获取此 URL 的路径部分。 
int getPort() 
         获取此 URL 的端口号。 
String getProtocol() 
         获取此 URL 的协议名称。 
String getQuery() 
         获取此 URL 的查询部 

*/