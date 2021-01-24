<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.emp.domain.Friend"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
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
    	String sql = "select * from friend where id=?";
    	Friend friend =new Friend();
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection conn = DriverManager.getConnection(url,"scott","tiger");
    	PreparedStatement stmt = conn.prepareStatement(sql);
    	stmt.setInt(1, new Integer(id));
        ResultSet rs = stmt.executeQuery();
    	
        while(rs.next()){
	    	friend.setId(rs.getInt(1));
	    	friend.setName(rs.getString(2));
	    	friend.setDescription(rs.getString(3));
	    	friend.setAge(rs.getInt(4));
        }
        rs.close();
        stmt.close();
        conn.close();
    %>
    
   
    <form action="update2.jsp" method='post'>
    	朋友ID：<input type="text" value=<%=friend.getId()%> name="id" />	<br/>	
    	朋友姓名：<input type="text" value=<%=friend.getName()%> name="name" /><br/>
    	朋友描述：<input type="text" value=<%=friend.getDescription()%> name="decription" /><br/>
    	朋友年龄：<input type="text" value=<%=friend.getAge()%> name="age" /><br/>
    	<input type="submit" value="确认修改">
    </form>
    
  </body>
</html>
