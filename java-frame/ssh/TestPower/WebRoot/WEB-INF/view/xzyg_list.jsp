<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script language="JavaScript" src="<c:url value='/FusionCharts/Charts/FusionCharts.js'/>"></script>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/index.css" type="text/css"></link>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.js"></script>
  <body onload="huixian()">
  <form action="<c:url value='/user!saveyg.action'/>" method="post">
  
  
    <table border="1" align="center">
    	<tr align="center">
    		<td>
    		<input type="hidden" name="did" value="${deptid }"/>
    		<input type="checkbox" onclick="choice()">全选/反选</td>
    	
    		<td>员工编号</td>
    		<td>员工名字</td>
    	</tr>
    <c:forEach items="${list}" var="user">
    	<tr align="center">
    		<td><input type="checkbox" name="ck" value="${user.id }"></td>
    		<td>${user.id }</td>
    		<td>${user.name }
    		</td>
    	</tr>
    
    </c:forEach>
    <tr align="center">
    <td colspan="10"><input type="submit" value="保存"/>
   
    </td>
    </tr>
    </table>
    </form>
  </body>
  <script type="text/javascript">
 
  function huixian(){
  	var ids='${ids}';
  	var ck = document.getElementsByName("ck");
  	var idss = ids.split(",");
  	if(idss.length>0){
  		for(var i=0;i<ck.length;i++){
  			for(var j=0;j<idss.length;j++){
  				if(ck[i].value==idss[j]){
  					ck[i].checked=true;
  					break;
  				}
  			
  			}
  		
  		}
  	
  	}
  
  }
  
  
  
  //全选反选
	  function choice(){
			var ck = document.getElementsByName("ck");
			for(var i=0;i<ck.length;i++){
					if(ck[i].checked==true){
						ck[i].checked=false;

						}else{

						ck[i].checked=true;
								}
					}
		  }
  </script>
</html>
