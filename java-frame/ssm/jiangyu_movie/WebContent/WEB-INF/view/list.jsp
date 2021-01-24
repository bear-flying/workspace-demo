<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.js"></script>
<script type="text/javascript">
$().ready(function(){
	
	goPage(1);
	
	$("#ff").submit(function(e){
		e.preventDefault();

		goPage(1);
	});
	
	
	var url2 = "${pageContext.request.contextPath}/core/findTypes.do";
	$.post(url2,function(data){
		if(data!=null){
			for(var i=0;i<data.length;i++){
				if(searchtype==data[i].name){
					$("#searchtype").append("<option value="+data[i].name+" selected='selected'>"+data[i].name+"</option>");
				}else{
					$("#searchtype").append("<option value="+data[i].name+">"+data[i].name+"</option>");
				}
				
			}
		}
	},'json');
	
});

function goPage(page){
	
	var url1 = "${pageContext.request.contextPath}/core/findAll.do";
	var searchname = $("#searchname").val();
	var searchtype = $("#searchtype").val();
	//alert(searchtype)
	$.post(url1,{page:page,searchname:searchname,searchtype:searchtype},function(msg){
		var list = msg.jiangYu.list;
		$("#searchname").val(msg.searchname);
		var str = "";
		for(var i=0;i<list.length;i++){
			str+="<tr><td>"+list[i].name+"</td><td>"+list[i].price+"</td><td>"
					+list[i].area.name+"</td><td>"+list[i].type.name+"</td><td>2000</td><td>"
					+list[i].years.years+"</td><td>删除</td></tr>";
		}
		$("#tab1").html(str);
// 		var pager = $("#page").val();
// 		var aaa = eval(parseInt(pager)-1);
// 		var bbb = eval(parseInt(pager)+1);
// 		//alert(aaa);
// 		//alert(bbb);
// 		var count = msg.jiangYu.pageCount;
// 		$("#limit").empty();
// 		$("#limit").append("<a href='javascript:void(0)' onclick='goPage(1)'>首页</a>    ");
// 		$("#limit").append("<a href='javascript:void(0)' onclick='goPage("+aaa+")'>上一页</a>    ");
// 		$("#limit").append("<a href='javascript:void(0)' onclick='goPage("+bbb+")'>下一页</a>    ");
// 		$("#limit").append("<a href='javascript:void(0)' onclick='goPage("+count+")'>尾页</a>   ");
		
// 		$("#limit").append("当前页"+pager+"/"+count+"   共"+count+"页");

		$("#limit").html(msg.jiangYu.ajaxPage);
	},'json');
}
</script>

<body>
	<center>
	<h2>---------finish by 飞天猫熊---------</h2>
		<form action="" method="post" id="ff">
			按电影名称：<input type="text" id="searchname" name="searchname">&nbsp;&nbsp;
			按电影类型：<select name="searchtype" id="searchtype">
 						<option></option> 				
				    </select>
			<input type="hidden" name="page" id="page">
			<input type="submit" value="检索">
		</form>
		<br><br>
	<table border="1" cellspacing="0" cellpadding="5" width="60%">
		<tr>
			<td>电影名称</td>
			<td>票价</td>
			<td>地区</td>
			<td>类型</td>
			<td>票房</td>
			<td>年代</td>
			<td>操作</td>
		</tr>
		<tbody id="tab1">
		</tbody>
<%-- 		<c:forEach items="${jiangYu.list}" var="s"> --%>
<!-- 		<tr> -->
<%-- 			<td>${s.name}</td> --%>
<%-- 			<td>${s.price}</td> --%>
<%-- 			<td>${s.area.name}</td> --%>
<%-- 			<td>${s.type.name}</td> --%>
<%-- 			<td>${s.years.years}</td> --%>
<!-- 			<td>删除</td> -->
<!-- 		</tr> -->
<%-- 		</c:forEach> --%>
	</table>
	<div id="limit">
	
	</div>
	</center>
</body>
</html>