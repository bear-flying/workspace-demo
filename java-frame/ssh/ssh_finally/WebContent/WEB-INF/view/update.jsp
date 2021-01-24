<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.js"></script>
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

$().ready(function(){
	
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath}/bee/findOne.do",
		data:{id:$("#beeid").val()},
		dataType:"json",
		success:function(msg){
			$("#name").val(msg.name);
			$("#datea").val(dateFmt(msg.datea));
			
			var sex = msg.gender;
			if(sex==$("#gender1").val()){
				$("#gender1").attr("checked",true);
			}else{
				$("#gender2").attr("checked",true);
			}

			var hobbys = new Array();
			var strs = msg.hobby;
			hobbys = strs.split(",");
			for(var i=0;i<hobbys.length;i++){
				if(hobbys[i]==$("#hobby1").val()){
					$("#hobby1").attr("checked",true);
				}
				if(hobbys[i]==$("#hobby2").val()){
					$("#hobby2").attr("checked",true);
				}
				if(hobbys[i]==$("#hobby3").val()){
					$("#hobby3").attr("checked",true);
				}
			}
			
			var uri ="${pageContext.request.contextPath}/bee/getKinds.do";
			$.post(uri,function(result){
				for(var i=0;i<result.length;i++){
					if(msg.beeKind.kid==result[i].kid){
						$("#select").append("<option value="+result[i].kid+" selected='selected'>"+result[i].bkind+"</option>");
					}else{
						$("#select").append("<option value="+result[i].kid+">"+result[i].bkind+"</option>");
					}
					
				}
			});
			
		}
	});
	
	$("#ff").submit(function(e){
		e.preventDefault();
		var url = "${pageContext.request.contextPath}/bee/modify.do";
		$.post(url,$(this).serialize(),function(data){
			alert("修改成功！");
			window.location.href="${pageContext.request.contextPath}/bee/findAll.do"
		});
	});
	
})



</script>

</head>
<body>
	<form action="" id="ff">
			<input type="hidden" name="id" id="beeid" value="${id}">
		姓名：<input type="text" name="name" id ="name"><br><br>
		性别：<input type="radio" name="gender" id="gender1" value="男">男	
			<input type="radio" name="gender" id="gender2" value="女">女<br><br>
		爱好：<input type="checkbox" name="hobby" id="hobby1" value="火腿">火腿
			<input type="checkbox" name="hobby" id="hobby2" value="食人">食人	
			<input type="checkbox" name="hobby" id="hobby3" value="超级">超级<br><br>
		日期：<input type="text" name="datea" id ="datea" readonly="readonly"><br><br>
			<select name="beeKind.kid" id="select">
				<option>-请选择-</option>
			</select><br><br>
			<input type="submit" value="保存">
	</form>
</body>
</html>