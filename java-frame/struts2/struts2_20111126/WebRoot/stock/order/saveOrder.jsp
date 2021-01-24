<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
String time = sdf.format(new Date());
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
function showMaterials(){
	var form = document.forms[0];
	//时间戳
	var time = new Date();
	var url = "<%=path%>/material!queryMaterials.action?time="+time;
	var result = window.showModalDialog(url,window,'dialogWidth:800px;dialogHeight:400px');

	var ids = [];
	if(result!=null && result!=undefined){
		for(var i=0;i<result.length;i++){
			var array = result[i].split(",");
			//alert(array[0]);
			ids.push(array[0]);
			insertMaterialMsg(array);
		}
		form.materIds.value = ids.toString();
	}
}

function insertMaterialMsg(array){
	//原料ID
	var id = array[0];
	//原料名称
	var name = array[1];

	var trObj = selMaterialTable.insertRow();
	var tdObj = trObj.insertCell();
	tdObj.innerHTML = "<input type=\"hidden\" name=\"materId\" value=\""+id+"\">"+name+"";

	var tdObj = trObj.insertCell();
	tdObj.innerHTML = "<input type=\"text\" value=\"\" name=\"count\">";
	
	var tdObj = trObj.insertCell();
	tdObj.innerHTML = "<button onclick=\"deleteMaterial(this,'"+id+"')\" >删除</button>";
	tdObj.setAttribute("align","center");
}

function deleteMaterial(bn,id){
	var delTR = bn.parentNode.parentNode;
	var table = delTR.parentNode;
	table.removeChild(delTR);
	//alert(id);
	var materIds = document.getElementsByName('materIds')[0].value.split(",");
	var temp = [];
	for(var i=0;i<materIds.length;i++){
		if(materIds[i]!=id){
			temp.push(materIds[i]);
		}
	}
	document.getElementsByName('materIds')[0].value = temp.toString();
}

</script>
  <body>
    <form action="<%=path %>/order!saveOrder" name="orderForm" method="post">
    	<input type="hidden" name="materIds" value=""/>
    	<fieldset>
    		<legend>订单基本信息</legend>
    		<table border="1" width="80%" align="center">
    			<tr>
    				<td>订单编号</td>
    				<td>
    					<input type="text" value="" name="order.orderNo" readonly="readonly" style="border: 0px">
    				</td>
    				<td>制单日期</td>
    				<td>
    					<input type="text" value="<%=time %>" name="order.orderDateString" readonly="readonly" style="border: 0px">
    				</td>
    				<td>提交标志</td>
    				<td>未提交</td>
    			</tr>
    		</table>
    	</fieldset>
    	<fieldset>
    		<legend>原料信息</legend>
    		<table border="1" width="80%" align="center" id="selMaterialTable">
    			<tr>
    				<td colspan="3">
    					<button onclick="showMaterials()">选择原料</button>
    				</td>
    			</tr>
    			<tr>
    				<th>原料名称</th>
    				<th>订货数量</th>
    				<th>操作</th>
    			</tr>
    			
    		</table>
    	</fieldset>
    	<table align="center">
    		<tr>
    			<td align="center">
    				<input type="submit" value="保存订单">
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
