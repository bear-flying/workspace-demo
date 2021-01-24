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
	<link rel="stylesheet" type="text/css" href="styles/pop_style.css">
	<style type="text/css">
		td{background:transparent}
		
	</style>

  </head>
  <script type="text/javascript" src="js/jquery-1.7.js"></script>
  <body style = "background:URL(images/whitebody.jpg) no-repeat">
    <s:form id="f1" action="dept!remove.action">
    	<table>
    		<tr>
    			<td>
    				<input type="checkbox" id="selAll">
    				全选/反选
    			</td>
    			<td>标识</td>
    			<td>部门</td>
    			<td>操作</td>
    		</tr>
    		<s:iterator value="jiangYu.list" id="p">
    		<tr>
    			<td>
    				<input type="checkbox" name="ids" value="${p.did}">
    			</td>
    			<td>
    				<s:property value="did"/>
    			</td>
    			<td>
    				<s:property value="deptn"/>
    			</td>
    
    			<td>
    				<input type="button" value="修改" onclick="location='<%=path%>/dept!findOne.action?did=<s:property value="did"/>'"> 
    			</td>
    		</tr>
    		</s:iterator>
    		<tr>
    			<td colspan="4">
    			    <input type="button" value="添加" onclick="location='<%=path%>/dept!toAdd.action'">
    			    <input type="button" value="删除所选" onclick="del()">
    			</td>
    		</tr>
    	</table>
    	<div align="center">
    		${jiangYu.pageAll}
    	</div>
    </s:form>
  </body>
  <script type="text/javascript">
  $(function(){
	  $("#selAll").click(function(){
	       $(":checkbox[name='ids']").each(function()
	       		{$(this).prop("checked",!$(this).prop("checked"));
	       });
	  });
  });
  function del(){
	  document.getElementById('f1').submit();
  }
  </script>
</html>
