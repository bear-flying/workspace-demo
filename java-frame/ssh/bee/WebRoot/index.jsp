<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<%--<link rel="stylesheet" type="text/css" href="styles/pop_style.css">--%>
<script type="text/javascript">
 	function changeImg(){
 		document.getElementById('img').src="<%=path%>/image.jsp?t="+new Date() ;
 	}
</script>
</head>

<body style="background: URL(images/whitebody.jpg) no-repeat;">
	<s:form action="/user!login.action">
		<table align="center" style="margin-top:210px">
			<tr align="center">
				<td colspan="2">
					<h4>欢迎使用蜜蜂系统</h4>
				</td>
			</tr>
			<tr>
				<td>用户名</td>
				<td>
					<s:textfield name="user.uname"></s:textfield>
				</td>
			</tr>
			<tr>
				<td>密码</td>
				<td>
					<s:password name="user.pwd">${cookie.password.value}</s:password>
				</td>
			</tr>
			<tr>
				<td>验证码</td>
				<td>
					<s:textfield size="4" name="yzm"></s:textfield> 
					<img id="img" alt="验证码" src="<%=path%>/image.jsp"> 
					<a href="javascript:changeImg()">换一张</a>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<s:submit value="登陆"></s:submit> 
					<s:reset value="重置"></s:reset> 
					<input type="button" value="注册" onclick="location='<%=path%>/user!toReg.action'">
					<s:checkbox name="isSave" value="y">记忆账号?</s:checkbox>
				</td>
			</tr>
		</table>
		<div align="center">
			<font color="red">${error}</font>
		</div>
	</s:form>
</body>
</html>
