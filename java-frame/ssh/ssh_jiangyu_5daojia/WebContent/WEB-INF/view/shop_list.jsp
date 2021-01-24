<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
	});

</script>
<body>
	
	<center>
		<table border="1" cellspacing="0" width="60%">
			<tr>
				<td>餐厅名</td>
				<td>餐厅详细地址</td>
				<td>所属区域</td>
				<td>电话</td>
				<td>备注</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${shoplist}" var="p">
			<tr>
				<td>
					<a href="${pageContext.request.contextPath}/core/showOneshopFoods.do?id=${p.id}">${p.name}</a>
				</td>
				<td>${p.addresses}</td>
				<td>${p.areas.name}</td>
				<td>${p.tel}</td>
				<td>${p.remark}</td>
				<td>
					<a href="${pageContext.request.contextPath}/core/showOneshopFoods.do?id=${p.id}">进入餐厅</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>