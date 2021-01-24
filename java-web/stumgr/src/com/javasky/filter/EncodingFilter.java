package com.javasky.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		/*把 字符进行转码*/
			//设置响应类型
	    	response.setContentType("text/html;charset=UTF-8");
	    	//设置请求字符集
	    	request.setCharacterEncoding("UTF-8");
	    /*传递请求*/
	    chain.doFilter(request, response);
	
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
