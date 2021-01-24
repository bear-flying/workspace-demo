<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录页面</title>
  </head>
  <body>
  
  	<div>
  		<c:forEach items="${list }" var="mes" varStatus="s">
  			<font color="red">${s.count}.${mes}</font><br/>
  		</c:forEach>
  	
  	</div>
  
  
  
  <!-- 
  	 action : 提交地址
  	 method : 提交方式
  	 type:  文本域的类型  有 text  password checkbox radio  submit
  	 name : 是servlet接受表达数据的key值
   -->
  	<form action="loginServlet" method="post">
	  	
	  	姓名： <input type="text" name="username"/><br/>
  		密 码：<input type="password" name="password"/><br/>
  		QQ：<input type="text" name="qq"/><br/>
  		身份证：<input type="text" name="idCard"/><br/>
  		邮    箱：<input type="text" name="email"/><br/>
  		
  		
  		<input type="submit" value="提交">
  	
  	</form>
  </body>
</html>
