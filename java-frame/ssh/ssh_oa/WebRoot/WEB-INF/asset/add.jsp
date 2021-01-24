<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/easyui-lang-zh_CN.js"></script>
 	
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/shangchuan/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/shangchuan/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/shangchuan/css/bootstrap-responsive.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/shangchuan/css/bootstrap-image-gallery.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/shangchuan/css/jquery.fileupload-ui.css">
  </head>
  
  <body style="padding-left: 20px">
  	  
      <form id="assets" method="post">   
	    <div>   
	        <label for="name">资产名称:</label>   
	        <input class="easyui-validatebox" type="text" id="name" name="name" data-options="required:true" />   
	    </div>   
	    <div>   
	        <label for="num">资产编号:</label>   
	        <input class="easyui-validatebox" type="text" id="num" name="num" />   
	    </div>   
	    <div>   
	        <label for="price">价格:</label>   
	        <input class="easyui-validatebox" type="text" id="price" name="price"/>   
	    </div>      
	    <div>   
	        <label for="facto.id">厂家:</label>    
			<input id="facto" name="facto.id" class="easyui-combobox" data-options="    
       			 valueField: 'ID',    
       			 textField: 'NAME',    
       			 url: 'asset!findFactorys.action',    
        		 onSelect: function(rec){  
            	 	var url = 'asset!findTypes.action?id='+rec.ID;    
           		 	$('#typeid').combobox('clear'); 
           		 	$('#typeid').combobox('reload', url);    
           		 	
       		 }" />   	
	    </div>        
	    <div>   
	        <label for="typeid">类型:</label> 
	        <input id="typeid" class="easyui-combobox" name="typeid" data-options="valueField:'ID',textField:'NAME'" />  
	    </div> 
	    <div>   
	        <label for="user.id">用户:</label>   
	        <input class="easyui-validatebox" type="text" id="userid" name="user.id" value="${sessionScope.user.id}"/>   
	        <input class="easyui-validatebox" type="text"  value="${sessionScope.user.realname}"/>  
	    </div>     
	    <div>   
	        <label for="buyDate">购入日期:</label>   
	        <input class="easyui-datebox" type="text" id="buyDate" name="buyDate"/>   
	    </div>     
	    <div>   
	        <label for="content">备注:</label> 
	        <textarea name="content" id="content" style="height:40px;width:200px"></textarea>   
	    </div>
	    <table name="detail" width="65%">
	      	<tr>
	      		<td>配置名称</td>
	      		<td>规格型号</td>
	      		<td>数量</td>
	      		<td>配置备注</td>
	      		<td>
	      			<a id="addone" class="easyui-linkbutton" data-options="iconCls:'icon-add'"></a>
	      		</td>
	      	</tr>
	     </table> 
	   	 <!--图片上传属性-->
	   	 <input type="hidden" name="imgss" id="imgss">
	  </form>  

	    <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                </div>
            </div>
        </div>
        <div class="container">
       <form id="fileupload" action="UploadServlet" method="POST" enctype="multipart/form-data">
             <div class="row fileupload-buttonbar">
                  <div class="span7">
                        <span class="btn btn-success fileinput-button">
                            <i class="icon-plus icon-white"></i>
                            <span>选择图片</span>
                            <input type="file" name="files[]" multiple>
                        </span>
                        <button type="submit" class="btn btn-primary start">
                            <i class="icon-upload icon-white"></i>
                            <span>开始上传</span>
                        </button>
                        <button type="reset" class="btn btn-warning cancel">
                            <i class="icon-ban-circle icon-white"></i>
                            <span>取消</span>
                        </button>
                        <button type="button" class="btn btn-danger delete">
                            <i class="icon-trash icon-white"></i>
                            <span>删除</span>
                        </button>
                        <input type="checkbox" class="toggle">
                    </div>
                    <div class="span5 fileupload-progress fade">
                        <div class="progress progress-success progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100">
                            <div class="bar" style="width:0%;"></div>
                        </div>
                        <div class="progress-extended">&nbsp;</div>
                    </div>
                </div>
                <div class="fileupload-loading"></div>
                <br>
                <table role="presentation" class="table table-striped"><tbody class="files" data-toggle="modal-gallery" data-target="#modal-gallery"></tbody></table>
     	</form>
            
        </div>
        <div id="modal-gallery" class="modal modal-gallery hide fade" data-filter=":odd">
            <div class="modal-header">
                <a class="close" data-dismiss="modal">&times;</a>
                <h3 class="modal-title"></h3>
            </div>
            <div class="modal-body"><div class="modal-image"></div></div>
            <div class="modal-footer">
                <a class="btn modal-download" target="_blank">
                    <i class="icon-download"></i>
                    <span>Download</span>
                </a>
                <a class="btn btn-success modal-play modal-slideshow" data-slideshow="5000">
                    <i class="icon-play icon-white"></i>
                    <span>Slideshow</span>
                </a>
                <a class="btn btn-info modal-prev">
                    <i class="icon-arrow-left icon-white"></i>
                    <span>Previous</span>
                </a>
                <a class="btn btn-primary modal-next">
                    <span>Next</span>
                    <i class="icon-arrow-right icon-white"></i>
                </a>
            </div>
        </div>

      
      <a id="add" onclick="javascript:add()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
      
  </body>
  <script type="text/javascript">
  
  function add(){
	  
	 	var imgs ='';
 		$('td[class="name"] a').each(function(){
 			imgs+=';'+$(this).text()+','+$(this).attr('href').split('=')[1];
 		});
 		imgs=imgs.substring(1);
 		console.log(imgs);
 		$("#imgss").val(imgs);
	  
	  $.post("asset!add.action",$("#assets").serialize(),function(msg){
		  alert('添加成功！');
	  });
  }
  
  $().ready(function(){
	  
	  //添加资产编号
	  $("#name").blur(function(){
		  var result = $("#name").val();
		  if(result!=null||result!=""){
			  $.post("asset!getNums.action",{numname:result},function(msg0){
				  $("#num").val(msg0);
			  });
		  }
		  
	  });
	  
	  
	  //增加一行
	  $("#addone").click(function(){
			var buts = '<a id="removeone" class="easyui-linkbutton" value="删除" iconCls="icon-remove"></a>';
			var buts1 = '<input type="button" value="删除" id="removeone">';
			var t1 = '<input class="easyui-validatebox" type="text" name="qname"/>';
			var t2 = '<input class="easyui-validatebox" type="text" name="qmodel"/>';
			var t3 = '<input class="easyui-validatebox" type="text" name="qnum"/>';
			var t4 = '<input class="easyui-validatebox" type="text" name="qcontent"/>';
			$("table[name='detail']:eq(0) tr:last").after("<tr><td>"+t1+"</td><td>"+t2+"</td><td>"+t3+"</td><td>"+t4+"</td><td>"+buts1+"</td></tr>");
	  });
	  
	  //删除一行
	  $(":button[value='删除']").live("click",function(){
		  var f = confirm("确认被删除吗？");
		  if(f==true){
				$(this).parent().parent().remove();
		  }
	  });

  });

  </script>
  
  <script id="template-upload" type="text/x-tmpl">
            {% for (var i=0, file; file=o.files[i]; i++) { %}
        <tr class="template-upload fade">
            <td class="preview"><span class="fade"></span></td>
            <td class="name"><span>{%=file.name%}</span></td>
            <td class="size"><span>{%=o.formatFileSize(file.size)%}</span></td>
            {% if (file.error) { %}
            <td class="error" colspan="2"><span class="label label-important">Error</span> {%=file.error%}</td>
            {% } else if (o.files.valid && !i) { %}
            <td>
                <div class="progress progress-success progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0"><div class="bar" style="width:0%;"></div></div>
            </td>
            <td class="start">{% if (!o.options.autoUpload) { %}
                <button class="btn btn-primary">
                    <i class="icon-upload icon-white"></i>
                    <span>上传</span>
                </button>
                {% } %}</td>
            {% } else { %}
            <td colspan="2"></td>
            {% } %}
            <td class="cancel">{% if (!i) { %}
                <button class="btn btn-warning">
                    <i class="icon-ban-circle icon-white"></i>
                    <span>取消</span>
                </button>
                {% } %}</td>
        </tr>
        {% } %}
  </script>
  <script id="template-download" type="text/x-tmpl">
        {% for (var i=0, file; file=o.files[i]; i++) { %}
        <tr class="template-download fade">
            {% if (file.error) { %}
            <td></td>
            <td class="name"><span>{%=file.name%}</span></td>
            <td class="size"><span>{%=o.formatFileSize(file.size)%}</span></td>
            <td class="error" colspan="2"><span class="label label-important">Error</span> {%=file.error%}</td>
            {% } else { %}
            <td class="preview">{% if (file.thumbnail_url) { %}
                <a href="{%=file.url%}" title="{%=file.name%}" rel="gallery" download="{%=file.name%}"><img src="{%=file.thumbnail_url%}"></a>
                {% } %}</td>
            <td class="name">
                <a href="{%=file.url%}" title="{%=file.name%}" rel="{%=file.thumbnail_url&&'gallery'%}" download="{%=file.name%}">{%=file.name%}</a>
            </td>
            <td class="size"><span>{%=o.formatFileSize(file.size)%}</span></td>
            <td colspan="2"></td>
            {% } %}
            <td class="delete">
                <button class="btn btn-danger" data-type="{%=file.delete_type%}" data-url="{%=file.delete_url%}"{% if (file.delete_with_credentials) { %} data-xhr-fields='{"withCredentials":true}'{% } %}>
                        <i class="icon-trash icon-white"></i>
                    <span>Delete</span>
                </button>
                <input type="checkbox" name="delete" value="1">
            </td>
        </tr>
        {% } %}
  </script>
  
  
  <script src="${pageContext.request.contextPath}/js/shangchuan/vendor/jquery.ui.widget.js"></script>
  <script src="${pageContext.request.contextPath}/js/shangchuan/tmpl.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/shangchuan/load-image.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/shangchuan/canvas-to-blob.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/shangchuan/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/shangchuan/bootstrap-image-gallery.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/shangchuan/jquery.iframe-transport.js"></script>
  <script src="${pageContext.request.contextPath}/js/shangchuan/jquery.fileupload.js"></script>
  <script src="${pageContext.request.contextPath}/js/shangchuan/jquery.fileupload-fp.js"></script>
  <script src="${pageContext.request.contextPath}/js/shangchuan/jquery.fileupload-ui.js"></script>
  <script src="${pageContext.request.contextPath}/js/shangchuan/locale.js"></script>
  <script src="${pageContext.request.contextPath}/js/shangchuan/main.js"></script>
  
  
    
</html>
