package cn.itcast.request;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.User;

public class RequestDemo4 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		System.out.println(request.getCharacterEncoding());
		//test3(request, response);
		
		//System.out.println(username);
		
		
	}


	private void test3(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		
		response.setCharacterEncoding("gb2312");
		response.setContentType("text/htm;charset=gb2312");
		response.getWriter().write(username);
	}
	
	
	private void test2(HttpServletRequest request)
			throws UnsupportedEncodingException {		
		//解决POST乱码
		request.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		System.out.println(username);
	}

	private void test1(HttpServletRequest request)
			throws UnsupportedEncodingException {
	// 解决Get方式提交的乱码
		String username2=request.getParameter("username2");
		username2=new String(username2.getBytes("iso-8859-1"),"UTF-8");
		System.out.println(username2);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
