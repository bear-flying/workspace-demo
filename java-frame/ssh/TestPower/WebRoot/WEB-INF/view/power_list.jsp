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
    		<td>权限编号</td>
    		<td>权限名称</td>
    		<td>操作(<a href="<c:url value='/user!toPowerAdd.action'/>">添加</a>)</td>
    	</tr>
    <c:forEach items="${list}" var="power">
    	<tr align="center">
    		<td>${power.id }</td>
    		
    		<td>${power.pname}</td>
    		<td colspan="10">
    		<a href="<c:url value='/user!toUpdate.action?id=${power.id }'/>">编辑</a>
    		<a href="<c:url value='/user!delete.action?id=${power.id }'/>">删除</a>
    		
    		</td>
    	</tr>
    
    </c:forEach>
    </table>
    
  </body>
  
</html>
