package com.javasky;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class PlayXmlServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		String path = getServletContext().getRealPath("/");
		File file = new File(path+"/001.xml");
		
		/*使用 org.dom4j下的工具类 解析 xml*/
		SAXReader xmlReader = new SAXReader();
		try {
			Document xmlDoc = xmlReader.read(file);
			/* 读到 xmlDoc 的根元素*/
			Element root = xmlDoc.getRootElement();
			out.print(root.getName());
			out.print("<br/>");
			/* 通过 根元素获得 子元素*/
			List<Element> elements = root.elements();
			for(Element element : elements){
				out.print(element.getName());
				if(element.elements().size()>0){
					for(Element e : (List<Element>)element.elements()){
						out.print(e.getName());
						out.print("<br/>");
						
						if(e.elements().size()>0){
							for(Element e2 : (List<Element>)e.elements()){
								out.print(e2.getText());
								out.print("<br/>");
							}
						}
					}
				}
				out.print("<br/>");
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
