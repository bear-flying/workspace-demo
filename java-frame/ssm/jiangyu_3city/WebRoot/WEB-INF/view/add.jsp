<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  	<script type="text/javascript">
  	$().ready(function(){
  		$.post("core/findChina.do",function(msg1){
  			for(var i=0;i<msg1.length;i++){
  				$("#china").append("<option value="+msg1[i].id+">"+msg1[i].cityname+"</option>");
  			}
  		});
  		
  		$("#china").change(function(){
  			$("#citys").html("<option>请选择</option>");
  			var s ="<option>请选择</option>";
  			$.post("core/findPriovinces.do",{id:$("#china").val()},function(msg2){
  				for(var i=0;i<msg2.length;i++){
  					s+="<option value="+msg2[i].id+">"+msg2[i].cityname+"</option>";
  				}
  				$("#priovince").html(s);
  			});
  		});	
  		
  		$("#priovince").change(function(){
  			var v ="<option>请选择</option>";
  			$.post("core/findCitys.do",{id:$("#priovince").val()},function(msg3){
  				for(var i=0;i<msg3.length;i++){
  					v+="<option value="+msg3[i].id+">"+msg3[i].cityname+"</option>";
  				}
  				$("#citys").html(v);
  			});
  		});
  		
  		$("#citys").change(function(){
  			var u = "";
  			$.post("core/findCinemaByCity.do",{id:$("#citys").val()},function(msg4){	
  				for(var i=0;i<msg4.length;i++){
  					u+="<input type='checkbox' name='cats' id="+msg4[i].id+" value="+msg4[i].id+">"+msg4[i].name+"<br>";
  				}
  				$("#cinemas").html(u);
  			});
  		});
  		
  		$("#ff").submit(function(e){
  			e.preventDefault();
  			$.post("core/add.do",$("#ff").serialize(),function(msg5){
  				alert("新增成功！");
  				window.location.href="core/findAll.do";
  			});
  		});
  		
  	});
  		
  		
 
  	</script>
  </head>
  
  <body>
    <form action="" id="ff">
    	
    	电影名：<input type="text" name="name" id="name"><br><br>
    	   票价：<input type="text" name="price" id="price"><br><br>
    	   类型：<select name="type.id">
    	   		<option>-请选择-</option>
    	   		<c:forEach items="${typelist}" var="typ">
    	   			<option value="${typ.id}">${typ.typename}</option>
    	   		</c:forEach>
    	   	  </select><br><br>
    	 日期：<input type="text" name="datea" id="datea"><br><br>
    	 地区：<select id="china" name="addre">
    			<option>请选择</option>
    		</select>
    		<select id="priovince" name="addre">
    			<option>请选择</option>
    		</select>
    		<select id="citys" name="addre">
				<option>请选择</option>
    		</select><br><br>
    		
    		<div id="cinemas"></div><br><br>
    		
    		<input type="submit" value="新增">
    		
    </form> 
  </body>
</html>
