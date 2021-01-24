<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>更新数据</title>
   <STYLE type="text/css">span{color: red}</STYLE>
  <script type="text/javascript" src="<%=path %>/js/jquery-1.8.2.min.js"></script>
  
  <SCRIPT type="text/javascript">
  		$().ready(function(){
  			
  			$("#name").blur(function(){
  				$("#s1").html("");
  			$.post(
  				"type_checkName.action",
  				{
  					id:$("#id").val(),
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
  			
  		})
  	</SCRIPT>
  
  </head>
  
  <body>
    	<s:form action="type_update.action" method="post" theme="simple" >
    			类型编号：<s:textfield name="id" id="id"  readonly="true" ></s:textfield><br/>
   				类型名称：<s:textfield name="name" id="name"></s:textfield><span id="s1"></span><br/>
   				<s:submit value="提交" id="sub" ></s:submit>&nbsp;&nbsp;&nbsp;&nbsp;<s:reset value="重置" ></s:reset>
   		</s:form>
  </body>
</html>
