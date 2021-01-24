<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function add(){
			open('servlet/EmpControl?method=addForward','','top=100,left=100,widtd=450,height=400');
		}
	</script>
  </head>
  
  <body>
    <!--  用于获得访问者ip和地址的方法 -->
    IP:<%=request.getRemoteAddr() %><br/>
    URI:<%=request.getRequestURI() %><br/><!--获得的是工程名+地址，参数不带-->
    <%
    	// 获得所有的请求参数
    	Enumeration params=request.getParameterNames(); 
    	
    	while(params.hasMoreElements()){
    		String name = (String)params.nextElement();
    		out.print(name+"="+request.getParameter(name)+"<br/>");
    	}
    
    %>
    
    <%
    	// 如果 你 的请求参数中没有  某一个东西 得到的null
    	
    	// hobby 
    %>
    
    QueryString:<%=request.getQueryString() %>
    工程名:<%=request.getContextPath() %>
    ServletContext:<%=application.getContextPath()%>
    
    <%=application.getInitParameter("uu") %>
    
    <input type='button' value='新增' onclick='add()'/>
  </body>
</html>
