<%@ page language="java" import="java.util.*,vos.Student" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script src="js/jquery-1.8.2.js"></script>
  <script type="text/javascript">
  function upda(id){
	  var form = document.forms[0];
	  form.id.value=id;
	  form.method.value = 'querybyid';
	  form.submit();
  }
  function dele(id){
	  var form = document.forms[0];
	  form.id.value=id;
	  form.method.value = 'deleteStudent';
	  form.submit();
  }
  $(function(){
	  //全选
	  $("#selAll").click(function(){
		  $("input[name='sel']").attr("checked",true);
	  });
	  //反选
	  $("#away").click(function(){
		  $("input[name='sel']").each(function(){
			  $(this).attr("checked",!$(this).attr("checked"));
		  });
	  });
	  //取消所选
	  $("#reseter").click(function(){
		  $("input[name='sel']").attr("checked",false);
	  });
	  $("#changes").click(function(){
		  location="index.jsp";
	  });
	  $("#delall").click(function(){
		  var a = $("input[name='sel']:checked");
		  var b = new Array();
		  for(i=0;i<a.length;i++){
			  b[i] = $(a[i]).val();
		  }
		  if(confirm("你确定要删除这些么？"+b.toString())){
			  $.ajax({
				  type:"post",
				  url:"student",
				  data:{"ids":b.toString(),"method":"delselect"},
				  success:function(msg){
					  if(msg == 1) {
						alert("删除成功！");
					  } else {
						alert("删除失败！");
					  }
				  }
			  });
			  $("input[name='sel']:checked").each(function(){
				  $(this).parents("tr").remove();
			  });
		  }
	  });
	  
	  $("#ball").click(function(){
		  location="ball.html";
	  });
  });
  </script>
  <body>
    <%
    String s = (String)session.getAttribute("key");
    if(s==null){
    	response.sendRedirect("index.jsp");
    }else{
    	List<Student> list = (List)request.getAttribute("list"); 
    %>
    	<h2 align="center">欢迎：<%=s%>!访问飞天猫熊小白侠姜宇的表格！</h2>
    	<form action="student">
    	<input type="hidden" name="method">
    	<input type="hidden" name="id">
    	<table align="center" border="1" width="35%">
    		<tr>
    			<td align="center"><input type="button" id="selAll" value="全选"></td>
    			<td>ID:</td><td>姓名:</td><td>年龄:</td><td>生日:</td>
    			<td>操作(<a href="save.jsp">添加</a>)</td>
    		</tr>
    <% 
    	if(list!=null){
    		for(Student st : list){
    %>
    		<tr>
    		<td align="center"><input type="checkbox" name="sel" value=<%=st.getId() %>></td>
    		<td><%=st.getId() %></td>
    		<td><%=st.getName() %></td>
    		<td><%=st.getAge() %></td>
    		<td><%=st.getHiredate() %></td>
    		<td>
    			<input type="button" value="修改" onclick="upda('<%=st.getId() %>')">
    			<input type="button" value="删除" onclick="dele('<%=st.getId() %>')">
    		</td>
    		</tr>
    		
    	  <%} %>
    	  <tr>
    		<td align="center" colspan="6">
    			<input type="button" value="反选操作" id="away">
    			<input type="button" value="取消所选" id="reseter">
    			<input type="button" value="批量删除" id="delall">
    			<input type="button" value="更换用户" id="changes">
    			<input type="button" value="台球专区" id="ball">
    		</td>
    		</tr>
      <%} 
      }%>
      </table></form>
      <%
      String sss = "";
      int aaa = (Integer)session.getAttribute("one"); 
      if(aaa==0){
    	  sss="普通";
      }else{
    	  sss="特殊";
      }
      %>
      <p align="center">亲爱哒，你的权限是：<%=sss %>&nbsp;&nbsp;<a href="mouse.html">更改权限</a></p>
  </body>
</html>
