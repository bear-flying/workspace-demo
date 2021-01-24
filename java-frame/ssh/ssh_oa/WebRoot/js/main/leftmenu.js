var showLeftMenuFlg = true;	//当前是否显示左侧菜单
var resizeOldWidth = 0;
// onLoad();

/**
 * 初始化
 *
 */
$(document).ready(function() {
    //取得在线用户数
    getIframeOnlineUsers();
//    if (resizeOldWidth != "200, *") {
//        showLeftMenuFlg = false;
//        changeLeftMenu();
//    }

//    var scrollBoxHeight = document.documentElement.clientHeight;
//    var divHeight = $(".side_menu_bg_bot").height();
    //    var inpubHeight = $(".L_search").height();
//    $(".scroll_box_2").css("height", scrollBoxHeight);
//解决低分辨率下弹出的菜单显示偏左
var screenWidth =window.screen.width;
if (screenWidth <1300) {
if ($(".moreStyle").length>0) {
 $(".moreStyle").css("margin-left", 455);
}
}

});

/**
 * 更改左侧菜单显示方式
 *
 */
function changeLeftMenu() {    
    //指定总显示宽度
   var screenWidth = window.screen.availWidth 
           var pageWidth = 1366;
    if(screenWidth < pageWidth) {
           pageWidth = screenWidth;
    }
    //左侧菜单宽度
		   var leftWidth = parent.document.getElementsByName("leftMenu")[0].width
    //主画面显示宽度
		   var mainWidth = pageWidth - leftWidth;    
    var resizeObj = parent.document.getElementById("resize");
    if (showLeftMenuFlg) {
        resizeObj.cols = "16, *";
        $(".user_bg").hide();
        $(".sideBarContent").hide();
        $(".sideBar").css("width", "16px");
        $(".hidden_btn").css("left", "1px");
        var imgSrc = $(".hidden_btn").attr("src");
        $(".hidden_btn").attr("src", appPath + "show_btn.gif");
        $(".sideBar").addClass("sideBarHidden");
    } else {          
        resizeObj.cols = "*,200, "+mainWidth+",*";
        $(".user_bg").show();
        $(".sideBarContent").show();
        $(".sideBar").css("width", "200px");
        $(".hidden_btn").css("left", "184px");
        $(".hidden_btn").attr("src", appPath + "hidden_btn.gif");
        $(".sideBar").removeClass("sideBarHidden");
    }
    showLeftMenuFlg = !showLeftMenuFlg;
    //如果菜单是打开的，要更改菜单的位置
    window.parent.TopMenu.resizeMenu();
}


var alreadyOpenTableId = null;		//记录当前打开的菜单
var hrefBaseValue = null;			//记录当前打开画面的主链接

//判断当前菜单是否是打开的，如果是打开的，直接关闭并且删除下层菜单
function closeMenu(obj) {
    if (alreadyOpenTableId == null) return;
    //当前菜单为已经打开菜单，直接关闭

    
    $("[parentid='" + alreadyOpenTableId + "']").detach();

    //当关闭二级菜单或切换二级菜单的时候，根据各种情况计算
    $("#" + alreadyOpenTableId).removeClass("side_menu_4");
    var asd = $("#" + alreadyOpenTableId).prev(".side_menu_1");
    asd.removeClass("side_menu_3");

    var side_menu_1_height = $(".side_menu_1").length * 42; //一级菜单高度
    //    alert("side_menu_1_height---" + side_menu_1_height);
    var windowHeight = $(window).height();       //浏览器高度
    var maxHeight = windowHeight - 300;          //浏览器可用高度


    if (side_menu_1_height > maxHeight) {
        $(".side_menu").attr("style", "height:" + side_menu_1_height + "px");  //若没超越最大高度，则将一级菜单加上二级菜单的高度赋给side_menu高度
        document.getElementById("leftHeightDiv").style.height = maxHeight + "px";
    } else {
        $(".side_menu").attr("style", "height:" + side_menu_1_height - 10 + "px");  //若没超越最大高度，则将一级菜单加上二级菜单的高度赋给side_menu高度
        document.getElementById("leftHeightDiv").style.height = side_menu_1_height + "px";
    }
    

//    var side_iconHeightStr = $("#iconHeight").val();    //关闭子菜单，回复原始高度
//    var side_iconHeight = parseInt(side_iconHeightStr) + 63;    //关闭子菜单，回复原始高度
//
//    $(".side_menu").attr("style", "height:" + side_iconHeight + "px");
    //        var heigh = $("[parentid='" + functionId + "']").height();//取得点开二级菜单的总长度
    //        alert("heigh---" + heigh);
    //        alert("side_menu---" + $(".side_menu").height());
    //        var currentSideMenuHeight = $(".side_menu").height();
    //        var sideMenuHeight = currentSideMenuHeight - heigh;
    ////        $("[parentid='" + alreadyOpenTableId + "']").detach();
    //        $(".side_menu").attr("style", "height:" + sideMenuHeight + "px");
                           

}

