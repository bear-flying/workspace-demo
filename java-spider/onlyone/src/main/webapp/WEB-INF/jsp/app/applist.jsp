<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.css"/>
<script src="http://cdn.gbtags.com/datatables/1.10.5/js/jquery.js"></script>
<script src="http://cdn.gbtags.com/datatables/1.10.5/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" language="javascript" src="http://cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/date/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/js/handlebars-v3.0.1.js"></script>
<body>
<div class="container">
    <table id="datatable-one" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>应用名称</th>
            <th>版本</th>
            <th>文件大小</th>
            <th>描述</th>
            <th>更新时间</th>
            <th>开发者</th>
            <th>评论</th> 
            <th>价格</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>  <!-- tbody是必须的 -->
        <c:forEach items="${applist}" var="app">
		<tr>
			<td>${app.appname}</td>
			<td>${app.version}</td>
			<td>${app.filesize}</td>
			<td>${app.description}</td>
			<td>${app.updatetime}</td>
			<td>${app.developer}</td>
			<td>
				<c:forEach items="${app.commentList}" var="comment">
					${comment.commentDate}
				</c:forEach>
			</td>
			<td>${app.price}</td>
			
			<td>
				<button type="button" class="btn btn-default" data-dismiss="modal">删除</button>
                <button type="button" class="btn btn-primary" onclick="location='${pageContext.request.contextPath}/pay/index.jsp?appname=${app.appname}'">推广</button>
			</td>
		</tr>        
        </c:forEach>
        </tbody>
    </table>
</div>
<script type="text/javascript">
        $(function () {
            $("#datatable-one").dataTable({
                //lengthMenu: [5, 10, 20, 30],//这里也可以设置分页，但是不能设置具体内容，只能是一维或二维数组的方式，所以推荐下面language里面的写法。
                paging: true,//分页
                ordering: true,//是否启用排序
                searching: true,//搜索
                language: {
                    lengthMenu: '<select class="form-control input-xsmall">' + '<option value="1">1</option>' + '<option value="10">10</option>' + '<option value="20">20</option>' + '<option value="30">30</option>' + '<option value="40">40</option>' + '<option value="50">50</option>' + '</select>条记录',//左上角的分页大小显示。
                    search: '<span class="label label-success">搜索：</span>',//右上角的搜索文本，可以写html标签

                    paginate: {//分页的样式内容。
                        previous: "上一页",
                        next: "下一页",
                        first: "第一页",
                        last: "最后"
                    },

                    zeroRecords: "没有内容",//table tbody内容为空时，tbody的内容。
                    //下面三者构成了总体的左下角的内容。
                    info: "总共_PAGES_ 页，显示第_START_ 到第 _END_ ，筛选之后得到 _TOTAL_ 条，初始_MAX_ 条 ",//左下角的信息显示，大写的词为关键字。
                    infoEmpty: "0条记录",//筛选为空时左下角的显示。
                    infoFiltered: ""//筛选之后的左下角筛选提示，
                },
                paging: true,
                pagingType: "full_numbers",//分页样式的类型

            });
            $("#table_local_filter input[type=search]").css({ width: "auto" });//右上角的默认搜索文本框，不写这个就超出去了。
       
        });
        
        
		function spread(appname){
			var url = "${pageContext.request.contextPath}/parse/spreadApp.do";
			$.post(url,{appname:appname},function(){
				
			});
		}
</script>

</body>
</html>