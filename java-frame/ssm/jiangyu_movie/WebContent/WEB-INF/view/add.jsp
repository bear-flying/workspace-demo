<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.js"></script>
<script type="text/javascript">
$().ready(function(){
	
	$("#ff").submit(function(e){
		e.preventDefault();
		var url = "${pageContext.request.contextPath}/core/add.do";
		$.post(url,$("#ff").serialize(),function(smg){
			alert("添加成功！");
			window.location.href="${pageContext.request.contextPath}/core/tofindAll.do";
		});
		
	});
	
});


</script>

<body>

	<form action="" id="ff">
		电影名：<input type="text" name="name"><br><br>
		票价：<input type="text" name="price"><br><br>
		票房：<input type="text" name="tits" value="2000"><br><br>
		地区：<select name="area.id">
				<c:forEach items="${alist}" var="s">
					<option value="${s.id}">${s.name}</option>
				</c:forEach>
			</select><br><br>
		年份：<select name="years.id">
				<c:forEach items="${ylist}" var="y">
					<option value="${y.id}">${y.years}</option>
				</c:forEach>
			</select><br><br>
		类型：<select name="type.id">
				<c:forEach items="${tlist}" var="z">
					<option value="${z.id}">${z.name}</option>
				</c:forEach>
			</select><br><br>
		<input type="submit" value="提交">
	</form>

</body>
</html>