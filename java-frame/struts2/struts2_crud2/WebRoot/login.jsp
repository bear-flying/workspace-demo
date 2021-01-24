<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

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
	<!--<s:form action="">
		<s:textfield name="username" label="用户名"></s:textfield>
		<s:password name="password" label="密码"></s:password>
		<s:radio list="{'男','女'}" name="sex" label="性别"></s:radio>
		<s:select list="{'北京','上海','广州'}" name="address" label="地址"></s:select>
		<s:checkboxlist list="#{'read':'看书','netplay':'上网','music':'音乐' }"
			name="hobby" label="兴趣"></s:checkboxlist>
		<s:textarea cols="30" rows="4" label="简介"></s:textarea>
		<s:submit value="提交"></s:submit>
	</s:form>-->
	<s:form >
		<s:textfield name="username" label="用户"></s:textfield>
		<s:password name="password" label="密码"></s:password>
		<s:radio list="{'男','女'}" name="sex" label="性别"></s:radio>
		<s:checkboxlist list="#{'work':'工作','net':'上网','da':'抠脚'} "
		  name="hong" 	label="hobby"></s:checkboxlist>
		   	
		  
		<s:select list="{'上海','北京','罗马'}" label="地址"></s:select>
		<s:textarea label="描述："></s:textarea>
		<s:file label="上传"></s:file>
		<s:date name="date" format="yyyy-mm-dd" id="wang" timezone="2015-9-12" nice="122" var="wang"/>
		
		<s:submit value="登录"></s:submit>
	</s:form>
</body>
</html>
