<%--
  Created by IntelliJ IDEA.
  User: HaominYang
  Date: 2018/12/19
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://dev.otw.space:808/API/SSOLogin" method="post">
        <input type="text" name="CustomerId" value="${CustomerId}"><br>
        <input type="text" name="UserName" value="${UserName}"><br>
        <input type="text" name="Timestamp" value="${Timestamp}"><br>
        <input type="text" name="Signature" value="${Signature}"><br>
        <input type="submit" vlaue="Submit">
    </form>
</body>
</html>
