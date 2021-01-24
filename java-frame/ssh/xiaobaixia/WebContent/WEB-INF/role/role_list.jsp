<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>岗位列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="<%=request.getContextPath() %>/script/jquery.js"></script>
    <script language="javascript" src="<%=request.getContextPath() %>/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="<%=request.getContextPath() %>/script/PageUtils.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/style/blue/pageCommon.css" />
    <script type="text/javascript">
    </script>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="<%=request.getContextPath() %>/style/images/title_arrow.gif"/> 岗位管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="200px">岗位名称</td>
                <td width="300px">岗位说明</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="roleList">
			<s:iterator value="%{#roleList}">
			
			<tr align="CENTER" valign="MIDDLE" class="TableDetail1 template">
				<td><s:property value="name"/>&nbsp;</td>
				<td><s:property value="description"/>&nbsp;</td>
				<td><s:a href="role_remove.action?id=%{id}" onclick="return confirm('确定要删除吗？')">删除</s:a>
					<s:a href="role_findOne.action?id=%{id}">修改</s:a>
					<a href="setPrivilegeUI.html">设置权限</a>
				</td>
			</tr>
			
			</s:iterator>
			
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="role_toAdd.action"><img src="<%=request.getContextPath() %>/style/images/createNew.png" /></a>
        </div>
    </div>
</div>
</body>
</html>
