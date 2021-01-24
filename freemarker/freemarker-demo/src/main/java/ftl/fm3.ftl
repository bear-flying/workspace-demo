<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${user.id}-------${user.name}-------${user.age}</h1>

<#-- 注释的写法

if(age < 10){

}else if( age < 16){

}else{

}
-->

<#if user.age lt 10>
	小孩
<#elseif user.age lt 16>
	未成年
<#else>
	已经成年
</#if>
  

	

</body>
</html>