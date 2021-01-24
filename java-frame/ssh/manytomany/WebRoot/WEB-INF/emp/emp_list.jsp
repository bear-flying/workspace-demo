<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'emp_list.jsp' starting page</title>
    
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
    		<td>ID</td>
    		<td>姓名</td>
    		<td>操作</td>
    	</tr>
    	<s:iterator value="list">
    	<tr>
    		<td><s:property value="id"/></td>
    		<td><s:property value="name"/></td>
    		<td>
    			<a href="<%=path%>/core_findOne.action?id=<s:property value="id"/>">修改</a>
    			<a href="<%=path%>/core_remove.action?id=<s:property value="id"/>">删除</a>
    			<a href="<%=path%>/core_toRole.action?id=<s:property value="id"/>">分配角色</a>
    		</td>
    	</tr>
    	</s:iterator>
    </table>
  </body>
</html>
