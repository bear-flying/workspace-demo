package com.baidu.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.baidu.entity.Power;

public class MyFilter implements Filter {

	private Set<String> urls = new HashSet<String>();
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

		HttpServletRequest req = (HttpServletRequest) request;
		StringBuffer sb = req.getRequestURL();
		String url = sb.substring(sb.lastIndexOf("/")+1);
		System.out.println("url=============================="+url);

		Object user = req.getSession().getAttribute("user");
		List<Power> list = (List<Power>) req.getSession().getAttribute("powers");


		if(urls.contains(url)){
			chain.doFilter(request, response);

		}else{
			if(user==null){
				request.setAttribute("msg", "非法访问，请登录");
				req.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}else{
				for(Power p:list){
					if(url.equals(p.getUrl())){
						
						chain.doFilter(request, response);
					}
					
				}
				request.setAttribute("msg", "你没有这个url的访问权限，一边玩去");
				RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
				try {
					dispatcher.forward(request, response);
					return ;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}


		}
	}


	/*		
		if(user==null){
			if(urls.contains(url)){
				System.out.println("这是登陆的action，可以直接放行===============");
				chain.doFilter(request,response);
			}else{
				System.out.println("未登录已经被拦截了==================================");
			}
		}else{
			if(list!=null&&list.size()>0){
				for(Power p:list){
					if(url.equals(p.getUrl())){
						chain.doFilter(request,response);
						//continue;

					}
				}
				if(urls.contains(url)){
					System.out.println("这是登陆的action，可以直接放行===============");
					chain.doFilter(request,response);
				}else {
					System.out.println("权限不足已经被拦截了==================================");
				}
			}else {
				System.out.println("权限不足已经被拦截了==================================");
			}

		}*/



	/**
	 * 过滤所有action中的方法(user!login.action...)
	 */
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器的初始化======================");
		//获取web.xml中的参数
		String s = config.getInitParameter("notCheckUrl");
		String[] url = s.split(",");
		if(url!=null&&url.length>0){
			for(String u:url){
				urls.add(u.trim());
			}
		}
	}

}
