<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'rolelist.jsp' starting page</title>
	<link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="js/themes/icon.css">   
	<script type="text/javascript" src="js/jquery-1.7.2.js"></script>   
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/sys.js"></script>
  </head>
  
  <body>
    <table id="dg" title="My Users" class="easyui-datagrid"
		style="width:700px;height:430px" url="power/findRoleList.do"
		 rownumbers="true"  toolbar="#toolbar" pagination="true"
		fitColumns="true" singleSelect="true" >
		<thead>
			<tr>
				<th field="Id" width="50">角色id</th>
				<th field="rolename" width="50">角色名称</th>
				<th field="操作" width="50" data-options="formatter:formatOper">操作</th>
			</tr>
		</thead>
	</table>
	
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="newUser()">New User</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editUser()">Edit User</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove
			User</a>
	</div>
	
	<div id="roleid" title="角色设置权限" class="easyui-dialog"
		style="width:400px;height:380px;padding:10px 20px" closed="true"
		buttons="#dlg-buttons">
		<span id="tree-roleid"></span>
	    <span id="tree"></span>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-ok" onclick="saverolepower()" style="width:90px">保存</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
			style="width:90px">取消</a>
	</div>
  </body>
  <script type="text/javascript">
  		function formatOper(val,row,index){ 
	   		 return	'<input type="button" value="角色赋权限" onclick="openRole('+row.Id+')"/>';
		} 
		//第一次是  打开角色信息和权限信息，第二次还要回显权限细细
		function openRole(roleid){
			$('#roleid').dialog('open');
			//去数据库获取角色的信息
			$.ajax({
				//async:false,
				dataType:'text',
				url:"power/findRoleById.do",
				success:function(data){
					$('#tree-roleid').html("当前角色为:"+data+"<br>当前角色ID为："+roleid+"<input type='hidden'  id='roleidvalue' value='"+roleid+"'/>");
				}
			});
			//获取权限树
			$('#tree').tree({
				url:'<%=request.getContextPath()%>/power/getPowerTree.do',
				checkbox:true,
				idFiled:"Id",
				textFiled:"powername",
				parentField:"parentid"
		  	});

		  	//回显权限
		  	$.ajax({
		  	//async:false,
			url : "power/findRolePower.do",
			dataType : 'json',
			data : {
				'roleid' : roleid
				//'roleid' : $('#roleidvalue').val()
			},
			success : function(data) {
				alert(data);
				//{"powerid":7},{"powerid":6},{"powerid":5},{"powerid":1},{"powerid":5},{"powerid":6},{"powerid":7},{"powerid":9},{"powerid":1},{"powerid":5},{"powerid":6},{"powerid":7},{"powerid":9}
				$.each(data, function(i, item) {
					var node = $('#tree').tree('find', item.powerid);
				    	alert(node);
					//alert(roleid);
					//让它被选中
					if ($('#tree').tree('isLeaf', node.target)) {
						$('#tree').tree('check', node.target);
					}
					
				});
			}
		  	});
		}

		//保存角色和权限
		function saverolepower(){
			var getChecked = $('#tree').tree('getChecked',[ 'checked', 'indeterminate' ]);
			var ids = "";
			for (var i = 0; i < getChecked.length; i++) {
				ids += getChecked[i].Id + ",";
			}
			alert(ids)
			var roleidvalue = $("#roleidvalue").val();	
			$.get("power/addRolePower.do", {
				roleid : roleidvalue,
				powerids : ids
			}, function(data) {
				alert(data + "设置角色成功！");
				$('#roleid').dialog('close');
			});




				
		} 
  
  </script>
  
</html>
