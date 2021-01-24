<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=path%>/js/jquery-1.7.js"></script>
	<script type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
 	<script type="text/javascript">
 	function dateFmt(creatTime){
		var time = new Date(creatTime);
	   	var year = time.getFullYear();  //年  
	   	var month = time.getMonth() + 1;  //月  
        var day = time.getDate();         //日  
        var hh = time.getHours();       //时  
        var mm = time.getMinutes();    //分  
        var ss = time.getSeconds(); //秒
        var dateTimeStr= year + "-"+month+"-"+day+" "+hh+":"+mm+":"+ss; 
        return dateTimeStr;
		
	}
 	
 	
 	$(document).ready(function(){
 		var did = $("#did").val();
 		$.ajax({
 			type:"post",
 			url:"<%=path%>/core/modify.do",
 			data:{"id":did},
 			success:function(msg){
 				alert(msg);
 				$("#name").val(msg.name);
 				$("#price").val(msg.price);
 				var times = dateFmt(msg.datea);
 				$("#datea").val(times);
 				url1 = "<%=path%>/core/getBrand.do";
 				$.post(url1,function(data){
 					for(i=0;i<data.length;i++){	
 						if(msg.brand.id==data[i].id){
 	 						$("#select").append("<option value="+data[i].id+" selected='selected'>"+data[i].dname+"</option>");	
 						}else{
 	 						$("#select").append("<option value="+data[i].id+">"+data[i].dname+"</option>");	
 						}
 						
 					}
 				},'json');
 			},
 		});
 		
 		$("#ff").submit(function(e){
 			e.preventDefault();
 			var url = "<%=path%>/core/modify2.do";
 			$.post(url,$(this).serialize(),function(msg){
 				alert('修改成功！');
 				window.location.href="<%=path%>/core/findAll.do";
 			});
 		});
 	
 		
 	});
 	
 	</script>
 
  </head>
  
  <body>
  	<form action="" id="ff">
	    <input type="hidden" name="id" id="did" value="${id}">
	   	名称： <input type="text" name="name" id="name"><br><br>
	    价格：<input type="text" name="price" id="price"><br><br>
	    日期：<input type="text" name="datea" id="datea" onclick="WdatePicker()"><br><br>
	   品种：<select name="brand.id" id="select">
	   		<option>-请选择-</option>
	   	</select>
	    <input type="submit" value="修改">
    </form>
  </body>
</html>
