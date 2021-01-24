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
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=path%>/js/jquery-1.7.js"></script>
    <script type="text/javascript" src="<%=path%>/FusionCharts/Charts/FusionCharts.js"></script><!--  -->
  </head>
  
  <body>
    <table border="1" width="65%">
    	<tr>
    		<td>编号</td>
    		<td>用户名</td>
    		<td>年龄</td>
    	</tr>
    	<c:forEach items="${userList}" var="user">
    	<tr>
    		<td>${user.id}</td>
    		<td>${user.userName}</td>
    		<td>${user.age}</td>
    	</tr>
    	</c:forEach>
    </table>
    <div id="pie"></div>
  </body>
<%--  <script type="text/javascript">--%>
<%--	//创建报表 需要6个参数 一般只用前四个（模版，报表名称(报表ID)，宽，高）--%>
<%--    var chart = new FusionCharts('${pageContext.request.contextPath }/FusionCharts/Charts/Column3D.swf',"chartId", "400", "300");--%>
<%--    //数据的加载来源   setDataURL(找XML文件的路径)--%>
<%--	chart.setDataURL("${pageContext.request.contextPath }/data.xml");--%>
<%-- 	chart.render("pie");--%>
<%--  </script>--%>
  <script type="text/javascript">
  	//创建报表 需要6个参数 一般只用前四个（模版，报表名称(报表ID)，宽，高）
    var chart = new FusionCharts('${pageContext.request.contextPath }/FusionCharts/Charts/Column3D.swf',"chartId", "400", "300");
	//从model里面取json串
	var ss = '${json}';
	//解析json串 把json串转成数组
	var list = eval(ss);
	var charts="<chart showBorder='1' yAxisMinValue='100' borderColor='#cfaec1' yAxisMaxValue='100' xaxisname='用户名' yaxisname='年龄'>";
	for(var i = 0; i< list.length; i++){
		charts+="<set name='"+list[i].userName+"' value='"+list[i].age+"' /> ";
	}
	charts+="</chart>";
	//setDataXML(拼接的xml内部代码的字符串)
 	chart.setDataXML(charts);
 	chart.render("pie");
  </script>
</html>
