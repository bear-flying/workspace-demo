package com.stumgr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javasky.daos.StudentDao;
import com.stumgr.pojo.Student;

public class SaveStudent extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//在doPost方法中的第一行处理乱码的问题
		req.setCharacterEncoding("UTF-8");//设置字符集 与HTML中设置的要相同
		//从表单中获得数据 装对象
		Student student = new Student();
		student.setSname(req.getParameter("sname"));//从表单中的name属性获取信息
		student.setGender(req.getParameter("gender"));
		student.setMobile(req.getParameter("mobile"));
		student.setClasses(req.getParameter("classes"));
		//爱好允许多选 如果一个都没有选 得到的是null 如果选择了 我们应该把它装到字符串数组
		String[] hobby = req.getParameterValues("hobby");
		if(null==hobby){
			hobby = new String[]{""};
		}
		String hobbyStr = "";
		for(String str : hobby){
			hobbyStr+=str+",";
		}
		student.setHobby(hobbyStr);
		
		StudentDao dao = new StudentDao();
		
		//从表单中获取sno 如果没有获取到 就是新增 否则为修改
		String sno = req.getParameter("sno");
		boolean flag = false;
		if("".equals(sno)){
			flag = dao.save(student);
		}else{
			student.setSno(Integer.parseInt(sno));
			flag = dao.update(student);
		}
		if(flag){
			req.getRequestDispatcher("/czcg.jsp").forward(req, resp);
		}else{
			req.getRequestDispatcher("/czsb.jsp").forward(req, resp);
		}
	}

	
}
