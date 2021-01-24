<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息完善</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.1.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>

<script type="text/javascript">
$().ready(function(){
	
	$("#otherMsgForm").submit(function(e){
		e.preventDefault();
		var url = "${pageContext.request.contextPath}/user/finishOtherMsg.do";
		$.post(url,$("#otherMsgForm").serialize(),function(msg){
			alert("保存成功！");
		});
	});
	
});
	
</script>

</head>
<body>
<center>
		
		<br><br>
		
		<img alt="飞天猫熊" src="${pageContext.request.contextPath}/image/maomao.JPG" style="width: 150px;height: 70px;">
	
		<h3>完善信息</h3>
		
		<form id="otherMsgForm" class="form-inline" role="form">
		   <div class="form-group">
		      <label for="mail"></label>
		      <input type="text" class="form-control" name="mail" id="mail" 
		         placeholder="请输入邮箱">
		   </div><br><br>
		   
		   <div class="form-group">
		      <label for="phone"></label>
		      <input type="text" class="form-control" name="phone" id="phone" 
		         placeholder="请输入手机号码">
		   </div><br><br>
		   
		   <div class="form-group">
		      <label for="address"></label>
		      <input type="text" class="form-control" name="address" id="address" 
		         placeholder="请输入地址">
		   </div><br><br>
		   
		   <div class="form-group">
		      <label for="realName"></label>
		      <input type="text" class="form-control" name="realName" id="realName" 
		         placeholder="请输入真实姓名">
		   </div><br><br>
		   
		   <input type="hidden" name="nickName" id="nickName" value="${nickName}">
		   <input type="hidden" name="social_uid" id="social_uid" value="${social_uid}">
		   <input type="hidden" name="access_token" id="access_token" value="${access_token}">
		   
		   <button type="submit" class="btn btn-default">提交</button>
		</form>
		
	</center>
</body>
</html>