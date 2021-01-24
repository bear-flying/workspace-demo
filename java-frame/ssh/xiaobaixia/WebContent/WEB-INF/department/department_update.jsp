<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>部门修改</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="<%=request.getContextPath() %>/script/jquery.js"></script>
    <script language="javascript" src="<%=request.getContextPath() %>/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="<%=request.getContextPath() %>/script/PageUtils.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/style/blue/pageCommon.css" />
    <script type="text/javascript">
    </script>
</head>
<body> 
<!-- 标题显示 --> 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="<%=request.getContextPath() %>/style/images/title_arrow.gif"/> 部门信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="dept_modify.action">
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="<%=request.getContextPath() %>/style/blue/images/item_point.gif" /> 部门信息 </DIV>  -->
        </div>
        
        <s:hidden name="id"></s:hidden>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr><td width="100">上级部门</td>
                        <td><s:select name="parentId" cssClass="SelectStyle"
                         			  list="#departmentList" listKey="id" listValue="name"
                         			  headerKey="" headerValue="==请选择=="/>
                        </td>
                    </tr>
                    <tr><td>部门名称</td>
                   		 <td><s:textfield name="name" cssClass="InputStyle"></s:textfield> *</td>
                    </tr>
                    <tr><td>职能说明</td>
                     <td><s:textarea name="description" cssClass="TextareaStyle"></s:textarea> </td>
                    </tr>
                </table>
            </div>
        </div>
        
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="<%=request.getContextPath() %>/style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="<%=request.getContextPath() %>/style/images/goBack.png"/></a>
        </div>
    </s:form>
</div>

<div class="Description">
	说明：<br />
	1，上级部门的列表是有层次结构的（树形）。<br/>
	2，如果是修改：上级部门列表中不能显示当前修改的部门及其子孙部门。因为不能选择自已或自已的子部门作为上级部门。<br />
</div>
</body>
</html>
