<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=path%>/js/jquery-1.7.js"></script>
	<script type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
  	<script type="text/javascript">
  	$(document).ready(function(){
  		var url1 = "core/findTimes.do";
  		var url2 = "core/findAddress.do";
  		var url3 = "core/findFoods.do";
  		$.post(url1,function(msg1){
  			var s1 = "";
  			for(var i=0;i<msg1.length;i++){
  				s1+="<option id="+msg1[i].id+">"+msg1[i].name+"</option>";
  			}
  			$("#time").html(s1);
  		});
  		$.post(url2,function(msg2){
  			var s2 = "";
  			for(var i=0;i<msg2.length;i++){
  				s2+="<option id="+msg2[i].id+">"+msg2[i].name+"</option>";
  			}
  			$("#addre").html(s2);
  		});
  		$.post(url3,function(msg3){
  			var s3 = "";
  			for(var i=0;i<msg3.length;i++){
  				s3+="<input type='checkbox' name='cats' id="+msg3[i].id+" value="+msg3[i].id+">"+msg3[i].name+"<br>";
  			}
  			$("#food").html(s3);
  		});
  		
  		$("#ff").submit(function(e){
  			e.preventDefault();
  			$.post("core/add.do",$("#ff").serialize(),function(msg4){
  				alert("添加成功！");
		  		window.location.href="core/findAll.do";
  			});
  		});
  	});
  	</script>
  </head>
  
  <body>
    <form action="" id="ff">
    	姓名：<input type="text" name="name"><br><br>
    	电话：<input type="text" name="tel"><br><br>
    	订餐日期：<input type="text" name="datea" onclick="WdatePicker()"><br><br>
    	送餐时间：<select name="times.id" id="time"></select><br><br>
    	地址：<select name="address.id" id="addre"></select><br><br>
    	所订餐品：<div id="food"></div><br><br>
    	<input type="submit" value="保存">
    </form>
  </body>
</html>
