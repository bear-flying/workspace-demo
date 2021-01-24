<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.7.js"></script>
  	<script type="text/javascript">
	$(function(){
		 $("#uname").blur(function(){
				var $uname=$("#uname").val();
				
				$.ajax({
						type:"post",
						url:"user!check.action",
						data:{"uname":$uname},
						success:function(msg){
							alert(msg);
							$("#span").html(msg);
						}
				});
				
			});
		  
		  $("#uname").focus(function(){
			  $("#span").empty();
		  });
	});
	</script>
  </head>
  
  <body>
    <s:form action="user!register.action">
    	<s:textfield name="uname" id="uname">账户</s:textfield><span id="span"></span>
    	<s:textfield name="pwd">密码</s:textfield>
    	<s:submit value="注册"></s:submit> 
		<s:reset value="重置"></s:reset>
    </s:form>
  </body>
</html>
