<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>图片</h1>

	<c:forEach items="${list }" var="p">
		<a
			href="<%=request.getContextPath()%>/picture!download.action?picture.filename=${p.filename}"><img
			width="100" border="1"
			src="<%=request.getContextPath() %>/upload/${p.filename}" alt="图片" /></a>
		<br>
		<hr>
	</c:forEach>
</body>
</html>