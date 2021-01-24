<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登陆</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.1.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>

<script type="text/javascript">
$().ready(function(){
	$("#loginForm").submit(function(e){
		e.preventDefault();
		var url = "${pageContext.request.contextPath}/user/login.do";
		$.post(url,$("#loginForm").serialize(),function(msg){
			
			if(msg!='ok'){
				$("#span").html(msg);
			}else{
				window.location.href="success.jsp";
			}
			
		});
	});
});
</script>

<!-- 第三方登陆 -->
<script type="text/javascript" id="bd_soc_login_boot"></script>
<script type="text/javascript">
(function(){
  var t = new Date().getTime(),
      script = document.getElementById("bd_soc_login_boot"),
      redirect_uri = encodeURIComponent("http://127.0.0.1:8080/onlyone/user/otherLogin.do"),
      domid = "otherLogin",
      src = "http://openapi.baidu.com/social/oauth/2.0/connect/login?redirect_uri=" + redirect_uri + "&domid=" + domid + "&client_type=web&response_type=code&media_types=sinaweibo%2Cqqdenglu%2Cbaidu%2Cqqweibo%2Ckaixin%2Crenren&size=-1&button_type=1&client_id=iZ2OrS1XxmK0udqo4Mwcbiuz&view=embedded&t=" + t;
    script.src = src;
})();
</script>

</head>
<body>
	<center>
		
		<br><br>
		
		<img alt="飞天猫熊" src="${pageContext.request.contextPath}/image/maomao.JPG" style="width: 150px;height: 70px;">
	
		<h4>欢迎登陆</h4>
		
		<form id="loginForm" class="form-inline" role="form">
		   <div class="form-group">
		      <label for="loginName"></label>
		      <input type="text" class="form-control" id="loginName" name="loginName"
		         placeholder="请输入邮箱"><span id="span"></span>
		   </div><br><br>
		   <div class="form-group">
		      <label for="password"></label>
		      <input type="password" class="form-control" id="password" name="password"
		         placeholder="请输入密码">
		   </div><br><br>
		   
		   <button type="submit" class="btn btn-default">登陆</button>
		</form>
		
		<div id="otherLogin"></div>
		
	</center>
</body>
</html>