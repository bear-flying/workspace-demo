<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'receivebox.jsp' starting page</title>
    
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
	    <!-- 当前用户（已读和未读的）邮件列表 -->
	</table> 
	
	<div id="dia" title="操作" class="easyui-dialog"
			style="width:400px;height:380px;padding:10px 20px" closed="true">	
		<span id="span"></span>	
	</div>
  </body>
  <script type="text/javascript">
  function changeToRubbish(id){
	  var url = "${pageContext.request.contextPath}/mail!changeToRubbish.action";
	  $.post(url,{id:id},function(msg){
		  $('#mailtable').datagrid('reload'); 
	  });
  }
  
  function lookup(row){
	  $('#dia').dialog('open');
	  $("#span").html("主题：<font color='gree'>"+row.TITLE+"</font><br><br>"+
			  "接收时间：<font color='red'>"+row.SENDTIME+"</font><br><br>"+
			  "发件人：<font color='blue'>"+row.SENDER+"</font><br><br>"+
			  "邮件内容："+row.CONTENT);
  }
  
  $().ready(function(){
	  $("#mailtable").datagrid({
		    url:'${pageContext.request.contextPath}/mail!receiveList.action',
		    //title:"邮件展示",
		    fit:true,
		    fitColumns:true,
		    singleSelect:true,
		    pagination:true,
		    rowStyler: function(index,row){
		        if (row.RECEIVESTATUS=='未读'){
		            return 'background-color:#6293BB;color:#fff;font-weight:bold;';
		        }
		    },
			//toolbar: '#tools',
			columns:[[    
			   {field:'ID',title:'编号',width:100},    
			   {field:'TITLE',title:'主题',width:100},    
			   {field:'CONTENT',title:'内容',width:100,align:'left'},    
			   {field:'SENDTIME',title:'发送时间',width:100,formatter:Common.formatterDate1},   
			   {field:'SENDER',title:'发送人',width:100},    
			   {field:'RECEIVESTATUS',title:'邮件状态',width:100,formatter:function(value,row,index){
				   if(row.RECEIVESTATUS=='未读'){
					   return "<font color='red'>未读</font>";
				   }else{
					   return '已读';
				   }
			   }},    
			   {field:'操作',title:'操作',width:100,formatter:function(value,row,index){
				   return '<input type="button" value="查看邮件" onclick="lookup(\''+row+'\')">'+
				   		  '<input type="button" value="删除" onclick="changeToRubbish(\''+row.ID+'\')">';
			   			   //删除邮件的操作 --->是把邮件放入垃圾箱
			   			   
			   	   }
			   },
			]]    
	  });
	  

  });
  

  </script>
</html>
