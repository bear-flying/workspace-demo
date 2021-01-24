<%--
 * 
 * @author Shengzhao Li
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>首页</title>
    <script type="text/javascript">
        function getUserList() {
            location.href="/user/get_user_list";
        }
        function getOrgList() {
            location.href="/api/list";
        }
    </script>

</head>
<body>
    <button onclick="getUserList()" class="btn btn-default">展示用户列表页面</button>
    <button onclick="getOrgList()" class="btn btn-default">查询全量组织机构</button>
</body>
</html>
