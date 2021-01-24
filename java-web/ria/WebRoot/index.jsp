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
  </head>
  <script src="js/jquery-1.8.2.min.js"></script>
  <script src="js/jquery.validate.js"></script>
  <script src="js/jquery.metadata.js"></script>
  <script type="text/javascript">
  $(function(){
	  /***/
	  
	  $("#form").validate({
		  rules:{
			user:"required",
			pass:"required"
		  },
		  messages:{
			 user:"帐号必须填写！",
			 pass:"密码必须填写！"
		  },
		 // debug:true,
	  });
	  
	  $("#run").click(function(){
		  location="register.jsp";
	  });
  });
  </script>
  <%
  String user1 ="";
  String pass1 ="";
  Cookie[] cookies = request.getCookies();
  if(cookies!=null){
	  for(int i = 0;i<cookies.length;i++){
		  if((cookies[i].getName()).equals("username")){
			  user1 = cookies[i].getValue();
		  }else if((cookies[i].getName()).equals("password")){
			  pass1 = cookies[i].getValue();
		  }
		  
	  }
  }
  %>
  <body>
   <form action="<%=path%>/login" id="form">
   	<input type="hidden" value="login" name="method">
    <table align="center" border="1" cellspacing='0' bordercolor="gree" width="27%">
    	<tr>
    		<td>用户：</td>
    		<td>
    			<input type="text" name="user" value="<%=user1 %>" id="user">
    			<span id="span">${err }</span>
			</td>
    	</tr>
    	<tr>
    		<td>密码：</td>
    		<td>
    			<input type="text"  name="pass" value="<%=pass1 %>" id="pass">
			</td>
    	</tr>
    	<tr>
    		<td colspan="2" align="center">
    			<input type="submit" value="登陆">
    			<input type="button" value="注册" id="run">
    			<input type="checkbox" value="y" name="isSave">记忆账号?
    			
			</td>
    	</tr>
    </table>
   </form>
  </body>
</html>
