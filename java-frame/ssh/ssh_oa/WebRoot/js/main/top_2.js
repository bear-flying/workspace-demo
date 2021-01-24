//****************************************************************
//USER NAME            大连华天
//SYSTEM NAME           OAapp
//SUN SYSTEM NAME       共通
//CLASS NAME            top.js

/**
 * 顶部菜单使用js
 * 
 * @author sissi
 * @version 2013-02-05 新建
 */
//****************************************************************
//记录当前打开画面的主链接
var hrefBaseValue = null;
//判断是否有审批单打开
var traceOpenFlg = 0;
var Hid = true;//是否打开

document.onclick = CloseDiv;
function CloseDiv() {
    if (Hid) {
        if ($("#moreStyle") != null)  $("#moreStyle").hide();
//        if($("#morePortal")!=null)  $("#morePortal").hide();
        if ($("#moreMenu") != null)  $("#moreMenu").hide();
    }
    Hid = true;
}
/**
 * 设置按钮的显示样式
 * 当鼠标滑过钮时，设置显示样式为over
 *
 */
function menuOver(obj) {
    $(obj).addClass("over");
    var imgObj = $(obj).find("img");
    imgObj.attr("src", imgObj.attr("hoverSrc"));
}

/**
 * 设置按钮的显示样式
 * 当鼠标离开按钮时，去除显示样式
 *
 */
function menuOut(obj) {
    $(obj).removeClass();
    var imgObj = $(obj).find("img");
    imgObj.attr("src", imgObj.attr("normalSrc"));
}

/**
 * 转向指定的模块
 *
 */
function enterPages(obj) {
    var buffalo = null;
    buffalo = new Buffalo(endPointTop);

    //调用的java方法
    var javaMethod = "topMenuService.getIframeSliderForMenu";
    //返回值
    var resultData = null;
    var functionId = obj.id;
    var oaMenuStr = "oaMenuStr";
    buffalo.async = false;
    buffalo.remoteCall(javaMethod, [functionId, rankGroup, userId, languageType], function(reply) {
        resultData = reply.getResult();
        var leftMenuStr = document.getElementById("leftMenuStr");
        var menuTitle = document.getElementById("menuTitle");
        leftMenuStr.innerHTML = resultData[0];
        menuTitle.innerHTML = "<img class=\"dian_1\" src=\"/htoa/image/comm/BLUE/dian_1.png\" />" + resultData[1];
//        menuTitle.innerHTML = "<img class=\"dian_1\" src=\"/htoa/image/comm/BLUE/dian_1.png\" />asd";
        //        leftMenuStr.innerHTML=  "<div onclick=\"actionPage('actHtMsg0106_1', '短消息', 'desktop');\" " +
        //                             "class=\"side_menu_1\" id=\"FUNCMsg01002\" style=\"cursor: pointer; \"><span style=\"cursor: pointer; \">短消息</span></div>  ";


    });

        //    //取得跳转链接对象
    //	var autoEnterObj = document.getElementById("enterMenu");
    //	//设置基础链接
    //	if (hrefBaseValue == null) hrefBaseValue = autoEnterObj.href;
    //	//取得左侧菜单中的一级菜单
    //	autoEnterObj.href = hrefBaseValue + "?enterUrl=" + obj.id;
    //	window.parent.leftMenu.location = autoEnterObj.href;
    //	//如果左侧菜单是隐藏的，需要先显示出来
    //    if($("div.sideBarContent", window.parent.leftMenu.document).css("display") == "none") {
    //    	window.parent.leftMenu.changeLeftMenu();
    //    }
    //	//显示主画面内容
    ////	window.parent.menu.actionPage(obj.id, "", "desktop");
    hiddenMoreMenu();
    resizeMenu();
}

/**
 * 显示“更多”菜单
 *
 */
function showMoreMenu(obj) {
    //取得桌面上的菜单域
    var menuObj = $("#moreMenu");
//	//如果不存在，需要先建立
    //	if (menuObj.length == 0) {
    //		var createObj = window.desktop.document.createElement("DIV");
    //		createObj.id = "moreMenu";
    //		$(createObj).css("z-index", "101");
    //		$(createObj).html($("#moreMenu").html());
    //		window.desktop.document.body.appendChild(createObj);
    //		menuObj = $(createObj);
    //	}
    $("#menu").addClass("menu_show");
////		alert(menuObj.html());
    //	//显示下级菜单
    //	document.body.style.zoom = 1;
    //	//设置菜单显示的位置
    //	var leftSite = $("#menu").offset().left;
    //	leftSite = getLeftSite(leftSite);
    //    //增加左侧leftMenu显示状态的判定和位置的修改
    //    var h_menu_R_con = menuObj.children("div.h_menu_R_con");
    //    h_menu_R_con.css("left", leftSite);
    //关闭按钮的显示位置
    //	setcloseBtnSite(leftSite);
    menuObj.show();
//	menuObj.attr("tabIndex", "-1"); //桌面显示有影响
    Hid = false;
    menuObj.focus();
//	menuObj.focusout(function(){hiddenMoreMenu();});
}

