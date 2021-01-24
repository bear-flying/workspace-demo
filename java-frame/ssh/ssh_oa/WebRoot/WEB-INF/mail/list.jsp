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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-chengeTime.js"></script>
  </head>
  
  <body  class="easyui-layout">
  	<div data-options="region:'north',title:''" style="height:50px;">
  		<div align="center">
	  		<a href="mail!writePage.action" target="jfq" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">写邮件</a>
			<a href="mail!receivePage.action" target="jfq" class="easyui-linkbutton" data-options="iconCls:'icon-print',plain:true">收件箱</a>
			<a href="mail!sendPage.action" target="jfq" class="easyui-linkbutton" data-options="iconCls:'icon-redo',plain:true">发件箱</a>
			<a href="mail!draftPage.action" target="jfq" class="easyui-linkbutton" data-options="iconCls:'icon-tip',plain:true">草稿箱</a>
			<a href="mail!rubbishPage.action" target="jfq" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true">垃圾箱</a>
  		</div>
  	</div>   
    <div data-options="region:'center',title:''">
	    <iframe name="jfq" frameborder="0"  style="width: 100%;height: 100%;">
			
       	</iframe>
    </div>   
	<input id="uid" value="${sessionScope.user.id}">
	
  </body>
  <script type="text/javascript">
  $().ready(function(){
	  
	  var url ="${pageContext.request.contextPath}/mail!findNoreadmail.action";
	  $.post(url,{id:$("#uid").val()},function(msg){
		  $.messager.show({
				title:'My Title',
				msg:"您还有<font color='red'>"+msg+"</font>封未读邮件！",
				showType:'show'
		  });
	  })
  });
  </script>
</html>
