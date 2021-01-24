<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JQUERY-RegexDemo</title>
</head>
<body>
<script>
    $(function(){
		$("#btn").click(function(){
		  	var username=/^[A-Za-z0-9]{3,7}$/;//用户 由字每和数字组成，且在3,7位
		  	var userage=/^\d{1,3}$/;//验证用户age
		  	var userphone=/^(((13[0-9]{1})|159|153|189|188|158)+\d{8})$/;//验证用户电话
		  	var useremail=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;//验证用户邮件
		  	if(!$("#user").val().match(username)){
				$("#show1").html("<font color='red'>用户要输入！！！</font>");
				alert("用户输入有误 ！！！！")
				$("#user").focus();
			}else if(!$("#age").val().match(userage)){//整数0-3位
					alert("用户age输入有误 ！！！！")
					$("#age").focus();
			}else if(!$("#phone").val().match(userphone)){
					alert("用户电话输入有误！！！");
					$("#phone").focus();//获取焦点
			}else if(!$("#email").val().match(useremail)){
				alert("用户邮件输入有误！！！");
				$("#email").focus();//获取焦点
			}else{
				$("#form").submit();//所有信息通过，则提交
			}
	  	})
	})
 </script>

</body>
</html>