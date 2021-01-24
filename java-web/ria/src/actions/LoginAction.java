package actions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vos.Login;

import daos.LoginDao;

public class LoginAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		//System.out.println("========"+method);
		if(method.equals("login")){
			login(request,response);
		}else if(method.equals("search")){
			search(request,response);
		}else if(method.equals("register")){
			register(request,response);
		}
	}


	public void register(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String rank = request.getParameter("rank");
		LoginDao ld = new LoginDao();
		ld.insert(new Login(new Integer(rank),user,pass));
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	public void search(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String user = request.getParameter("user");
		LoginDao ld = new LoginDao();
		PrintWriter out = response.getWriter();
		Login one = ld.queryOne(new Login(user));
		if(one!=null){
			out.println(1);
			out.flush();
			out.close();
		}else{
			out.println(0);
			out.flush();
			out.close();
		}
	}

	public void login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String user = request.getParameter("user");
		//System.out.println(user+"==========");
		String pass = request.getParameter("pass");
		LoginDao ld = new LoginDao();
		Login one = ld.queryOne(new Login(user));
		if(one!=null){
			String isSave = request.getParameter("isSave");
			if(ld.login(new Login(user,pass))){
				if(isSave!=null&&isSave.equals("y")){
					Cookie cookie1 = new Cookie("username", user);
					Cookie cookie2 = new Cookie("password", pass);
					cookie1.setMaxAge(7*24*60*60);
					cookie2.setMaxAge(7*24*60*60);
					cookie1.setPath("/ria");
					cookie2.setPath("/ria");
					response.addCookie(cookie1);
					response.addCookie(cookie2);
				}
				HttpSession session = request.getSession();
				session.setAttribute("key", user);
				//System.out.println(one.getRank());
				session.setAttribute("one", one.getRank());
				request.getRequestDispatcher("/student?method=queryStudent").forward(request, response);
			}else{
				request.setAttribute("err", "密码错误！");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("err", "无此用户！");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}
	
	
	
}
