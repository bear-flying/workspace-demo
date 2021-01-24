<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'tree.jsp' starting page</title>
     <link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="js/themes/icon.css">   
	<script type="text/javascript" src="js/jquery-1.7.2.js"></script>   
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/sys.js"></script>
  </head>
  
  <body>
    <ul id="tree"></ul>  
  </body>
  <script type="text/javascript">
  	$('#tree').tree({
		url:'<%=request.getContextPath()%>/power/getPowerTree.do',
		idFiled:"Id",
		textFiled:"powername",
		parentField:"parentid",
		onClick: function(node){
				alert(node.text);  // 在用户点击的时候提示
		}
		
		
  	  	});
  
  </script>
</html>
