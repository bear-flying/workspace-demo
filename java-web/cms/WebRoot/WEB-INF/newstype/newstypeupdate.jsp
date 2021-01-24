<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'newstypeupdate.jsp' starting page</title>
    
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
  	function sub(){
  		var a = document.getElementById('name').value;
  		if(a==''){
  			alert('新闻类型必须填写！');
  		}else{
  			document.forms[0].submit();
  		}
  		
  	}
  </script>
  <body>
  	<center>
    <form action="newstype?method=alter" method="post">
    	<table>
  		<tr>
  			<td>请输入新闻类型:</td>
  			<td>
  				<input type="text" name="name" id="name" value="${n.name}">
  			</td>
  		</tr>
  		<tr>
  			<td colspan="2">
  				<input type="hidden" name="id" value="${n.id}">
  				<input type="button" value="确认修改新闻类型"  onclick="sub()">
  				<input type="reset" value="重置">
  			</td>
  		</tr>
  		</table>
    </form>
    </center>
  </body>
</html>
