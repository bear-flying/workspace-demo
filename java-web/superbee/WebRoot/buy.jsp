<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'buy.jsp' starting page</title>
    
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
  function run(){
	
		open('pay.jsp','ErrorStudent','top=150,left=200,width=300,height=400'); 
	
  }
  
  </script>
  <body>
    <h3 align="center">尊敬的用户，您需要付款:<font color="blue"><%=request.getParameter("price")%></font>元。</h3>
    <fieldset>
    	<legend>请选择付款方式</legend>
    	<form action="pay.jsp">
    	<table align="center">
    		<tr>
    			<td>
    				<input type="radio" name="money" value="a" checked="checked">
    			</td>
    			<td>
    				支付宝
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<input type="radio" name="money" value="b">
    			</td>
    			<td>
    				财付通
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<input type="radio" name="money" value="c">
    			</td>
    			<td>
    				中国银行
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<input type="radio" name="money" value="d">
    			</td>
    			<td>
    				中国工商银行
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<input type="radio" name="money" value="e">
    			</td>
    			<td>
    				中国农业银行
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<input type="radio" name="money" value="c">
    			</td>
    			<td>
    				中国建设银行
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<input type="radio" name="money" value="c">
    			</td>
    			<td>
    				招商银行
    			</td>
    		</tr>
    	</table>
    	<input type="button" value="确认付款" onclick="run()">
    	</form>
    </fieldset>  
  </body>
</html>
