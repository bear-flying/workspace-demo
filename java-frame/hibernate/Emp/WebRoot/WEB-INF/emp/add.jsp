<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="xv" uri="/struts-dojo-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<xv:head/>
  </head>
  
  <body>
    <s:form action="emp!add.action">
    	姓名：<s:textfield name="name"></s:textfield><br><br>
    	生日：<xv:datetimepicker name="hiredate" displayFormat="yyyy-MM-dd"></xv:datetimepicker><br><br>
    	<s:select name="emp.dept.did" list="list" listKey="did" listValue="deptn" 
    		headerKey="aa" headerValue="-请选择-"></s:select><br><br>
    	<s:submit value="提交"></s:submit>
    </s:form>
  </body>
</html>
