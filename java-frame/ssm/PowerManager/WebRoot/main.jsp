<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>首页</title>
     <link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="js/themes/icon.css">   
	<script type="text/javascript" src="js/jquery-1.7.2.js"></script>   
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/sys.js"></script>
  </head>
  <body class="easyui-layout">
    	<div data-options="region:'north',title:'log',split:true" style="height:130px;">
    		<a href="javascript:tuichu()" class="easyui-linkbutton" iconcls="icon-cancel">注销</a>
    		<audio controls="controls">
		  		<source src="js/always online.mp3" type="audio/ogg">
			</audio> 
			<marquee behavior="alternate" scrollamount="10" onmouseover="this.stop();" onmouseout="this.start();">
				<h1 style="color:grey;">《《欢迎<font style="color: fuchsia;">${userInfo.userName}</font>进入管理系统》》</h1>
			</marquee>
		</div>
		
		<div data-options="region:'west',title:'导航菜单',split:true" style="width:150px;">
			<ul id="tree"></ul>
		</div>
		
		<div data-options="region:'center',title:''" style="padding:5px; background:#eee; width:50" >
			<div class="easyui-tabs" fit="true" border="false" id="tabs" style="width:150;" >
				<div align="center" data-options="title:'首页'" style="background-image: url('images/shouye.jpg')">
					<h1>欢迎使用管理系统</h1>
					<video controls="controls" width="800px" height="600px" autoplay='autoplay'>
						<source src="js/depend.mp4" type="video/mp4" />
					</video>
				</div>
			</div>
		</div>
  </body>
    <script type="text/javascript">
 		$('#tree').tree({
			url:'<%=request.getContextPath()%>/power/getPowerTree.do',
			//url:'<%=request.getContextPath()%>/power/findPowerTreeByUserid.do?userid=1',
			checkbox:true,
			idFiled:"Id",
			textFiled:"powername",
			parentField:"parentid",
			onClick: function(node){
				var context = "<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%'  src="+node.url+"></iframe>";
				$('#tabs').tabs("add",{//add是方法名
					title:node.text,
					content:context,
					closable:true
				});
			}
	  	});
  </script>
</html>
