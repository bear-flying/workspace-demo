<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		<%--这个javascript要验证用户名和密码都填写了   
		在javascript中，声明对象就用var ，
		写字符串的时候可以用单引号，也可以用双引号--%>
		function yanzheng(){
			<%--第一种方法：按照id值获得某一个对象  获取这个sn所对应的用户填入的value值--%>
			var userName = document.getElementById('sn').value;
			if(userName==''){
				alert('用户名必须填写');
				return false;
			}
			
			<%--根据name：spwd属性获取一堆，但是我们知道就一个 --%>
			var pwd = document.getElementsByName('spwd')[0].value;
			if(pwd==''){
				alert('密码必须填写');
				return false;
			}
			
			return true;
		}
		<%--这个javascript写好，要有人来调用，所以就在form里面填写onsubmit
		注意：onsubmit事件必须返回boolean值--%>
	</script>
  </head>
  
  <body>
  	<font color='red' face='楷体_GB2312'>${err}</font>
    <form onsubmit='return yanzheng();' action="loginServlet" method='post'>
    	<table>
    		<tr>
    			<td>用户名：</td>
    			<td>
    				<%--要让JavaScript获得sname,有两种方法：方法一：在这个input
    				里面添加一个id属性 按照id值获得某一个对象--%>
    				<input id='sn' type='text' name='sname'/>
    			</td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td>
    				<input type='password' name='spwd'/>
    			</td>
    		</tr>
    		<tr>
    			<td colspan='2'>
    				<input type='submit' value='登陆'/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
