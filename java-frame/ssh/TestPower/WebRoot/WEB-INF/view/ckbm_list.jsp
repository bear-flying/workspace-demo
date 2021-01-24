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
  <h3 align="center">【${user.name }】所属部门情况</h3>
    <table border="1" align="center">
    	<tr align="center">
    		<td>部门编号</td>
    		<td>员工部门</td>
    		<td>部门人数</td>
    	</tr>
    	<c:forEach items="${user.dept}" var="dept">
    	<tr align="center">
    		
    		
    		
    			<td>${dept.deptid}</td>
    			<td>${dept.dname}</td>
    		
    			<td>${dept.num }</td>
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
