<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'orderList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
<script type="text/javascript">
function toUpdatePage(id){
	alert(id);	
}

function deleteOrder(id){
	alert(id);
}

function toSavePage(){
	var form = document.forms[0];
	form.action = "<%=path%>/stock/order/saveOrder.jsp";
	form.submit();
}
</script>
  <body>
	<s:form action="order" name="orderForm" method="post">
		
		<table border="1" width="80%" align="center">
			<tr>
				<td>
					<button onclick="toSavePage()">添加</button>
				</td>
			</tr>
			<tr>
				<th style="width: 5%">序号</th>
				<th>订单编号</th>
				<th>制单日期</th>
				<th>操作</th>
			</tr>
			<s:iterator value="list" var="order" status="rows">
				<tr>
					<td align="center">${rows.count }</td>
					<td>
						<s:property value="orderNo"/>
					</td>
					<td>
						<s:date name="orderDate" format="yyyy-MM-dd"/>
					</td>
					<td align="center">
						<button value="修改" onclick="toUpdatePage(<s:property value="id"/>)">修改</button>
						<button value="删除" onclick="deleteOrder(<s:property value="id"/>)">删除</button>
					</td>
				</tr>
			</s:iterator>
			
						
		</table>
		
	</s:form>    
  </body>

</html>
