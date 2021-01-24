<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.8.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	goPage(1);
	
});

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

function goPage(page){
	
	var url = "${pageContext.request.contextPath}/core/findAll.do";
	$.post(url,{page:page},function(msg){
		
		var result = msg.jiangYu.list;
		var s ="";
		for(var i =0;i<result.length;i++){
			
			s+="<tr><td><input type='checkbox' name='ids' value="+result[i].id+"></td><td>"+result[i].name+"</td><td>"+result[i].tel+"</td><td>"+
			dateFmt(result[i].datea)+"</td><td>";
			for(var j=0;j<result[i].foods.length;j++){
				s+=""+result[i].foods[j].name+"  ";
			}
			s+="</td><td>"+result[i].times.name+"</td><td>"+result[i].address.name+"</td><td>"+
			"<a href='toModify.do?id="+result[i].id+"'>修改</a>  <a href='javascript:void(0)' onclick='del("+result[i].id+")'>删除</a>  "+
			"</td><td><input type='button' onclick='editMenu("+result[i].id+")' value='修改菜品'></td></tr>";
		}
		$("#tabl").html(s);
		$("#tan").html(msg.jiangYu.ajaxPage);
	},'json');
	
}

function del(id){
	$.ajax({
		type:"post",
		dataType:"json",
		url:"${pageContext.request.contextPath}/core/remove.do",
		data:{id:id},
		success:function(){
			alert("删除成功");
			goPage(1);
		}
	});
}

function delBatch(){
	
	var a = $("input[name='ids']:checked");
	var b = new Array();
	for(var i=0;i<a.length;i++){
		b[i] = $(a[i]).val();
	}
	if(confirm("你确定要删除这些么？"+b.toString())){
		$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath}/core/removeBatch.do",
			data:{ids:b.toString()},
			success:function(mm){
				alert("删除成功");
				goPage(1);
			}
		});
	}
	
}

function editMenu(orderid){
	$("#check").html("");
	var url1 = "${pageContext.request.contextPath}/core/findFoods.do";
	$.post(url1,function(msg){
		for(var j=0;j<msg.length;j++){
			$("#check").append("<input type='checkbox' value="+msg[j].id+" id="+msg[j].id+" name='cats'>"+msg[j].name);
		}
		var url2 = "${pageContext.request.contextPath}/core/findFoodsByOrderid.do";
		$.post(url2,{id:orderid},function(data){
			for(var i=0;i<data.length;i++){
				for(var k=0;k<msg.length;k++){
					if(msg[k].id==data[i].id){
						$("#"+msg[k].id).attr("checked",true);
					}
				}
			}
		},'json');
	},'json');
	
	$("#check").append("<br><input type='button' onclick='subMenu("+orderid+")' value='确认修改'>");
	
}


function subMenu(orderid){
	
	var url3 = "${pageContext.request.contextPath}/core/modifyOnefoodByOrderid.do";
	var a = $("input[name='cats']:checked");
	var b = new Array();
	for(var i=0;i<a.length;i++){
		b[i] = $(a[i]).val();
	}
	$.post(url3,{id:orderid,cats:b.toString()},function(result){
		$("#check").html("");
		goPage(1);		
	});

}

</script>
<body>
	
	<center>
		<form action="">
			<table border="1" cellspacing="0" width="70%">
				<tr>
					<td>
						<input type="checkbox" id="selAll">全选
					</td>
					<td>姓名</td>
					<td>电话</td>
					<td>时间</td>
					<td>菜品</td>
					<td>送餐时间</td>
					<td>地点</td>
					<td>操作</td>
				</tr>
				<tbody id="tabl">
				</tbody>
			</table>
		</form>
		<a href="toAdd.do">新增</a>
		<a href="javascript:delBatch()">批量删除</a>
		<span id="tan"></span>
		<br>
		<div id="check">
			
		</div>
	</center>
	
</body>
</html>