/**
 * 当改变画面尺寸时设置菜单显示的位置
 *
 */
$(window).resize(function() {
   resizeMenu();
   resizeDeskTop();
});
/**
 * 当改变画面尺寸时设置桌面的宽度控制横向滚动条
 *
 */
function resizeDeskTop(obj) {
  var v = parent.desktop.frameElement.offsetWidth; 
      parent.desktop.resizeHeight();
 try {
        parent.desktop.resizeWidth(v);
        parent.desktop.resizeWidthView();
     } catch (ex) {
   }   
}
/**
 * 设置菜单显示的位置
 *
 */
function resizeMenu() {
    //	var leftSite = $("#menu").offset().left;
    //	leftSite = getLeftSite(leftSite);
    //	//取得桌面上的菜单域
    //	var menuObj = $("#moreMenu", window.parent.desktop.document);
    //    //增加左侧leftMenu显示状态的判定和位置的修改
    //    var h_menu_R_con = menuObj.children("div.h_menu_R_con");
    //    h_menu_R_con.css("left", leftSite);
    //
    //    //  alert(parent.document.getElementsByName("leftMenu")[0].width);
    //    //alert(parent.document.getElementsByName("desktop")[0].width)
    //
    //    document.getElementById("toptable").style.width = parent.document.getElementsByName("leftMenu")[0].width + parent.document.getElementsByName("desktop")[0].width;
    //    var leftHeightDivHeight = document.getElementById("leftHeightTable").offsetHeight;
    var windowHeight = $(window).height();
    var maxHeight = windowHeight - 300;
    var side_menu_1_height = $(".side_menu_1").length * 41.5; //一级菜单高度
    try{
    if(alreadyOpenTableId != null){
        var heigh = $("#" + alreadyOpenTableId).next().height();//取得点开二级菜单的总长度
        side_menu_1_height =heigh + side_menu_1_height; //一级菜单高度
        }
    }catch(e){}
    if (side_menu_1_height > maxHeight) {
        document.getElementById("leftHeightDiv").style.height = maxHeight + "px";
        $(".side_menu").attr("style", "height:" + side_menu_1_height + "px");
    } else {
        document.getElementById("leftHeightDiv").style.height = side_menu_1_height + 5 + "px";
        $(".side_menu").attr("style", "height:" + side_menu_1_height + "px");
    }
}


/**
 * 隐藏“更多”菜单
 *
 */
function hiddenMoreMenu() {
    var obj = $("#moreBtn");
    $(obj).removeClass();
    $(obj).addClass("more");
    $("#menu").removeClass();
	//取得桌面上的菜单域
    var menuObj = $("#moreMenu");
    if (menuObj.length > 0) menuObj.hide();
    menuObj.css("display", "none");
}

/**
 * 取得菜单左侧的位置
 *
 */
function getLeftSite(oldSite) {
    //取得浏览器的信息
    var appVer = navigator.appVersion;
	//当左侧的菜单显示时，显示的菜单要减少掉菜单占的位置
    if (appVer.indexOf("MSIE") > -1) {    //IE
        if ($("div.sideBarContent", window.parent.leftMenu.document).css("display") != "none") {
            return oldSite - 200;
        } else {
            return oldSite - 15.5;
        }
    } else if (appVer.indexOf("Chrome") > -1) {    //Chrome
        if ($("div.sideBarContent", window.parent.leftMenu.document).css("display") != "none") {
            return oldSite - 200;
        } else {
            return oldSite - 16;
        }
    } else if (appVer.indexOf("Safari") > -1) {    //Safari
        if ($("div.sideBarContent", window.parent.leftMenu.document).css("display") != "none") {
            return oldSite - 206;
        } else {
            return oldSite - 21.5;
        }
    } else {    //火狐
        if ($("div.sideBarContent", window.parent.leftMenu.document).css("display") != "none") {
            return oldSite - 200;
        } else {
            return oldSite - 16;
        }
    }
}

/**
 * 设置关闭按钮的位置
 *
 */
function setcloseBtnSite(menuLeftSite) {
    var leftSite = menuLeftSite + 435;
    var topSite = "112px";
    var closeBtn = $(".closeBtn > img");
//    closeBtn.css("left", leftSite);
    closeBtn.css("top", topSite);
}


