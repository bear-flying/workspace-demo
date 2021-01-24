<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'save.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="js/jquery-ui.css">
  </head>
  <script src="js/jquery-1.8.2.js"></script>
  <script src="js/jquery.validate.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/jquery.autocomplete.js"></script>
  <script type="text/javascript">
  $(function(){
	  var result = (Math.floor(Math.random()*9000+1000)).toString();
	  
	  $("#yanzheng").html("<font color='red'>"+result+"</font>");
	  $("#form").validate({
		  rules:{
			  name:"required",
			  age:{required:true,range:[0,100]},
			  hiredate:{required:true,dateISO:true},
			 // yanzheng:{required:true,equalTo:result}
		  },
		  messages:{
			  name:"姓名必须填写！",
			  age:"年龄不合法！",
			  hiredate:"日期不合法！",
			 // yanzheng:"验证码不合法！"
		  },
	  });
	  $("#dateiso").datepicker({
		  	changeMonth:true,
			changeYear:true,
			dayNamesMin:["星期天","星期一","星期二","星期三",
			           "星期四","星期五","星期六"],
			monthNamesShort:['1月','2月','3月','4月','5月','6月','7月',
			           '8月','9月','10月','11月','12月'],
			showMonthAfterYear:true,
			dateFormat:"yy-mm-dd",
	  });
	  
  });
  
  </script>
  <body>
    <form action="student" id="form">
    	<table align="center">
    	<tr><td>
    		姓名：<input type="text" name="name"><br><br>
    		年龄：<input type="text" name="age"><br><br>
    		日期：<input type="text" name="hiredate" id="dateiso"><br><br>
    		验证：<input type="text" name="yanzheng" size="4"><span id="yanzheng"></span>
    		<br><br>
    		<input type="hidden" name="method" value="saveStudent">
    		<input type="reset" value="重置">
    		<input type="submit" value="提交">
    	</td></tr>
    	</table>
    </form>
  </body>
</html>
