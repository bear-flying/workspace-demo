<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
    <body>
   <script src="js/jquery-1.8.2.min.js"></script>
  <script src="js/jquery.validate.js"></script>
  <script src="js/jquery.metadata.js"></script>
  <script type="text/javascript">
  //function run(){
	//  var form = document.forms[0];
	//  form.method.value = 'register';
	 // form.submit();
 // }
  $(function(){
	  $("#form").validate({
		  rules:{
			user:"required",
			pass:"required",
			rpass:{required:true,equalTo:"#pass"}
		  },
		  messages:{
			 user:"帐号必须填写！",
			 pass:"密码必须填写！",
			 rpass:"两次密码输入的不一致！"
		  },
		  
	  });
	  
	  $("#user").blur(function(){
			var $user=$("#user").val();
			//alert($user);
			if($user!=""){
			$.ajax({
					type:"post",
					url:"login",
					data:{"user":$user,"method":"search"},
					success:function(msg){
						//alert(msg);
						if(msg==1){
							$("#span").html("<font color=red>此用户存在!</font>");
						}else{
							$("#span").html("<font color=blue>此用户可用!</font>");
						}
					}
				});
			}
		});
	  
	  $("#user").focus(function(){
		  $("#span").empty();
	  });
  });
	  
  </script>
  <body>
   <form id="form" action="login">
   	<input type="hidden" name="method" value="register" >
    <table align="center" border="1" cellspacing='0' bordercolor="gree" width="35%">
    	<tr>
    		<td>用户：</td>
    		<td>
    			<input type="text" name="user" id="user">
    			<span id="span"></span>
			</td>
    	</tr>
    	<tr>
    		<td>密码：</td>
    		<td>
    			<input type="text"  name="pass" id="pass">
			</td>
    	</tr>
    	<tr>
    		<td>确认密码：</td>
    		<td>
    			<input type="text"  name="rpass" id="rpass">
			</td>
    	</tr>
    	<tr>
    		<td>权限：</td>
    		<td>
    			<input type="radio"  name="rank" value="0" checked="checked">普通权限
    			<input type="radio"  name="rank" value="1">特殊权限
			</td>
    	</tr>
    	<tr>
    		<td colspan="2" align="center">
    			<input type="submit" value="注册">
    			<input type="reset" value="重置">
			</td>
    	</tr>
    </table>
   </form>
  </body>
</html>
