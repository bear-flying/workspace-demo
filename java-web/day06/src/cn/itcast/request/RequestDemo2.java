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

public class RequestDemo2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		String value=request.getParameter("username");
		System.out.println(value);
		
		Enumeration e=request.getParameterNames();
		while(e.hasMoreElements()){
			String name=(String) e.nextElement();
			value=request.getParameter(name);
			System.out.println(name+"="+value);
		}
		
		String value2[]=request.getParameterValues("username");
		for(String v:value2){
			System.out.println("u="+v);
		}
		
		Map<String,String[]> map=request.getParameterMap();
		User user=new User();
		User formbean=new User();
		try {
			BeanUtils.populate(user, map);//用map集合填充bean
			BeanUtils.copyProperties(user, formbean);//bean的拷贝
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println(user);
		*/
		InputStream in=request.getInputStream();
 		byte buffer[]=new byte[1024];
 		int len=0;
 		while((len=in.read(buffer))>0){
 			System.out.println(new String(buffer,0,len));
 		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	private void test1(HttpServletRequest request) {
		//获取头相关数据
		String headValue=request.getHeader("Accept-Encoding");
		
		Enumeration e=request.getHeaderNames();
		while(e.hasMoreElements()){
			String value=(String) e.nextElement();
			System.out.println(value);
		}
		
		e=request.getHeaderNames();
		while(e.hasMoreElements()){
			String name=(String) e.nextElement();
			String value=request.getHeader(name);
			System.out.println("name="+name+",value="+value);
		}
	}

}
