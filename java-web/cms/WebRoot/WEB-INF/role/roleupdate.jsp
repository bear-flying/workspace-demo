<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'roleupdate.jsp' starting page</title>
    
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
  	count = 0;
	function checkarea(){
		var zwjs = document.getElementById("zwjs");
		var check = document.getElementById("check");
		if(zwjs.value.length<=30){
			count++;
		}
		check.innerText = "你还可以输入"+(30-count)+"个字！";
		if(30-count<=0){
			check.innerText ="";
		}
		//截取
		if(zwjs.value.length>=30){
			zwjs.value = zwjs.value.substr(0,30);
		}
	}
	function check(){
		var zwjs = document.getElementById("zwjs").value;
		var rname = document.getElementById("rname").value;
		if(zwjs==''){
			document.getElementById("bb").innerText="角色名称不能为空！";
		}
		if(rname==''){
			document.getElementById("cc").innerText="角色描述不能为空！";
		}else{
			document.forms[0].submit();	
		}
	}
	function clear1(){
		document.getElementById("bb").innerText="";
	}
	function clear2(){
		document.getElementById("cc").innerText="";
	}
  </script>
  <body>
   <center>
  <form action="role?method=alter" method="post">
  	<table>
  		<tr>
  			<td>角色名称:</td>
  			<td>
  				<input type="text" name="rolename" value="${r.role_name}">
  				<span id="bb" style="color: red"></span>
  			</td>
  		</tr>
  		<tr>
  			<td>角色描述:</td>
  			<td>
  				<textarea  id="zwjs" rows="5" cols="12" name="roledesc" onkeypress="checkarea()" onfocus="clear2()">${r.role_desc}</textarea>
  				<span id="check" style="color: blue"></span>
  				<span id="cc" style="color: red"></span>
  			</td>
  		</tr>
    	<tr>
  			<td colspan="2">
  				<input type="hidden" name="id" value="${r.id}">
  				<input type="submit" value="提交">
  				<input type="reset" value="重置">
  			</td>
  		</tr>
  	</table>  
  </form>
  </center>
  </body>
</html>
