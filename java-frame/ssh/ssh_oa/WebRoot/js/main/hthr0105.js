
/**
 * 页面初始加载
 */
$(document).ready(function() {
    //初始化dtree的全部展开和全部收缩按钮
    initDreeBtn();
    //设置部门左侧列显示的颜色
    $("#table_view_dept").find("tr").each(function(i) {
        if(i % 2 == 1) {
            $(this).find("td:first").addClass("table_view_background");
            }
    });
});
/**
 * 初始化dtree的全部展开和全部收缩按钮
 */
function initDreeBtn() {
    $(".dtree_btn").hover(
            function () {
                var spanAry = $(this).find("span");
                $(spanAry[0]).removeClass().addClass("dtree_btn_l_h");
                $(spanAry[1]).removeClass().addClass("dtree_btn_m_h");
                $(spanAry[2]).removeClass().addClass("dtree_btn_r_h");
            },
            function () {
                var spanAry = $(this).find("span");
                $(spanAry[0]).removeClass().addClass("dtree_btn_l");
                $(spanAry[1]).removeClass().addClass("dtree_btn_m");
                $(spanAry[2]).removeClass().addClass("dtree_btn_r");
            }
            );
}
/**
 * 点击部门显示部门信息
 *  
 */
function showDepartment(objId) {
	$("#currentDeptId").val(objId);	
	return submitButton('ROLE');
}

/**
 * 当改变画面尺寸时执行方法
 * 
 * 用于控制滚动条的显示
 */
$(window).resize(function(){
   resizeHeight();
});

/**
 * 根据画面尺寸控制滚动条显示长度
 * 
 */
function resizeHeight() {
   var scrollBoxHeight = document.documentElement.clientHeight;
    	var ieFlg;    
    var oPopupMenu = null;
    var browser = navigator.appName
    var b_version = navigator.appVersion
    var version = b_version.split(";");
        try {
            var trim_Version = version[1].replace(/[ ]/g, "");
    if (browser == "Microsoft Internet Explorer" && trim_Version == "MSIE8.0")
    {
        ieFlg = "IE8";
    } else if (browser == "Microsoft Internet Explorer" && trim_Version == "MSIE9.0") {
        ieFlg = "IE9";
    } else if (browser == "Microsoft Internet Explorer" && trim_Version == "MSIE10.0") {
        ieFlg = "IE10";
            } else if (navigator.appVersion.toLowerCase().indexOf("trident") > -1 && navigator.appVersion.indexOf("rv") > -1) {
                ieFlg = "IE11";
    }
} catch(e) {
    ieFlg = "NOTIE";
}
 if (ieFlg == "IE8") {
            scrollHeight = scrollBoxHeight - 110;
        } else if (ieFlg == "IE9") {
            scrollHeight = scrollBoxHeight-100;
        } else if (ieFlg == "IE10") {
            scrollHeight = scrollBoxHeight - 110;
        } else if (ieFlg == "IE11") {
            scrollHeight = scrollBoxHeight - 50;
        } else if (window.navigator.userAgent.indexOf("Firefox") > 0) {
            scrollHeight = scrollBoxHeight - 110;
         } else if (window.navigator.userAgent.indexOf("Safari") > 0) {
                scrollHeight = scrollBoxHeight-70;
        } else {
            scrollHeight = scrollBoxHeight - 50;
        }

    var showHeight = 0;
    var top =0;
    //if($(".scroll_box_1")!=null){
      //  try {
           // top = $(".scroll_box_1").offset().top;
            //showHeight =  scrollBoxHeight-ttop-20;
           // $(".scroll_box_1").css("height",showHeight);// css属性距低20此处多减20 update by JiangLiye20150303
           // $(".scroll_box_1").css("overflow","hidden");//强制不滚动
          // var scrollBoxWidth = document.documentElement.clientWidth-20;
          //  $(".scroll_box_1").css("width", scrollBoxWidth);// css属性距低20此处多减20 update by JiangLiye20150303
          // $(".R_clumn_1_box").css("width", scrollBoxWidth * 0.98);// css属性距低20此处多减20 update by JiangLiye20150303

       // } catch(ex) {}
   //}
	$(".hr_menu").css("height", scrollHeight-top-120);
	// 2014-03-31 qiaoguoyu 如果部门名称过长时增加横向滚动 start
	$(".hr_scroll_box_1").css("height", scrollHeight-top-120);
	try{
		var menuBoxDiv = $(".hr_menu_box_1");
	    // 标记是否需要横向滚动
	    var xScrollFlag = false;
	    scrollDiv = $(".hr_scroll_box_1");
	    var scrollDivWidth = 200;
	    // 跟部门名称
		var rootA = $("a", $(".dtree_menu_1"));
		// 根图片宽度加根文字的宽度
	    var divWidth = rootA.width() + rootA.offset().left;
	    if(divWidth > scrollDivWidth) {// 根部门名称超出外层宽度时，设置外层div为可滚动
	    	xScrollFlag = true;
	    }
        // 循环查看下级部门中是否存在超出外层div并且超过根部门名称长度的部门
		$(scrollDiv.find(".dtree_menu_bg_1")).each(function(){
			sonDivWidth = 0;
			a = $("a", $(this));
			sonDivWidth += a.offset().left;
		    sonDivWidth += $("a", $(this)).width();
		    if(sonDivWidth >= scrollDivWidth && sonDivWidth >= divWidth) {//如果有比根部门名称还长的部门,设置宽度为子部门名称的宽度
		    	divWidth = sonDivWidth;
		    	xScrollFlag= true;
		    }
	    });
        // 循环查看下级部门中是否存在超出外层div并且超过根部门名称长度的部门
		$(scrollDiv.find(".dtree_menu_bg_2")).each(function(){
			sonDivWidth = 0;
			a = $("a", $(this));
			sonDivWidth += a.offset().left;
		    sonDivWidth += $("a", $(this)).width();
		    if(sonDivWidth >= scrollDivWidth && sonDivWidth >= divWidth) {//如果有比根部门名称还长的部门,设置宽度为子部门名称的宽度
		    	divWidth = sonDivWidth;
		    	xScrollFlag= true;
		    }
	    });
        if(xScrollFlag) {//需要横向滚动时
	    	$(".hr_scroll_box_1").attr("style","width:200px;overflow-x: scroll;height:" + (scrollHeight-top-120) + "px");
			$(".hr_menu_box_1").css("width", divWidth);
			//比不需要横向滚动多了滚动条，这里需要去掉滚动条高度，否则看不见滚动条
	    	$(".hr_menu_box_1").css("height", scrollHeight-top-137);
	    } else {
	    	$(".hr_menu_box_1").css("height", scrollHeight-top-120);
	    }

	}catch(ex){}
	// 如果部门名称过长时增加横向滚动 end

}