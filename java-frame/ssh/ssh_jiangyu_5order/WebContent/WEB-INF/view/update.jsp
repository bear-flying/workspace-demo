<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	var url1="${pageContext.request.contextPath}/core/findOneOrder.do";
	var url2="${pageContext.request.contextPath}/core/findTimes.do";
	var url3="${pageContext.request.contextPath}/core/findAddress.do";
	var url4="${pageContext.request.contextPath}/core/findFoods.do";
	$.post(url1,{id:$("#id").val()},function(msg){
		$("#name").val(msg.name);
		$("#tel").val(msg.tel);
	//	$("#id").val(msg.id);
		var timeid = msg.times.id;
		var addressid = msg.address.id;
		var foodss = msg.foods;
		$.post(url2,function(msg1){
			for(var i=0;i<msg1.length;i++){
				if(msg1[i].id==timeid){
					$("#utime").append("<option value="+msg1[i].id+" selected='selected'>"+msg1[i].name+"</option>");
				}else{
					$("#utime").append("<option value="+msg1[i].id+">"+msg1[i].name+"</option>");
				}
			}
		},'json');
		$.post(url3,function(msg2){
			for(var i=0;i<msg2.length;i++){
				if(msg2[i].id==addressid){
					$("#uaddress").append("<option value="+msg2[i].id+" selected='selected'>"+msg2[i].name+"</option>");
				}else{
					$("#uaddress").append("<option value="+msg2[i].id+">"+msg2[i].name+"</option>");
				}
			}
		},'json');
		
		$.post(url4,function(msg3){
			var s='';
			for(var i=0;i<msg3.length;i++){
				s="<input type='checkbox' name='cats' value='"+msg3[i].id+"' ";
				var z = "";
				for(var j=0;j<foodss.length;j++){
					if(foodss[j].id==msg3[i].id){
						z+=" checked='checked'";
					}
				}
				s+= z+">"+msg3[i].name+" ";
				$("#ufood").append(s);
			}
			
		},'json');
		
	},'json');
	
	var url5 = "${pageContext.request.contextPath}/core/modify.do";
	
	$("#ff").submit(function(e){
		e.preventDefault();
		$.post(url5,$(this).serialize(),function(){
			alert("修改成功");
			window.location.href="${pageContext.request.contextPath}/core/toList.do";
		});
	});
	
});
</script>
<body>
	<form action="" method="post" id="ff">
		<input type="hidden" name="id" id="id" value="${id}">
		接收人：<input type="text" name="name" id="name"><br><br>
		电话：<input type="text" name="tel" id="tel"><br><br>
		送餐时间：<select name="times.id" id="utime">
				 <option>-请选择-</option>
			   </select><br><br>
		送餐地点：<select name="address.id" id="uaddress">
				<option>-请选择-</option>
			   </select><br><br>
		精品菜：<div id="ufood">
			 </div><br><br>
			<input type="submit" value="保存">
	</form>
</body>
</html>