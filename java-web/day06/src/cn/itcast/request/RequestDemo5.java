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

public class RequestDemo5 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String message="aaaaaa";
		request.setAttribute("data", message);
		request.getRequestDispatcher("/mesage.jsp").forward(request, response);
		
		request.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		
		response.setCharacterEncoding("gb2312");
		response.setContentType("text/htm;charset=gb2312");
		response.getWriter().write(username);
		
		//System.out.println(username);
		
		
	}
	
	



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
