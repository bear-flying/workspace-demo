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
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=path%>/js/jquery-1.7.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.8.js"></script>
  </head>
  
  <body>
    <center>
    	<form action="">
    		<table border="1" width="65%">
    			<tr>
    				<td>
    					<input type="checkbox" id="selAll">全选
    				</td>
    				<td>编号</td>
    				<td>姓名</td>
    				<td>年龄</td>
    				<td>学院</td>
    				<td>班级</td>
    				<td>入学时间</td>
    				<td>操作</td>
    			</tr>
    			<c:forEach items="${jiangYu.list}" var="p">
    			<tr>
    				<td>
    					<input type="checkbox" name="ids">
    				</td>
    				<td>${p.id}</td>
    				<td>${p.name}</td>
    				<td>${p.age}</td>
    				<td>${p.academy.name}</td>
    				<td>${p.classes.cname}</td>
    				<td>${p.adddate}</td>
    				<td>
    					<a href="core/toModify.do?id=${p.id}">修改</a>
    				</td>
    			</tr>
    			</c:forEach>
    		</table>
    		${jiangYu.pageAll}
    		<input type="button" value="添加" onclick="location='core/toAdd.do'">
    	</form>
    </center>
  </body>
</html>