//取得左侧菜单中的二级菜单
function menuClick(obj, functionId, languageType, rankGroup, userId) {

    var windowHeight = $(window).height();       //浏览器高度
    var maxHeight = windowHeight - 300;          //浏览器可用高度


    //判断当前菜单是否是打开的，如果是打开的，直接关闭并且删除下层菜单
    closeMenu(obj);

    if (functionId == alreadyOpenTableId) {
        $("#" + functionId).removeClass("side_menu_4");
        var asd = $("#" + functionId).prev(".side_menu_1");
        asd.removeClass("side_menu_3");
        alreadyOpenTableId = null;
        return true;
    }

    alreadyOpenTableId = functionId;

    //取得第二层菜单
    try {
        //add  by  jinfei  20150511
        $(".side_menu_4").removeClass("side_menu_4")
        $(".side_menu_3").removeClass("side_menu_3")

        $("#" + obj.id).addClass("side_menu_4");
        var asd = $("#" + obj.id).prev(".side_menu_1");
        asd.addClass("side_menu_3");
        var buffalo = new Buffalo(endPointTop);
        buffalo.remoteCall("desktopService.getSubMenuStr", [languageType, rankGroup, functionId, userId], function(reply, obj) {
            var menuStr = reply.getResult();
//            alert(menuStr)
            $("#" + functionId).after(menuStr);

            ///*当点开二级菜单的时候根据各种情况判断隐藏*/

            var heigh = $("#" + functionId).next().height();//取得点开二级菜单的总长度
            var i; //定义一个位置标识，标识当前第几个一级菜单点开的二级菜单
            $("#" + functionId).parent().children(".side_menu_1").each(function(index) {     //计算标识位置
                if ($(this).attr("id") == functionId) {
                    i = index;
                }
            });

//            var leftHeightDivHeight = document.getElementById("leftHeightTable").offsetHeight;
            //           var windowHeight = $(window).height();
            //              var maxHeight = windowHeight - 300;
            //            if(leftHeightDivHeight > maxHeight) {
            //                 document.getElementById("leftHeightDiv").style.height =  maxHeight +"px";
            //            }   else{
            //                   document.getElementById("leftHeightDiv").style.height =  leftHeightDivHeight +"px";
            //            }


            var side_menu_1_height = $(".side_menu_1").length * 41.5; //一级菜单高度

            var sideMenuTotalHeight = side_menu_1_height + heigh;   //一级菜单 + 二级菜单的高度



            //var maxHeight = $("#maxHeight").val();//取出后台计算的最大高度

            if (sideMenuTotalHeight > maxHeight) {      //若一级菜单加上二级菜单超越了浏览器可用高度那么将最大高度赋给side_menu高度
                document.getElementById("leftHeightDiv").style.height =  maxHeight +"px";
                $(".side_menu").attr("style", "height:" + sideMenuTotalHeight + "px");
            } else {
                $(".side_menu").attr("style", "height:" + sideMenuTotalHeight + "px");  //若没超越最大高度，则将一级菜单加上二级菜单的高度赋给side_menu高度
                document.getElementById("leftHeightDiv").style.height =  sideMenuTotalHeight+2 +"px";
            }
//            if (side_menu_1_height + heigh > maxHeight) {      //若一级菜单加上二级菜单超越了最大高度那么将最大高度赋给side_menu高度
//                $(".side_menu").attr("style", "height:" + maxHeight + "px");
//            } else {
//                var h = side_menu_1_height + heigh - 20     //若没超越最大高度，则将一级菜单加上二级菜单的高度赋给side_menu高度
//                $(".side_menu").attr("style", "height:" + h + "px");
//            }

        });


        closeOtherClass();
    } catch (ex) {

    }
}
function chengeStyle(obj) {
    if ($(obj).attr("class") == "out") {
        var oldObj = $(".side_menu").find(".click_menu");
        oldObj.attr("class", "out");
        oldObj = $(".side_menu").find(".click_menu_last");
        oldObj.attr("class", "out_last");
//        if ($(oldObj).attr("mark") && "last"==$(oldObj).attr("mark")) {
//            oldObj.attr("class", "out_last");
//        } else {
//            oldObj.attr("class", "out");
//        }
        $(obj).attr("class", "click_menu");
    }
    if ($(obj).attr("class") == "out_last") {
        var oldObj = $(".side_menu").find(".click_menu");
        oldObj.attr("class", "out");
        $(obj).attr("class", "click_menu_last");
    }
    //add by jinfei  20150511
    if ($(obj).parent().attr("class") != "side_menu_2") {
        $(".side_menu_4").removeClass("side_menu_4")
        $(".side_menu_3").removeClass("side_menu_3")

    }
    if ($(obj).parent().attr("class") == "side_menu") {
        closeMenu(obj);
        alreadyOpenTableId = null;            
    }
    $("#" + obj.id).addClass("side_menu_4");
    var asd = $("#" + obj.id).prev(".side_menu_1");
    asd.addClass("side_menu_3");
}
//进入画面
function actionPage(obj, urlValue, urlName, urlTarget) {
    chengeStyle(obj);
    if (urlValue == "") return false;
    var autoEnterObj = document.getElementById("autoEnter");
    autoEnterObj.target = urlTarget;
    var pageNameObj = document.getElementById("pageName");
    if (pageNameObj) pageNameObj.value = urlName;
    if (urlValue.indexOf("act") > -1) {
        var linkEle = document.getElementById(urlValue.substring(3));
        if (linkEle != null) {
            if (linkEle.href == "") {
                alert(errMsg);
                return true;
            }
            linkEle.click();
            return true;
        }
    }

    if (hrefBaseValue == null) hrefBaseValue = autoEnterObj.href;
	//打开 普通菜单报表

    if (urlValue.indexOf(path_report +"raq") == 0) {
        var num = hrefBaseValue.indexOf("/OAapp/");
        var url = hrefBaseValue.substring(0, num + 6) + "/jsp/showMenuReport.jsp?fileReportId=" + urlValue.substring(12);
        window.open(url, "showReportWin", "fullscreen,scrollbars");
        return true;
    }
    //打开 固定资产jsp菜单报表
    if (urlValue.indexOf(path_report+"jsp/assets") == 0) {
        var url = "/report/jsp/assetsReport.jsp?companyId=" + $("#companyId").val();
        window.open(url, "showReportWin", "fullscreen,scrollbars");
        return true;
    }
    //打开 jsp菜单报表
    if (urlValue.indexOf(path_report) == 0) {
        var num = hrefBaseValue.indexOf("/OAapp/");
        var url = hrefBaseValue.substring(0, num) + urlValue;
        window.open(url, "showReportWin", "fullscreen,scrollbars");
        return true;
    }
        //打开模板自定义模板对应块的方法  add by chenwen at 20141127
    if (urlValue.indexOf("traceOpen") > -1) {
        var buffalo = new Buffalo(endPointTop);
        buffalo.remoteCall("traceForeignService.createInstanceIndex", [userId,deptId,urlValue], function(reply) {
            if (reply.getResult() != null) {
	    //add by chenwen at 20150721 增加标识判断，弹出出错信息
                if (reply.getResult() == "noPath") {
                    alert("该模板没有适用于您的流程，请与模板管理员确认。")
                } else if (reply.getResult() == "pathError") {
                    alert("创建表单流程出错")
                } else if (reply.getResult() == "morePath") {
                    alert("该模板为多流程，暂不支持发起，请与模板管理员联系。")
                } else {
                    var num = hrefBaseValue.indexOf("/OAapp/");
                    var url = hrefBaseValue.substring(0, num + 7) + reply.getResult();
//                window.open(url, "showReportWin", "fullscreen,scrollbars");
                    openWindow(url, window.screen.availWidth, window.screen.availHeight, "");  //打开方式优化 update by chenwen at 20141210
                    //                return true;
                }
            }
        });
        return true;     //update by chenwen at 20150519 修改return 的位置，防止程序接着像下运行 update by chenwen at 20150519
    }
    //SSO
    if (urlValue.indexOf("acthtsso_") == 0) {
        var url = hrefBaseValue + "?PAGEID=" + urlValue + "&PAGENAME=" + encodeURI(urlName);
        window.open(url, "showSSOWin", "fullscreen,scrollbars");
        return true;
    }
	//普通链接的跳转
    if ((urlValue.indexOf("SYSTEMDEFINE") < 0 && urlValue.toLowerCase().indexOf("ht") < 0 && urlValue.toLowerCase().indexOf("template") < 0 && urlValue.indexOf("FUNC") < 0 && urlValue.indexOf("htfile_") < 0) || urlValue.indexOf('http://') == 0 || urlValue.indexOf('https://') == 0) {
        var temp = autoEnterObj.href;
        if (urlValue.indexOf('http://') != 0 && urlValue.indexOf('https://') != 0) {
            urlValue = 'http://' + urlValue;
        }
        autoEnterObj.href = urlValue;
        autoEnterObj.target = urlTarget;
        autoEnterObj.click();
        autoEnterObj.href = temp;
        return true;
    }
    autoEnterObj.href = hrefBaseValue + "?PAGEID=" + urlValue + "&PAGENAME=" + encodeURI(urlName);
    //点击菜单跳转兼容firefox火狐  20150424
    document.getElementsByName("desktop")[0].src = autoEnterObj.href;
//    document.desktop.location = autoEnterObj.href;
     closeOtherClass();
}

