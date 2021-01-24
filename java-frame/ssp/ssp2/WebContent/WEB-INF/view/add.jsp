<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>


<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.js"></script>


<script type="text/javascript">
	$().ready(function(){
		$("#form1").submit(function(e){
			e.preventDefault();
			$.post("add.do",$(this).serialize(),function(){
				alert("添加员工信息成功！");
			});
		});
	});
</script>


</head>
<body>

	<form action="<%=request.getContextPath()%>/employee/add.do" method="POST" id="form1">
	
		<table align="center" border="1" cellpadding="5" cellspacing="0">

			<tr>
				<th>姓名:</th>
				<td><input type="text" name="name"/></td>
			</tr>
			
			<tr>
				<th>年龄：</th>
				<td><input type="text" name="age"/></td>
			</tr>
			
			<tr>
				<th>薪资：</th>
				<td><input type="text" name="salary"/></td>
			</tr>
			
			<tr>
				<th>入职时间：</th>
				<td><input type="text" name="datea"/></td>
			</tr>
			
			<tr>
				<th>所属部门：</th>
				<td>
					<select name="dept.id">
						<option value="">===请选择===</option>
						<c:forEach items="${depts }" var="dept">
							<option value="${dept.id }">${dept.dname }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<th colspan="2">
					<input type="submit" value="添加"/>
					<input type="reset" value="重置"/>
				</th>
			</tr>
		</table>
		
	</form>
</body>
</html>