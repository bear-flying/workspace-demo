package com.cms.servlet;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.pojo.Newstype;

import com.cms.service.NewsInfoService;
import com.cms.service.NewstypeService;
import com.xiaobai.utils.PageBean;

public class NewstypeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NewstypeService ns = new NewstypeService();
	private NewsInfoService nis = new NewsInfoService();
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String method = request.getParameter("method");
		try {
			Method methodname = this.getClass().getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			methodname.invoke(this, request,response);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	protected void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String page = request.getParameter("page");
		String pageSize = request.getParameter("pageSize");

		if(page==null){
			page="1";
		}
		if(pageSize==null){
			pageSize="10";
		}
		
		PageBean<Newstype> pageBean = ns.query(new Integer(page),new Integer(pageSize));
		//System.out.println(pageBean.getList());
		request.setAttribute("pages", page);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/WEB-INF/newstype/newstypeshow.jsp").forward(request, response);
	
	}
	
	protected void toSave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/newstype/newstypesave.jsp").forward(request, response);
	
	}
	protected void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		Newstype n = new Newstype();
		n.setName(name);
		ns.add(n);
		response.sendRedirect("newstype?method=query");
	}
	protected void drop(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String[] ids = request.getParameterValues("ids");
		for (String s : ids) {
			nis.dropByTypeId(new Integer(s));
			ns.drop(new Integer(s));
		}
		
		response.sendRedirect("newstype?method=query");
	}
	protected void alter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Newstype n = new Newstype();
		n.setId(new Integer(id));
		n.setName(name);
		ns.alter(n);
		response.sendRedirect("newstype?method=query");
	}
	protected void queryOne(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		Newstype n = ns.queryOne(new Integer(id));
		request.setAttribute("n", n);
		request.getRequestDispatcher("/WEB-INF/newstype/newstypeupdate.jsp").forward(request, response);
		
	}


}
