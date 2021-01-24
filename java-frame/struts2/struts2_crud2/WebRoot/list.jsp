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
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/styles/white_style.css">
<%--	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/general.css" type="text/css"></link>--%>
<%--    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css" type="text/css"></link>--%>
<%--	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/public.css" type="text/css"></link>--%>
<%--    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css" type="text/css"></link>--%>

<script src = "<%= request.getContextPath() %>/js/jquery-1.7.js"></script>
	<style type="text/css">
		td{background:transparent}
		
	</style>
<script type="text/javascript">

function toUpdatePage(id){
	alert(id);
	var form = document.getElementById('f1');
	document.getElementsByName("emp.id")[0].value = id;
	form.action = '<%=path%>/emp!toUpdate.action';
	form.submit();
}

function deleteOrder(id){
	alert(id);
	var form = document.getElementById('f1');
	document.getElementsByName("emp.id")[0].value = id;
	form.action = '<%=path%>/emp!toDelete.action';
	form.submit();
}

//function toSavePage(){
//	var fm = document.getElementById('f1');
//	fm.action = "<%=path%>/emp!tosave.action";
	
//	fm.submit();
//}

</script>	
  </head>
  
  <body style = "background:URL(images/blackbody2.jpg) no-repeat">
  	<s:form action="" theme="simple" id="f1" method="post">
    <table border="1" width="80%" align="center" class="table">
    	<tr>
			<td>
				<input type="button" value="添加" onclick="location='<%=path%>/emp!tosave.action'">
				<a href="<%=path%>/emp!tosave.action">添加</a>
			</td>
		</tr>
    	<tr>
    		<td>序号</td>
    		<td>名字</td>
    		<td>性别</td>
    		<td>爱好</td>
    		<td>种类</td>
    		<td>ID</td>
    		<td>操作</td>
    	</tr>
    	<s:iterator value="pb.list" id="emp" status="s">
    	<tr>
    		<td align="center">${s.count}</td>
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
    			<s:property value="rname"/>
    		</td>
    		<td>
    			${emp.sex}${emp.id}
    		</td>
    		<td>
    			<input type="hidden" name="emp.id" value="">
    			<button value="修改" onclick="toUpdatePage(<s:property value="id"/>)">修改</button>
				<button value="删除" onclick="deleteOrder(<s:property value="id"/>)">删除</button>
    			<a href="<%=path%>/emp!toDelete.action?id=${emp.id}">删除</a>
    			<a href="<%=path%>/emp!toUpdate.action?id=<s:property value="id"/>">修改</a>
    		</td>
    	</tr>
    	</s:iterator>	
    	<tr>
  			<td colspan = "20">
  						共${totalNums }条数据
		    			${page }/${totalPages }页
		    			${firstPage }
		    			${prevPage }
		    			${nextPage }
		    			${lastPage }
  			</td>
  		</tr>
    </table>
    </s:form>
  </body>
</html>
