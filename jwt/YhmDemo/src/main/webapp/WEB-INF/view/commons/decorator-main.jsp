<%--
 * 
 * @author Shengzhao Li
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ include file="../commons/taglib-header.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" scope="application"/>
    <script>
        <%--JS gloable varilible--%>
        var contextPath = "${contextPath}";
    </script>


    <meta name="viewport" content="width=device-width,user-scalable=no"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="${_csrf.headerName}" content="${_csrf.token}"/>
    <link rel="shortcut icon" href="${contextPath}/static/favicon.ico"/>

    <title><sitemesh:write property='title'/> | Yanghaomin_Demo</title>

    <link href="${contextPath}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <sitemesh:write property='head'/>

</head>
<body>
<nav class="navbar navbar-default navbar-static-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${contextPath}/"><img alt="Brand" style="max-height: 25px;"
                                                                src="${contextPath}/static/images/logo2.png"></a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <p class="navbar-text">Yanghaomin_Demo</p>
            <ul class="nav navbar-nav">
                <li><a href="${contextPath}/">首页</a></li>
                <%--  菜单位置 --%><%--
                <li><a href="${contextPath}/user/welcome">User</a></li>
                <li><a href="${contextPath}/admin/welcome">Admin</a></li>--%>
            </ul>
            <form action="${contextPath}/signout" class="navbar-form navbar-right" role="search" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-warning">退出</button>
            </form>
            <p class="navbar-text pull-right"><a
                    href="">${SPRING_SECURITY_CONTEXT.authentication.principal.username}</a></p>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <%--JS--%>
    <%--<script src="${contextPath}/static/js/jquery-1.9.1.min.js"></script>--%>
    <%--<script src="${contextPath}/static/bootstrap/js/bootstrap.min.js"></script>--%>

    <sitemesh:write property='body'/>

    <div>
        <hr/>
        <p class="text-muted text-center">
            &copy; 2014-2018 IDsManager.com | Ver. ${currVersion}
        </p>
    </div>
</div>

</body>
</html>