<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加数据</title>
  <STYLE type="text/css">span{color: red}</STYLE>
  <script type="text/javascript" src="<%=path %>/js/jquery-1.8.2.min.js"></script>
  	<SCRIPT type="text/javascript">
  		$().ready(function(){
  			$("#name").blur(function(){
  			$("#s1").html("");
  			$.post(
  				"<%=path%>/book_checkName.action", 
  				{
  					id:-1,
  					name:$("#name").val()
  				},
  				function(s){
  					if(s){
  						$("#s1").html(s);
  						$("#sub").attr("disabled",true);
  					}else{
  						$("#sub").attr("disabled",false);
  					}
  				},
  				"text"
  			
  			)
  		})
  		
  		$("#price").blur(function(){
  			$("#s2").html("");
  			$.post(
  				"<%=path%>/book_checkPrice.action",
  				{
  					prices:$("#price").val()
  				},
  				function(s){
  					if(s){
  						$("#s2").html(s);
  						$("#sub").attr("disabled",true);
  					}else{
  						$("#sub").attr("disabled",false);
  					}
  				},
  				"text"
  			)
  			
  		})
  		
  		})
  	</SCRIPT>
  </head>
  
  <body>
   		<s:form action="book_add.action" method="post" theme="simple" >
   				图书名称：<s:textfield name="name" id="name"></s:textfield><span id="s1"></span><br/>
   				图书价格：<s:textfield name="price" id="price"></s:textfield><span id="s2"></span><br/>
   				图书类型：<s:select name="type.id" list="list" listKey="id" listValue="name" headerKey="" headerValue="--请选择--"></s:select>
   				<br/>
   				<s:submit value="提交" id="sub" ></s:submit>&nbsp;&nbsp;&nbsp;&nbsp;<s:reset value="重置" ></s:reset>
   		</s:form>
  </body>
</html>
