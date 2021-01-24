<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>Untitled Document</title>
<link href="<c:url value='/css/style.css'/>" rel="stylesheet" type="text/css"/>
<script language="JavaScript" type="text/javascript" src="<c:url value='/js/tree.js'/>"></script>
<link rel="stylesheet" href="<c:url value='/csstree/zTreeStyle.css'/>" type="text/css">
<script type="text/javascript" src="<c:url value='/js/jquery-1.4.4.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.ztree.all-3.3.js'/>"></script>
<script type="text/javascript">
	var setting={
		view:{
			showLine:true//是否显示线，默认为true
		},
		data:{
			key:{
				name:"pname"
			},
			simpleData:{
				enable:true,//开启树的层级结构
				idKey:"id",//设置树节点id，节点参数id必须与之相匹配，即在Actiob中穿过来的值必须与之相对应
				pIdKey:"pid"//设置pid，节点参数pid必须与之相匹配
			}
		},
		check:{
			enable:true
		},
		callback:{
			onClick:zTreeClick//定义节点点击的事件为单击事件
		}
	};
	var zNodes = ${json};//struts2的特性，通过el表达式从java代码中读取zTree节点数据，json必须与从Action中传过来的参数是一样的
	var currentSelectedNode; //定义全局变量  查看当前节点
	//得到当前点击节点的信息，并将id赋值给将要添加节点的pid
	function zTreeClick(event, treeId, treeNode) {
	   var treeObj = $.fn.zTree.getZTreeObj("treeClass");
	   currentSelectedNode = treeObj.getNodeByTId(treeNode.tId);
	  var path =currentSelectedNode.url;
	  parent.frames[3].location.href = path;
	  //parent.frames[3].location.href = currentSelectedNode.url;
	   
	};
	
	//$.fn.zTree.init():为ztree的初始方法，创建zTree必须要使用该方法
	$(document).ready(function(){ 
		//$("#treeClass")通过id，来找到页面的元素
		//setting表示zTree 的配置数据
		//zNodes表zTree的节点数据,从数据库中获取到的
		$.fn.zTree.init($("#treeClass"),setting,zNodes);
		
	});
	function ck(){
		var treeObj = $.fn.zTree.getZTreeObj("treeClass");
		var nodes=treeObj.getCheckedNodes(true);
		var xx="";
      	 for(var i=0;i<nodes.length;i++){
      	 //alert(nodes[i].id);
          xx+=nodes[i].id+",";//获取选中节点的值
       }
		if(xx.length==0){
			alert("请选择权限");
		}else{
			xx=xx.substring(0,xx.length-1);
			document.getElementsByName("ids")[0].value=xx;
			document.forms[0].submit();
			window.close();
		}
	}
</script>
</head>


<body style="background-color: aqua" >
		<form action="<c:url value='/user!saveQx.action'/>" method="post">
			<input type="hidden" name="rid" value="${rid }"/>
			<input type="hidden" name="ids"/>
        <div id="nodes" >
		     <ul id="treeClass" class="ztree"></ul>
         </div>
         <input type="button" value="提交" onclick="ck()"/>
         </form>
</body>
</html>