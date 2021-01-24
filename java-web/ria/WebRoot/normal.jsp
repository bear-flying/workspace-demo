<%@ page language="java" import="java.util.*,vos.Student" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'normal.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script src="js/jquery-1.8.2.js"></script>
  <script type="text/javascript">
  $(function(){
	  $("#changes").click(function(){
		  location="index.jsp";
	  });
	  $("#rank").click(function(){
		  open('open.jsp','ErrorStudent','top=150,left=200,width=300,height=400');
	  });
  });
  </script>
  <body>
    <%
    String s = (String)session.getAttribute("key");
    if(s==null){
    	response.sendRedirect("index.jsp");
    }else{
    	List<Student> list = (List)request.getAttribute("list"); 
    %>
    	<h2 align="center">欢迎：<%=s%>!访问飞天猫熊小白侠姜宇的表格！</h2>
    	<form action="student">
    	<table align="center" border="1" width="35%">
    		<tr>
    			<td>ID:</td><td>姓名:</td><td>年龄:</td><td>生日:</td>
    		</tr>
    <% 
    	if(list!=null){
    		for(Student st : list){
    %>
    		<tr>
    		<td><%=st.getId() %></td>
    		<td><%=st.getName() %></td>
    		<td><%=st.getAge() %></td>
    		<td><%=st.getHiredate() %></td>
    		</tr>
    		
    	  <%} %>
    	  
      <%} 
      }%>
      <tr><td colspan="4" align="center"><input type="button" value="更换用户" id="changes"></td></tr>
      </table></form>
      <%
      String sss = "";
      int aaa = (Integer)session.getAttribute("one"); 
      if(aaa==0){
    	  sss="普通";
      }else{
    	  sss="特殊";
      }
      %>
      <p align="center">亲爱哒，你的权限是：<%=sss %>&nbsp;&nbsp;<input type="button" value="更改权限" id="rank"></p>
  </body>
</html>
