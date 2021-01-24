<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title><s:text name="title" /></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/index.css">
	
	<s:head theme="ajax"/>
  </head>
  
  <body>
    <h1><s:text name="title" /></h1>
    <a href="<%=request.getContextPath() %>/user!change.action?request_locale=zh_CN">中文</a>
	<a href="<%=request.getContextPath() %>/user!change.action?request_locale=en_US">英文</a>
    <s:form action="user!add" theme="simple">
   
    	<s:text name="name" />：<s:textfield name="userModel.name" /><br>
    	<s:text name="pwd" />：<s:password name="userModel.pwd" /><br>
    	年龄：<s:textfield name="userModel.age" /><br>
    	性别：<s:radio list="{'男','女'}" name="userModel.sex"/><br>
    	爱好：<s:checkboxlist list="{'小说','电影','散步','游戏'}"  name="userModel.hobby" /><br>
    	简介：<s:textarea name="userModel.content" cols="30" rows="5" /><br>
    	部门：<s:select name="userModel.dept" list="#{'财务':'财务','人力':'人力'}" headerKey="aaa" headerValue="--请选择--" /><br>
    	出生日期：<s:datetimepicker type="date" name="userModel.datea" displayFormat="yyyy-MM-dd" /><br>
    	<s:submit value="添加"/>
    	
    </s:form>
  </body>
</html>
