<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台登陆</title>
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
  <script type="text/javascript">
  	<!-- 以时间作为动态值 使每次访问都是一个新的访问（告诉浏览器：每次点击换一张 都是一个新的链接） 否则会被当作是同一次访问而不加载-->
  	function changeImg(){
  		
  		document.getElementById('img').src="<%=request.getContextPath()%>/common/image.jsp?t="+new Date();
  		
  	}
  </script>
  <body>
    <form action="<%=request.getContextPath()%>/login" method="post">
    	<table style="width:290px; margin-top:250px; margin-left:500px;" align="center">
    		<tr>
    			<th colspan="2">用户登陆：</th>
    		</tr>
    		<tr>
    			<th>用户名：</th>
    			<td style="text-align: left"><input type="text" name="login_name" value="${cookie.login_name.value}"></td>
    		</tr>
    		<tr>
    			<th>密&nbsp;&nbsp;&nbsp;&nbsp;码：</th>
    			<td style="text-align: left"><input type="password" name="password" value="${cookie.password.value}"></td>
    		</tr>
    		<tr>
    			<th>验证码：</th>
    			<td style="text-align: left">
    				<input type="text" name="yzm" style="width:50px">
    				<!-- 除了include动态和静态引入 第三种引入jsp的方式：img -->
    				<img id="img" alt="验证码" src="<%=request.getContextPath()%>/common/image.jsp">
    				<a href="javascript:changeImg();">换一张</a>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<input type="submit" value="登陆">
    				<input type="reset" value="重置">
    				<input type="checkbox" value="y" name="isSave">记忆帐号?
    			</td>
    		</tr>
    	</table>
    </form>
    <center><font color="red">${errorInfo}</font></center>
  </body>
</html>
