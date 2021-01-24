package com.cms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.pojo.User;



public class CheckSessionFilter implements Filter {

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req ;
		HttpServletResponse response = (HttpServletResponse) resp ;
		
		User user = (User) request.getSession().getAttribute("user");
		
		if(user != null)
		{
			chain.doFilter(req, resp);
		}else
		{
			//  无session 或 session过期-----》返回登录页面
			request.getRequestDispatcher("sessiontimeout.jsp").forward(request, response);
		}
	
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
