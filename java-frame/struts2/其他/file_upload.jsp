<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'file_upload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
<script type="text/javascript">
function dowload(){
	var form = document.all.downForm;

	var iframe = document.getElementById("excelIFrame");

	var url = "<%=path%>/upload!upload.action";
	
	iframe.src = url;
	
	//form.submit();
}
</script>
  <body>
    <s:form action="/upload!upload.action" method="post" enctype="multipart/form-data">
    	
    	<s:file name="file" ></s:file>
    	<s:submit></s:submit>
    </s:form>
    
    <s:form action="/down!downLoad.action" method="post" enctype="multipart/form-data" name="downForm">
    	<s:textfield name="fnamePath" value="20120117112201.txt" label="CAPTION"/>
    	
<%--    	<input type="button" value="下载" onclick="dowload();"/>--%>
<s:submit value="下载"></s:submit>
    	
    	
    </s:form>
	<IFRAME id="excelIFrame" name="excelIFrame" src="about:blank" height="0" width="0" style="height: 0px; width: 0px; display: none;"/>
  </body>
</html>
