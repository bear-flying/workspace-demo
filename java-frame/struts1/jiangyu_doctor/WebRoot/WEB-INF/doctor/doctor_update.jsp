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
    
    <title>My JSP 'doctor_update.jsp' starting page</title>
    
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
    <form action="<%=request.getContextPath()%>/doctor.do?method=alter" method="post">
    	姓名：<input type="text" name="name" value="${dd.name}">
    	年龄：<input type="text" name="age" value="${dd.age}">
    	简介：<input type="text" name="content" value="${dd.content}">
    		<input type="hidden" name="id" value="${dd.id}">
    	学历：<select name="xid">
    			<c:forEach items="${list}" var="l">
    				<option value="${l.xid}" <c:if test="${l.xid==dd.xid}">selected</c:if> >${l.xname}</option>
    				 
    			</c:forEach>
    		</select>
    	<input type="submit" value="提交">
    </form>
  </body>
</html>
