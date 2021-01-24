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
    
    <title>My JSP 'usershow.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="common/css/index.css">
  </head>
  <script type="text/javascript" src="common/js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript">
  function selPage(){
	  var a = document.getElementById('selpage').value;
	  document.getElementById('page').value = a;
	  var p = document.getElementById('pageSizes').value;
	  document.getElementById('pageSize').value = p;
	  document.getElementById('f1').submit();
  }
  function goPage(result){
	  document.getElementById('page').value = result;
	  var p = document.getElementById('pageSizes').value;
	  document.getElementById('pageSize').value = p;
	  document.getElementById('f1').submit();
  }
  function del(){
	  if(confirm('确定要删除么？')){
		  document.getElementById('f2').submit();
	  }  
  }
  $(function(){
	  	//全选 反选
		$("#selAll").click(function(){
			$(":checkbox[name='ids']").prop("checked",$(this).prop("checked"));
		});
		//当下方所有的复选框都选中 全选的复选框自动勾选
		$(":checkbox[name='ids']").click(function(){
				var flag = true ;
				$(":checkbox[name='ids']").each(function(){
					if(!$(this).prop("checked"))
					{
						flag = false ;
						return ;
					}
				});
				$("#selAll").prop("checked",flag);
		});
		
  });
  </script>
  <body>
  	<center>
  	<form action="user?method=query" method="post" id="f1">
  		<input type="hidden" name="page" id="page" value="1">
  		<input type="hidden" name="pageSize" id="pageSize" value="2">
  		请输入真实姓名：<input type="text" name="condition" value="${u.real_name}">
  		<input type="submit" value="检索">
  	</form>
  	</center>
  	<form action="user?method=drop"  method="post" id="f2">
	<table align="center" border="1" cellspacing="0" width="60%">
		<tr>
			<th><input type="checkbox" id="selAll">序号</th>
			<th>登陆名</th>
			<th>真实名</th>
			<th>角色</th>
			<th>性别</th>
			<th>操作 [<a href="user?method=toSave" target="mainPage">添加</a>]</th>
		</tr>
		<c:forEach items="${pageBean.list}"  var="type" varStatus="s">
		<tr align="center">
			<td>
				<input type="checkbox" name="ids" value="${type.id}">
				${s.count+(pageBean.page - 1)* pageBean.pageSize}
			</td>
			<td>${type.login_name}</td>
			<td>${type.real_name}</td>
			<td>
				<c:choose>
    				<c:when test="${empty type.roleList}">
    					暂无
    				</c:when>
    				<c:otherwise>
    					<c:forEach items="${type.roleList}"  var="a" varStatus="s">
							${a.role_name}
						</c:forEach>
    				</c:otherwise>
    			</c:choose>
			</td>
			<td>${type.sex}</td>
			<td>
				<a href="user?method=userRole&id=${type.id}" target="mainPage">分配角色</a>
				<a href="user?method=queryOne&id=${type.id}" target="mainPage">修改</a>
				<a href="user?method=drop&ids=${type.id}" target="mainPage">删除</a>
			</td>
		</tr>
		</c:forEach>
    </table>
    </form>
    <div align="center">
    	<a href="javascript:goPage(1)">首页</a>
    	<c:choose>
    		<c:when test="${pageBean.page==1}">
    			上一页
    		</c:when>
    		<c:otherwise>
    			<a href="javascript:goPage(${pageBean.prevPage})">上一页</a>
    		</c:otherwise>
    	</c:choose>
    	<c:choose>
    		<c:when test="${pageBean.page==pageBean.totalPages}">
    			下一页
    		</c:when>
    		<c:otherwise>
    			<a href="javascript:goPage(${pageBean.nextPage})">下一页</a>
    		</c:otherwise>
    	</c:choose>
    	<a href="javascript:goPage(${pageBean.totalPages})">尾页</a>
    	<form action="" id="f3">
    	 <input type="button" value="删除所选" onclick="del()">
    	  每页显示:
    	  <c:choose>
    	  	<c:when test="${pageBean.pageSize==2}">
    	  		<select id="pageSizes" onchange="goPage(1)">
    	  			<option value="2" selected="selected">2</option>
    	  			<option value="5">5</option>
    	  			<option value="10">10</option>
    	  		</select>
    	  	</c:when>
    	  	<c:when test="${pageBean.pageSize==5}">
    	  		<select id="pageSizes" onchange="goPage(1)">
    	  			<option value="2">2</option>
    	  			<option value="5" selected="selected">5</option>
    	  			<option value="10">10</option>
    	  		</select>
    	  	</c:when>
    	  	<c:when test="${pageBean.pageSize==10}">
    	  		<select id="pageSizes" onchange="goPage(1)">
    	  			<option value="2">2</option>
    	  			<option value="5">5</option>
    	  			<option value="10" selected="selected">10</option>
    	  		</select>
    	  	</c:when>
    	  </c:choose> 条数据&nbsp;&nbsp;&nbsp;&nbsp;第
    	  <input type="text" style="width:18px" name="selpage" id="selpage" value="${pages}">
    	  <input type="button" onclick="selPage()" value="GO">
    	    页&nbsp;&nbsp;&nbsp;&nbsp;共${pageBean.totalPages}页
    	</form>
    	
      </div>
  </body>
</html>
