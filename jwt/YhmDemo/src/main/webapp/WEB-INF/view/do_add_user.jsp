<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HaominYang
  Date: 2018/11/30
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户页面</title>
    <meta charset="utf-8"/>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" scope="application"/>
    <meta name="viewport" content="width=device-width,user-scalable=no"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="${_csrf.post}" content="${_csrf.token}"/>
    <link rel="shortcut icon" href="${contextPath}/static/favicon.ico"/>
</head>
<body>
    <form:form commandName="userFormDto" action="/user/do_add_user" method="post" cssClass="form-horizontal">
        <table>
            <tr>
                <td>UserName:</td>
                <td><form:input path="username" cssClass="form-control"/></td>
                <td><form:errors path="username" cssStyle="color: red"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:password path="password" cssClass="form-control"/></td>
                <td><form:errors path="password" cssStyle="color: red"/></td>
            </tr>
            <tr>
                <td>rePassword:</td>
                <td><form:password path="rePassword" cssClass="form-control"/></td>
                <td><form:errors path="rePassword" cssStyle="color: red"/></td>
            </tr>
            <tr>
                <td>Privileges:</td>
                <td>
                    <form:checkbox path="privileges"  value="ADMIN"/>管理员
                    <form:checkbox path="privileges"  value="USER"/>用户
                </td>
                <td><form:errors path="privileges" cssStyle="color: red"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit" class="btn btn-default">Submit</button>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
