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

/**
 * 全选
 */
function checkAll(checkFlag){
	var ids = document.getElementsByName("id");
	for(var i=0;i<ids.length;i++){
		ids[i].checked = checkFlag;
	}
}

function checkValues(){
	var ids = document.getElementsByName("id");
	var array = [];
	for(var i=0;i<ids.length;i++){
		if(ids[i].checked){
			array.push(ids[i].value);
		}
	}
	window.returnValue = array;
	window.close();
}

function selectMaterials(){
	var parentWin = window.dialogArguments;
	var materIds = parentWin.document.getElementsByName('materIds')[0].value.split(",");
	var ids = document.getElementsByName("id");
	for(var i=0;i<ids.length;i++){
		for(var j=0;j<materIds.length;j++){
			if(materIds[j]==ids[i].value.split(",")[0]){
				ids[i].checked = true;
				ids[i].disabled = 'disabled';
			}
		}
	}
}

</script>
<body onload="selectMaterials()">
<s:form action="order" name="orderForm" method="post">
		
		<table border="1" width="80%" align="center">
			<tr align="center">
				<td colspan="3">
					<button onclick="checkValues()">确定</button>
					<button onclick="window.close()" style="margin-left: 40px">关闭</button>
				</td>
			</tr>
			<tr>
				<th style="width: 5%">
					<input type="checkbox" name="ids" onclick="checkAll(this.checked)"/>
				</th>
				<th>原料名称</th>
				<th>原料库存</th>
			</tr>
			<s:iterator value="list" var="material" status="rows">
				<tr>
					<td align="center">
						<input type="checkbox" name="id" value="<s:property value="id"/>,<s:property value="materialName"/>"/>
					</td>
					<td>
						<s:property value="materialName"/>
					</td>
					<td>
						<s:property value="storage"/>
					</td>
				</tr>
			</s:iterator>
			
						
		</table>
		
	</s:form> 
  </body>
</html>
