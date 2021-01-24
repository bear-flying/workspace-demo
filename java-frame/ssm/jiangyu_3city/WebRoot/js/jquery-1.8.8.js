$(document).ready(function() {
	    
	//全选、反选
	$("#selAll").click(function(){
    	$(":checkbox").not("#selAll").each(function(){
    		$(this).prop("checked",!$(this).prop("checked"));
    	});
    });
    
	// 点击下面的复选框取消全选
	$(":checkbox").not("#selAll").click(function() {
		var falg = true;
		$(":checkbox").not("#selAll").each(function() {
			if (!$(this).prop("checked")) {
				falg = false;
				return;
			}
		});
		$("#selAll").prop("checked", falg);
	});
	
	//取消所选
	$("#resetAll").click(function(){
		$(":checkbox").prop("checked",false);
	});

});