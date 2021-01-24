<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.stumgr.pojo.Student"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>list.html</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
	<script type="text/javascript">
		function editStu(sno){
			open('./editStudent?sno='+sno,'EditStudent','top=150,left=200,width=300,height=400');
			/*
				resizable=yes,表示窗口的大小可以被改变 （可以拉伸 最大化和最小化）
				menubar=yes,表示显示菜单栏
				toolbar=yes,显示工具（不全）
			*/
		}
		function delStu(sno){
			if(confirm("你确定要删除学生编号为"+sno+"的学生？")){
				open('./delStudent?sno='+sno,'EditStudent','top=150,left=200,width=300,height=400');
			}
		}
	</script>
  </head>
  
  <body>
    <table border='1' bordercolor='gree' cellspacing='0'>
    	<tr align='center'>
    		<td rowspan='2' valign='top'>序号</td>
    		<td rowspan='2' valign='middle'>姓名</td>
    		<td rowspan='2' valign='bottom'>性别</td>
    		<td colspan='3'>联系方式</td>
    		<td colspan='2'>操作</td>
    	</tr>
    	<tr align='center'>
    		<td>电话</td>
    		<td>QQ</td>
    		<td>信箱</td>
    		<td>修改</td>
    		<td>删除</td>
    	</tr>
    	<%
    		//servlet那边set 这边就get 两边传递的名称要相同 为STUDENTS
    		List<Student> stuList = (List<Student>) request.getAttribute("STUDENTS");
    		if(null!=stuList)//如果没有查询 就显示了此list.jsp页面，那么就没有人传递STUDENTS过来 就会报错 所以 这里判断一下
    		for(Student s : stuList){
    	%>
    	<tr>
    		<td><%=s.getSno() %></td>
    		<td><%=s.getSname() %></td>
    		<td><%=s.getGender().equals("m")?"男":"女" %></td>
    		<td><%=s.getMobile() %></td>
    		<td>.....</td>
    		<td>......@qq.com</td>
    		<td>
    			<img src="/stumgr/images/xiugai.JPG" onclick='editStu("<%=s.getSno() %>")'/>
    		</td>
    		<td>
    			<img src='/stumgr/images/shanchu.JPG' onclick='delStu("<%=s.getSno() %>")'/>
    		</td>
    	</tr>
    	<% } %>
    </table>
  </body>
</html>
