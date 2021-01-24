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
    
    <title>My JSP 'modify.jsp' starting page</title>
    
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
  		$.post("core/findOneMovie.do",{id:$("#id").val()},function(msg1){
  			$("#name").val(msg1.name);
  			$("#price").val(msg1.price);
  			$.post("core/findTypes.do",function(msg2){
  				if(msg2.id==msg1.type.id){
  					$("#types").append("<option value="+msg2.id+" selected='selected'>"+msg2.typename+"</option>");
  				}else{
  					$("#types").append("<option value="+msg2.id+">"+msg2.typename+"</option>");
  				}
  			},'json');
  			$("#datea").val(msg1.datea);
  			var addresses = msg1.addressId.split(",");
  			$.post("core/findOneCityname.do",{id:addresses[0]},function(msg3){
  				$("#china").html("<option value="+addresses[0]+">"+msg3+"</option>");
  			});
  			$.post("core/findOneCityname.do",{id:addresses[1]},function(msg4){
  				$("#priovince").html("<option value="+addresses[1]+">"+msg4+"</option>");
  			});
  			$.post("core/findOneCityname.do",{id:addresses[2]},function(msg5){
  				$("#citys").html("<option value="+addresses[2]+">"+msg5+"</option>");
  			});
  			
  			$.post("core/findCinemaByCity.do",{id:addresses[2]},function(msg6){
  				
  				$.post("core/findCinemaByMovie.do",{movieid:msg1.id},function(msg7){
  					var rooms = '';
  					for(var j=0;j<msg6.length;j++){
  	  					rooms+= "<input type='checkbox' name='cats' id="+msg6.id+" ";
	  	  				if(msg7.id==msg6.id){
	  	  					rooms+= "selected='selected'";
	  	  				}
  	  					rooms+= ">"+msg6.name+"<br>";
  	  				}
  					$("#cinemas").html(rooms);
  				},'json');	
  			},'json');
  			
  		},'json');
  		
  		
  		
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
    		  <input type="hidden" id="id" name="id" value="${id}">
    	电影名：<input type="text" name="name" id="name"><br><br>
    	   票价：<input type="text" name="price" id="price"><br><br>
    	   类型：<select name="type.id" id="types">
    	   		<option>-请选择-</option>
    	   		
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