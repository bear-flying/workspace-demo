<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>Untitled Document</title>
<link href="<c:url value='/css/style.css'/>" rel="stylesheet" type="text/css"/>
<script language="JavaScript" type="text/javascript" src="<c:url value='/js/tree.js'/>"></script>
<link rel="stylesheet" href="<c:url value='/csstree/zTreeStyle.css'/>" type="text/css">
<script type="text/javascript" src="<c:url value='/js/jquery-1.4.4.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.ztree.all-3.3.js'/>"></script>

</head>


<body>
<div align="center">
       <marquee><h1 style="color: red">欢迎【${name }】光临</h1></marquee>
       </div>
</body>
</html>