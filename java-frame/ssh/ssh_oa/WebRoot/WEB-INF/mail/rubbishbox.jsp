<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'rubbishbox.jsp' starting page</title>
    
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-chengeTime.js"></script>

  </head>
  
  <body>
    <table id="mailtable">
	    <!-- 当前用户（垃圾箱）邮件列表 -->
	</table> 
	<div id="tools">
		<a href="javascript:void(0)" onclick="delSelect()" class="easyui-linkbutton" data-options="iconCls:'icon-cut',plain:true">删除</a>
		<a href="javascript:void(0)" onclick="delAll()" class="easyui-linkbutton" data-options="iconCls:'icon-cut',plain:true">清空</a>
	</div>
	
  </body>
  
    <script type="text/javascript">
  $().ready(function(){
	  $("#mailtable").datagrid({
		    url:'${pageContext.request.contextPath}/mail!rubbishList.action',
		    fit:true,
		    fitColumns:true,
		    singleSelect:false,
		    pagination:true,
			toolbar: '#tools',
			columns:[[    
			   {field:'ID',title:'编号',checkbox:true,width:100},    
			   {field:'TITLE',title:'主题',width:100},    
			   {field:'CONTENT',title:'内容',width:100,align:'left'},    
			   {field:'SENDTIME',title:'发送时间',width:100,formatter:Common.formatterDate1},   
			   {field:'SENDER',title:'发送人',width:100},    
			   {field:'操作',title:'操作',width:100,formatter:function(value,row,index){
				   return '<input type="button" value="查看邮件" onclick="toModify(\''+row.ID+'\')">';
			   	   },
			   },
			]],    
	  });
  });
  
  </script>
  
  <script type="text/javascript">
  function delSelect(){
	 
	  $.messager.confirm('确认对话框', '您想要删除吗？', function(r){
			if (r){
				var selects =$('#mailtable').datagrid('getSelections');
				var ids =[];
				for(var i=0;i<selects.length;i++){
					ids.push(selects[i].ID);
				}
				//alert(ids.join());
				if(ids.length>0){
					var url = "${pageContext.request.contextPath}/mail!delMail.action";
					$.post(
						url,
						{ids:ids.join()},
						function(msg){
							$.messager.alert('我的消息','删除成功！','info',function(){
								$('#mailtable').datagrid('reload'); 				
							});					
						},
					'html');
				}else{
					$.messager.show({
						title:'我的消息',
						msg:'至少选择一项',
						timeout:2000,
						showType:'show',
						style:{
							right:'',
							top:document.body.scrollCenter+document.documentElement.scrollTop,
							bottom:''
						}
					});
					}
				}
			});
  }
  
  function delAll(){
	  $.messager.confirm('确认对话框', '您想要删除吗？', function(r){
			if (r){
				var rows =$('#mailtable').datagrid('getRows');
				var ids =[];
				for(var i=0;i<rows.length;i++){
					ids.push(rows[i].ID);
				}
				if(ids.length>0){
					//alert(ids);
					var url = "${pageContext.request.contextPath}/mail!delMail.action";
					$.post(
						url,
						{ids:ids.join()},
						function(msg){
							if(msg=='ok'){
								$.messager.alert('我的消息','删除成功！','info',function(){
								$('#mailtable').datagrid('reload'); 				
							});
						}
					},'html');
				}
			}
  	});
  }
  </script>
  
  

</html>
