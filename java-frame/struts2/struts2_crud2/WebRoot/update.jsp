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
    
    <title>My JSP 'update.jsp' starting page</title>
    
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
    <s:form action="emp!alter.action" theme="simple">
    	姓名：<s:textfield name="emp.name" label="姓名"></s:textfield>
    	<s:radio list="{'男','女'}" name="emp.sex" label="性别"></s:radio>
    	<s:checkboxlist list="{'火腿','食人','普通','超级'}"
		    name="emp.hobby" label="爱好"></s:checkboxlist>
<%--	<s:select list="#{'财务部':'财务部','销售部':'销售部','人事部':'人事部'}" name="name" label="姓名"></s:select>--%>
		<s:select list="#request.rolelist"
			listKey="id" listValue="rname" name="emp.rid"
			label="种类"></s:select>
		<s:submit value="提交"></s:submit>
    </s:form>
  </body>
</html>
