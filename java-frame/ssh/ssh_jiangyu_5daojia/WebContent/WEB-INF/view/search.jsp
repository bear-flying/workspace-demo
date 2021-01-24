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
		
	  $("#btn").click(function(){
		  var name = $("#abc").val();
			$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath}/core/searchShops.do",
				dataType:"json",
				data:{name:name},
				success:function(msg){
					if(msg!=null){
						var a = msg.area;
						var b = msg.shops;
						alert("您的送餐地址于"+a+"区域，共有"+b+"家餐厅可选");
						window.location.href="${pageContext.request.contextPath}/core/findShops.do"
					}else{
						alert("搜索地址没有对应的区域，请重新搜索");
					}
					
				}
				
			});
	  });
		
	});

</script>
<body>
	
	<center>
		<form action="" id="ff">
			<input type="text" name="" id="abc">
			<input type="button" id="btn" value="开始订餐">
		</form>
	</center>
</body>
</html>