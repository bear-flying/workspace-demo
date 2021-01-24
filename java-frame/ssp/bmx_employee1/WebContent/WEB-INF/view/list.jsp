<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>---------- list  jsp-------------</h1>
<br><br><hr><br><br>
<!-- 
    private Integer id;
	private String name;
	private Integer age;
	private Integer salary;
	private Date datea;
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Dept dept;
 -->

<table border="1">
 <tr>
   <td><input type="checkbox">/全选</td>
   <td>员工姓名</td>
   <td>员工年龄</td>
   <td>员工薪资</td>
   <td>入职时间</td>
   <td>所在部门</td>
 </tr>
 
 <c:forEach items="${pageBean.list}" var="bmx">
    <tr>
      <td><input type="checkbox"></td>
      <td>${bmx.name }</td>
      <td>${bmx.age }</td>
      <td>${bmx.salary }</td>
      <td>${bmx.datea }</td>
      <td>${bmx.dept.dname }</td>
    </tr>
 </c:forEach>
 
 
 <tr>
 <td colspan="6">
  ${pageBean.pageing }
 </td>
 </tr>
</table>
</center>
</body>
</html>