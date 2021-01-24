<%--
  Created by IntelliJ IDEA.
  User: HaominYang
  Date: 2018/11/28
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="${_csrf.post}" content="${_csrf.token}"/>
    <title>编辑用户页面</title>
    <script type="text/javascript" src="${contextPath}/static/bootstrap/js/jquery.js"></script>
    <link href="${contextPath}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${contextPath}/static/bootstrap/js/bootstrap.js" rel="stylesheet"/>

</head>
<body>
<form:form commandName="userDto" action="/user/do_update_user" method="post" cssClass="form-horizontal">
    <table>
        <tr>
            <td><label>UserName</label>:</td>
            <td><form:input path="username" cssClass="form-control"/></td>
            <td><form:errors path="username" cssStyle="color: red"/></td>
        </tr>
        <tr>
            <td>Privileges:</td>
            <td>
                <form:checkbox path="privileges" value="ADMIN"/>管理员
                <form:checkbox path="privileges" value="USER"/>用户
            </td>
            <td><form:errors path="privileges" cssStyle="color: red"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <form:hidden path="uuid"/>
                <button type="submit" class="btn btn-default">Submit</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
