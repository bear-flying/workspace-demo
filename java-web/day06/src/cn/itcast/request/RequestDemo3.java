package cn.itcast.request;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.User;

public class RequestDemo3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getParameter("username");
		request.getParameter("password");
		request.getParameter("gender");
		request.getParameter("city");
		request.getParameter("city");
		String[] likes=request.getParameterValues("likes");
		for(int i=0;likes!=null && i<likes.length;i++){
			System.out.println(likes[i]);
		}
		request.getParameter("description");
		
		request.getParameter("id");
		
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
