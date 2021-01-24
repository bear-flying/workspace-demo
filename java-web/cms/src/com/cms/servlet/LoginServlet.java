package com.cms.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.pojo.User;
import com.cms.service.LoginService;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//鍏堣�铏戦獙璇佺爜 濡傛灉楠岃瘉鐮佷笉瀵�鍒欐病鏈夊繀瑕佸啀姣旇緝鐢ㄦ埛鍚嶅拰瀵嗙爜浜�
		//鑾峰彇鐢ㄦ埛濉殑楠岃瘉鐮�
		String yzm = request.getParameter("yzm");
		//System.out.println("***"+yzm+"***");
		//鑾峰彇闅忔満浜х敓鐨勯獙璇佺爜
		Object randomCode = request.getSession().getAttribute("randomCode");
		if(yzm==null){
			//System.out.println("111");
			response.sendRedirect("index.jsp");
			return;
		}
		if(!yzm.equals(randomCode.toString())){
			request.setAttribute("errorInfo",  "楠岃瘉鐮侀敊璇紒");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		
		String login_name = request.getParameter("login_name");
		String password = request.getParameter("password");
		
		LoginService service = new LoginService();
		int result = service.checkLogin(login_name, password);
	
		if(result == 0){
			//鎴愬姛
			User user = service.getUserByLoginName(login_name);
			
			String isSave = request.getParameter("isSave");
			if(isSave!=null&&isSave.equals("y")){
				Cookie cookie1 = new Cookie("login_name",login_name);
				Cookie cookie2 = new Cookie("password",password);
				cookie1.setMaxAge(7*24*60*60);
				cookie2.setMaxAge(7*24*60*60);
				response.addCookie(cookie1);
				response.addCookie(cookie2);
				
			}
			
			request.getSession().setAttribute("user", user);
			//request.getSession().setAttribute("login", "zhangsan");
			request.setAttribute("login", "zhangsan");
			request.getRequestDispatcher("/frame/main.jsp").forward(request, response);
		}else{
			//澶辫触
			request.setAttribute("errorInfo", result == 1 ? "鐢ㄦ埛鍚嶄笉瀛樺湪锛�":"瀵嗙爜閿欒锛�");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	
	}
}
