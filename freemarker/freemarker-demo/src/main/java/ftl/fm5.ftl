<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<#include "fm5_include.ftl">
</head>
<body>
<#list userList as user>
${user.id}-----${user.name}-------${user.age}<br>
</#list>
</body>
</html>