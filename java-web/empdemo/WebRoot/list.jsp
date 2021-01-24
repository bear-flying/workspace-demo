<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,com.emp.domain.Friend"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
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
    String url = "jdbc:oracle:thin:localhost:1521:ORCL";
	String sql = "select * from friend";
	Friend friend =null;
	ArrayList<Friend> al = new ArrayList<Friend>();
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection(url,"scott","tiger");
	PreparedStatement stmt = conn.prepareStatement(sql);
    ResultSet rs = stmt.executeQuery();
	while(rs.next()){
		friend = new Friend();
		friend.setId(rs.getInt(1));
		friend.setName(rs.getString(2));
		friend.setDescription(rs.getString(3));
		friend.setAge(rs.getInt(4));
		al.add(friend);
	}
	rs.close();
	stmt.close();
	conn.close();
    %>
    
    <a href='add.jsp'>添加新的朋友</a><br/>
    <table border='1' bordercolor='gree' cellspacing='0'>
    	<tr>
    		<td>朋友ID</td>
    		<td>朋友姓名</td>
    		<td>朋友描述</td>
    		<td>朋友年龄</td>
    		<td>操作朋友</td>
    	</tr>
    <%
    for(Friend fri : al){
    %>
    	<tr>
    		<td><%=fri.getId() %></td>
    		<td><%=fri.getName() %></td>
    		<td><%=fri.getDescription() %></td>
    		<td><%=fri.getAge() %></td>
    		<td>
    			<a href='update.jsp?id=<%=fri.getId()%>'>修改</a>
    			<a href='delete.jsp?id=<%=fri.getId()%>'>删掉</a>
    		</td>
    	</tr>
    <%
    }	
    %>
    </table>
  </body>
</html>
