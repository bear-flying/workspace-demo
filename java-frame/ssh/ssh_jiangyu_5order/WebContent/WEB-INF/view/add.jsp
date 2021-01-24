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
	<form action="${pageContext.request.contextPath}/core/add.do" method="post">
		接收人：<input type="text" name="name"><br><br>
		电话：<input type="text" name="tel"><br><br>
		送餐时间：<select name="times.id">
				 <option>-请选择-</option>
				 <c:forEach items="${timelist}" var="time">
				 	<option value="${time.id}">${time.name}</option>
				 </c:forEach>
			   </select><br><br>
		送餐地点：<select name="address.id">
				<option>-请选择-</option>
				<c:forEach items="${addresslist}" var="address">
				 	<option value="${address.id}">${address.name}</option>
				 </c:forEach>
			   </select><br><br>
		精品菜：<input type="checkbox" name="cats" value="1">五香驴肉
			<input type="checkbox" name="cats" value="2">麻花鸭胗
			<input type="checkbox" name="cats" value="3">酸菜鱼
			<input type="checkbox" name="cats" value="4">兰花炖<br><br>
			<input type="submit" value="保存">
	</form>

</body>
</html>