function showOrHide() {

    var allPortal = $("#sum").val();
    var pageNum = Math.ceil(allPortal / 6);
    $("#nowPage").val(1);
    $("#pageNum").val(pageNum);
    if (allPortal < 6) {
        $("#leftImg").hide();
        $("#rightImg").hide();
    } else {
        $("#leftImg").show();
        $("#rightImg").show();
    }
    $(".portalDiv").each(function () {
        var id = this.id;
        var index = id.substring(11);
        if (index > 6) {
            $("#portalImage" + index).hide();
        }

    });

}

function changeImg(obj, flg, overOrBlur) {

    if (flg == "1") {
        if (overOrBlur == "over") {
            obj.src = "/htoa/image/main_click.png";
        }
        if (overOrBlur == "blur") {
            obj.src = "/htoa/image/main.png";
        }
    }
    if (flg == "2") {
        if (overOrBlur == "over") {
            obj.src = "/htoa/image/home_click.png";
        }
        if (overOrBlur == "blur") {
            obj.src = "/htoa/image/home.png";
        }
    }
    if (flg == "3") {
        if (overOrBlur == "over") {
            obj.src = "/htoa/image/return_click.png";
        }
        if (overOrBlur == "blur") {
            obj.src = "/htoa/image/return.png";
        }

    }
    if (flg == "4") {
        if (overOrBlur == "over") {
            obj.src = "/htoa/image/exit_click.png";
        }
        if (overOrBlur == "blur") {
            obj.src = "/htoa/image/exit.png";
        }

    }
}



//取得左侧菜单中的二级菜单
function portalClick(portalIndexId, oaappWebPath) {

    if (portalIndexId == "DEFAULT_DESKTOP_JSP") {
        window.parent.location = oaappWebPath + "jsp/portalMid.jsp?portalIndexId=" + portalIndexId;
    }
    else {
        window.parent.desktop.location = oaappWebPath + "jsp/portalMid.jsp?portalIndexId=" + portalIndexId;
    }
    try {
        var buffalo = new Buffalo(endPointTop);
        buffalo.remoteCall("portalService.setPortalDefaultConfig", [portalIndexId, userId], function(reply) {
        });
    } catch (ex) {
    }
    hiddenMorePortal();
}

//取得左侧菜单中的二级菜单
function portalClickChange(obj, portalIndexId, oaappWebPath) {
    if (obj) {
    chengeStyle(obj);
    }
    if (portalIndexId == "DEFAULT_DESKTOP_JSP") {
        window.parent.location = oaappWebPath + "jsp/portalMid.jsp?portalIndexId=" + portalIndexId;
    }
    else {
        window.parent.desktop.location = oaappWebPath + "jsp/portalMid.jsp?portalIndexId=" + portalIndexId;
    }
    try {
        var buffalo = new Buffalo(endPointTop);
        buffalo.remoteCall("portalService.setPortalDefaultConfig", [portalIndexId, userId], function(reply) {
        });
    } catch (ex) {
    }
    hiddenMorePortal();
}


// 门户切换前6个
function preSix() {
    var sumPortal = $("#sum").val();
    var minIndex = "";
    var allPage = $("#pageNum").val();
    var nowPage = $("#nowPage").val();
    if (nowPage != 1) {
        nowPage--;
    }
    if (nowPage == 0) {
        return;
    }
    $(".portalDiv").each(function () {
        check(this, parseInt(nowPage) - parseInt(1));
    });

    $("#nowPage").val(nowPage++);
}

//门户切换后6个
function nexSix() {

    var sumPortal = $("#sum").val();
    var minIndex = "";
    var allPage = $("#pageNum").val();
    var nowPage = $("#nowPage").val();
    if (nowPage == allPage) {
        $("#nowPage").val(nowPage);
        return;
    }
    $(".portalDiv").each(function() {
        check(this, nowPage);
    });
    if (nowPage != allPage) {
        nowPage++;
    }
    $("#nowPage").val(nowPage);

}

//门户切换
function check(obj, nowPage) {
    var index = obj.id.substring(11);
    if (index == (parseInt(parseInt(parseInt(parseInt(nowPage))) * 6) + parseInt(1))) {
        $("#portalImage" + index).show();
    } else if (index == (parseInt(parseInt(parseInt(parseInt(nowPage))) * 6) + parseInt(2))) {
        $("#portalImage" + index).show();
    } else if (index == (parseInt(parseInt(parseInt(parseInt(nowPage))) * 6) + parseInt(3))) {
        $("#portalImage" + index).show();
    } else if (index == (parseInt(parseInt(parseInt(parseInt(nowPage))) * 6) + parseInt(4))) {
        $("#portalImage" + index).show();
    } else if (index == (parseInt(parseInt(parseInt(parseInt(nowPage))) * 6) + parseInt(5))) {
        $("#portalImage" + index).show();
    } else if (index == (parseInt(parseInt(parseInt(parseInt(nowPage))) * 6) + parseInt(6))) {
        $("#portalImage" + index).show();
    } else {
        $("#portalImage" + index).hide();
    }
}

