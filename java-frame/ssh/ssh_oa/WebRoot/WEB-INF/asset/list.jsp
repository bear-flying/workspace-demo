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
  
  <body>
    <table id="pp" title="资产一览" class="easyui-datagrid" toolbar="#tool" style="width:400px;height:250px"   
        data-options="fit:true,pagination:true,method:'get',url:'asset!listData.action',fitColumns:true,singleSelect:false">   
    	<thead>   
        <tr>   
        	<th data-options="field:'ID',checkbox:true,width:80">编号</th>
            <th data-options="field:'NAME',width:100">资产名称</th>   
            <th data-options="field:'TYPENAME',width:100">资产类型</th>   
            <th data-options="field:'USERNAME',width:100">用户</th> 
            <th data-options="field:'PRICE',width:100">价格</th> 
            <th data-options="field:'BUYDATE',width:100,formatter:Common.formatterDate1">购买时间</th> 
            <th data-options="field:'CONTENT',width:100">备注</th> 
            <th data-options="field:'FACTORYNAME',width:100">厂家</th> 
            <th data-options="field:'NUM',width:100">NUM</th> 
        </tr>  
    	</thead> 
  
	</table> 
	
	<div id="tool">
		<a href="${pageContext.request.contextPath}/asset!exportAsset.action" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true">导出</a>
		<a href="javascript:void(0)" onclick="imports()" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true">导入</a>
		<div>
			<form id="td" action="${pageContext.request.contextPath}/asset!importAsset.action" method="post" enctype="multipart/form-data">
			
			</form>
		</div>
	</div>
	
  </body>
    <script type="text/javascript">
     function imports() {
        //alert("aaa");
        var td=document.getElementById("td");
        var br=document.createElement("br");
        var file=document.createElement("input");
        var button1=document.createElement("input");
        var button2=document.createElement("input");
        file.type="file";
        file.name="filepath";
        file.id="fp";
        button1.type="button";
        button1.value="删除";
        button1.onclick=function remove() {
           td.removeChild(br);
           td.removeChild(file);
           td.removeChild(button1);
           td.removeChild(button2);
        };
        button2.type="button";
        button2.value="上传";
        button2.onclick=function toimport() {
        	var form = document.all.td;
        	form.submit();
        };
        td.appendChild(file);
        td.appendChild(button2);
        td.appendChild(button1);
        td.appendChild(br);
     }
  </script>
  <script type="text/javascript">
  
  $(function(){
		var pager = $('#pp').datagrid().datagrid('getPager');	// get the pager of datagrid
		pager.pagination({
			 buttons:[{
	                    iconCls:'icon-add',
	                    handler:function(){
	              			window.location.href="asset!toAdd.action";
	                    }
              	 },{
	                    iconCls:'icon-cut',
	                    handler:function(){
	                    	var ids = '';
	           				ids =$('#pp').datagrid('getSelections'); //获得一行数据
	           				if(ids.length==1){
	           					window.location.href="asset!toModify.action?id="+ids[0].ID;
	           				}else{
	           					$.messager.show({
	           							title:'我的消息',
	           							msg:'请选择其中一条数据',
	           							timeout:2000,
	           							showType:'show',
	           							style:{
	           								right:'',
	           								top:document.body.scrollCenter+document.documentElement.scrollTop,
	           								bottom:''
	           							}
	           					});
	           				}
	                    }
               	 },{
	                    iconCls:'icon-remove',
	                    handler:function(){
	                    	
	                    	$.messager.confirm('确认对话框', '您想要删除吗？', function(r){
	 	           				if (r){
	 	           				var selects =$('#pp').datagrid('getSelections');
	 	           				var ids =[];
	 	           				for(var i=0;i<selects.length;i++){
	 	           					ids.push(selects[i].ID);
	 	           				}
	 	           				alert(ids.join());
	 	           				if(ids.length>0){
	 	           				$.post(
	 	           					"<%=path%>/asset!remove.action",
	 	           					{ids:ids.join()},
	 	           					function(msg){
	 	           						if(msg=='ok'){
	 	           							$.messager.alert('我的消息','删除成功！','info',function(){
	 	           								$('#pp').datagrid('load');					
	 	           							});
	 	           						}
	 	           					},'html'
	 	           				);
	 	           				}else{
	 	           					$.messager.show({
	 	           						title:'我的消息',
	 	           						msg:'至少选择一项',
	 	           						timeout:2000,
	 	           						showType:'show',
	 	           						style:{
	 	           							right:'',
	 	           							top:document.body.scrollCenter+document.documentElement.scrollTop,
	 	           							bottom:''
	 	           						}
	 	           					});
	 	           					}
	 	           				}
	           				});
	           			}		
	                   
               	 },]
			});			
	});
  </script>
</html>
