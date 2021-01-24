<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/easyui-lang-zh_CN.js"></script>
  
  </head>
  
  <body>
	<table id="dg" title="部门列表"
	 data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true,url:'${pageContext.request.contextPath}/dept!listData.action',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'ID',width:80">编号</th>
				<th data-options="field:'NAME',width:100">部门名称</th>
				<th data-options="field:'PNAME',width:80,align:'right'">上级部门</th>
				<th data-options="field:'FIRSTUSER',width:80,align:'right'">部门正职</th>
				<th data-options="field:'SECONDUSER',width:240">部门副职</th>
				<th data-options="field:'SECRETARY',width:240">部门秘书</th>
				<th data-options="field:'dddd',width:100,align:'center',formatter:getButtons">操作</th>
				<th data-options="field:'eeee',width:100,align:'center',formatter:getAddButton">添加</th>
			</tr>
		</thead>
	</table>
	
	<div id="win"></div>
	<script type="text/javascript">
		$(function(){
			var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
			pager.pagination({
				 buttons:[{
	                    iconCls:'icon-add',
	                    handler:function(){
	                        window.location.href="dept!editPage.action";
	                    }
	                },]
			});			
		});
		
		function getAddButton(){
			return '<input type="button" onclick="addDept()" value="添加">';
		}
		function getButtons(value,row,index){
			return '<input type="button" onclick="editDept(\''+row.ID+'\')" value="修改"><input type="button" onclick="delDept(\''+row.ID+'\')" value="删除">';
		}
		
		function addDept(){
			window.location.href="dept!editPage.action";
		}
		function delDept(id){
			$.post("dept!remove.action",{id:id},function(msg){
				alert("删除成功！");
				$('#dg').datagrid('reload');
			});
		}
		
		function editDept(id){
			openWindow('修改',600,540,'dept!toModify.action?id='+id);
		}
		function openWindow(title,width,height,url){
			$('#win').window({
				title:title,
			    width:width,    
			    height:height,
			    left:($(window).width()-width)*0.5,
				top:($(window).height()-height)*0.5,
			    collapsible:false,
			    minimizable:false,
			    maximizable:false,
			    modal:true   
			});
			$('#win').html('<iframe id="child" name="child" src="${pageContext.request.contextPath}/'+url+'" frameborder="0" style="width: 100%;height: 100%"></iframe>');
		}
		function closeWindow(){
			$('#win').window('close');
			$('#dg').datagrid('reload');
		}
	</script>

  </body>
</html>
