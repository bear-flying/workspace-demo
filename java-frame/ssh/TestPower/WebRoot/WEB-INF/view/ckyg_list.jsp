<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script language="JavaScript" src="<c:url value='/FusionCharts/Charts/FusionCharts.js'/>"></script>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/index.css" type="text/css"></link>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.js"></script>
  <body onload="tubiao()">
  
    <table border="1" align="center">
    	<tr align="center">
    		<td>员工编号</td>
    		<td>员工名字</td>
    		<td>员工密码</td>
    		<td>员工年龄</td>
    		<td>员工职位</td>
    		<td>  </td>
    	</tr>
    <c:forEach items="${list}" var="user">
    	<tr align="center">
    		<td>${user.id }</td>
    		<td><a href="<c:url value='/user!getUserById.action?id=${user.id }'/>">${user.name }</a>
    		</td>
    		<td>${user.password }</td>
    		<td>${user.age}</td>
    		<td>${user.rname}</td>
    		<td colspan="10">
    		<a href="<c:url value='/user!toUpdate.action?id=${user.id }'/>">编辑</a>
    		
    		</td>
    	</tr>
    
    </c:forEach>
    </table>
    <h1 align="center">
   <input type="button" value="关闭" onclick="closes()"/>
  
  </h1>
  </body>
  <script type="text/javascript">
  function closes(){
		window.close();
	  }
  
  </script>
</html>
