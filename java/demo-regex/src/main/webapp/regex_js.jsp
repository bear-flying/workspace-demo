<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JS-RegexDemo</title>
</head>
<body>
<input type="submit" value="提交" onclick="return checkData()" />
  <script>
	function checkData(){
	    //验证用户名		
		var reg = /^\w{4,6}$/gi//定义正则：数字字母下划线，4-6位
		var userName=document.getElementById("userName");
		var checkUserName=document.getElementById("checkUserName");
		if(!reg.test(userName.value)){
			checkUserName.innerText="用户名错误!";
			checkUserName.style.color="red";
			return false;//阻止提交
		}

		//验证密码   正则:密码必须是4-10位的纯数字
		var reg = /^\d{4,10}$/gi
		var userPwd = document.getElementById("userPwd");
		if(!reg.test(userPwd.value)){
			alert("密码错误!");
			return false;
		}
		
		//验证单选框
		var sexs = document.getElementsByName("sex");
		if(!sexs[0].checked && !sexs[1].checked){
			alert("至少选择一个！");
			return false;
		}

		//验证下列列表
		var addr = document.getElementById("addr").value;
		if(addr=="请选择"){
			alert("请选择其中一个!");
			return false;
		}
	}
	count = 0;
	function show(){
		var zwjs = document.getElementById("zwjs");
		var check = document.getElementById("check");
		if(zwjs.value.length<=10){
			count++;
		}
		check.innerText = "你还可以输入"+(10-count)+"个字！";
		if(10-count<=0){
			check.innerText ="";
		}
		//截取
		if(zwjs.value.length>=10){
			zwjs.value = zwjs.value.substr(0,10);
		}
	}
</script>

</body>
</html>