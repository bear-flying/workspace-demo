package com.cms.servlet;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.pojo.Role;
import com.cms.service.RoleService;
import com.xiaobai.utils.PageBean;

public class RoleServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private RoleService rs = new RoleService();
	
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
		PageBean<Role> pageBean = rs.queryByPage(new Integer(page),new Integer(pageSize));

		request.setAttribute("pages", page);
		request.setAttribute("pageBean", pageBean);
		
		request.getRequestDispatcher("/WEB-INF/role/rolelist.jsp").forward(request, response);
	
	}
	protected void toSave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/role/rolesave.jsp").forward(request, response);
	
	}
	protected void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String rolename = request.getParameter("rolename");
		String roledesc = request.getParameter("roledesc");
		
		rs.add(new Role(rolename,roledesc));
		response.sendRedirect("role?method=query");
	}
	protected void alter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String rolename = request.getParameter("rolename");
		String roledesc = request.getParameter("roledesc");
		
		rs.alter(new Role(new Integer(id),rolename,roledesc));
		response.sendRedirect("role?method=query");
	}
	protected void drop(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String[] ids = request.getParameterValues("ids");
		for(String s : ids){
			rs.dropMiddle(new Integer(s));
			rs.drop(new Integer(s));
			
		}
		
		response.sendRedirect("role?method=query");
	}
	protected void queryOne(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		Role r = rs.queryOne(new Integer(id));
		request.setAttribute("r", r);
		request.getRequestDispatcher("/WEB-INF/role/roleupdate.jsp").forward(request, response);
		
	}
}
