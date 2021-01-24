<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<#list userList as user>
	<#-- 
	userList是map中集合 的key， user是集合中每项
	list的索引变量名+"_index" 相当于foreach里varStatus="state" ${state.index} -->
	${user_index}---------${user.id}-----${user.name}-------${user.age}<br>
</#list>
     
</body>
</html>