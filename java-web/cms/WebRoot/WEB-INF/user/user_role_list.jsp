<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_role_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="common/css/index.css">
  </head>
  
  <body>
    <form action="user?method=changeRole" method="post">
    	<input type="hidden" name="userid" value="${user.id}">
    	<table>
			<tr>
				<th>用户姓名</th>
				<th>分配角色</th>
			</tr>  
			<tr>
				<td>${user.real_name}</td>
				<td>
				<c:forEach items="${roleList}" var="roles">
					
		  		 <input type="checkbox" 
		  				
		  			<c:forEach items="${userRoleList}" var="r">
		  			
		  				<c:if test="${r.role_id==roles.id}">checked</c:if> 
		  				
		  			</c:forEach>
		  			
		  			name="roleid" value="${roles.id }" />${roles.role_name }<br/>
		  				
				</c:forEach>
				
				<!-- 第二种复选框回显 如下：
				<c:forEach items="${roleList}" var="role">
					<c:set var="flag" value="false"></c:set>
					
					<c:forEach items="${userRoleList}" var="r">
						<c:if test="${r.role_id==role.id}">
						
							<c:set var="flag" value="true"></c:set>
							
						</c:if>
					</c:forEach>
					
					<input type="checkbox" ${flag?"checked='checked'":""} 
					  name="roleid" value="${role.id}"/>${role.role_name}<br>
				</c:forEach>	
				 -->
				</td>
			</tr>  
			<tr>
	  			<td colspan="3">
	  				<input type="submit" value="提交"/>
	  				<input type="reset" value="重置"/>
	  				<input type="button" value="回退" onclick= "history.go(-1)"/> <!-- history.back() -->
	  			</td>
	  		</tr>
		</table>
    </form>
  </body>
</html>
