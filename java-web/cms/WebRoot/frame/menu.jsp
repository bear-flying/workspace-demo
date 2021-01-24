<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  	<link rel="stylesheet" href="common/dtree/dtree.css" type="text/css"></link>
  	<script type="text/javascript" src="common/dtree/dtree.js"></script>
  </head>
  
  <body style="background-color: aqua;">
  	
  	<!-- dtree：
  		引入dtree.css和dtree.js文件
  		根节点的parentID必须是-1 
  		参数：add（此节点的ID,此节点的父节点的ID(parentID),
  				节点的名字,URL,target(在哪个窗口打开),图片,图片,图片）
  		
  	-->
  	<script type="text/javascript">
  	
  		var d = new dTree('d');
  		
  		d.add(0, -1, "CMS管理系统");
  		
  		d.add(1, 0 , "业务管理" );
  		
  		d.add(3, 1 , "新闻类型" ,"newstype?method=query","newstype","mainPage","common/dtree/img/page.gif");
  		d.add(4, 1 , "新闻信息" ,"newsinfo?method=query","newsmanager","mainPage","common/dtree/img/page.gif");
  		
  		d.add(2 ,0 , "系统管理");
  		d.add(5, 2 , "用户信息" ,"user?method=query","usermessage","mainPage","common/dtree/img/page.gif");
  		d.add(6, 2 , "角色信息" ,"role?method=query","rolemessage","mainPage","common/dtree/img/page.gif");
  		
  		document.write(d);
  	
  	</script>
  	
  
  </body>
</html>