/**
 * 显示“更多”风格
 *
 */
function showMoreStyle(obj) {
    //取得桌面上的菜单域
    var menuObj = $("#moreStyle");
    menuObj.show();
    Hid = false;
    menuObj.focus();
    hiddenMorePortal();
}


/**
 * 隐藏“更多”菜单
 *
 */
function hiddenMoreStyle() {
    //    var obj = $("#moreBtn");
    //    $(obj).removeClass();
    //    $(obj).addClass("more");
    //    $("#menu").removeClass();
    //取得桌面上的菜单域
    var menuObj = $("#moreStyle");
    if (menuObj.length > 0) menuObj.hide();
    menuObj.css("display", "none");
}


/**
 * 设置按钮的显示样式
 * 当鼠标滑过钮时，设置显示样式为over
 *
 */
function menuOverTopBtn(obj) {
    $(obj).addClass("over");
    var imgObj = $(obj).find("img");
    imgObj.attr("src", imgObj.attr("hoverSrc"));

}

/**
 * 设置按钮的显示样式
 * 当鼠标离开按钮时，去除显示样式
 *
 */
function menuOutTopBtn(obj) {

    $(obj).removeClass();
    var imgObj = $(obj).find("img");
    imgObj.attr("src", imgObj.attr("normalSrc"));

}


function writeCookie(style,type) {
    var expdate = new Date();
    var str = "";
    var nIndex;
    str += $("#userId").val();
    str += "|";
    str += style;
//    str += $("#useStyle").val();
    str += "|";
    str += $("#useLanguage").val();
    str += "|";
    str += type;
//    str += $("#useLanguage").val();
    str += "|";
    expdate.setTime(expdate.getTime() + 365 * (24 * 60 * 60 * 1000)); //+1 year
    SetCookie("htoa8000", str, expdate, "/");
    hiddenMoreStyle();
}


function SetCookie(nameValue, valueValue) {
    var argv = SetCookie.arguments;
    var argc = SetCookie.arguments.length;
    var expires = (argc > 2) ? argv[2] : null;
    var path = (argc > 3) ? argv[3] : null;
    var domain = (argc > 4) ? argv[4] : null;
    var secure = (argc > 5) ? argv[5] : false;
    document.cookie = nameValue + "=" + escape(valueValue) +
                      ((expires == null) ? "" : ("; expires=" + expires.toGMTString())) +
                      ((path == null) ? "" : ("; path=" + path)) +
                      ((domain == null) ? "" : ("; domain=" + domain)) +
                      ((secure == true) ? "; secure" : "");
}


/**
 * 显示“更多”风格
 *
 */
function showMorePortal(obj) {
    //取得桌面上的菜单域
    var menuObj = $("#morePortal");
    Hid = false;
    menuObj.show();
    menuObj.focus();
     hiddenMoreStyle();
}


/**
 * 隐藏“更多”菜单
 *
 */
function hiddenMorePortal() {
    var menuObj = $("#morePortal");
    if (menuObj.length > 0) menuObj.hide();
//    menuObj.css("display", "none");
}

/**
 * 切换成WIN8门户
 */
function changeWin8Portal(styleId) {
   writeCookie(styleId,'WIN8');
    var strHrefUrl = "jsp/defaultWin8.jsp?styleId=" + styleId; 
    var href = window.location.href;
    href = href.substring(0, href.indexOf("WebObjects"))
    strHrefUrl = href + strHrefUrl;
    openWindow(strHrefUrl, window.screen.availWidth, window.screen.availHeight, "");
    window.opener=null;           //防止弹提示
    window.open('', '_self', '');      
    window.close();
}


$(document).ready(function() {
    showOrHide();
    //Safari浏览器下需要强制隐藏body的滚动条，并且高分辨率下必须强制指定两边的td宽度否者无法居中，计算滚动条宽度也会失效
    var appVer = navigator.appVersion;
    //if (appVer.indexOf("Safari") > -1) {
    	$(parent.document.body)[0].style.cssText="overFlow:hidden";
     	var  v = document.documentElement.clientWidth;
   	 if (v >1366) {
       	v = (v - 1190-180)/2;
       		$("#frame_bg_color1").css("width",v);
        	$("#frame_bg_color2").css("width",v); 
     	}
    //}
});

