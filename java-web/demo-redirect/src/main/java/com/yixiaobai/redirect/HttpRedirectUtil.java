package com.yixiaobai.redirect;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

public class HttpRedirectUtil {

	private static Map<String, String> parameter = new HashMap<String, String>();

	private HttpServletResponse response;

	public HttpRedirectUtil() {

	}

	public HttpRedirectUtil(HttpServletResponse response) {
		this.response = response;
	}

	public void setParameter(String key, String value) {
		HttpRedirectUtil.parameter.put(key, value);
	}

	public void sendByPost(String url) throws IOException {

		this.response.setContentType("text/html");

		PrintWriter out = this.response.getWriter();

		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>sender</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<form name=\"submitForm\" action=\"" + url + "\" method=\"post\" >");
		Iterator<String> it = HttpRedirectUtil.parameter.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			out.println("<input type=\"hidden\" name=\"" 
					+ key + "\" value=\"" 
					+ HttpRedirectUtil.parameter.get(key)
					+ "\"/>");
		}
		out.println("</from>");
		out.println("<script>window.document.submitForm.submit();</script> ");
		out.println(" </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	public static void main(String[] args) {
//		System.out.println("---->跳转页面中...");
//      String mainUrl = "http://www.baidu.com";
//      HttpRedirectUtil http = new HttpRedirectUtil(response);
//      http.setParameter("userID", "1");
//      http.setParameter("userCode", "JiangYu");
//		http.sendByPost(mainUrl);
	}
	
}
