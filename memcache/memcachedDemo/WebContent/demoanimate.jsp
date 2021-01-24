<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>js效果</title>
<script src="<%=request.getContextPath() %>/js/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" href="./autocomplete/jquery.autocomplete.css" type="text/css"></link>
<script src="./autocomplete/jquery.autocomplete.js"></script>
</head>
<script type="text/javascript">
function emp(){
	$("p").empty();
}
$(document).ready(function(){
	$('#sample').autocomplete({
    	'data': ['One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten', 'Eleven', 'Twelve']
	});
});

</script>
<body>
<p>Hello, <span>Person</span> <a href="#">and person</a></p>
<button onclick="emp()">test测试</button>
<input type="text" id="sample" name="sample"/>
</body>
</html>