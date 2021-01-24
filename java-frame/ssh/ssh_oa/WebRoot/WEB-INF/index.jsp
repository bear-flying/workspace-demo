<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<title>展示页面</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/js/ztree/zTreeStyle.css" type="text/css"></link>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/ztree/jquery.ztree.core-3.5.min.js"></script>
		<script type="text/javascript">
			function quit(){
				$.messager.confirm('确认框', '您想要注销吗？', function(r){
					if (r){
					    location.href="login.jsp";
					}
				});
			}
		</script>
	</head>
	<body class="easyui-layout" >
	
		<div data-options="region:'north',border:false" style="height:88px;padding:10px">
			<img alt="华天" src="js/main/images/toplogo.gif" style="margin-left:45px;padding-top:8px;" >
			
			<div style="font-size: 30px;color: red;" align="center">
				
			</div>
			<div align="right">
				<label style="color:green;font-size: 20px">当前登录用户为:<%=session.getAttribute("username")%></label>
				<a href="javascript:quit();" class="easyui-linkbutton">注销</a>
			</div>
		</div>
		
		<div data-options="region:'west',split:true,title:''" style="width:200px;padding:10px;" >
           	
           	<div class="easyui-accordion" data-options="border:true" style="width:170px;height:65px;padding:8px;">
           		<img alt="admin" src="js/main/images/11.png" align="left" style="width:65px;height:65px;">
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" >管理员</a>
           	</div>
           	<br>
           	<div class="easyui-accordion" data-options="fit:true,border:false">
				<span>系统管理</span>
				<ul id="tt" class="easyui-tree">     
                    <li>   
						<span><a href="dept!listPage.action" target="jf">部门管理</a></span>   
					</li>  
                    <li>   
                        <span><a href="user!listPage.action" target="jf">用户设置</a></span>   
                    </li>   
                    <li>   
                        <span><a href="asset!listPage.action" target="jf">相关资产</a></span>   
                    </li>   
                    <li>   
                        <span><a href="mail!listPage.action" target="jf">办公邮箱</a></span>   
                    </li>   
                    <li>   
                        <span><a href="salary!listPage.action" target="jf">财务工资</a></span>   
                    </li>   
                    <li>   
                        <span><a href="chart!listPage.action" target="jf">报表统计</a></span>   
                    </li>   
                    <li>   
                        <span><a href="#">系统日志</a></span>   
                    </li>   
                </ul>   
        	</div>
		</div>
		
		<div id="center" data-options="region:'center',title:''">
			<iframe src="${pageContext.request.contextPath}/videos.html" name="jf" frameborder="0"  style="width: 100%;height: 100%;">
			  
       		</iframe>
		</div>
		
<%--	<div align="center" data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">--%>
<%--	</div>--%>
	
		
	</body>
	
</html>
