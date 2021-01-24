<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
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
  </head>
  
  <body>
    <form id="ff" method="post">   
	    <div>   
	        <label for="loginname">账户1:</label>   
	        <input class="easyui-validatebox" type="text" name="loginname" data-options="required:true" />   
	    </div>   
	    <div>   
	        <label for="password">密码:</label>   
	        <input class="easyui-validatebox" type="password" name="password"/>   
	    </div>      
	    <div>   
	        <label for="realname">真实姓名:</label>   
	        <input class="easyui-validatebox" type="text" name="realname"/>   
	    </div>      
	    <div>   
	        <label for="age">年龄:</label>   
	        <input class="easyui-validatebox" type="text" name="age"/>   
	    </div>      
	    <div>   
	        <label for="sex">性别:</label>   
	        <select class="easyui-combobox" name="sex" style="width:200px;">   
			    <option value="男">男</option>   
			    <option value="女">女</option>    
			</select>    
	    </div> 
	    <div>   
	        <label for="phone">电话:</label>   
	        <input class="easyui-validatebox" type="text" name="phone"/>   
	    </div>     
	    <div>   
	        <label for="mail">邮箱:</label>   
	        <input class="easyui-validatebox" type="text" name="mail"  data-options="validType:'email'"/>   
	    </div>     
	    <div>   
	        <label for="birthday">生日:</label>   
	        <input class="easyui-datebox" type="text" name="birthday"/>   
	    </div>     
	    <div>   
	        <label for="adddate">入职时间:</label>   
	        <input class="easyui-datebox" type="text" name="adddate"/>   
	    </div>   
	    <a id="add" onclick="javascript:add()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>  
	    
	    
	</form>  
  </body>
  <script type="text/javascript">
  function add(){
	  
	  $.post("user!add.action",$("#ff").serialize(),function(msg){
		  window.parent.closeDialog();
	  });
	  
  }
  </script>
</html>
