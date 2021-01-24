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
			
			<c:forEach items="${categorylist}" var="p">
			<tr>
				
				<td>
					${p.name}<hr>
					<c:forEach items="${foodmap}" var="s">
						<c:choose>
							<c:when test="${p.name==s.key}">
								${s.value} <br>
							</c:when>
						</c:choose>
					</c:forEach>
				</td>
				
			</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>