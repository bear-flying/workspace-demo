package com.bee.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bee.dao.SearchDao;
import com.bee.vo.Food;

public class SearchServlet extends HttpServlet {
	/**
	 * 超级蜜蜂专用搜索菜品的Servlet
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if(method.equals("select")){
			queryFood(request,response);
		}
	}



	public void queryFood(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String city = new String(request.getParameter("city").getBytes("ISO-8859-1"),"utf-8");
		String content = new String(request.getParameter("content").trim().getBytes("ISO-8859-1"),"utf-8");

		request.setAttribute("city",city+"市有如下菜品，欢迎品尝！");
		SearchDao dao = new SearchDao();
		List<Food> list1 = dao.querySome(city,content);
		//System.out.println(list1);
		if(list1.size()==0){
			request.setAttribute("sorry", "抱歉！没有找到您的搜索，");
			List<Food> list2 = dao.querySome(city, null);
			request.setAttribute("vegetables", list2);
			request.getRequestDispatcher("show.jsp").forward(request, response);
		}else{
			request.setAttribute("vegetables", list1);
			request.getRequestDispatcher("show.jsp").forward(request, response);
		}
	}

	
	
}
