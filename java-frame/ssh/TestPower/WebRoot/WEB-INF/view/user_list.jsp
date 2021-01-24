<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script language="JavaScript" src="<c:url value='/FusionCharts/Charts/FusionCharts.js'/>"></script>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/index.css" type="text/css"></link>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.js"></script>
  <script type="text/javascript">
  function ckjs(id){

		window.open("<c:url value='/user!ckjs.action?id='/>"+id,"","height=300ox,width=400px");

	  }
  function ckbm(id){
	  window.open("<c:url value='/user!ckbm.action?id='/>"+id,"","height=300ox,width=400px");

	  }
  function ckqx(id){
	  window.open("<c:url value='/user!ckqx.action?id='/>"+id,"","height=300ox,width=400px");

	  }
  
  </script>
  <body onload="tubiao()">
    <table border="1" align="center">
    	<tr align="center">
    		<td><input type="checkbox" onclick="choice()">全选/反选</td>
    		<td>员工编号</td>
    		<td>员工名字</td>
    		<td>员工密码</td>
    		<td>员工年龄</td>
    		<td>职位</td>
    		<td>操作(<a href="<c:url value='/user!toAdd.action'/>">添加</a>)</td>
    	</tr>
    <c:forEach items="${list}" var="user">
    	<tr align="center">
    		<td><input type="checkbox" name="ck" value="${user.id }"></td>
    		<td>${user.id }</td>
    		<td><a href="<c:url value='/user!getUserById.action?id=${user.id }'/>">${user.name }</a>
    		</td>
    		<td>${user.password }</td>
    		<td>${user.age}</td>
    		<td>
    		${user.rname } 
    		</td>
    		<td colspan="10">
    		<a href="<c:url value='/user!toUpdate.action?id=${user.id }'/>">修改</a>
    		<a href="<c:url value='/user!delete.action?id=${user.id }'/>">删除</a>
    		<button onclick="ckjs(${user.id})">查看角色</button>
    		<button onclick="ckbm(${user.id})">查看部门</button>
    		<button onclick="ckqx(${user.id})">查看权限</button>
    		</td>
    	</tr>
    
    </c:forEach>
    <tr align="center">
    	<td colspan="10"><input type="button" onclick="deletea()" value="批量删除"/></td>
    </tr>
    </table>
    <div id="jddq" align="center">
    </div>
  </body>
  <script type="text/javascript">
  //全选反选
	  function choice(){
			var ck = document.getElementsByName("ck");
			for(var i=0;i<ck.length;i++){
					if(ck[i].checked==true){
						ck[i].checked=false;

						}else{

						ck[i].checked=true;
								}
					}
		  }
	  //批量删除
	  	function deletea(){
	  	  	var id="";
	  	  	var flag=0;
	  		var ck = document.getElementsByName("ck");
			for(var i=0;i<ck.length;i++){
					if(ck[i].checked==true){
						id+=","+ck[i].value;
						flag++;
						}
	  				}
				id=id.substring(1);
				if(flag==0){
				alert("请选择要删除的数据！");
				return;
					}
				location.href="<%=request.getContextPath() %>/user!delete.action?id="+id;
	  }
	  	function tubiao(){
	  			var json='${json}';
	  			
	  			var _jddqChart = new FusionCharts("FusionCharts/Charts/Column3D.swf", "_jddqChart", "750", "255", "0", "0");
	  			aa(_jddqChart,"jddq",json);
	  		}
	  		function aa(tbname,tbid,json){
	  			
	  				var list = eval("("+json+")");
	  				
	  				var chart = "";
	  				
	  				chart = "<chart showBorder='0' rotateValues='1' borderColor='#BEBEBE' chartTopMargin='20'  chartBottomMargin='0' paletteColors='83C1F5,83C1F5,83C1F5,83C1F5,83C1F5,83C1F5,89BD00,89BD00,89BD00,89BD00,89BD00,89BD00,F8E095,F8E095,F8E095,F8E095,F8E095,F8E095,F8E095,F8E095'  captionPadding='0' bgColor=\"FFFFFF\" formatNumberScale='0' palette=\"2\" rotateYAxisName='0' yAxisName='年\n龄\n\n用\n户' caption=''  labelDisplay='WRAP' baseFontSize='12' placeValuesInside='1' baseFontColor='black' >";
	  					//chart += "<set label='zhangsan' value='16' color='7CFC00' />";//亮绿
	  					//chart += "<set label='lisi' value='15' color='7CFC00' />";//亮绿
	  					
	  					for (var i = 0; i < list.length; i++) {
	  							chart += "<set label='"+list[i].name+"' value='"+list[i].age+"' color='7CFC00' />";//亮绿
	  					}
	  					chart += "</chart>";
	  				tbname.setDataXML(chart);
	  				tbname.render(tbid);
	  			
	  		}
  
  </script>
</html>
