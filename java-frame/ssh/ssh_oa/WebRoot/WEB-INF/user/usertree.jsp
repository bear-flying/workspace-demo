<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tree.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.6.2.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/ztree/zTreeStyle.css" type="text/css"></link>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/ztree/jquery.ztree.core-3.5.min.js"></script>
    
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery/themes/base/jquery.ui.all.css">
	<script src="${pageContext.request.contextPath}/js/jquery/ui/jquery.ui.core.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery/ui/jquery.ui.widget.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery/ui/jquery.ui.position.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery/ui/jquery.ui.autocomplete.js"></script>
  </head>
  
  <body>
    <div class="zTreeDemoBackground left">
    	<input type="text" id="tags">
		<ul id="treeDemo" class="ztree"></ul>
	</div>
  </body>
   <SCRIPT type="text/javascript">
		
		var setting = {
			callback:{
				onClick:zTreeOnClick
			},
			data: {
				simpleData: {
					enable: true
				}
			}
		};

		function zTreeOnClick(event,treeId,treeNode){
			//console.log(treeNode);
			//alert(treeNode.name);
			if(treeNode.ISPARENT=='0'){
				//$.messager.alert('警告','请选择正确的员工');
				alert('请选择正确的员工');
				return;
			}
			
			$('#'+window.parent.idkey,window.parent.document).val(treeNode.id);
			$('#'+window.parent.namekey,window.parent.document).val(treeNode.name);
			window.parent.closeTree();
		}
		

		$(document).ready(function(){
			var availableTags = new Array;
			
			var zNodes = null ; 
		  	$.ajax({
		  		url:'${pageContext.request.contextPath}/user!findUsers.action',
		  		type:'post',
		  		async:false,//设置为同步
		  		dataType:'json',
		  		success:function(data){
		  			zNodes = eval(data);
		  			for(var i=0;1<zNodes.length;i++){
		  				availableTags[i]=zNodes[i].name;
		  				
		  			}
		  			
		  		}
		  	});
			
		  	//return;
		  	
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		
			$( "#tags" ).autocomplete({
				source: availableTags,
				select:function(event,ui){
					//直接选中树上对应输入框中的值
					var node = treeObj.getNodeByParam("name",ui.item.value,null);
					//treeObj.selectNode(node);
					zTreeOnClick(event,null,node);
				}
			});
			
			//获取父页面节点值
			$('#'+window.parent.idkey,window.parent.document).val();
			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			var node = treeObj.getNodeByParam("id",$('#'+window.parent.idkey,window.parent.document).val(),null);
			treeObj.selectNode(node);
			
		});
		
	</SCRIPT>
	
</html>
