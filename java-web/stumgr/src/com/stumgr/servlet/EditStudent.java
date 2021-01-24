package com.stumgr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javasky.daos.StudentDao;

public class EditStudent extends HttpServlet {

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

		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		StudentDao sd = new StudentDao();
		/*把查询到的学生对象传递到edit.jsp中.  在list.jsp中，通过点击修改按钮
		 * 调用了一个javascript把sno传过来   其中 sno在表单中和url中 都叫做“请求参数”
		 * 我们获得请求参数的时候，就用request.getParameter("参数名")*/
		request.setAttribute("STU", sd.getBySno(Integer.parseInt(request.getParameter("sno"))));
		
		/*跳转到/student/edit.jsp中去*/
		request.getRequestDispatcher("/student/edit.jsp").forward(request, response);
		
	}

}
