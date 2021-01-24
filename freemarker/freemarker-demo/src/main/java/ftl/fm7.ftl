<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<#--变量的定义语法-->
<#assign name="zhangsan">
<#--使用变量的语法${}-->
${name}

<#assign num=10>
${num+10}
 
<#assign num="10">
${num+10}


<#--布尔类型必须要转成字符串来输出-->
<#assign is=true>

${is?string}

${(a.b)???string}


<#-- 日期需要转成字符串输出 -->
${now?string("yyyy-MM-dd HH:mm:ss")}

<#--如果变量重复后边的变量值会覆盖前面的-->
<#assign bir="1985-04-22 12:33:33"?date("yyyy-MM-dd HH:mm:ss")>
${bir}

<#assign bir="1985-04-22 12:33:33"?datetime("yyyy-MM-dd HH:mm:ss")>

${bir}

<#-- 把html转成文本类型 -->
${"<br/>"?html}

${"abcd"?left_pad(10,"-")}

${1.6?int}
</body>
</html>