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
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=path%>/js/jquery-1.7.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.8.js"></script>
  	<script type="text/javascript">
  	function remove(id){
  		var url1 = "core/remove.do";
  		$.post(url1,{id:id},function(mag){
  			alert("删除成功！");
  			window.location.href="core/findAll.do";
  		});
  		
  	}
  	
  	function removeBatch(){
  		var a = $("input[name='ids']:checked");
  		var b = new Array();
  		for(var i=0;i<a.length;i++){
  			b[i] = $(a[i]).val();
  		}
  		if(confirm("你确定要删除这些么？"+b.toString())){
  			$.ajax({
  				type:"post",
  				data:{ids:b.toString()},
  				url:"<%=path%>/core/removeBatch.do",
  				dataType:"text",
  				success:function(msg){
  					alert("删除成功！");
  		  			window.location.href="core/findAll.do";
  				}
  			});
  		}
  	}
  	</script>
  </head>
  
  <body>
    <center>
    	<form action="">
    	<table border="1" cellspacing="0" width="66%">
    	<tr>
    		<td>
    			<input type="checkbox" id="selAll">
    		</td>
    		<td>姓名</td>
    		<td>电话</td>
    		<td>订餐日期</td>
    		<td>送餐时间</td>
    		<td>地址</td>
    		<td>所订菜品</td>
    		<td>操作</td>
    	</tr>
    	<c:forEach items="${jiangYu.list}" var="s">
    	<tr>
    		<td>
    			<input type="checkbox" name="ids" value="${s.id}">
    		</td>
    		<td>${s.name}</td>
    		<td>${s.tel}</td>
    		<td>${s.datea}</td>
    		<td>${s.times.name}</td>
    		<td>${s.address.name}</td>
    		<td>
    			<c:forEach items="${s.foods}" var="p">
    			${p.name}
    			</c:forEach>
    		</td>
    		<td>
    			<a href="core/toModify.do?id=${s.id}">修改</a>
    			<a href="javascript:remove('${s.id}')">修改</a>
    		</td>
    	</tr>
    	</c:forEach>
    	</table>
    	${jiangYu.pageAll}
    	<input type="button" value="添加" onclick="location='core/toAdd.do'">
    	<input type="button" value="批量删除" onclick="removeBatch()">
    	</form>
    </center>
  </body>
</html>
