<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试js的prop属性</title>
<script src="<%=request.getContextPath() %>/js/jquery-1.7.js"></script>
</head>
<script type="text/javascript">
	function test(){
		alert("dianjiyixia");
		$("input[type='checkbox']").prop({
			  disabled: true
		});
	}
	function test1(){
		$("input[type='checkbox']").prop("checked", true);
	}
	function test2(){
		$("input[type='checkbox']").prop("checked", false);
	}
	
	function test3(){
		var str = ""; 
		$(":checkbox[name='demo']").each(function(i){
			if(this.checked) {
				str +=",";
				str += $(this).val();
			}
		});
		var values = str.substring(1,str.length);
		if(values.length == 0) {
			alert("请选择");
		} else {
			alert(values);
		}
	}
</script>
<body>
	<table>
		<tr>
			<td><input type="button" name="button1" value="测试prop" onclick="test()"/></td>
			<td><input type="button" name="button1" value="全选" onclick="test1()"/></td>
			<td><input type="button" name="button1" value="反选" onclick="test2()"/></td>
			<td><input type="button" name="button1" value="获取选中id" onclick="test3()"/></td>
		</tr>
		<tr>
			<td><input type="checkbox" name="demo" value="1" /></td>
		</tr>
		<tr>
			<td><input type="checkbox" name="demo" value="2"/></td>
		</tr>
		<tr>
			<td><input type="checkbox" name="demo" value="3"/></td>
		</tr>
		<tr>
			<td><input type="checkbox" name="demo" value="4"/></td>
		</tr>
	</table>
</body>
</html>