<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    String id=request.getParameter("id");
    String name=request.getParameter("name");
    String description=request.getParameter("decription");
    String age=request.getParameter("age");
    
    Class.forName("oracle.jdbc.driver.OracleDriver");
    String url="jdbc:oracle:thin:localhost:1521:ORCL";
    String sql="update friend set name=?,description=?,age=? where id=?";
   	Connection conn = DriverManager.getConnection(url, "scott", "tiger");
   	PreparedStatement stmt =conn.prepareStatement(sql);
   	stmt.setInt(4, new Integer(id));
   	stmt.setString(1, name);
   	stmt.setString(2, description);
   	stmt.setInt(3, new Integer(age));
   	
   	int result = stmt.executeUpdate();
   	
   	response.sendRedirect("list.jsp");
   	stmt.close();
   	conn.close();
    %>
  </body>
</html>
