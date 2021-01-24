<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>测试freemarker</title>
	
	<#assign path =飞天猫熊>
	<style type="text/css">
	div{
		background: url("../img/xiaobaixia.png") no-repeat;
	}
	.href{
		background:orange;
	}
	</style>
</head>
<body>
	测试freemarker:
	<#if num0==19>19岁，成年了！</#if>
	
	<#-- 数字 -->
	${path}
	<#if num0!=19>还没成年……</#if>
	<#if user=="小白侠">欢迎你</#if><#-- 字符 -->
	<a href="www.baidu.com" class="href">跳转</a>
	<br><br>
	<div></div>
</body>
</html>