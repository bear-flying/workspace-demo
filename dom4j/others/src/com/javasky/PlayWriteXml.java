package com.javasky;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class PlayWriteXml extends HttpServlet {

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
		
		String url = "jdbc:oracle:thin:@192.168.1.177:1521:orcl";
		String user = "scott";
		String pwd ="tiger";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(url, user, pwd);
			
			String sql = "select * from dept";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			/*获得 元数据*/
			ResultSetMetaData rsmd = rs.getMetaData();
			
			/*创建一个xml文档*/
			Document xml = DocumentHelper.createDocument();
			/*创建一个元素, 作为 根元素*/
			Element root = DocumentHelper.createElement("employees");
			xml.setRootElement(root);
			
			PreparedStatement pstmt = conn.prepareStatement("select * from emp where deptno=?");
			
			while(rs.next()){
				Element deptE = root.addElement("dept");
				for(int i=1; i<=rsmd.getColumnCount(); i++){
					Element deptInfo = deptE.addElement(rsmd.getColumnLabel(i));
					deptInfo.setText(rs.getString(i));
				}
				/*创建员工元素*/
				Element emps = deptE.addElement("emps");
				pstmt.setInt(1, rs.getInt("deptno"));
				ResultSet rsemp = pstmt.executeQuery();
				ResultSetMetaData rsmdEmp = rsemp.getMetaData();
				while(rsemp.next()){
					Element emp = emps.addElement("employee");
					for(int i=1; i<=rsmdEmp.getColumnCount(); i++){
						Element empInfo = emp.addElement(rsmdEmp.getColumnLabel(i));
						empInfo.setText(rsemp.getString(i) == null ?"0":rsemp.getString(i));
					}
				}
			}
			
			/*格式化 xml 文档输出*/
			OutputFormat fmt = new OutputFormat("\t", true);
			XMLWriter writer = new XMLWriter(fmt);
			writer.write(xml);
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		
		out.print("xml文档已经生成");
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
