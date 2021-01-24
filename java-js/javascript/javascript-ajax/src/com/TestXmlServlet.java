package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestXmlServlet extends HttpServlet  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/xml;charset=utf-8"); 
		
		String name=request.getParameter("sname"); 
		System.out.println("ajaxtest"+"--"+name); 
		
		 // 给页面回传值     
		
		PrintWriter out=response.getWriter();
		out.print("<xml>"); 
		out.print("<id>007</id>"); 
		out.print("<name>"+name+"</name>"); 
		out.print("</xml>"); 
		out.close(); 
		
	}	
}

