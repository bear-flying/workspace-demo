<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>用户管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/index.css">
	
	<s:head theme="ajax"/>
  </head>
  
  <body>
    <h1>用户管理</h1>
    <s:form action="user!update" theme="simple" method="post" enctype="multipart/form-data">
    <s:hidden name="userModel.id" /><br>
    	用户名：<s:textfield name="userModel.name" /><br>
    	密码：<s:textfield name="userModel.pwd" /><br>
    	年龄：<s:textfield name="userModel.age" /><br>
    	性别：<s:radio list="{'男','女'}" name="userModel.sex"/><br>
    	爱好：<s:checkboxlist list="{'小说','电影','散步','游戏'}"  name="userModel.hobby" /><br>
    	简介：<s:textarea name="userModel.content" cols="30" rows="5" /><br>
    	部门：<s:select name="userModel.dept" list="#{'财务':'财务','人力':'人力'}" headerKey="aaa" headerValue="--请选择--" /><br>
    	出生日期：<s:datetimepicker type="date" name="userModel.datea" displayFormat="yyyy-MM-dd" /><br>
    	照片：<s:file name="myfile" />
    		<img src="<%=request.getContextPath() %>/upload/${userModel.filepath }" width="60" height="80" />
    		 <s:hidden name="userModel.filepath" />
    	<br>
    	<s:submit value="修改"/>
    	
    </s:form>
  </body>
</html>
