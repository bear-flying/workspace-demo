<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.stumgr.pojo.Student"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>edit.html</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
	<script type="text/javascript">
		function validate(){
			<%--这里面就一个表单 所以可以写成forms[0],如果有好几个表单
			就可以使用表单的name属性了 例forms['sform']--%>
			var name = document.forms['sform'].sname.value;
			if(!(name.length>=3 && name.length<=6)){//name为字符串 长度用length方法获得
				alert('学生姓名长度不正确，必须在3-6之间');
				return false;
			}
			var mobile = document.forms['sform'].mobile.value;
			if(mobile==''){
				alert('手机号码必须填写');
				return false;
			}
			/*验证性别的时候 会得到一个存放性别的数组*/
			var arr = document.forms['sform'].gender;
			/*首先认为 性别没选*/
			var genderFlag=false;
			for(var i=0; i<arr.length;i++){
				if(arr[i].checked){
					genderFlag = true;//如果选了 设置为true
					break;
				}
			}
			if(!genderFlag){
				alert('请选择性别');
				return false;
			}
			
			/*验证爱好*/
			arr = document.forms['sform'].hobby;
			var hobbyFlag = false;
			for(var i=0;i<arr.length;i++){
				if(arr[i].checked){
					hobbyFlag = true;//如果选了 设置为true
					break;
				}
			}
			if(!hobbyFlag){
				alert('请选择爱好');
				return false;
			}
			
			/*验证班级  下拉在验证的时候 验证的是选中的索引*/
			if(document.forms['sform'].classes.options.selectedIndex==0){
				alert('请选择班级');
				return false;
			}
			return true;
		}
	</script>
  </head>
  	
  <body>
  	<form onsubmit='return validate();' name='sform' action='/stumgr/bcsx' method='post'>
    <table border='1' cellspacing='0' bordercolor='gree'>
    	
	    	<tr>
	    		<td>姓名</td>
	    		<td>
	    			<input type ='text' name='sname' value='${STU.sname}'/>
	    		</td>
	    	</tr>
	    	<tr>
	    		<td>性别</td>
	    		<td>
	    			<input type ='radio' name='gender' value='m' 
	    				${STU.gender=='m' ?"checked":"" }/>男
	    			<input type ='radio' name='gender' value='f' 
	    				${STU.gender=='f' ?"checked":"" }/>女
	    		</td>
	    	</tr>
	    	<tr>
	    		<td>爱好</td>
	    		<td>
	    			<% 
	    				String[] hobby = null;
	    				Student stu =(Student) request.getAttribute("STU");	
	    				//由于不只是修改。在新增的时候，也要走这个页面，当新增的时候
	    				//因为获取不到Student，会发生空指针异常，所以，要在下面判断，当学生不为null时，
	    				//再进行字符串的分割。
	    				if(stu!=null){
	    					hobby = stu.getHobby().split(",");
	    				}else{
		    				hobby = new String[]{};
		    			}
	    				//if(hobby == null){
	    				//	hobby = new String[]{};
	    				//}
	    				Arrays.sort(hobby);
	    				int lq = Arrays.binarySearch(hobby, "lq");
	    				int hq = Arrays.binarySearch(hobby, "hq");
	    				int ssq = Arrays.binarySearch(hobby, "ssq");
	    			%>
	    			<input type='checkbox' name='hobby' value='lq' 
	    				<%=lq>=0?"checked":"" %>/>篮球
	    			<input type='checkbox' name='hobby' value='hq' 
	    				<%=hq>=0?"checked":"" %>/>红球
	    			<input type='checkbox' name='hobby' value='ssq' 
	    				<%=ssq>=0?"checked":"" %>/>双色球
	    		</td>
	    	</tr>
	    	
	    	<tr>
	    		<td>班级</td>
	    		<td>
	    			<select name='classes'>
	    				<option value='0'>--请选择--</option>
	    				<option value='1' ${STU.classes==1?"selected":""}>网络工程1班</option>
	    				<option value='2' ${STU.classes==2?"selected":""}>网络工程2班</option>
	    			</select>
	    		</td>
	    	</tr>
	    	<tr>
	    		<td>手机</td>
	    		<td>
	    			<input type ='text' name='mobile' value='${STU.mobile}'/>
	    		</td>
	    	</tr>
	    	<%
	    		//下面的隐藏域加上EL表达式，修改的时候能读到，新增的时候读不到
	    		//如此一来就可以根据sno来确定点击保存按钮的时候
	    		//执行的是新增还是修改
	    	%>
    		<input type="hidden" name='sno' value='${STU.sno }'/>
    		<tr>
    			<td colspan='2'>
    				<input type="submit" value='保存'/>
    				&nbsp;
    				<input type="reset" value='重填'/>
    			</td>
    		</tr>

    </table>
    </form>
    
  </body>
</html>