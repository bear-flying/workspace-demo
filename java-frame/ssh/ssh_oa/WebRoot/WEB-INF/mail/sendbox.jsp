<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sendbox.jsp' starting page</title>
    
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
  
  <body>
    <table id="mailtable">
	    <!-- 当前用户（已发送的）邮件列表 -->
	</table>
  </body>
  <script type="text/javascript">
  function changeToRubbish2(id){
	  var url = "${pageContext.request.contextPath}/mail!changeToRubbish2.action";
	  $.post(url,{id:id},function(msg){
		  $('#mailtable').datagrid('reload'); 
	  });
  }
  
  
  $().ready(function(){
	  $("#mailtable").datagrid({
		    url:'${pageContext.request.contextPath}/mail!sendList.action',
		    fit:true,
		    fitColumns:true,
		    singleSelect:true,
		    pagination:true,
			//toolbar: '#tools',
			columns:[[    
			   {field:'ID',title:'编号',width:100},    
			   {field:'TITLE',title:'主题',width:100},    
			   {field:'CONTENT',title:'内容',width:100,align:'left'},    
			   {field:'SENDTIME',title:'发送时间',width:100,formatter:Common.formatterDate1},   
			   {field:'SENDER',title:'发送人',width:100},    
			   {field:'操作',title:'操作',width:100,formatter:function(value,row,index){
				   return '<input type="button" value="查看邮件" onclick="toModify(\''+row.ID+'\')">'+
				   		  '<input type="button" value="删除" onclick="changeToRubbish2(\''+row.ID+'\')">';
			   			   //删除邮件的操作 --->是把邮件放入垃圾箱
			   			   
			   	   }
			   },
			]]    
	  });


  });
  </script>
</html>
