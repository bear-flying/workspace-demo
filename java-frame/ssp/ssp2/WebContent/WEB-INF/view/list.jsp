<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>list page</title>
</head>
<body>

	<table align="center" border="1" cellpadding="5" cellspacing="0">
	
		<tr>
			<th>姓名</th>
			<th>年龄</th>
			<th>部门</th>
			<th>薪资</th>
			<th>入职时间</th>
		</tr>
		
		<c:forEach items="${employees }" var="employee">
		
			<tr>
				<td>${employee.name }</td>
				<td>${employee.age }</td>
				<td>${employee.dept.dname }</td>
				<td>${employee.salary }</td>
				<td>${employee.datea }</td>
			</tr>
		
		</c:forEach>
	
	</table>

</body>
</html>