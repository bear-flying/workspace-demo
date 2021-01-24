<%--
 * 
 * @author Shengzhao Li
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>

    <meta charset="utf-8"/>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" scope="application"/>

    <meta name="viewport" content="width=device-width,user-scalable=no"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="${_csrf.headerName}" content="${_csrf.token}"/>
    <link rel="shortcut icon" href="${contextPath}/static/favicon.ico"/>

    <title>登录 | Yanghaomin_Demo</title>

    <link href="${contextPath}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div class="row" style="padding-top: 8%;">
        <div class="col-md-offset-3 col-md-6">

            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong>登录 </strong>
                </div>
                <div class="panel-body">
                    <p class="help-block">请先验证身份</p>

                    <form action="${pageContext.request.contextPath}/signin" method="post" class="form-horizontal">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                        <div class="form-group">
                            <label for="username" class="col-sm-2 control-label">账号</label>

                            <div class="col-sm-10">
                                <input type="text" name="username" id="username" class="form-control"
                                       placeholder="请输入账号" required="" value=""/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">密码</label>

                            <div class="col-sm-10">
                                <input type="password" name="password" id="password" class="form-control"
                                       placeholder="请输入密码" required="" value=""/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label"></label>

                            <div class="col-sm-10">
                                <button type="submit" class="btn btn-success"><em
                                        class="glyphicon glyphicon-log-in"></em> 登录
                                </button>
                                &nbsp;
                                <c:if test="${param.authorization_error eq '2'}"><span class="label label-warning">权限不足 !!!</span></c:if>
                                <c:if test="${param.authentication_error eq '1'}"><span
                                        class="label label-warning">认证失败</span></c:if>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
            <div class="text-center text-muted">&copy; 2014-2018 IDsManager.com | Ver. ${currVersion}</div>
        </div>
    </div>
</div>

</body>
</html>