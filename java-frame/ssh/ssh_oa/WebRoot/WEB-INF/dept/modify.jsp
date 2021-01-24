<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
		
	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/ztree/zTreeStyle.css" type="text/css"></link>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/ztree/jquery.ztree.core-3.5.min.js"></script>
  </head>
  
  <body>
    <div class="easyui-accordion" data-options="border:true" style="width:1140px;height:35px;margin:10px;">
		<img alt="华天" src="js/main/images/title_arrow.png" style="margin-left:15px;padding-top:8px;" >
		部门信息
	</div>
			
	<div class="easyui-layout" data-options="fit:true">   
           
           <div data-options="region:'west',collapsed:true" style="width:180px">
            		
           </div>   
          
           <div data-options="region:'center'">    		
              <form action="" id="ff">
              			<input type="hidden" name="dept.id" value="${id}" >
            	部门名称：<input class="easyui-textbox" name="dept.deptName" value="${deptName}" style="width:200px"> <br><br>
<%--            部门编号：<input class="easyui-textbox" id="deptid" style="width:200px"> <br><br>--%>
            	职能类型：<select id="cc" class="easyui-combobox" style="width:200px;">   
	    					<option></option>   
							<option selected="selected">管理</option>   
							<option>服务</option>   
							<option>销售</option>   
							<option>生产</option>   
					    </select><br><br>
					   
				上级部门：<input type="text" name="dept.pdept.id" value="${pdept.id}" id="pp">
						<input type="text" id="mm" onclick="openTree('dept!findTree.action')" style="width:200px"><br><br>
            	部门正职：<input type="text" name="dept.firstUser" value="${firstUser}" id="p1">
						<input type="text" id="m1" onclick="openTree('user!findTree.action')" style="width:200px"><br><br>
            	部门副职：<input type="text" name="dept.secondUser" value="${secondUser}" id="p2">
						<input type="text" id="m2" onclick="openTree('user!findTree.action')" style="width:200px"><br><br>
            	部门秘书：<input type="text" name="dept.secretary" value="${secretary}" id="p3">
						<input type="text" id="m3" onclick="openTree('user!findTree.action')" style="width:200px"><br><br>
						<a id="add" onclick="javascript:modify()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>  
        	 	<div id="win">
    				<!-- 树   -->
    			</div>
        	   </form>           		
            </div>   
       	</div> 
  </body>
  <script type="text/javascript">
  
  	var idkey = '';
  	var namekey = '';
  	
	function openTree(url){
		idkey = $('#'+event.target.id).prev().attr('id');
		namekey = event.target.id;
		openWindow('部门',300,500,url);
	}

	function closeTree(){
		$('#win').window('close');
	}
	
	function openWindow(title,width,height,url){
		$('#win').window({
			title:title,
		    width:width,    
		    height:height,
		    //相对居中
		    left:($(window).width()-width)*0.5,
			top:($(window).height()-height)*0.5,
		    collapsible:false,
		    minimizable:false,
		    maximizable:false,
		    modal:true   
		});
		$('#win').html('<iframe id="child" name="child" src="${pageContext.request.contextPath}/'+url+'" frameborder="0" style="width: 100%;height: 100%"></iframe>');
	}
	
	function modify(){
		$.post("dept!edit.action",$("#ff").serialize(),function(msg){
			window.parent.closeWindow();
		});
	}
	
	$().ready(function(){
		$.post("dept!findonepid.action",{id:$("#pp").val()},function(msg1){
			$("#mm").val(msg1);
		});
		$.post("user!findoneuser.action",{id:$("#p1").val()},function(msg2){
			$("#m1").val(msg2);
		});
		$.post("user!findoneuser.action",{id:$("#p2").val()},function(msg3){
			$("#m2").val(msg3);
		});
		$.post("user!findoneuser.action",{id:$("#p3").val()},function(msg4){
			$("#m3").val(msg4);
		});
	});
	</script>
</html>
