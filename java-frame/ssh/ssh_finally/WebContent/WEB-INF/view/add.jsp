<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.js"></script>
<script type="text/javascript">
$().ready(function(){
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath}/bee/getKinds.do",
		dataType:"json",
		success:function(msg){
			for(var i=0;i<msg.length;i++){
				$("#select").append("<option value="+msg[i].kid+">"+msg[i].bkind+"</option>");
			}
		}
	});
	
	$("#ff").submit(function(e){
		e.preventDefault();
		var url = "${pageContext.request.contextPath}/bee/add.do"
		$.post(url,$(this).serialize(),function(data){
			alert("添加成功！");
			window.location.href="${pageContext.request.contextPath}/bee/findAll.do"
		});
	});
	
})



</script>

</head>
<body>
	<form action="" id="ff">
		姓名：<input type="text" name="name" id ="name"><br><br>
		性别：<input type="radio" name="gender" id="gender" value="男">男	
			<input type="radio" name="gender" id="gender" value="女">女<br><br>
		爱好：<input type="checkbox" name="hobby" id="hobby" value="火腿">火腿
			<input type="checkbox" name="hobby" id="hobby" value="食人">食人	
			<input type="checkbox" name="hobby" id="hobby" value="超级">超级<br><br>
			<select name="beeKind.kid" id="select">
				<option>-请选择-</option>
			</select>
			<input type="submit" value="保存">
	</form>
</body>
</html>