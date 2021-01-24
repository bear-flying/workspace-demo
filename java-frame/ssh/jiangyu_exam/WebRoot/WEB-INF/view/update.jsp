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
    
    <title>My JSP 'update.jsp' starting page</title>
    
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
  	$().ready(function(){
  			
			var url2 = "<%=path%>/core/findOneHobbys.do";
			$.post(url2,{sid:$("#id").val()},function(msg2){
				var s = "";
				for(var i=0;i<msg2.length;i++){
					if($("#ck1").val()==msg2[i].id){
						$("#ck1").attr("checked",true);
					}
					if($("#ck2").val()==msg2[i].id){
						$("#ck2").attr("checked",true);
					}
					if($("#ck3").val()==msg2[i].id){
						$("#ck3").attr("checked",true);
					}
				}
				
			},'json');
			
			selectClasses();
			
  		$("#acad").change(function(){
  			selectClasses();
  		});
  		$("#btn").click(function(){
  	  		var url2 = "<%=path%>/core/modify.do";
  	  		$.post(url2,$("#ff").serialize(),function(ss){
  	  			alert("修改成功！");
  	  		});
  	  	});
  	});
  	
  	function selectClasses(){
  		var url = "<%=path%>/core/findClassByAcad.do";
			$.post(url,{acadid:$("#acad").val()},function(msg){
				var s = "";
				for(var i=0;i<msg.length;i++){
					if($("#classx").val()==msg[i].id){
						s+="<input type='radio' name='classes.id' id="+msg[i].id+" value="+msg[i].id+" checked='checked' >"+msg[i].cname+"<br>";
					}else{
						s+="<input type='radio' name='classes.id' id="+msg[i].id+" value="+msg[i].id+">"+msg[i].cname+"<br>";
					}
					
				}
				$("#div").html(s);
				
			},'json');
  	}
  	</script>
  </head>
  
  <body>
     <form action="" id="ff">
     		<input type="hidden" name="id" id="id" value="${s.id}">
    	姓名：<input type="text" name="name" id="name" value="${s.name}"><br><br>
    	年龄：<input type="text" name="age" id="age" value="${s.age}"><br><br>
    	入学日期：<input type="text" name="adddate" id="adddate" value="${s.adddate}" onclick="WdatePicker()"><br><br>
    	所属学院：<select name="academy.id" id="acad">
    				<option>-请选择-</option>
    				<c:forEach items="${acadlist}" var="p">
    					<option value="${p.id}" <c:if test="${p.id==s.academy.id}">selected</c:if>>${p.name}</option>
    				</c:forEach>
    				
    			</select><br>
    			<div id="div">
    				<input type="text" id="classx" value="${s.classes.id}">
    			</div><br><br>
    			
    	爱好：<br>
    			<input type="checkbox" id="ck1" name="cats" value="1">爱好1<br>
 	
    			<input type="checkbox" id="ck2" name="cats" value="2">爱好2<br>
    		
    			<input type="checkbox" id="ck3" name="cats" value="3">爱好3<br>
    		
    	
    	
    	<input type="button" id="btn" value="修改">
    	<input type="reset" value="重置">
    </form>
  </body>
</html>
