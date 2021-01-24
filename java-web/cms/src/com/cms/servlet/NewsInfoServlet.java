package com.cms.servlet;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.pojo.NewsInfo;
import com.cms.pojo.Newstype;
import com.cms.service.NewsInfoService;
import com.cms.service.NewstypeService;
import com.xiaobai.utils.PageBean;

public class NewsInfoServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NewsInfoService nd = new NewsInfoService();
	private NewstypeService ns = new NewstypeService();
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String method = request.getParameter("method");
		try {
			Method methodname = this.getClass().getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			methodname.invoke(this, request,response);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	protected void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String page = request.getParameter("page");
		String pageSize = request.getParameter("pageSize");
		String newstitle = request.getParameter("newstitle");
		String newsauthor = request.getParameter("newsauthor");
		String newscontent = request.getParameter("newscontent");
			
		NewsInfo n = new NewsInfo();
		n.setNewsTitle(newstitle);
		n.setNewsAuthor(newsauthor);
		n.setNewsContent(newscontent);
	
		if(page==null){
			page="1";
		}
		if(pageSize==null){
			pageSize="10";
		}
		
		PageBean<NewsInfo> pageBean = nd.queryByPage(new Integer(page),new Integer(pageSize),n);
		//System.out.println(pageBean.getList());
		request.setAttribute("n", n);
		request.setAttribute("pages", page);
		request.setAttribute("pageBean", pageBean);
		
		
		
		request.getRequestDispatcher("/WEB-INF/newsinfo/newsinfoshow.jsp").forward(request, response);
	
	}
	
	protected void toSave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Newstype> list = ns.queryAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/newsinfo/newsinfosave.jsp").forward(request, response);
	
	}
	protected void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String newsTitle = request.getParameter("newstitle");
		String newsAuthor = request.getParameter("newsauthor");
		String typeId = request.getParameter("typeid");
		String newsContent = request.getParameter("newscontent");
		String createDatetime = request.getParameter("createdatetime");
		String updateDatetime = request.getParameter("updatedatetime");
		
		nd.add(new NewsInfo(newsTitle,newsAuthor,new Integer(typeId),newsContent,Date.valueOf(createDatetime),Date.valueOf(updateDatetime)));
		response.sendRedirect("newsinfo?method=query");
	}
	protected void drop(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String[] ids = request.getParameterValues("ids");
		for (String s : ids) {
			//System.out.println(s);
			nd.drop(new Integer(s));
		}
		
		response.sendRedirect("newsinfo?method=query");
	}
	protected void alter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		//System.out.println(id);
		String newsTitle = request.getParameter("newstitle");
		String newsAuthor = request.getParameter("newsauthor");
		String typeId = request.getParameter("typeid");
		String newsContent = request.getParameter("newscontent");
		String createDatetime = request.getParameter("createdatetime");
		String updateDatetime = request.getParameter("updatedatetime");
		nd.alter(new NewsInfo(new Integer(id),newsTitle,newsAuthor,new Integer(typeId),newsContent,Date.valueOf(createDatetime),Date.valueOf(updateDatetime)));
		response.sendRedirect("newsinfo?method=query");
	}
	protected void queryOne(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		NewsInfo n = nd.queryOne(new Integer(id));
		//System.out.println(n);
		request.setAttribute("n", n);
		List<Newstype> list = ns.queryAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/newsinfo/newsinfoupdate.jsp").forward(request, response);
		
	}


	
}
