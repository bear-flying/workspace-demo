package com.stumgr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javasky.daos.LoginDao;
import com.stumgr.pojo.User;

public class LoginServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//设置响应类型
		response.setContentType("text/html;charset=UTF-8");
		//设置请求字符集
		request.setCharacterEncoding("UTF-8");
		
		User user = null;
		//从登陆表单中获得sname和spwd
		String uname =request.getParameter("sname");
		String upwd =request.getParameter("spwd");
		//创建dao
		LoginDao logindao= new LoginDao();
		user=logindao.getUserByName(uname);
		if(null!=user){//有此用户
			if(user.getPwd().equals(upwd)){
				//登陆成功，转发到系统主菜单
				request.getRequestDispatcher("/master/master.jsp").forward(request, response);
				
			}else{
				//密码错误，回到登录页面，提示密码不正确
				/*请求登陆对象，被请求对象 可以从请求中提取 信息*/
				request.setAttribute("err", "用户名或者密码不对");
				//跳转页面
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				
			}
		}else{
			request.setAttribute("err", "无此用户");//err这个名必须与JSP页面中EL表达式中的名一样
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
	}

}
