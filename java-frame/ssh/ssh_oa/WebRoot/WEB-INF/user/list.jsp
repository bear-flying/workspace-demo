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
    <table id="pp" title="用户一览" class="easyui-datagrid" style="width:400px;height:250px"   
        data-options="fit:true,pagination:true,method:'get',url:'user!listData.action',fitColumns:true,singleSelect:false">   
    	<thead>   
        <tr>   
        	<th data-options="field:'ID',checkbox:true,width:80">编号</th>
            <th data-options="field:'LOGINNAME',width:100">账户</th>   
            <th data-options="field:'REALNAME',width:100">真实姓名</th>   
            <th data-options="field:'AGE',width:100">年龄</th> 
            <th data-options="field:'SEX',width:100">性别</th> 
            <th data-options="field:'BIRTHDAY',width:100,formatter:Common.formatterDate1">生日</th> 
            <th data-options="field:'PHONE',width:100">电话</th> 
            <th data-options="field:'MAIL',width:100">邮箱</th> 
            <th data-options="field:'ADDDATE',width:100">日期</th> 
        </tr>  
         
    	</thead> 
	</table>  
	
	<div id="dia" title="操作" class="easyui-dialog"
			style="width:400px;height:380px;padding:10px 20px" closed="true"
			>	<!-- buttons="#dlg-buttons" -->
			<span id="span"></span>
	</div>
  </body>
  <script type="text/javascript">
    function getDate(value,row,index){
		var curDate =new Date(value.time);
		return curDate.getFullYear()+"-"+(curDate.getMonth()+1)+"-"+curDate.getDate();
	}
    
    function closeDialog(){
    	$('#dia').dialog('close');
    	$('#pp').datagrid('reload');
    }
    
    $(function(){
		var pager = $('#pp').datagrid().datagrid('getPager');	// get the pager of datagrid
		pager.pagination({
			 buttons:[{
	                    iconCls:'icon-add',
	                    handler:function(){
	                    	$('#dia').dialog('open');
	                    	$('#span').html('<iframe id="child" name="child" src="${pageContext.request.contextPath}/user!toAdd.action" frameborder="0" style="width: 100%;height: 100%"></iframe>');
	              			
	                    	
	                    }
                	 },{
 	                    iconCls:'icon-cut',
 	                    handler:function(){
 	                    	$('#dia').dialog('open');
 	                    	var ids = '';
 	           				ids =$('#pp').datagrid('getSelections'); //获得一行数据
 	           				if(ids.length==1){
 	           					$('#span').html('<iframe id="child" name="child" src="${pageContext.request.contextPath}/user!toModify.action?id='+ids[0].ID+'" frameborder="0" style="width: 100%;height: 100%"></iframe>');
 	           					//openWindow('修改','600','450','/dept!findby.action?id='+ids[0].ID);
 	           					/*$("#updateFrom").form('load',ids[0]);
 	           					$("#au").dialog();*/
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
	 	           					"<%=path%>/user!remove.action",
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
