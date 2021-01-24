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

  </head>
  
  <body>
    <center>
    	<form action="">
    	<table border="1" cellspacing="0" width="60%">
    	
    		<tr>
    			<td>
    				<input type="checkbox" id="selAll">全选
    			</td>
    			<td>电影名称</td>
    			<td>票价</td>
				<td>地区</td>
    			<td>上映时间</td>
    			<td>类型</td>
    			<td>操作</td>
    		</tr>
    		<c:forEach items="${jiangYu.list}" var="a">
    		<tr>
    			<td>
    				<input type="checkbox" name="ids">
    			</td>
    			<td>${a.name}</td>
    			<td>${a.price}</td>
				<td>
					${a.addressId} 
				</td>
    			<td>${a.datea}</td>
    			<td>${a.type.typename}</td>
    			<td>
    				<a href="<%=path%>/core/toModify.do?id=${a.id}">修改</a>
    			</td>
    		</tr>
    		</c:forEach>
    	</table>
    	<input type="button" value="新增" onclick="location='<%=path%>/core/toAdd.do'">
    	${jiangYu.pageAll}
    	</form>
    </center>
  </body>
</html>
