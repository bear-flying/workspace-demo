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
    
    <title>My JSP 'delete.jsp' starting page</title>
    
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
    	String id = request.getParameter("id");
    	
    	String url = "jdbc:oracle:thin:localhost:1521:ORCL";
    	String sql = "delete from friend where id=?";
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection conn = DriverManager.getConnection(url,"scott","tiger");
    	PreparedStatement stmt = conn.prepareStatement(sql);
    	stmt.setInt(1, new Integer(id));
        int result = stmt.executeUpdate();
    	
        if(result>0){
        	response.sendRedirect("list.jsp");
        }
        stmt.close();
    	conn.close();
    %>
  </body>
</html>
