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
	
	<link rel="stylesheet" type="text/css" href="styles/styles.css">
	

  </head>
  
  <body>
    <table>
    	<tr>
    		<td>编号</td>
    		<td>名称</td>
    		<td>价格</td>
    		<td>生产日期</td>
    		<td>品牌</td>
    		<td>操作</td>
    	</tr>
    	
    	<c:forEach items="${jiangYu.list}" var="p">
    	<tr>
    		<td>${p.id}</td>
    		<td>${p.name}</td>
    		<td>${p.price}</td>
    		<td>${p.datea}</td>
    		<td>${p.brand.dname}</td>
    		<td>
    		 	<input type="button" value="修改" onclick="location='<%=path%>/core/toModify.do?id=${p.id}'">
    			<input type="button" value="删除" >
    		</td>
    	</tr>
    	</c:forEach>
    </table>
    <div align="center">
    	${jiangYu.pageAll }
    </div>
  </body>
</html>
