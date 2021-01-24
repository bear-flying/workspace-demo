<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>头部页面</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		
		<script type="text/javascript">
			function logout() {
				if(window.confirm("您确认要退出吗？")) {
					window.top.location.href="<%=request.getContextPath()%>/index.jsp";
				}
			}
		</script>
	</head>

	<body  style="background-color: black;">
		<font color="white">欢迎您登录飞天猫熊小白侠~~姜宇的后台管理系统  -- ${login}</font> <font color="red">${sessionScope.user.login_name}</font>
		<br />
		<div align="right">
			<input type="button" value=" 退出 " onclick="logout();" />
		</div>
	</body>
</html>