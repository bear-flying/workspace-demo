<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.1.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>

<script type="text/javascript">
$().ready(function(){
	
	$("#registerForm").submit(function(e){
		e.preventDefault();
		var url = "${pageContext.request.contextPath}/user/register.do";
		$.post(url,$("#registerForm").serialize(),function(msg){
			alert("注册成功！");
		});
	});
	
});
	
</script>

</head>
<body>
	<center>
		
		<br><br>
		
		<img alt="飞天猫熊" src="${pageContext.request.contextPath}/image/maomao.JPG" style="width: 150px;height: 70px;">
	
		<h3>注册移动帐号</h3>
		
		<form id="registerForm" class="form-inline" role="form">
		   <div class="form-group">
		      <label for="loginName"></label>
		      <input type="text" class="form-control" name="loginName" id="loginName" 
		         placeholder="请输入邮箱">
		   </div><br><br>
		   <div class="form-group">
		      <label for="password"></label>
		      <input type="password" class="form-control" name="password" id="password" 
		         placeholder="请输入密码">
		   </div><br><br>
		   <div class="form-group">
		      <label for="phone"></label>
		      <input type="text" class="form-control" name="phone" id="phone" 
		         placeholder="请输入手机号码">
		   </div><br><br>
		   <div class="form-group">
		      <label for="nickName"></label>
		      <input type="text" class="form-control" name="nickName" id="nickName" 
		         placeholder="请输入昵称">
		   </div><br><br>
		   
		   
		   <button type="submit" class="btn btn-default">提交</button>
		</form>
		
	</center>
</body>
</html>