package com.hthl.jwt.sdk.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

public class HttpClientPostFs {

	private static Map<String, String> parameter = new HashMap<String, String>();

	private HttpServletResponse response;

	public HttpClientPostFs() {

	}

	public HttpClientPostFs(HttpServletResponse response) {

		this.response = response;

	}

	public void setParameter(String key, String value) {

		HttpClientPostFs.parameter.put(key, value);

	}

	public void sendByPost(String url, String redirectUrl) throws IOException {

		this.response.setContentType("text/html");

		PrintWriter out = this.response.getWriter();

		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");

		out.println("<HTML>");

		out.println(" <HEAD><TITLE>sender</TITLE></HEAD>");

		out.println(" <BODY>");

		out.println("<form name=\"submitForm\" action=\"" + url + "\" method=\"post\">");

		Iterator<String> it = HttpClientPostFs.parameter.keySet().iterator();

		while (it.hasNext()) {

			String key = it.next();

			out.println("<input type=\"hidden\" name=\"" 
					+ key + "\" value=\"" 
					+ HttpClientPostFs.parameter.get(key)
					+ "\"/>");

		}

		out.println("</from>");

		out.println("<script>window.document.submitForm.submit();window.location.href=" 
				+ redirectUrl + "</script> ");

		out.println(" </BODY>");

		out.println("</HTML>");

		out.flush();

		out.close();

	}

}