function st_onload() {
    return;
}

// 20130807 liujinlong 打开画面中带有链接的onclick方法
function actOpenWindowBtn(linkName, width, height) {
    //调整页面的 URL
    var hrefObj = document.getElementById(linkName);
    var strHrefUrl = hrefObj.href
    openWindow(strHrefUrl, width, height, linkName);
}

function openWindow(url, pWidth, pHeight, winName) {
    if (!url) return null;
    var winWidth = window.screen.availWidth;
    var winHeight = window.screen.availHeight;
    if (!pWidth) pWidth = winWidth;
    if (!pHeight) pHeight = winHeight;
    var pleft = (winWidth - pWidth) / 2;
    if (pleft < 1) {
        pleft = 0;
        pWidth = winWidth;
    }
    var ptop = (winHeight - pHeight) / 2;
    if (ptop < 1) {
        ptop = 1;
        pHeight = winHeight;
    }
    var varOption = "dependent,toolbar=no,location=no,status=yes,menubar=no,resizable=yes,scrollbars=yes,"//update by chenwen at 20150922 将scrollbars属性由auto改为yes和pageCommon中对应，解决单独模块打开审批单时无滚动条
            + "width=" + pWidth + "px,height=" + pHeight + "px,left=" + pleft + "px,top=" + ptop + "px;";
    if (winName == null) winName = "newWindow";
    return window.open(url, winName, varOption);
}
// 用户敲击回车执行查询方法
function checkInfo() {
    if (event.keyCode == 13) {
        actOpenWindowBtn('search', 800, 600);
    }
       // 鼠标焦点在输入框里 将“关键字隐藏”
    function inputAreaClick(inputElement, showText) {
        if (inputElement.value == showText) {
            inputElement.value = "";
        }
        inputElement.select;
    }
   // 鼠标焦点从输入框移出 将“关键字”显示
    function inputAreaBlur(inputElement, showText) {
        if (inputElement.value == "") {
            inputElement.value = showText;
        }
    }
}

