package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





public class Search extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Db db=new Db();
		List<Worker> list=db.showDb();
		String name=request.getParameter("name");
		for(int i=0;i<list.size();i++){
		if(name.equals(list.get(i).getName())){
		  System.out.println(list.get(i));
			out.println("<tr><td>"+list.get(i).getId()+"</td><td>"+list.get(i).getName()+"</td><td>"+list.get(i).getSex()+"</td></tr>");
		}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);

	}
}
