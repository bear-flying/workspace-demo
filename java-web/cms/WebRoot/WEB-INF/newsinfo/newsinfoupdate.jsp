<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fck" uri="http://java.fckeditor.net" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'newsinfoupdate.jsp' starting page</title>
    
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
  <script type="text/javascript" src="common/js/jquery.validate.js"></script>
  <script type="text/javascript">
  $(function(){
	  var $d1 = new Date();
	  var $d2 = $d1.getFullYear()+"-0"+$d1.getMonth()+"-0"+$d1.getDay();
	  $("#udt").val($d2);
	  
	  $("#form").validate({
		  rules:{
			  newstitle:{required:true,rangelength:[2,15]},
			  newsauthor:{required:true,minlength:2},
			  typeid:{required:true},
			  newscontent:{required:true,rangelength:[1,255]},
		  },
		  messages:{
			  newstitle:{required:"新闻标题不能为空！",rangelength:"新闻标题长度必须在2~15之间！"},
			  newsauthor:{required:"新闻作者不能为空！",minlength:"新闻作者长度不能小于2！"},
			  typeid:{required:"新闻类型不能为空！"},
			  newscontent:{required:"新闻内容不能为空！",rangelength:"新闻内容长度必须在1~255之间！"},
		  }
	  });
  });
  </script>
  <body>
    <center>
    <form action="newsinfo?method=alter" method="post" id="form">
    	<table>
  		<tr>
  			<td>新闻标题:</td>
  			<td>
  				<input type="text" name="newstitle" value="${n.newsTitle}">
  			</td>
  		</tr>
  		<tr>
  			<td>新闻作者:</td>
  			<td>
  				<input type="text" name="newsauthor" value="${n.newsAuthor}">
  			</td>
  		</tr>
  		<tr>
  			<td>新闻类型:</td>
  			<td>
  				<select name="typeid">
    			  <c:forEach items="${list}" var="v">
    				<option value="${v.id}" <c:if test="${n.typeId==v.id}">selected</c:if> >${v.name}</option>
    			  </c:forEach>
    		   </select><br>
  			</td>
  		</tr>
  		<tr>
  			<td>新闻内容:</td>
  			<td>
				<fck:editor instanceName="newscontent" height="200" width="100%" basePath="/common/fckeditor/" value="${n.newsContent}"></fck:editor>  			
			</td>
  		</tr>
  		<tr>
  			<td>创建时间:</td>
  			<td>
  				<input type="text" id="cdt" name="createdatetime" value="${n.createDatetime}" readonly="readonly">
  			</td>
  		</tr>
  		<tr>
  			<td>修改时间:</td>
  			<td>
  				<input type="text" id="udt" name="updatedatetime" value="${n.updateDatetime}"readonly="readonly">
  			</td>
  		</tr>
  		<tr>
  			<td colspan="2">
  				<input type="hidden" name="id" value="${n.id}">
  				<input type="submit" value="提交">
  				<input type="reset" value="重置">
  			</td>
  		</tr>
  		</table>
    </form>
    </center>
  </body>
</html>