/**
 * 画面收藏
 */
function faveriatePage(functionId) {
    try {
        var buffalo = new Buffalo(endPointTop);
        buffalo.remoteCall("desktopService.saveFaveriate", [userId, functionId], function(reply, obj) {
            alert(reply.getResult());
        });
    } catch (ex) {
        alert(ex.message);
    }
}

// 用户敲击回车执行查询方法
function checkInfo() {
    if (event.keyCode == 13) {
        actOpenWindowBtn('search', 800, 600); 
    }
}
       // 鼠标焦点在输入框里 将“关键字隐藏”
function inputAreaClick(inputElement, showText) {
    if (inputElement.value == showText) {
        inputElement.value = "";
    }
    inputElement.select;
}
   // 鼠标焦点从输入框移出 将“关键字”显示
function inputAreaBlur(inputElement, showText) {
    if (inputElement.value == "") {
        inputElement.value = showText;
    }
}
// 基本信息提示，得到焦点并选定
function BaseAlert(theText, notice) {
    if (notice) alert(notice);
    try {
        theText.focus();
        theText.select();
    } catch(e) {
    }
    return false;
}
//记录最后一次点击的门户
function saveDefaultPortal(portalIndexId, myUserId) {
    try {
        var buffalo = new Buffalo(endPointTop);
        buffalo.remoteCall("portalService.setPortalDefaultConfig", [portalIndexId, myUserId], function(reply) {
        });
    } catch (ex) {
    }

}



