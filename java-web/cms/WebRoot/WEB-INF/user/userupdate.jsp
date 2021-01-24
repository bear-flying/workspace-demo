<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userupdate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="common/css/index.css">
  </head>
  <script type="text/javascript" src="common/js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="common/js/jquery.validate.js"></script>
  <script type="text/javascript">
  $(function(){
	  $("#form").validate({
		  rules:{
			  loginname:{required:true,rangelength:[2,15]},
			  password:{required:true,rangelength:[2,12]},
			  password2:{required:true,equalTo:$("#password")},
			  realname:{required:true,rangelength:[2,15]},
			  sex:{required:true},
			  age:{required:true,range:[1,100]}
		  },
		  messages:{
			  loginname:{required:"登录名不能为空！",rangelength:"登录名长度必须在2~15之间！"},
			  password:{required:"密码不能为空！",minlength:"密码长度不能小于2！"},
			  password2:{required:"密码不能为空！",equalTo:"两次密码必须一致！"},
			  realname:{required:"真实姓名不能为空！",rangelength:"真实姓名长度必须在2~15之间！"},
			  sex:{required:"性别不能为空！"},
			  age:{required:"年龄不能为空！",rangelength:"年龄必须在1~100之间！"},
		  }
	  });
  });
  </script>
  <body>
  <center>
  <form action="user?method=alter" method="post" id="form">
  	<table>
  		<tr>
  			<td>登陆名(昵称):</td>
  			<td>
  				<input type="text" name="loginname" value="${n.login_name}">
  			</td>
  		</tr>
  		<tr>
  			<td>登录密码:</td>
  			<td>
  				<input type="password" name="password" id="password" value="${n.password}">
  			</td>
  		</tr>
  		<tr>
  			<td>真实姓名:</td>
  			<td>
  				<input type="text" name="realname" value="${n.real_name}">
  			</td>
  		</tr>
  		
  		<tr>
  			<td>用户性别:</td>
  			<td>
  				<input type="radio" name="sex" value="男" ${n.sex=="男"?"checked":""}>男
    			<input type="radio" name="sex" value="女" ${n.sex=="女"?"checked":""}>女
    			<input type="radio" name="sex" value="不详" ${n.sex=="不详"?"checked":""}>不详
  			</td>
  		</tr>
  		<tr>
  			<td>用户年龄:</td>
  			<td>
  				<input type="text" name="age" value="${n.age}">
  			</td>
  		</tr>
  		<tr>
  			<td colspan="2">
  				<input type="hidden" name="id" value="${n.id}">
  				<input type="submit" value="修改">
  				<input type="reset" value="重置">
  			</td>
  		</tr>
  	</table>
  </form>
  </center>
  </body>
</html>
