<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top.html</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
	<script type="text/javascript">
		function addStu(){
			open('./edit.jsp','AddStudent','top=150,left=200,width=300,height=400');
		}
	</script>
  </head>
  
  <body>
    <table width='98%'>
    	<tr>
    		<form action='/stumgr/queryStudent' name='topForm' method='post' target='listFrame'>
    			姓名：<input type="text" name='sname'/>
    			性别：<input type="radio" name='gender' value='m'/>男
    			<input type="radio" name='gender' value='f'/>女
    			<input type="radio" name='gender' value=''/>全部
    			<input type="submit" value='查询'/>
    			<input type="button" value='新增' onclick='addStu()'/>
    		</form>
    	</tr>
    </table>
  </body>
</html>
