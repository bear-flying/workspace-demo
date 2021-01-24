<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="picture!addPicture.action"
		enctype="multipart/form-data">

		<input type="file" name="myfile" /> <br> 
		
		<input type="submit" value="提交" />
	</form>
	Server Info:

<%

out.println(request.getLocalAddr() + " : " + request.getLocalPort()+"<br>");%>

<%

  out.println("<br> ID " + session.getId()+"<br>");

  // 如果有新的 Session 属性设置

  String dataName = request.getParameter("name");

  if (dataName != null && dataName.length() > 0) {

     String dataValue = request.getParameter("value");

     session.setAttribute(dataName, dataValue);

  }
  out.print("<b>Session List:</b>");  
  Enumeration<String> names = session.getAttributeNames();
  while (names.hasMoreElements()) {
      String sname = names.nextElement(); 
      String value = session.getAttribute(sname).toString();
      out.println( sname + " = " + value+"<br>");
      System.out.println( sname + " = " + value);
 }
%>
 <form action="index.jsp" method="post">
    名称:<input type=text size=20 name="name">
     <br>
    值:<input type=text size=20 name="value">
     <br>
    <input type=submit value="提交">
   </form>

   <b>负载均衡测试<font color=red>bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb</font><b>
</body>
</html>