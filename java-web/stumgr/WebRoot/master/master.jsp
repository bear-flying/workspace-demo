<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>masterl.jsp</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  <frameset rows='10%,*,10%'>
  		<frame src='master/top.jsp' name='topFrame'/>
  		<frameset cols='20%,*'>
  			<frame src='master/menu.jsp' name='menuFrame'/>
  			<frame src='master/right.jsp' name='rightFrame'/>
  		</frameset>
  		<frame src='master/bottom.jsp' name='bottomFrame'/>
  </frameset>
  <body>
    This is my HTML page. <br>
  </body>
</html>
