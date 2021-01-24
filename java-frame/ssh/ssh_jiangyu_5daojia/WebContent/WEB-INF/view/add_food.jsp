<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/core/addFood.do" id="ff" method="post">
	
		菜名：<input type="text" name="name"><br><br>
		价格：<input type="text" name="price"><br><br>
		餐厅：<select name="shops.id">
				<c:forEach items="${shoplist}" var="sl">
					<option value="${sl.id}">${sl.name}</option>
				</c:forEach>
			</select><br><br>
		分类：<select name="categorys.id">
				<c:forEach items="${categorylist}" var="ca">
					<option value="${ca.id}">${ca.name}</option>
				</c:forEach>
			</select><br><br>
			<input type="submit" value="添加菜品">
	</form>
</body>
</html>