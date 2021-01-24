<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>用户管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/index.css">
	
	<s:head theme="ajax"/>
  </head>
  
  <body>
    <h1>用户管理-用户列表</h1>
  	<table>
  		<tr>
  			<th><input type="checkbox" onchange="choice()">全选/反选</th>
  			<th>编号</th>
  			<th>用户名</th>
  			<th>照片</th>
  			<th>密码</th>
  			<th>性别</th>
  			<th>年龄</th>
  			<th>爱好</th>
  			<th>简介</th>
  			<th>部门</th>
  			<th>出生日期</th>
  			<th>操作</th>
  		</tr>
  		
  		<s:iterator id="user" value="list" status="i">
  		<tr>
  			<td><input type="checkbox" name="a" value="${user.id }"></td>
  			<td><s:property value="#i.index+1"/></td>
  			<td><s:property value="#user.name"/></td>
  			<td><a href="<%=request.getContextPath() %>/user!download.action?userModel.filepath=${user.filepath }">
  					<img src="<%=request.getContextPath() %>/upload/${user.filepath }" width="60" height="80" />
  				</a>
  			</td>
  			<td><s:property value="#attr.user.pwd"/></td>
  			<td>${user.sex }</td>
  			<td>${user.age }</td>
  			<td>${user.hobby }</td>
  			<td>${user.content }</td>
  			<td>${user.dept }</td>
  			<td>${user.datea }</td>
  			<td>
  				<input type="button" value="下载" onclick="download('${user.filepath }')">
  				<a href="<%=request.getContextPath() %>/user!download.action?userModel.filepath=${user.filepath }">下载1</a>
  				<a href="javascript:download('${user.filepath }')">下载2</a>
  			</td>
  			
  		
  		</tr>
  		</s:iterator>
  		 <tr>
		    <td colspan="40">
		    	<input type="button" value="添加" onclick="add()">
		    	<input type="button" value="批量删除" onclick="delall()">
		    	<input type="button" value="修改" onclick="update()">
		    	
			        共${listCount}条数据
			        ${currentPage}/${pageCount}页
			        ${firstPage}
			        ${precursorPage}
			        ${nextPage}
			        ${lastPage}
		    </td>
 		</tr>
  		
  	</table>
  </body>
</html>
<script type="text/javascript">

	

	//全选与反选
	function choice(){
		var a = document.getElementsByName("a");
		for(var i=0;i<a.length;i++){
			if(a[i].checked==true){
				a[i].checked=false;
			}else{
				a[i].checked=true;
			}
		}
	}

	//添加
	function add(){
		location.href="<%=request.getContextPath() %>/user!toAdd.action";
	}

	//批量删除
	function delall(){
		//得到id
		var id="";
		var flag = 0;
		var a = document.getElementsByName("a");
		for(var i=0;i<a.length;i++){
			if(a[i].checked==true){
				id += a[i].value+",";
				flag++;
			}
		}
		
		//必选
		if(flag==0){
			alert("请选择要删除的记录")
			return false;
		}

		id = id.substring(0,id.length-1);
		//alert(id)

		location.href="<%=request.getContextPath() %>/user!deletea.action?id="+id;
	}

	//到修改页面
	function update(){
		//得到id
		var id="";
		var flag = 0;
		var a = document.getElementsByName("a");
		for(var i=0;i<a.length;i++){
			if(a[i].checked==true){
				id = a[i].value;
				flag++;
			}
		}
		
		//必选
		if(flag==0){
			alert("请选择要删除的记录")
			return false;
		}
		//选一条
		if(flag>1){
			alert("请选择一条记录")
			return false;
		}

		//alert(id)

		location.href="<%=request.getContextPath() %>/user!toUpdate.action?userModel.id="+id;
	}


	//下载
	function download(filepath){
		//alert(filepath)
		if(filepath!=''){
			location.href="<%=request.getContextPath() %>/user!download.action?userModel.filepath="+filepath;
		}else{
			alert("没有图片可下载");
			return false;
		}
		
	}
	
</script>