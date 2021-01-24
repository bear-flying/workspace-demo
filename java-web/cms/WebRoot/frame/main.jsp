<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  	<frameset border="0" frameSpacing="0" rows="60, *" frameBorder="0">
  	
  		<frame name="header" src="<%=request.getContextPath()%>/frame/header.jsp" frameBorder=0  scrolling="no" />
  	
  		<frameset cols="170, *">
  			
  			<frame name="menu" src="<%=request.getContextPath()%>/frame/menu.jsp" frameBorder="0" />
  			
  			<frame name="mainPage" src="<%=request.getContextPath()%>/frame/center.jsp" frameBorder="0" scrolling="yes">
  		
  		</frameset>
  	
  	</frameset>
</html>
