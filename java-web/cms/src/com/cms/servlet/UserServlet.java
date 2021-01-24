package com.cms.servlet;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cms.pojo.Role;
import com.cms.pojo.User;
import com.cms.pojo.UserRole;

import com.cms.service.RoleService;
import com.cms.service.UserRoleService;
import com.cms.service.UserService;
import com.xiaobai.utils.PageBean;

public class UserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserService us = new UserService();
	private RoleService rs = new RoleService();
	private UserRoleService urs = new UserRoleService();
	
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
		String condition = request.getParameter("condition");
		User user = new User();
		user.setReal_name(condition);
		if(page==null){
			page="1";
		}
		if(pageSize==null){
			pageSize="10";
		}
		PageBean<User> pageBean = us.queryByPage(new Integer(page),new Integer(pageSize),user);
		//System.out.println(pageBean.getList());
		request.setAttribute("u", user);
		request.setAttribute("pages", page);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/WEB-INF/user/usershow.jsp").forward(request, response);
	
	}
	
	protected void toSave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/user/usersave.jsp").forward(request, response);
	
	}
	protected void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		
		us.add(new User(loginname,password,realname,sex,new Integer(age)));
		response.sendRedirect("user?method=query");
	}
	protected void drop(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String[] ids = request.getParameterValues("ids");
		for(String s : ids){
			us.dropMiddle(new Integer(s));
			us.drop(new Integer(s));
			
		}
		
		response.sendRedirect("user?method=query");
	}
	protected void alter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		us.alter(new User(new Integer(id),loginname,password,realname,sex,new Integer(age)));
		response.sendRedirect("user?method=query");
	}
	protected void queryOne(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		User n = us.queryOne(new Integer(id));
		request.setAttribute("n", n);
		request.getRequestDispatcher("/WEB-INF/user/userupdate.jsp").forward(request, response);
		
	}
	protected void userRole(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = us.findUserById(userId);
		List<Role> roleList = rs.query();
		request.setAttribute("user", user);
		request.setAttribute("roleList", roleList);
		
		List<UserRole> userRoleList = urs.findUserRolesById(userId);
		request.setAttribute("userRoleList", userRoleList);
		request.getRequestDispatcher("/WEB-INF/user/user_role_list.jsp").forward(request, response);

	}
	//给对应的User对象分配角色
	protected void changeRole(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取User对象的主键
		int userId = Integer.parseInt(request.getParameter("userid"));
		//2.获取Role对象的主键
		String[] roleIds = request.getParameterValues("roleid");
		
		
		//3.保存到t_user_role中建立两个表的多对多的关联
		//4.(注意：保存之前，要删除此User对象的所有角色)
		us.changeRole(userId, roleIds);
		
		response.sendRedirect("user?method=query");
		
	}


}






