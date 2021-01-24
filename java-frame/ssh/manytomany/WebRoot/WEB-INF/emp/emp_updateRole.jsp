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
    
    <title>My JSP 'emp_updateRole.jsp' starting page</title>
    
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
  <s:form action="core_saveUserRole.action">
 	
<%--    <s:iterator value="#request.roleList" var="r">--%>
		<!-- 两个都叫id 加一个var区分名字 -->
<%--    	<s:iterator value="#request.userRoleList" var="ur">--%>
<%--    		<s:property value ="#ur.id"/>--%>
<%--  		</s:iterator>--%>
<%--  		<input type="checkbox" name="roleid" value='<s:property value ="#r.id"/>'>  <s:property value ="name"/><br>--%>
<%--    </s:iterator>--%>

	<!-- 只要一次request请求 struts2就自动把ModelDriven中的
	实体类压到栈顶  所以就算没有传递实体类对象 这里也一样取值-->
	<input type="hidden" name="id" value="${id}">
	<!-- 自动遍历value集合 比较 勾选 -->
	<s:checkboxlist name="roleid" list="#request.roleList" 
		value="#request.userRoleList.{id}" listKey="id" 
		listValue="name">
	</s:checkboxlist>
	<input type="submit" value="保存">
  </s:form>
  </body>
</html>
