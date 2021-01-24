<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=path%>/js/jquery-1.7.js"></script>
	<script type="text/javascript">
	function selCity(){
		$.ajax({
			type:"post",
			url:"<%=path%>/core/findCitys.do",
			dataType:"json",
			success:function(msg){
				$("#span1").append("<select name='city' id='select'><option>-请选择-</option>");
				for(i=0;i<msg.length;i++){
					$("#select").append("<option value="+msg[i].id+">"+msg[i].name+"</option>");
				}
				$("#span1").append("</select>");
			}
		});
		
	}
	
<%--	$(":checkbox[name='aa']").live('click',function(){--%>
<%--		$("#name").val($(":checkbox:checked").val());--%>
<%--	});--%>
<%--	单选框绑定事件；--%>
<%--	$(":radio[name='street']").live('click', function(){--%>
<%--		$("#str").val($(":radio:checked").val());--%>
<%--	});--%>
	
	$(document).ready(function(){
		$("#message").blur(function(){
			var mess = $("#message").val();
			var cityid = $("#select").val();
			var url1 = "<%=path%>/core/findStreetsByCondition.do";
			$.post(url1,{mess:mess,cityid:cityid},function(datas){
				if(datas.length>0){
					$("#addre").empty();
					for(i=0;i<datas.length;i++){
						
						$("#addre").append("<input type='radio' name='radio' value="+datas[i].name+">"+datas[i].name+"<br>");
					}
				}else{
					$("#addre").append("抱歉！查无结果！");
				}
				
				
			},'json');
		});
		
		$("#ff").submit(function(e){
			e.preventDefault();
			var city = $("#select").val();//城市id
			var street = $("input[name='radio']:checked").val();//街道信息
			var c = $("#abc").val();
			if(city!=""&&c!=""&&street!=""){
				$("#message").val(street);
				var meg = street+c;//详细地址
				var url2 = "<%=path%>/core/addAddress.do";
				$.post(url2,{city:city,street:street,meg:meg},function(){
					alert("添加成功！");
					window.location.href="success.jsp";
				});
			}else{
				$("#span2").html("请先选择送餐信息！");
			}
		});
		
	});
	</script>
  </head>
   
  <body>
   当前城市：<span id="span1"></span><a href="javascript:void(0)" onclick="selCity()">请选择</a>
    <br><br><br>
    
    <form action="" id="ff">
    	确认送餐地址：<br><br>
    	关键字：<input type="text" name="message" id="message"><span id="span2"></span><input type="button" value="修改"><br><br>
    	详细地址：<input type="text" name="abc" id="abc"><br><br>
    	<input type="submit" value="确认">	
    </form>
    <br><br>
         请选择您的送餐地址：<br><br>
    <div id="addre">

    </div>
  </body>
</html>
