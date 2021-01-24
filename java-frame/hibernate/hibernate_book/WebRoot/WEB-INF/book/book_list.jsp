<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>列表展示</title>
  <link rel="stylesheet" href="<%=path %>/js/index.css" type="text/css"></link>
  <script type="text/javascript" src="<%=path %>/js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript">
  	$().ready(function(){
  		
  		$("#cks").click(function(){
  			$(".ck").prop("checked",this.checked);
  		})
  		$(".ck").click(function(){
  			
  			$("#cks").prop("checked",$(".ck:checked").length == $(".ck").length);
  		})
  		
  		$(".go").click(function(){
  			
  			$("#page").val($(this).attr("name"));
  			$("#fm").submit();
  		})
  		$("#delAll").click(function(){
  			
  			if($(".ck:checked").length){
  				var ids = $.map($(".ck:checked").toArray(),function(s){return $(s).val()})
  				if(confirm("确认删除数据?"))
  					location.href = "book_delete.action?oid="+ids;
  			}else{
  				alert("请选择数据!");
  			}
  		})
  		
  	})
  </script>
  </head>
  
  <body>
   		<form action="book_list.action" method="post" id="fm" >
   			<input type="hidden" name="page" id="page" />
   		</form>
   		
   		<table>
   			<tr align="center" >
   				<td colspan="6">
   					<a href="type_list.action" >类型展示</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="book_toAdd.action" >添加</a>
   				</td>
   			</tr>
   			<tr align="center" >
   				<td>
   					<input type="checkbox" id="cks" />全选/全不选
   				</td>
   				<td>图书编号</td>
   				<td>图书名称</td>
   				<td>图书价格</td>
   				<td>图书类型</td>
   				<td>操&nbsp;&nbsp;&nbsp;&nbsp;作</td>
   			</tr>
   			<s:iterator value="pagebean.list">
   				<tr align="center" >
   				<td>
   					<input type="checkbox" class="ck" value='<s:property value="id" />' />
   				</td>
   				<td>
   					<s:property value="id" />
   				</td>
   				<td>
   					<s:property value="name" />
   				</td>
   				<td>
   					<s:property value="price" />
   				</td>
   				<td>
   					<s:property value="type.name" />
   				</td>
   				<td>
   					<a href='book_toUpdate.action?oid=<s:property value="id" />' >修改</a>
   					<a href='book_delete.action?oid=<s:property value="id" />' >删除</a>
   				</td>
   				</tr>
   			</s:iterator>
   			<tr align="center" >
   				<td colspan="6">
   					<a href="javascript:void(0)" name='1' class="go" >首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
   					<a href="javascript:void(0)" name='<s:property value="pagebean.prevPage" />' class="go" >上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
   					<a href="javascript:void(0)" name='<s:property value="pagebean.nextPage" />' class="go" >下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
   					<a href="javascript:void(0)" name='<s:property value="pagebean.totalPages" />' class="go" >尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;
   					<a href="javascript:void(0)" id="delAll" >批量删除</a>
   				</td>
   			</tr>
   		</table>
  </body>
</html>