/**
 * 取得在线用户数
 *
 */
function getIframeOnlineUsers() {
    try {
		var buffalo = new Buffalo(endPointTop);
	        buffalo.remoteCall("desktopService.getOnlineUserCount", [], function(reply) {
	            var str = reply.getResult();
                document.getElementById("onlineUserNum").innerHTML = "<FONT color=red >" + str + "</FONT>"+online_people+"&nbsp;";
	        });
	} catch (ex) {
		alert(ex.message);
	}
	//每10分钟刷新一次
	setTimeout("getIframeOnlineUsers()", 1000 * 60 * 10);
}



/**
 * 打开在线人员
 *
 */
function openOnlinePage() {
	var href = $("#actOnlinePage").attr("href");
    var winWidth = window.screen.availWidth;
    var winHeight = window.screen.availHeight;
    var pleft = (winWidth - 800) / 2;
    var ptop = (winHeight - 700) / 2;
    var width = 800;
    var height = 700;
    var varOption = "dependent,toolbar=no,location=no,status=no,menubar=no,resizable=yes,scrollbars=no,width="+width+"px,height="+height+"px,left=" + pleft + ",top=" + ptop + ";";
    window.open(href, "OnlinePage", varOption);
}


/**
 * 关闭其他窗口
 *
 */
function closeOtherClass() {
    hiddenMorePortal();
    hiddenMoreStyle();
    hiddenMoreMenu();

}


function addEventHandler(oTarget, sEventType, fnHandler) {
	if (oTarget.addEventListener) {
        oTarget.addEventListener(sEventType, fnHandler, false);
    } else if (oTarget.attachEvent) {
        oTarget.attachEvent("on" + sEventType, fnHandler);
    } else {
        oTarget["on" + sEventType] = fnHandler;
    }
}
;

