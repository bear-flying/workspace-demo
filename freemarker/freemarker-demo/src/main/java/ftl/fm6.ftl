<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<#-- 如果所取的属性值为空默认不处理会报错，如果想显示空（xxx.yy）！-->
${user.id}-----${user.name}-------${user.age}-----${(user.group.name)!"空值"}<br>


${(user.group)!"空值"}
<#--无论打.有几层都加（）！永远不错-->
${(user.group.name)!}


<#-- 三层以上不如不加括号用！直接取值不成功必须加括号，按规范无论几层都加括号-->

${(a.b)!}


<#-- ()??非空判断, 非空为true-->

<#if (user.group)??>
不为空
<#else>
为空
</#if>

</body>
</html>