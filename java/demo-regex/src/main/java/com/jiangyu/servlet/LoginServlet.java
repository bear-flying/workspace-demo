package com.jiangyu.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
*/

public class LoginServlet /*extends HttpServlet*/ {

	/*
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1. 从客户端获取表单输入的值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String qq = request.getParameter("qq");
		String idCard = request.getParameter("idCard");
		String email = request.getParameter("email");
		
		//2.创建一个集合，将数据提示信息保存到集合中
		List<String> list = new ArrayList<String>();
		//用户名
		if(!username.matches("[0-9a-zA-Z]{4,}"))
		{
			list.add("用户名格式不正确，请输入4位以上的字母或者数字");
		}
		else{
			list.add("用户名格式正确");
		}
		//密码
		if(!password.matches("\\d{1,4}"))
		{
			list.add("密码格式不正确，请输入1-4位的数字。");
		}
		else{
			list.add("密码格式正确");
		}
		//QQ
		if(!qq.matches("\\d{5,11}"))//[0-9]{4,12} QQ必须是4-12位
		{
			list.add("QQ号格式不正确");
		}
		else{
			list.add("QQ号格式正确");
		}
		//身份证
		if(!idCard.matches("\\d{17}[0-9|x]"))
		{
			list.add("身份证号格式不正确");
		}
		else{
			list.add("身份证号格式正确");
		}
		//邮箱
		if(!email.matches("w{3}.*"))//[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+
		{
			list.add("邮箱格式不正确");
		}
		else{
			list.add("邮箱格式正确");
		}
		
		//将存放信息的集合放入到request作用域中
		request.setAttribute("list", list);
		
		//转发到登录页面
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}
	*/
}
