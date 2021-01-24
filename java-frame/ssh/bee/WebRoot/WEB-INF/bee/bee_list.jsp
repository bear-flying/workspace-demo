<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bee_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="styles/white_style.css">
	<style type="text/css">
		td{background:transparent}	
		
	</style>
	<script type="text/javascript" src="js/jquery-1.7.js"></script>
	<script type="text/javascript" src="js/jquery-1.8.8.js"></script>
  </head>
  
  <body style="background: URL(images/blackbody.jpg)">
  	<s:form id="f2" action="bees/bee!findAll.action">
  		请输入蜜蜂名：<input type="text" name="name" value="${bee.name}">
  		<s:submit value="查询"></s:submit>
  	</s:form>
    <s:form id="f1" action="bees/bee!remove.action">
    	<table width="60%">
    		<tr>
    			<td>
    				<input type="checkbox" id="selAll">
    			</td>
    			<td><s:text name="name"/></td>
    			<td><s:text name="id"/></td>
    			<td><s:text name="sex"/></td>
    			<td><s:text name="hobby"/></td>
    			<td><s:text name="birthday"/></td>
    			<td><s:text name="image"/></td>
    			<td><s:text name="type"/></td>
    			<td><s:text name="options"/></td>
    		</tr>
    		<s:iterator value="jiangYu.list" id="p">
    		<tr>
    			<td>
    				<!-- 没写value~~~取得值为null -->
    				<input type="checkbox" name="ids" value="${p.cid}">
    			</td>
    			<td>
    				<s:property value="cid"/>
    			</td>
    			<td>
    				<s:property value="name"/>
    			</td>
    			<td>
    				<s:property value="sex"/>
    			</td>
    			<td>
    				<s:property value="hobby"/>
    			</td>
    			<td>
    				<s:property value="birthday"/>
    			</td>
    			<td>
    				<img alt="小白侠" src="<%=path%>/upload/<s:property value="filepath"/>">
    			</td>
    			<td>
    				<s:property value="kindOfBee.kind"/>
    			</td>
    			<td>
    				<input type="button" value="修改蜜蜂" onclick = "location='<%=path%>/bees/bee!findOne.action?cid=<s:property value="cid"/>'">
    				<input type="button" value="下载" onclick = "location='<%=path%>/bees/bee!download.action?filepath=<s:property value="filepath"/>'">
    			</td>
    		</tr>
    		</s:iterator>
    		
    		<tr>
    			<td colspan="8">
    				<input type="button" value="添加蜜蜂" onclick = "location='<%=path%>/bees/bee!toAdd.action'">
    				<input type="button" value="批量删除" onclick = "dele()">
    				<input type="button" value="取消所选" id ="resetAll">
    				<a href="<%=request.getContextPath() %>/bees/bee!change.action?request_locale=zh_CN">中文</a>/
    				<a href="<%=request.getContextPath() %>/bees/bee!change.action?request_locale=en_US">英文</a>
    			</td>
    			<td>
    				<input type="button" value="添加" onclick = "save()">
    				<input type="button" value="修改" onclick = "update()">
    				<input type="button" value="删除所选" id="del">
    			</td>
    		</tr>
<%--    		<tr> 页面小窗口代码：passframe--%>
<%--    			<td>--%>
<%--    				<iframe src="<%=path %>/bees/bee!findAll.action?cid=<s:property value="cid"/>" frameborder="0" height="100%" --%>
<%--    					name="kkk" scrolling="auto" width="100%"></iframe>--%>
<%--    			</td>--%>
<%--    		</tr>--%>
    	</table>
    	
    	<div align="center">
    		${jiangYu.pageAll}
    	</div>
    </s:form>
    <script type="text/javascript">

	//修改
	function update(){
		var id = "";
		var count = 0;
		$(":checkbox").not("#selAll").each(function(){
			if($(this).attr("checked")){
				id = id+","+$(this).parent().parent().children().eq(1).text();
				
				count++;
			}
		});
		ids = id.substring(9);
		if(count==0){
			alert("请至少选择一条记录");	
		}
		if(count>1){
			alert("只能选择一条记录");	
		}
		if(count==1){
			alert("-------------"+ids);
			location.href = "<%=request.getContextPath()%>/bees/bee!findOne.action?cid="+ids;
		}
		
	}
	//删除所选
	$("#del").click(function(){
		 var a = $("input[name='ids']:checked");
		 var b = new Array();
		 for(i=0;i<a.length;i++){
			 b[i] = $(a[i]).val();
		 }
		 if(b.length==0){
			 alert("请至少选择一条记录");	
		 }else{
			if(confirm("你确定要删除ID为 "+b.toString()+" 的记录么？")){
			  	$.ajax({
				   type:"post",
				   url:"bees/bee!remove.action",
				   data:{"ids":b.toString(),}
<%--				   success:function(msg){--%>
<%--						alert("删除成功！");--%>
<%--				   }--%>
			  	});
			    $("input[name='ids']:checked").each(function(){
				   $(this).parents("tr").remove();
			    });
			};
		 };
	});
	
	//添加
	function save(){
		open('<%=path%>/bees/bee!toAdd.action','AddBee','top=150,left=200,width=430,height=400');
	}
	//批量删除
	function dele(){
		document.getElementById('f1').submit();
	}
	
	//全选/反选
	<%--	$("#selAll").click(function(){--%>
	<%--		$(":checkbox").not("#selAll").each(function(){--%>
	<%--			if($(this).attr("checked")){--%>
	<%--				$(this).attr("checked",false);	--%>
	<%--			}else{--%>
	<%--				$(this).attr("checked",true);	--%>
	<%--			}--%>
	<%--		});--%>
	<%--	});--%>
	</script>
  </body>
</html>
