<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//Dth HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dth">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/common/My97DatePicker/WdatePicker.js"></script>
<script src="<%=request.getContextPath()%>/common/js/jquery-1.8.2.min.js"></script>
<script>

 
  $().ready(function(){
	  $("#form1").submit(function(e){
		  e.preventDefault();
		  $.post(
			 "add.do",
			 $(this).serialize(),
			 function () {
				alert("添加成功");
			} );
	  });
  });
</script>
</head>
<body>

 <center>
<h1>---------- EmployeeAdd  jsp-------------</h1>
<form action="add.do" method="POST" id="form1">
<table border="1">

  <tr> 
   <th>员工姓名</th>
   <td><input type="text" name="name"></td></tr>
  <tr>  
   <th>员工年龄</th>
  <td><input type="text" name="age"></td></tr>
  <tr> 
   <th>员工薪资</th>
   <td><input type="text" name="salary"></td></tr>
  <tr>
    <th>入职时间</th>
    <td><input type="text" onclick="WdatePicker()" name="datea"></td></tr>
  <tr> 
     <th>员工部门</th>
   <td><select name="dept.id">
      <option value="">===請選擇====</option>
     <c:forEach items="${deptList}" var="bmx">
       <option value="${bmx.id }">${bmx.dname }</option>
     </c:forEach>
   </select></td></tr>
  <tr>
   <td>
      <input type="submit" value="提交">
        <input type="reset" value="重置">
   </td>
 </tr>

 </table>
 </form>
</center>
</body>
</html>