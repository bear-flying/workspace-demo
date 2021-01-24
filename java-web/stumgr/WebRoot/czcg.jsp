<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'czcg.jsp' starting page</title>
    
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
    <h1>操作成功</h1>
    <h3>本窗口，2秒自动关闭，如果不关闭，请手动</h3>
    <script type="text/javascript">
    	<%--第一种写法是：setTimeout("openner.location.reload();close();",2000);
    	(自动刷新；关闭；2秒)--%>
    	
    	<%--(自动刷新；关闭；2秒)如下：也可以写一段代码，让它自动调用查询来实现，
    	这种就需要在student文件夹下的top.jsp中的form标签中加入name属性,
    	还需要在student文件夹下的master.jsp中的第一个frame标签中加上
    	name属性--%>
    	setTimeout("openner.parent.frames[0].document.forms['topForm'].submit();close();",2000);
    </script>
  </body>
</html>
