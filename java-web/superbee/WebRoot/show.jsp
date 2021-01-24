<%@ page language="java" import="java.util.*,com.bee.vo.Food" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
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
  </script>
  <body>
    <form action="buy.jsp">
    <h3 align=center><font color="red">${sorry}${city}</font></h3>
    <table align="center" border="1" width="35%" cellspacing="0">
    
    <% 
    	List<Food> list = (List<Food>)request.getAttribute("vegetables");
    	
    	if(list!=null){
    		for(Food f : list){
    %>
    	<tr>
    		<td align="center" rowspan="3"><img src="images/<%=f.getImg()%>"></td>
    		<td><%=f.getName() %></td>
    	</tr>
    	<tr>
    		<td><%=f.getPrice() %></td>
    	</tr>
    	<tr>
    		<td rowspan="2"><%=f.getIntroduce()%></td>
    	</tr>
   		<tr>
    		<td align="center">
    		    <input type="hidden" name="price" value="<%=f.getPrice() %>">
    			<input type="submit" value="我要购买">
    		</td>
    	</tr>
    	
    		<%} %>
    	<%}%>
    </table>
    </form>
  </body>
</html>
