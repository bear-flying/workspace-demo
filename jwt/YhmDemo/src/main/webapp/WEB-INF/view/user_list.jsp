<%--
  Created by IntelliJ IDEA.
  User: HaominYang
  Date: 2018/11/28
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="commons/taglib-header.jsp" %>
<html>
<head>
    <meta charset="utf-8"/>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" scope="application"/>
    <meta name="viewport" content="width=device-width,user-scalable=no"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="${_csrf.post}" content="${_csrf.token}"/>
    <link rel="shortcut icon" href="${contextPath}/static/favicon.ico"/>
    <title>用户展示页面</title>
    <link href="${contextPath}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${contextPath}/static/bootstrap/js/bootstrap.js" rel="stylesheet"/>
    <script type="text/javascript" src="${contextPath}/static/bootstrap/js/jquery.js"></script>
    <script src="${contextPath}/static/bootstrap/js/t-v1.js"></script>
    <script type="text/javascript">
        function doUpd(uuid) {
            location.href = "/user/to_update_user?uuid=" + uuid;
        }

        function doReset(uuid) {
            if (confirm("确定要重置密码么？")) {
                $.ajax({
                    url: "/user/reset_user",
                    type: "POST",
                    data: {"uuid": uuid},
                    dataType: "text",
                    success: function (result) {
                        //判断是否修改成功
                        alert("重置密码成功！");
                        alert("新密码为：" + result);
                    },
                    error: function () {
                        alert("重置密码失败！！！");
                    }
                });
            }
        }

        function doDel(uuid) {
            if (confirm("确定要删除用户么？")) {
                location.href = "/user/del_user?uuid=" + uuid;
            }
        }
    </script>
</head>
<body>
<h3 class="page-header">
    <spring:message text="用户列表"/></h3>
    <spring:message text="用户名" var="username"/>
    <spring:message text="权限" var="privilege"/>
    <spring:message text="创建时间" var="createtime"/>
    <spring:message text="操作" var="action"/>
</h
<form action="" id="filterForm">
    <div class="form-group">
        <div class="pull-right">
            <a href="/user/to_add_user" class="btn btn-success"><em class="glyphicon glyphicon-plus"></em><spring:message
                    text="添加用户"/></a>
        </div>
    </div>
   <span class="text-info">总数: ${user.totalSize}</span>
</form>
<dis:table list="${user}" id="item" form="filterForm"
           class="table table-striped table-hover table-bordered">
    <dis:setProperty name="pagination.sort.asc.value" value="${userPaginated.sortDir}"/>
    <dis:column property="username" title="${username}" sortable="true"/>
    <dis:column property="privileges" title="${privilege}" sortable="true"/>
    <dis:column property="createTime" title="${createtime}" sortable="true"/>
    <dis:column title="${action}">
        <a type="text" onclick="return doUpd('${item.uuid}');">编辑</a>
        <a type="text" onclick="return doReset('${item.uuid}');">重置密码</a>
        <a type="text" onclick="return doDel('${item.uuid}');">删除</a>
    </dis:column>
</dis:table>
<tags:paginated_sele userPaginated="${user}"/>
</body>
</html>
