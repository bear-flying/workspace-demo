<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.8.js"></script>
<script type="text/javascript">
$().ready(function(){
	
	
});

function goPage(page){
	$("#page").val(page);
	$("#ff").submit();
}

function del(id){
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath}/bee/remove.do",
		data:{id:id},
		dataType:"text",
		success:function(msg){
			alert("删除成功！");
			window.location.href="${pageContext.request.contextPath}/bee/findAll.do"
			
		}
		
	});
}

function delBatch(){
	var a = $("input[name='ids']:checked");
	var b = new Array;
	for(var i = 0;i<a.length;i++){
		b[i] = $(a[i]).val();
	}
	if(confirm("你确定要删除这些么？")){
		var url = "${pageContext.request.contextPath}/bee/removeBatch.do";
		$.post(url,{ids:b.toString()},function(r){
			alert("删除成功！");
			window.location.href="${pageContext.request.contextPath}/bee/findAll.do"
		});
	}
	
}
</script>
</head>
<body>
	<center>
		<h2>---------finish by 飞天猫熊----------</h2>
		<form action="${pageContext.request.contextPath}/bee/findAll.do" id="ff" method="get">
			按姓名：<input type="text" name="name" id="beename" value="${beename}">
			<input type="hidden" id="page" name="page">
			<input type="button" onclick="goPage(1)" value="检索">
		</form>
		<form action="">
		<table border="1" cellpadding="5" cellspacing="0" width="50%">
			<tr>
				<td>
					<input type="checkbox" id="selAll">全选
				</td>
				<td>姓名</td>
				<td>爱好</td>
				<td>性别</td>
				<td>种类</td>
				<td>日期</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${jiangYu.list}" var="x">
			<tr>
				<td>
					<input type="checkbox" name="ids" value="${x.id}">
				</td>
				<td>${x.name}</td>
				<td>${x.hobby}</td>
				<td>${x.gender}</td>
				<td>${x.beeKind.bkind}</td>
				<td>
					<fmt:formatDate value="${x.datea}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/bee/toModify.do?id=${x.id}">修改</a>
					<a href="javascript:void(0)" onclick="del('${x.id}')">删除</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<input type="button" value="添加" onclick="location='${pageContext.request.contextPath}/bee/toAdd.do'">
		<input type="button" value="批量删除" onclick="delBatch()">
<!-- 		<a href="javascript:void(0)" onclick="goPage(1)">首页</a> -->
<%-- 		<a href="javascript:void(0)" onclick="goPage('${jiangYu.pageCount-1}')">上一页</a> --%>
<%-- 		<a href="javascript:void(0)" onclick="goPage('${jiangYu.pageCount+1}')">下一页</a> --%>
<%-- 		<a href="javascript:void(0)" onclick="goPage('${jiangYu.pageCount}')">尾页</a> --%>
		<div id="div">
			${jiangYu.ajaxPage}
		</div>
		</form>
	</center>
</body>
</html>