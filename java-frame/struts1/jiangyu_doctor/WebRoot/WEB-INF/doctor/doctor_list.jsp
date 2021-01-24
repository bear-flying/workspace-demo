<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>doctor_list.jsp</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	 function goPage(result){
		  	document.getElementById('page').value=result;
		  	document.getElementById('f1').submit();
	 }
	</script>
  </head>
  
 
  <body>
  	<form action="<%=request.getContextPath()%>/doctor.do?method=query" method="post" id="f1">
  		<input type="hidden" name="page" id="page">
  	</form>
    <table border="1" width="70%">
    	<tr>
    		<td>
    		<a href="<%=request.getContextPath()%>/doctor.do?method=toSave">添加</a>
    		</td>
    	</tr>
    	<tr>
    		<th>序号</th>
    		<th>姓名</th>
    		<th>年龄</th>
    		<th>简介</th>
    		<th>学历</th>
    		<th>操作</th>
    	</tr>
    	<c:forEach items="${pagebean.list}" var="d" varStatus="s">
    	<tr>
    		<td>${s.count}</td>
    		<td>${d.name}</td>
    		<td>${d.age}</td>
    		<td>${d.content}</td>
    		<td>${d.jname}</td>
    		<td>
				<a href="<%=request.getContextPath()%>/doctor.do?method=queryOne&id=${d.id}">修改</a>
			</td>
    	</tr>
    	</c:forEach>
    </table>
    <div align="center">
    	<a href="javascript:goPage(1)">首页</a>
    	<a href="javascript:goPage(${pagebean.prevPage})">上一页</a>
    	<a href="javascript:goPage(${pagebean.nextPage})">下一页</a>
    	<a href="javascript:goPage(${pagebean.totalPages})">尾页</a>
    </div>
  </body>
</html:html>
