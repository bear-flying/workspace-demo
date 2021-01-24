<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=path%>/js/jquery-1.7.js"></script>
    <script type="text/javascript" src="<%=path%>/FusionCharts/Charts/FusionCharts.js"></script>
  </head>
  
  <body>
          不同部门发送邮件的数量统计：<br>
    <div id="mails"></div><br>
          公司资产的不同状态统计：<br>
    <div id="assets"></div><br>
    
    
    <a href="<%=path%>/chart!findQuartzDmps.action">导出dmp</a>
    <a href="<%=path%>/chart!findQuartzMails.action">导出ImgExcel</a>
  </body>
  <script type="text/javascript">
  	$().ready(function(){
  		var chart1 = new FusionCharts('${pageContext.request.contextPath }/FusionCharts/Charts/Column3D.swf',"chartId", "400", "300");
  		$.ajax({
  			url:"<%=path%>/chart!findmails.action",
  			type:"post",
  			dataType:"json",
  			success:function(list){
  				var charts="<chart showBorder='1' yAxisMinValue='0' borderColor='#cfaec1' yAxisMaxValue='50' xaxisname='部门' yaxisname='邮件数'>";
  				for(var i = 0; i< list.length; i++){
  					charts+="<set name='"+list[i].NAME+"' value='"+list[i].NUM+"' /> ";
  				}
  				charts+="</chart>";
  			 	chart1.setDataXML(charts);
  			 	chart1.render("mails");
  			}
  		});
  		var chart2 = new FusionCharts('${pageContext.request.contextPath }/FusionCharts/Charts/Pie3D.swf',"chartId2", "400", "300");
  		$.ajax({
  			url:"<%=path%>/chart!findAssets.action",
  			type:"post",
  			dataType:"json",
  			success:function(msg){
  				var charts2="<chart showBorder='1'  borderColor='#cfaec1' xaxisname='资产' yaxisname='状态'>";
  				for(var i = 0; i< msg.length; i++){
  					charts2+="<set name='"+msg[i].STATUS+"' value='"+msg[i].RESULT+"' /> ";
  				}
  				charts2+="</chart>";
  			 	chart2.setDataXML(charts2);
  			 	chart2.render("assets");
  			}
  		});
  	});
  </script>
</html>
