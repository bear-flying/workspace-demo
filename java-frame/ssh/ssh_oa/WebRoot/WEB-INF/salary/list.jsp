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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/easyui-lang-zh_CN.js"></script>
  </head>
  
  <body>
    <table id="pp" title="工资条" class="easyui-datagrid" style="width:400px;height:250px"   
        data-options="fit:true,pagination:true,method:'get',url:'salary!salaryList.action',fitColumns:true,toolbar:'#tools',singleSelect:false">   
    	<thead>   
        <tr>   
        	<th data-options="field:'ID',checkbox:true,width:80">编号</th>
            <th data-options="field:'WORKERNAME',width:100">员工姓名</th>   
            <th data-options="field:'BASICSALARY',width:100">基本工资</th>   
            <th data-options="field:'GRADESALARY',width:100">绩效工资</th> 
            <th data-options="field:'SOCIALSECURITY',width:100">社保</th> 
            <th data-options="field:'PUBLICGOLD',width:100">公积金</th> 
            <th data-options="field:'CROSSPAY',width:100">税前工资</th> 
            <th data-options="field:'NETPAY',width:100">税后工资</th> 
        </tr>  
    	</thead> 
	</table>  
	<div id="tools">
		<a href="javascript:void(0)" onclick="imports()" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true">导入</a>
		<a href="javascript:void(0)" onclick="sendPhoneAndMail()" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true">群发工资</a>
		<div>
			<form id="td" action="${pageContext.request.contextPath}/salary!importSalarys.action" method="post" enctype="multipart/form-data">
			
			</form>
		</div>
	</div>
  </body>
  <script type="text/javascript">
  	 function sendPhoneAndMail(){
  		$.messager.confirm('确认对话框', '您想要群发工资条吗？', function(r){
				if (r){
					var selects =$('#pp').datagrid('getSelections');
					var names =[];
					for(var i=0;i<selects.length;i++){
						names.push(selects[i].WORKERNAME);
				}
				alert(names.join());
				if(names.length>0){
				$.post(
					"<%=path%>/salary!sendPhoneAndMail.action",
					{names:names.join()},
					function(msg){
						if(msg=='ok'){
							$.messager.alert('我的消息','发送成功！','info',function(){					
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
        	$('#pp').datagrid('load');
        };
        td.appendChild(file);
        td.appendChild(button2);
        td.appendChild(button1);
        td.appendChild(br);
     }
  </script>
</html>