function Event(e) {
    var oEvent = document.all ? window.event : e;
    if (document.all) {
        if (oEvent.type == "mouseout") {
            oEvent.relatedTarget = oEvent.toElement;
        } else if (oEvent.type == "mouseover") {
            oEvent.relatedTarget = oEvent.fromElement;
        }

        oEvent.stopPropagation = function() {
            this.cancelBubble = true;
        }
    }
    return oEvent;
}

function Each(list, fun) {
    for (var i = 0, len = list.length; i < len; i++) {
        fun(list[i], i);
    }
}
;


var Class = {
    create: function() {
        return function() {
            this.initialize.apply(this, arguments);
	}
  }
}

Object.extend = function(destination, source) {
	for (var property in source) {
		destination[property] = source[property];
	}
	return destination;
}


var CascadeMenu = Class.create();
CascadeMenu.prototype = {
  //初始化对象(容器集合, 菜单结构)
  initialize: function(arrContainer, arrMenu, options) {
	if(arrContainer.length <= 0 || arrMenu.lenght <= 0) return;

	var oThis = this;

	this._timerContainer = null;//容器定时器
	this._timerMenu = null;//菜单定时器
	this._onmenu = null;//当前菜单对象
	this._index = -1;//要设置容器的索引

	this.Container = [];//容器集合
	this._menu = arrMenu;//菜单结构

	this.SetOptions(options);

	this.Position = this.options.Position || "right";
        this.Delay = parseInt(this.options.Delay) || 0;
        this.Class = this.options.Class || "";
        this.onClass = this.options.onClass || this.Class;
        this.Tag = this.options.Tag;

	//设置容器
        Each(arrContainer, function(o, i) {
            oThis.IniContainer(oThis.Container[i] = (o = $(o)), i > 0);
        });

        this.Ini();
    },
//设置默认属性
    SetOptions: function(options) {
        this.options = {//默认值
		Position:	"right",//默认位置(up,down,left,right)
		Tag:		"div",//默认生成标签
		Class:		"",//默认样式
		onClass:	"",//焦点样式
		Delay:		0//延迟值(微秒)
        };
        Object.extend(this.options, options || {});
    },
//初始化容器(容器集合, 是否子菜单容器)
    IniContainer: function(container, bChild) {
        var oThis = this;
        addEventHandler(container, "mouseover", function() {
            clearTimeout(oThis._timerContainer);
        });
        addEventHandler(container, "mouseout", function(e) {
            //是否在菜单之内
            var isIn = false, oT = Event(e).relatedTarget;
            Each(oThis.Container, function(o, i) {
                if (o.contains ? o.contains(oT) || o == oT : o.compareDocumentPosition(oT) & 16) {
                    isIn = true;
                }
            });
		//在菜单外隐藏
            if (!isIn) {
                clearTimeout(oThis._timerContainer);
                clearTimeout(oThis._timerMenu);
                oThis._timerContainer = setTimeout(function() {
                    oThis.Hide();
                }, oThis.Delay);
            }
        });
	//重置索引
        container.index = -1;
	//子菜单容器设置
        if (bChild) {
            container.style.position = "absolute";
            container.style.visibility = "hidden";
        }
    },
//初始化第一个容器
    Ini: function() {
        this.Container[0].innerHTML = "";
        this._index = 0;
        this.SetMenu(this._menu);
    },
//全局设置
    Set: function() {
        //隐藏select
        Each(document.getElementsByTagName("select"), function(o) {
            o.style.visibility = "hidden";
        })

        var menu = this._menu;
	//第一个不需要处理所以从1开始
        var i = 1;
        while (menu.length > 0) {
            //获取子菜单结构和定位
            var iC = this.Container[i - 1].index, position = this.Position;
            if (iC >= 0) {
                //这里要先取position再设menu
                position = menu[iC].position || this.Position;
                menu = menu[iC].menu || [];
            } else {
                menu = [];
            }

		//如果容器不够就根据前一个自动添加
            if (!this.Container[i]) {
                var oPre = this.Container[i - 1], oNew = document.body.appendChild(document.createElement(oPre.tagName));
                oNew.style.cssText = oPre.style.cssText;
                oNew.className = oPre.className;
                this.IniContainer(this.Container[i] = oNew, true);
            }

		//设置下一级菜单
            if (this._index == i++) {
                this.SetContainer(menu, position);
                break;
            }
        }
    },
//容器设置(菜单结构, 位置)
    SetContainer: function(menu, position) {
        var oContainer = this.Container[this._index];

	//设置容器
        oContainer.innerHTML = "";
        oContainer.index = -1;
        oContainer.style.visibility = "hidden";

        if (menu.length > 0) {
            //设置菜单
            this.SetMenu(menu);

		//容器定位
		//offset取值会有偏差，要注意
		var o = this._onmenu, iLeft = o.offsetLeft, iTop = o.offsetTop;
		//注意如果display为none的话取不到offset值，所以要用visibility
		switch (position.toLowerCase()) {
			case "up" :
				iTop -= oContainer.offsetHeight;
				break;
			case "down" :
				iTop += o.offsetHeight;
				break;
			case "left" :
                    iLeft -= oContainer.offsetWidth;
                    break;
                case "right" :
                default :
                    iLeft += o.offsetWidth;
            }
            while (o.offsetParent) {
                o = o.offsetParent;
                iLeft += o.offsetLeft;
                iTop += o.offsetTop;
            }
            oContainer.style.left = iLeft + "px";
            oContainer.style.top = iTop + "px";
            oContainer.style.visibility = "visible";
        }

	//隐藏不需要的容器
        for (var i = this._index + 1, len = this.Container.length; i < len; i++) {
            this.Container[i].style.visibility = "hidden";
        }
    },
//菜单设置(菜单结构)
    SetMenu: function(menu) {
        var oThis = this, index = this._index, oContainer = this.Container[index];
        Each(menu, function(o, i) {
            var oMenu = document.createElement(oThis.Tag);
            oMenu.innerHTML = o.txt;
            oMenu.onmouseover = function() {
                clearTimeout(oThis._timerMenu);

			//重新设置菜单
                oThis._timerMenu = setTimeout(function() {
                    oContainer.index = i;
                    oThis._onmenu = oMenu;
                    oThis._index = index + 1;
                    oThis.Set();
                }, oThis.Delay);

			//重新设置样式
                //为解决设置延时后样式的问题每次都全部重新设置
                Each(oThis.Container, function(o, i) {
                    if (i > index) return;
                    Each(o.getElementsByTagName(oThis.Tag), function(o) {
                        o.className = oThis.Class;
                    });
                    if (i == index) {
                        oMenu.className = oThis.onClass;
                    } else if (o.index >= 0) {
                        o.getElementsByTagName(oThis.Tag)[o.index].className = oThis.onClass;
                    } else return;
                });
		}
		oContainer.appendChild(oMenu);
	});
  },
//隐藏菜单
    Hide: function() {
        var oThis = this;
	//除第一个外隐藏
        Each(this.Container, function(o, i) {
            if (i == 0) {
                Each(o.getElementsByTagName(oThis.Tag), function(o, i) {
                    o.className = oThis.Class;
                })
            } else {
                o.style.visibility = "hidden";
            }
            o.index = -1;
        });

	//显示select
        Each(document.getElementsByTagName("select"), function(o) {
            o.style.visibility = "visible";
        })
    },
//添加菜单(一个菜单结构)
    Add: function(arrMenu) {
        this._menu.push(arrMenu);
        this.Ini();
    },
//删除菜单
    Delete: function(index) {
        if (index < 0 || index >= this._menu.length) return;
        for (var i = index, len = this._menu.length - 1; i < len; i++) {
            this._menu[i] = this._menu[i + 1];
        }
        this._menu.pop();
        this.Ini();
    }
};

