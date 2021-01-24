<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sessiontimeout.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<!-- 加上top 表示返回frameset框架的最顶层 否则会在框架的center.jsp处出现登陆框 -->
	<script type="text/javascript">
		window.onload = function()
		{
			alert("账号已经过期，请重新登录");
			window.top.location.href="<%=request.getContextPath()%>/index.jsp";
		}
		
	</script>
  </head>
  
  <body>
   		
  </body>
</html>
