<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>华天动力协同办公系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<LINK href="js/login/login.css" type=text/css rel=stylesheet>
	<script language='javascript' src='js/jquery-1.8.0.min.js'></script>
	<script language="javascript" src="js/login/login.js"></script>
	<script language='javascript' src='js/login/login_002.js'></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/easyui-lang-zh_CN.js"></script>
  	
  	<script type="text/javascript">
  	
  	function login(){
  		$.ajax({
  			url:'${pageContext.request.contextPath}/user!login.action',
  			type:'post',
  			dataType:'text',
  			data:{loginname:$("#userId").val(),password:$("#userPwd").val()},
  			success:function(data){
  				if(data=='true'){
  					window.location.href="${pageContext.request.contextPath}/user!index.action";
  				}
  			}
  		});
  	}
  	</script>
  </head>
  
  <body LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 ONLOAD=onLoad(); >
		
	<DIV STYLE="display:none;">
		
	</DIV>
	<form method="post" name="actForm" id="loginform" action="">
		<DIV CLASS=browesPosition>
			<input id="alertMsg" type="hidden" name="alertMsg" /><input id="confirmMsg" type="hidden" name="confirmMsg" /><TABLE WIDTH=1000 BORDER=0 CELLSPACING=0 CELLPADDING=0 ID=tableheight ALIGN=CENTER>
				<TR>
					<TD HEIGHT=100 VALIGN=bottom>
						<TABLE BORDER=0 WIDTH=100% CELLPADDING=0 CELLSPACING=0 STYLE="padding-bottom: 20px">
							<TR>
								<TD STYLE="padding-left:10px;"><img src="js/login/images/mainlogo.jpg" /></TD>
								<TD ALIGN=right STYLE="padding-right:10px;"><img src="js/login/images/logo2.jpg" /></TD>
							</TR>
						</TABLE>
					</TD>
				</TR>
				<TR>
					<TD HEIGHT=352 ALIGN=center><img id="banner" src="js/login/images/banner1.jpg" />
						<DIV CLASS=bannerPoint>
							<img onmouseout="setinter();" onmouseover="pointBanner(1);" id="bp1" src="js/login/images/bannerRed.gif" />&nbsp;&nbsp;<img onmouseout="setinter();" onmouseover="pointBanner(2);" id="bp2" src="js/login/images/bannerGray.gif" />&nbsp;&nbsp;<img onmouseout="setinter();" onmouseover="pointBanner(3);" id="bp3" src="js/login/images/bannerGray.gif" />
						</DIV>
					</TD>
				</TR>
				<TR>
					<TD  HEIGHT=130>
						<TABLE BORDER=0 WIDTH=100% CELLPADDING=0 CELLSPACING=0 STYLE="padding-bottom: 20px">
							<TR>
								<TD STYLE="padding-left:10px;" WIDTH=60% VALIGN=top>
								<div style="width:400px;">
									<UL>
										<LI CLASS=tips>主画面上的信息不再是摆设！点击登录用户能够进行个人设置，点击系统时间能够创建日程，点击天气预报能够切换城市，点击……</LI>
										
										<LI CLASS=function><img src="js/login/images/setup.gif" />&nbsp;&nbsp;<a target="_blank" width="50" height="50" href="/OAapp/jsp/download.jsp?wosid=et0LE19mvylQbNVQB2sWBw">IE环境初始化</a>&nbsp;&nbsp;&nbsp;&nbsp;<img src="js/login/images/download.gif" />&nbsp;&nbsp;<span onclick="actOpenWindowBtn('down','800','500');" class="login_4_span">助手及手机应用下载</span></LI>
									</UL>
								</div>
								</TD>
								<TD VALIGN=MIDDLE ALIGN=CENTER>
									<TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0 CLASS=input_area>
										<TR>
											<TD WIDTH=80 HEIGHT=40>用户名</TD>
											<TD WIDTH=220><input size="20" class="user_input" name="loginname" id="userId" type="text" value="admin" /></TD>
											<TD WIDTH=100 ROWSPAN=3 VALIGN=middle ALIGN=center><img onclick="login()"  id="btn"  border="0" style="cursor:pointer" src="js/login/images/go.gif" /></TD>
										</TR>
										<TR>
											<TD HEIGHT=40>密	码</TD>
											<TD><input size="20" class="user_input" id="userPwd" name="password" type="password" /></TD>
										</TR>
										
									</TABLE>
								</TD>
							</TR>
						</TABLE>
					</TD>
				</TR>
				<TR>
					<TD ALIGN=center HEIGHT=10><img src="js/login/images/line.gif"/></TD>
				</TR>
				<TR>
					<TD CLASS=version VALIGN=TOP>						
						版权所有  2005-2013 华天软件&nbsp;&nbsp;<span ONCLICK="actOpenWindowBtn('version','505','400');" CLASS=login_3_span>版本号:DLHT-OA8000-3-0-7.0-3-1-0-500[7.0(7.0.3_2015-10-19)]</span>
					</TD>
				</TR>
			</TABLE>
		</DIV>
		<DIV STYLE="display:none;">
			<input type="hidden" name="functionName" />
			<input type="hidden" name="screenWidth" />
			<input type="hidden" name="screenHeight" />
			<input id="userNameInputId" type="hidden" name="userNameInputId" />
			<input id="pasdInputId" type="hidden" name="pasdInputId" /><input id="useStyle" type="text" value="BLUE" name="11.56" /><input id="useLanguage" type="text" value="CN" name="11.57" /><input id="useStyleType" type="hidden" value="DEFAULT" name="11.58" /><a id="version" href="/OAapp/WebObjects/OAapp.woa/wo/com.oa8000.mainapp.Main/et0LE19mvylQbNVQB2sWBw/0.11.59;jsessionid=4CE2FD9693582763B10659E4A3CE3E34"></a><a id="down" href="/OAapp/WebObjects/OAapp.woa/wo/com.oa8000.mainapp.Main/et0LE19mvylQbNVQB2sWBw/0.11.60;jsessionid=4CE2FD9693582763B10659E4A3CE3E34"></a>
                        
		</DIV>
	<input type="hidden" name="wosid" value="et0LE19mvylQbNVQB2sWBw" /></form>
  
  
  
 </body>   	
  
</html>
