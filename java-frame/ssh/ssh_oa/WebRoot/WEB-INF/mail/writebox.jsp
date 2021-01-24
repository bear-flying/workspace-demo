<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'writebox.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/kindeditor/default.css" />
	<script charset="utf-8" src="${pageContext.request.contextPath}/js/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="${pageContext.request.contextPath}/js/kindeditor/zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css"/>
	
	
  </head>
  
  <body>
  	<center>
  	<form action="" id="sendForm">
  		邮件主题：<input type="text" id="title" name="title" style="width:480px;"><br><br>
  		收件人：<input type="text" id="userid" name="userid" >
  			  <input type="text" id="username" onclick="openTree('mail!findTree.action')" style="width:465px;"><br><br>
  		邮件状态：<input type="text" id="status" value="未发送" readonly="readonly"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  			  <input type="hidden" id="sendeStatus" name="sendeStatus" value="发送">
  		发件人：<input type="text" id="sender" name="sender" value="${sessionScope.user.realname}" readonly="readonly"> <br><br>
  			
	         邮件内容：<textarea id="textarea" style="width:680px;height:400px;">
			
			  </textarea><br><br>
			  <input type="hidden" name="content" id="content">
		<input type="button" name="sendhtml" value="发送">
		<input type="button" name="savehtml" value="放进草稿箱">
		
		<div id="win">
    		<!-- 树   -->
    	</div>
	</form>
	</center>
  </body>
  <script>
        var editor;
        KindEditor.ready(function(K) {
            editor = K.create('#textarea');
        
	        K("input[name='sendhtml']").click(function(e) {
				alert(editor.html());
				$("#content").val(editor.html());
				url = "${pageContext.request.contextPath}/mail!sendMail.action";
				  $.post(url,$("#sendForm").serialize(),function(msg){
					    $("#status").val("已发送");
						$.messager.show({
								title:'消息',
								msg:'发送成功！',
								timeout:2000,
								showType:'show',
								style:{
									right:'',
									top:document.body.scrollCenter+document.documentElement.scrollTop,
									bottom:''
								}
						});
	
				  });
			});
	        K('input[name=savehtml]').click(function(e) {
				alert(editor.html());
				$("#content").val(editor.html());
				url = "${pageContext.request.contextPath}/mail!toDraftbox.action";
				$.post(url,$("#sendForm").serialize(),function(msg){
					    $("#status").val("草稿");
						$.messager.show({
								title:'消息',
								msg:'已存入草稿！',
								timeout:2000,
								showType:'show',
								style:{
									right:'',
									top:document.body.scrollCenter+document.documentElement.scrollTop,
									bottom:''
								}
						});
	
				  });
			});
        });	
  </script>
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
  </script>
</html>
