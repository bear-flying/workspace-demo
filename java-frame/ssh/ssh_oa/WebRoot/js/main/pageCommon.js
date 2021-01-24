//******************************************************
// USER NAME			大连华天
// SYSTEM NAME		OA8000
// SUB SYSTEM NAME	COMMON COMPONENT
// FILE NAME			pageCommon.js
/**
* 窗口共通处理
* @AUTHOR	sissi
* @VERSION 	2004.10.18 新建
* @VERSION 	2012.11.22 sissi 修改 加入jquery支持，修改为6.0版
*/
//******************************************************

/**
 * 页面初始化调用
 *
 * 
 */
  var style ;

$(document).ready(function() {
    style =$("#style").val();
    initOfficeSize();
    initSelect();
    init();
    //对页面上按键的处理
    document.body.onkeydown = function(event) {
    	if (document.activeElement.type == "textarea" || document.activeElement.type == "password") return true;
        var eve = document.all ? window.event : event;
        if (eve.keyCode == 13) {
			//页面上如果按回车键，当作tab键处理
            eve.keyCode = 9;
        } else if (eve.keyCode == 8 && document.activeElement.type != "text") {
			//页面上如果按退回键，当作tab键处理
            eve.keyCode = 9;
        }
    }
	document.body.onclick=function(){
		closeOtherClass();
}


        if ($(".R_clumn_1_box").length>0  &&  $(".R_clumn_1_box")[0].style.length!=0)  {
              var a =  $(".R_clumn_1_box").width();
              obj = $(".scroll_box_1")[0];
	      if($(".scroll_box_1").length>0 && (obj.scrollHeight>obj.clientHeight||obj.offsetHeight>obj.clientHeight)){ 
	         a= a-20;
         }
           a= a+2;
           $(".view_div").css("width", a-2);
           $(".contents_table").css("width", a);
           $(".edit_div").css("width", a-2);
	  $(".hr_table_view").css("width", a);
       }

});

/**
 *  office控件初期化时对宽度的设置
 *
 */
function initOfficeSize() {
    var officeObj = document.getElementById("TANGER_OCX")
    if (officeObj) {
        officeObj.setAttribute("width", "100%");
        officeObj.setAttribute("height", "100%");
    }
}


var hiddenSelectUlFlg = true;
var hiddenPageSelectUlFlg = true;
var clickRunning = "";
var clickPageRunning = "";

/**
 * 清除画面上打开的列表元素
 * 
 * 
 */
$(document).click(function() {
	try {
		if (!hiddenSelectUlFlg) {
			if (clickRunning == "show") {
				clickRunning = "";
				return true;
			}
			hiddenSelect();
			hiddenSelectUlFlg = true;
		}
        if (!hiddenPageSelectUlFlg) {
            if (clickPageRunning == "show") {
                clickPageRunning = "";
                return true;
            }
            document.getElementById("select_ul").style.display = "none";
            b = document.getElementById("select");
            b.style.border = "0px solid #D8D8D8";
            b.style.background = "#ffffff";
            c = document.getElementById("button_select");
            c.style.background = "url(/htoa/image/comm/"+style+"/select.gif)";
            document.getElementById("image1").src = "/htoa/image/comm/"+style+"/write.gif";
            document.getElementById("image2").src = "/htoa/image/comm/"+style+"/write.gif";
            hiddenPageSelectUlFlg = true;
        }
	} catch (ex) {
	}
});

/**
 * 下拉列表点击方法
 * 
 * 点击时，要判断当前列表是显示还是隐藏，然后调用不同的方法
 */
function initSelect() {
//2015-01-30 qiaoguoyu 针对6.5样式修改 增加俩种样式 查询画面和编辑画面
	//判断在当前画面中是否存在下拉列表
	var selectSpanList = $(".selectSpan");
	if (selectSpanList.length != 0) {
        initSelectList(selectSpanList);
    }
    var selectSpanList1 = $(".selectSpanOval");
	if (selectSpanList1.length != 0) {
        initSelectList(selectSpanList1);
    }

}

/**
 * 下拉列表点击方法
 * selectSpanList  下拉列表数组
 * 点击时，要判断当前列表是显示还是隐藏，然后调用不同的方法
 */
function initSelectList(selectSpanList) {
    var count = selectSpanList.length;
	for (var i = 0; i < count; i++) {
		var selectSpanObj = selectSpanList[i];
		//取得SPAN中间select对象
		var obj = $("#selHidSpa_" + selectSpanObj.id.substring(10) + " > select");
		if (obj == null || obj.length == 0) continue;
		var selectObj = obj[0];
		if(selectObj.selectedIndex > -1) {
			//把当前列表的选中项的文本赋给SPAN
			$(selectSpanObj).text(selectObj.options[selectObj.selectedIndex].text);
			var objWidth = parseInt($(selectObj).width());
			if (objWidth < 80) objWidth = 80;
			$(selectSpanObj).css("width", objWidth - 8 /*- 28*/);
            $(selectSpanObj).bind("select", function() {
                return false;
            });
		}   else    {
            $(selectSpanObj).width(65);//没有项目时，也显示一个空白条，65宽度
        }
	}
	//创建一个虚拟对象，用于显示下拉列表的内容
	//下拉菜单主体
	var selectUl = document.createElement("UL");
	selectUl.id = "showSelectUl";
	selectUl.className = "selectUl";
	selectUl.style.display = "none";
    //selectUl.style.width = objWidth + 50;
	document.body.appendChild(selectUl);
}

/**
 * 下拉列表点击方法
 * 
 * 点击时，要判断当前列表是显示还是隐藏，然后调用不同的方法
 */
function clickSelect(obj, event) {
	hiddenSelectUlFlg = false;
	var selectId = obj.id.substring(10);
	//取得绑定对象
	var selectUl = $("#showSelectUl");
	//判断列表框是否是隐藏的，如果是隐藏的说明没有对象打开。
	if (selectUl.css("display") == "none") return showSelect(obj, selectUl, event);
	//列表框是显示的，需要先判断是否是当前对象打开的
	if (selectUl.attr("objId") == "selectBtn_" + selectId) return hiddenSelect(selectUl);
	//先把原来的对象关闭后才能打开现在的对象
	hiddenSelect(selectUl);
	showSelect(obj, selectUl, event);
}

/**
 * 下拉列表显示方法
 * 
 * 显示时，要把对应的下拉列表的内容复制到块中显示出来
 */
function showSelect(obj, selectUl, event) {
	var selectId = $(obj).attr("id").substring(10);
    var ovalFlg = $(obj).attr("class") == "selectSpanOval";
    //取得当前列表对象
	var obj = $("#selHidSpa_" + selectId + " > select");
    if($(obj).prop("disabled")) {//如果select是disable状态,则不显示 update by ZZQ 2013-08-26
        return false;
    }
	if (obj == null || obj.length == 0) return false;
	var listWidth = parseInt(obj.css("width"));
    if(ovalFlg) {//增加圆角下拉显示宽度
        if (listWidth < 80) {
            listWidth = 96;
        } else {
            listWidth = listWidth + 16;// - 28;
        }
    } else {
        if (listWidth < 80) {
            listWidth = 88;
        } else {
            listWidth = listWidth + 8;// - 28;
        }

    }
    var selectObj = obj[0].options;
	//在UL中创建LI对象
	for (var i = 0; i < selectObj.length; i++) {
		var obj = document.createElement("LI");
        var value = selectObj[i].value;
//        obj.value = value;
        obj.setAttribute("value",value);   //update by  chenwen at 20140829 审批状态为-1时下拉列表赋值出错
		obj.innerHTML = selectObj[i].text;
        //$(obj).height(16);
        $(obj).bind("click", function() {
            clickSelectObj(this);
        });
        $(obj).bind("mouseover", function() {
            this.className = "selectedItem";
        });
        $(obj).bind("mouseout", function() {
            this.className = "unSelectedItem";
        });
		$(obj).attr("order", "" + i);
		selectUl.append(obj);
	}
	//设置列表的显示样式及位置
	var site = $("#selectSpa_" + selectId).offset();
    if(ovalFlg) { //去掉左边圆角位置
        selectUl.css("left", site.left - 3);
    } else {
        selectUl.css("left", site.left);
    }
    var showTop = site.top;
	selectUl.css("height", "150px");
	var objHeight = parseInt(selectUl.height());
	if ((showTop + objHeight + 28) > document.body.offsetHeight) {
		//showTop = document.body.offsetHeight - objHeight - 53 - 56;
        showTop = $("#selectSpa_" + selectId).offset().top - 150 - 10;
	} else {
		showTop += 28;
	}
    if(ovalFlg) { //圆角下拉列表 top位置加3
        showTop += 3;
    }
    selectUl.css("top", showTop);
	selectUl.css("width", listWidth);
	selectUl.attr("objId", "selectBtn_" + selectId);
	selectUl.css("display", "block");
	selectUl.css("overflow-y", "scroll");
	clickRunning = "show";
	hiddenSelectUlFlg = false;
	selectUl.focus();
    var eventName;//update by ZZQ 2013-07-22 增加了mousewheel事件的绑定和去除，在firefox下事件的名称和冒泡组织方式有所不同，所以区别对待
    if($.browser.mozilla) {
        eventName = "DOMMouseScroll";
    }   else    {
        eventName = "mousewheel";
    }
    $(":not(.selectUl, .selectUl > li)", window.document.body).on(eventName, function(e){
        if($.browser.mozilla) {
            event.stopPropagation();
        }   else    {
            e.stopPropagation();
        }
        hiddenSelect(selectUl);
        $(window.document.body).off(eventName);
    });

}
function stopEvent(e)
{
    e = e||event;
    if( e.preventDefault )e.preventDefault();
    e.returnValue = false;
}

/**
 * 下拉列表选中值
 * 
 * 把选中的值返回原列表并隐藏列表
 */
function clickSelectObj(liObj) {
	hiddenSelectUlFlg = false;
	var oElement = liObj;// document.elementFromPoint(event.x,event.y);
	//2012-12-14 By ZZQ 从oElement.order修改
	var num = $(oElement).attr("order");
	var showSelectUlObj = $("#showSelectUl");
	//取得原列表对象
	var selectId = showSelectUlObj.attr("objId").substring(10);
	//取得当前列表对象
	var obj = $("#selHidSpa_" + selectId + " > select");
	if (obj == null || obj.length == 0) return false;
	var selectObj = obj[0].options;
	//找到应该选中的项目
	selectObj.selectedIndex = num;
	//把当前列表的选中项的文本赋给SPAN
	$("#selectSpa_" + selectId).text(selectObj[num].text);
	//调用原列表的onChange方法——如果有的话
	$(obj).change();
	hiddenSelect(showSelectUlObj);
}

/**
 * 下拉列表隐藏方法
 * 
 * 隐藏前，要把选中的值返回给隐藏的下拉列表，再隐藏显示的块
 */
function hiddenSelect(selectUl) {
	hiddenSelectUlFlg = true;
	if (selectUl == null || selectUl == undefined) {
		selectUl = $("#showSelectUl");
	}
	if (selectUl == null || selectUl == undefined) return false;
	//去除全部的li节点并设置为隐藏
	selectUl.children().remove();
	selectUl.css("display", "none");
}
// 2014-04-01
///**
// * 当改变画面尺寸时执行方法
// *
// * 用于控制滚动条的显示及菜单的显示位置
// */
//$(window).resize(function(){
//	resizeHeight();
//});
//
//
///**
// * 根据画面尺寸控制滚动条显示长度
// *
// */
//function resizeHeight() {
//	var scrollBoxHeight = document.documentElement.clientHeight;
//	try {
//		var ttop = $(".scroll_box_1").offset().top;
//		$(".scroll_box_1").css("height", scrollBoxHeight-ttop);
//	} catch(ex) {}
//}


/**
 * 关闭其他窗口
 *
 */
function closeOtherClass() {
    hiddenMorePortal();
    hiddenMoreStyle();
    hiddenMoreMenu();
    hiddenTopMoreMenu();
    
}

/**
 * 隐藏顶部的“更多”菜单
 *
 */
function hiddenMoreMenu() {
	//取得桌面上的菜单域
	var menuObj = $("#moreMenu",parent.document);
	if (menuObj.length > 0) menuObj.hide();
}

/**
 * 隐藏“更多”菜单
 *
 */
function hiddenMoreStyle() {
    //取得桌面上的菜单域
    var menuObj = $("#moreStyle",parent.document);
    if (menuObj.length > 0) menuObj.hide();
    menuObj.css("display", "none");
}

/**
 * 隐藏“更多”菜单
 *
 */
function hiddenMorePortal() {
    var menuObj = $("#morePortal",parent.document);
    if (menuObj.length > 0) menuObj.hide();
//    menuObj.css("display", "none");
}

/**
 * 设置按钮的显示样式
 * 当鼠标滑过钮时，设置显示样式为over
 *
 */
function menuOver(obj){
	$(obj).addClass("over");
}

/**
 * 设置按钮的显示样式
 * 当鼠标离开按钮时，去除显示样式
 *
 */
function menuOut(obj){
	$(obj).removeClass();
}

/**
 * 转向指定的模块
 *
 */
function enterPages(obj) {
	//取得跳转链接对象
	var autoEnterObj = window.parent.TopMenu.document.getElementById("enterMenu");
	//设置基础链接
	if (window.parent.TopMenu.hrefBaseValue == null) window.parent.TopMenu.hrefBaseValue = autoEnterObj.href;
	//取得左侧菜单中的一级菜单
	autoEnterObj.href = window.parent.TopMenu.hrefBaseValue + "?enterUrl=" + obj.id;
             window.parent.leftMenu.location = autoEnterObj.href;
    //显示主画面内容
//	window.parent.menu.actionPage(obj.id, "", "desktop");
	hiddenMoreMenu();
}

/**
 * 画面初始化
 * 
 */
function init() {
       resizeHeight();
try {
       parent.resizeDeskTop();
 } catch(e) {
    }

    //if(window.opener) 
     self.focus();//update by chenwen at 20150922 助手打开发文正文无法打开
    //  李浩修改xp ie8 编辑器加载不全导致出错
    try {
	setTopTitle();
	showAlert();
	showConfirm();
	openNewWindow();
	openNewUrl();
    } catch(e) {
    }
	writeCookie("");
    repeat_table_init();
    window.inerror = false;
	try {
		initPage();
	} catch (ex) {
	}
	//20130409 xg
	if ($("#functionName").val() == "^^CLOSE") {
       		window.close();
		try {
		if(opener != null){
			$("#functionName",window.opener.document).val("");
			opener.document.getElementById("actForm").submit();
			}
		} catch (ex) {
		}
		
		try {
			if ($("#functionId").val() != null&&$("#functionId").val() != "") {
				if(opener != null){	
					opener.refreshMode($("#functionId").val());
				}
			}
		} catch (ex) {
		}	
	}
}

//******************************************************
/**
* 初使化窗口时，根据父窗口传的值设置窗口标题
*/
//******************************************************
function setTopTitle() {
	if (document.homeForm.topTitle.value != "") {
		top.document.title = document.homeForm.topTitle.value;
	}
}

function showAlert() {
	if (document.homeForm.alertMsg.value != "") {
		alert(document.homeForm.alertMsg.value);
		document.homeForm.alertMsg.value = "";
	}
}

function openNewUrl() {
	if (document.homeForm.newUrl.value != "") {
		openUrl(document.homeForm.newUrl.value);
		document.homeForm.newUrl.value = "";
	}
}

function openUrl(urlStr) {
	window.open(urlStr, 'newWindow',
			   'toolbar=yes,location=yes,directories=yes,status=yes,menubar=yes,scrollbars=yes,resizable=yes');
}

function openNewWindow() {
	if (document.homeForm.newWindow.value != "") {
	    var varOption = "toolbar=no,location=no,status=yes,menubar=no,resizable=yes,scrollbars=yes,width=" + screen.availWidth + ",height=" + screen.availHeight + ",left=0,top=0";
	    window.open(document.homeForm.newWindow.value, 'autoOpenWin', varOption);
	}
}

function showConfirm() {
	if (document.homeForm.confirmMsg.value != "") {
		if (confirm(document.homeForm.confirmMsg.value)) {
    			document.homeForm.submit();
		}
		document.homeForm.confirmMsg.value = "";
	}
}

function openWindow(url, pWidth, pHeight, winName) {
	if(!url) return null;
	var winWidth = window.screen.availWidth; 
	var winHeight = window.screen.availHeight;
	if(!pWidth) pWidth = winWidth;
	if(!pHeight) pHeight = winHeight;
	var pleft = (winWidth - pWidth) / 2;
	if(pleft < 1) {
		pleft = 0;
		pWidth = winWidth;
	}
	var ptop = (winHeight - pHeight) / 2;
	if(ptop < 1) {
		ptop = 1;
		pHeight = winHeight;
	}
	var varOption = "dependent,toolbar=no,location=no,status=yes,menubar=no,resizable=yes,scrollbars=yes,"
				+ "width=" + pWidth + "px,height=" + pHeight + "px,left=" + pleft + "px,top=" + ptop + "px;";
	if(winName == null) winName = "newWindow"; 
    return window.open(url, winName, varOption);
}

/**
 * 点击数据行
 * 
 */
function content_onclick(trObj) {
	//去除之前的选中状态
	$(".selectLine").find(":checkbox").prop("checked",false);
	$(".selectLine").removeClass();
	//将所选数据行设置为选中状态
    $(trObj).removeClass();
	$(trObj).addClass("selectLine");
	//取得复选框对象并设置为选中状态
	$(trObj).find(":checkbox").prop("checked",true);	
}

/**
 * 点击选中全部数据行
 */
function checkAll(obj) {
	if ($(obj).attr("checked")) {
		$("input[type='checkbox']").attr("checked", true);
	} else {
		$("input[type='checkbox']").attr("checked", false);
	}
	//去除之前的选中状态
	$(".selectLine").removeClass();
}

//******************************************************
/**
* 输入框内的提示文字显示与设置
*/
//******************************************************
function inputAreaClick(inputElement, showText) {
	if (inputElement.value == showText) {
		inputElement.value = "";
	}
	inputElement.select;
}

function inputAreaBlur(inputElement, showText) {
	if (inputElement.value == "") {
		inputElement.value = showText;
	}
}

function writeCookie(str) {
	var expdate = new Date();
	SetCookie("oaDesktop", str, expdate, "/");
}

function SetCookie (nameValue, valueValue) {
	var argv = SetCookie.arguments;
	var argc = SetCookie.arguments.length;
	var expires = (argc > 2) ? argv[2] : null;
	var path = (argc > 3) ? argv[3] : null;
	var domain = (argc > 4) ? argv[4] : null;
	var secure = (argc > 5) ? argv[5] : false;
	document.cookie = nameValue + "=" + escape (valueValue) +
		((expires == null) ? "" : ("; expires=" + expires.toGMTString())) +
		((path == null) ? "" : ("; path=" + path)) +
		((domain == null) ? "" : ("; domain=" + domain)) +
		((secure == true) ? "; secure" : "");
}

//打印
function printDOC() {
	var hkey_root,hkey_path,hkey_key;
	hkey_root="HKEY_CURRENT_USER";
	hkey_path="\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
	try{
	  var RegWsh = new ActiveXObject("WScript.Shell") ;
	  hkey_key="header" ;
	  RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"") ;
	  hkey_key="footer" ;
	  RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"") ;
	  }
    catch(e) {
    }
	window.print();
}
//打印按钮
function printBtn() {
	document.all.WEB_PVX.printing.Print(true);
//	window.print();
}

//打印预览
function privewDOC() {
	var hkey_root,hkey_path,hkey_key;
	hkey_root="HKEY_CURRENT_USER";
	hkey_path="\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
	try{
	  var RegWsh = new ActiveXObject("WScript.Shell") ;
	  hkey_key="header" ;
	  RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"") ;
	  hkey_key="footer" ;
	  RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"") ;
	  }
    catch(e) {
    }
	var obj = document.all.WebBrowser;
 	obj.ExecWB(7,1);
}

//打印预览按钮
function privewBtn() {
	var printObj = document.getElementById("WEB_PVX");
	try {
		var printViewModelSetObj = document.getElementById("printViewModelSet");
		if(printViewModelSetObj) {
			var setObj = jsonToObject(printViewModelSetObj.value);
			if(setObj != null) {
				if(setObj.portrait != null) printObj.printing.portrait = setObj.portrait == "ZX"; //横向 false; 纵向 true;
			}
		}
    } catch(e) {
    }
//  printObj.printing.header = "This is 页眉";
//    printObj.printing.footer = "Printing by ScriptX This is 页脚";
//    printObj.printing.portrait = false;		//横向 false; 纵向 true;
//    printObj.printing.leftMargin = 5.0;
//    printObj.printing.topMargin = 50.0;
//    printObj.printing.rightMargin = 5.0;
//    printObj.printing.bottomMargin = 5.0;
    printObj.printing.Preview(); 
}

function writeQuickIdeaDefault() {
	var ideaTextObj = $("ideaText");
	var quickIdeaListObj = $("quickIdeaList");
	if (quickIdeaListObj == null || ideaTextObj == null) return ;
    //add 赵健 审批表单时，审批页面带有快捷意见，例如，选择了快捷意见，并做修改，点【保存】按钮后，无效。修改的意见，保存不上 start
    if (ideaTextObj.value != "") return;
    //add 赵健 审批表单时，审批页面带有快捷意见，例如，选择了快捷意见，并做修改，点【保存】按钮后，无效。修改的意见，保存不上 end
    if (quickIdeaListObj.length == 0) return ;
	var count = document.all.quickIdeaList.length;
	for (var i = 0; i < count; i++) {
		if (quickIdeaListObj.options[i].value == 1) {
			ideaTextObj.value = quickIdeaListObj.options[i].text;
			quickIdeaListObj.selectedIndex = i;
			break;
		}
	}
}

function writeQuickIdea() {
	var ideaTextObj = $("ideaText");
	var quickIdeaListObj = $("quickIdeaList");
	if (quickIdeaListObj == null || ideaTextObj == null) return ;
	var selectedItem = quickIdeaListObj.selectedIndex;
	if (selectedItem == -1) return ;
	if (quickIdeaListObj.value == "WONoSelectionString") {
		ideaTextObj.value = '';
	} else {
		ideaTextObj.value = quickIdeaListObj.options[selectedItem].text;
	}
}

function showQueryArea() {
	var queryAreaObj = $("queryArea");
	var quickQueryStateObj = $("quickQueryState");
	queryAreaObj.style.display = "none";
	quickQueryStateObj.value = "display:none";
	if (queryAreaObj.style.display == "none") {
		queryAreaObj.style.display = "";
		quickQueryStateObj.value = "";
	}
}

function getFrameHeight() {
	var obj = $("msgFrame");
	if (obj == null || obj.style == undefined) return;
	var formHeight = document.body.clientHeight;
	obj.style.height = formHeight - 210;
	obj = $("bgImg");
	if (obj != null && obj.style != undefined) {
		obj.width = document.body.clientWidth;
		obj.height = document.body.clientHeight;
	}
}

var hrefBaseValue = null;

//编辑器文件下载
function downloadFile(downloadSrc, uploadFileName) {
	var obj = document.getElementById("downloadLnk");
	if (hrefBaseValue == null) hrefBaseValue = obj.href;
	obj.href = hrefBaseValue + "?downloadSrc=" + downloadSrc + "&fileName=" + encodeURI(uploadFileName);
	obj.target = "_blank";
	obj.click();

}

//对于HTML编辑部品，打开窗口画面
function openW(elementName){
	if (eWebEditor == null) return;
	if(eWebEditor.contentWindow){
		eWebEditor.contentWindow.dialogOpen_formInsert(elementName);
	}else{
		eWebEditor.dialogOpen_formInsert(elementName);
	}
}

//替换字符串中全部包含内容
function replaceStr(str, findKey, replaceKey) {
	if (str == null || findKey == null) return str;
	var site = str.indexOf(findKey);
	while (site > -1) {
		str = str.substring(0, site) + replaceKey + str.substring(site + findKey.length);
		site = str.indexOf(findKey);
	}
	return str;
}

//去除主机地址
function removeLocationAddress(html) {
	var hostAdd = window.location.protocol + "//" + window.location.host;
	var findSite = html.indexOf(hostAdd);
	while(findSite > -1) {
		html = html.substring(0, findSite) + html.substring(findSite + hostAdd.length);
		findSite = html.indexOf(hostAdd);
	}
	return html;
}

//***********************************
// 一些通用 方法
//***********************************

//创建下拉列表的一个子项
function createOption(s, txt, v) {
	if(!s || s.options == null) return ;
	if (txt == null && v == null) return ;
	v = v == null ? txt : v;
	s.options.add(new Option(txt, v));
}

// 基本信息提示，得到焦点并选定
function baseAlert(theText, notice){
	if(notice) alert(notice);
	try {
		theText.focus();
		theText.select();
    } catch(e) {
    }
	return false;
}
function loadIFrameContent() {
	var frameSectionObj = document.getElementById("frameSection");
	if (frameSectionObj == null) return;
	var frmValueObj = document.getElementById("frmValue");
	if (frmValueObj == null) return;
	var obj = document.frames["frameSection"].document;
	obj.open();
	obj.write(frmValueObj.value);
}

//给页面OnLoad增加执行方法
function addLoadEvent(func) {
	if (document.all) { //IE浏览器分支
		window.attachEvent("onload", func);
	} else {  //非IE浏览器分支
		window.addEventListener("load", func, false);
	}
}

//******************************************
//		提醒设置		BGN
//******************************************

function awokeSettingLoad() {
	var changeObj = "";
	var popUpSelect = "";
	var sectIndex = "";
	var state1 = "";
	var state2 = "";
	var obj1 = "";
	var obj2 = "";
	try {
		if(document.all.beforeCheck.checked){
			changeObj = document.getElementById("beforeSetting");
			changeObj.style.display = "";	
			
		        popUpSelect = document.getElementById("beforeSelect");	
			sectIndex = popUpSelect.selectedIndex;
			if (sectIndex == 0) {
				state1 = "none";
				state2 = "none";
			} else if (sectIndex == 1) {
				state1 = "";
				state2 = "none";
			} else if (sectIndex == 2) {
				state1 = "none";
				state2 = "";
			}
			obj1 = document.getElementById("before1");
			obj2 = document.getElementById("before2");
			obj1.style.display = state1;		
			obj2.style.display = state2;			
		}
	} catch(ex) {
	}
	try {
		if(document.all.endCheck.checked){
			changeObj = document.getElementById("endSetting");
			changeObj.style.display = "";	
				
		        popUpSelect = document.getElementById("endSelect");	
			sectIndex = popUpSelect.selectedIndex;
			if (sectIndex == 0) {
				state1 = "none";
				state2 = "none";
			} else if (sectIndex == 1) {
				state1 = "";
				state2 = "none";
			} else if (sectIndex == 2) {
				state1 = "none";
				state2 = "";
			}
			obj1 = document.getElementById("end1");
			obj2 = document.getElementById("end2");
			obj1.style.display = state1;		
			obj2.style.display = state2;			
		}
	} catch(ex) {
	}
	try {
		if(document.all.beyondCheck.checked){
			changeObj = document.getElementById("beyondSetting");
			changeObj.style.display = "";		
				
		        popUpSelect = document.getElementById("beyondSelect");	
			sectIndex = popUpSelect.selectedIndex;
			if (sectIndex == 0) {
				state1 = "none";
				state2 = "none";
			} else if (sectIndex == 1) {
				state1 = "";
				state2 = "none";
			} else if (sectIndex == 2) {
				state1 = "none";
				state2 = "";
			}
			obj1 = document.getElementById("beyond1");
			obj2 = document.getElementById("beyond2");
			obj1.style.display = state1;		
			obj2.style.display = state2;			
		}
	} catch(ex) {
	}
}

//******************************************
//		提醒设置
//******************************************

function settingChange (categoryName) {
	var checkboxChange = "";
	if (categoryName == "beforeSetting") {
		checkboxChange = document.getElementById("beforeCheck");
	} else if (categoryName == "endSetting") {
		checkboxChange = document.getElementById("endCheck");
	} else if (categoryName == "beyondSetting") {
		checkboxChange = document.getElementById("beyondCheck");
	}
	var playState = "";
	if (checkboxChange.checked) {
		playState = "";	
	} else {
		playState = "none";
	}
	var changeObj = document.getElementById(categoryName);
	changeObj.style.display = playState;		
}

function awokeCategorySelect(awokeCategory) {
	var selectObjName = "";
	var obj1 = "";
	var obj2 = "";
	if (awokeCategory == "before") {
		selectObjName = "beforeSelect";
		obj1 = document.getElementById("before1");
		obj2 = document.getElementById("before2");
	} else if (awokeCategory == "end") {
		selectObjName = "endSelect";
		obj1 = document.getElementById("end1");
		obj2 = document.getElementById("end2");
	} else if (awokeCategory == "beyond") {
		selectObjName = "beyondSelect";
		obj1 = document.getElementById("beyond1");
		obj2 = document.getElementById("beyond2");
	}
	var popUpSelect = document.getElementById(selectObjName);	
	var sectIndex = popUpSelect.selectedIndex;
	var state1 = "";
	var state2 = "";
	if (sectIndex == 0) {
		state1 = "none";
		state2 = "none";
	} else if (sectIndex == 1) {
		state1 = "";
		state2 = "none";
	} else if (sectIndex == 2) {
		state1 = "none";
		state2 = "";
	}
	obj1.style.display = state1;		
	obj2.style.display = state2;			
}

//******************************************
//		提醒设置		END
//******************************************

//在当前页面创建Input节点
function creatInputElement(type, name) { 
	var inputObj = document.createElement("input");
	inputObj.type = type;
	inputObj.name = name;
	return inputObj;
}

//未设置的返回 ""
function convertUndefinToStr(o) {
	if (typeof(o) == "undefined") return "";
	if (o == null) return "";
	return o;
}

//获得节点页面的显示位置 横坐标
function getObj_OffSetLeft(obj) {
    var set = 0;
	if (obj.offsetParent){
		set += obj.offsetLeft + getObj_OffSetLeft(obj.offsetParent);
	}
	if (obj.tagName.toUpperCase()!= "BODY"){
		var x = parseInt(obj.scrollLeft,10);
		if(!isNaN(x)) set -= x;
	}
    return set;
}

//获得节点页面的显示位置 纵坐标
function getObj_OffSetTop(obj) {
    var set = 0;
	if (obj.offsetParent){
		set += obj.offsetTop + getObj_OffSetTop(obj.offsetParent);
	}
	if (obj.tagName.toUpperCase()!= "BODY"){
		var y = parseInt(obj.scrollTop,10);
		if(!isNaN(y)) set -= y;
	}
    return set;
}

//判断str 是否是 以 findStr 结尾
function endWith(str, findStr) {
	if(str == null || findStr == null || findStr == "") return true;
	findStr += ""; 
	if(str.length < findStr.length) return false;
	str = str.substring((str.length - findStr.length), str.length);
	return str.indexOf(findStr) == 0;
}
//1203专用
function changeCompany(obj) {
	var nIndex = obj.selectedIndex;
	if (nIndex == -1) submitButton('COMPANY');
	if (obj.options[nIndex].text.indexOf("======") == 0) return ;
	submitButton('COMPANY');
}

//转入系统画面
function gotoSystemPage(urlValue, urlName) {
	if (urlValue == null) return ;
	parent.menu.actionPage(urlValue, urlName);
}

//******************************************
//		部门下拉列表设置
//******************************************

	//显示部门选择
//	changDeptShow(deptEmtName);


function changDeptShow(deptEmtName) {
	return false;
	var deptEmt = document.getElementById(deptEmtName);
	if (!deptEmt) return false;
	var deptShowEmt = document.getElementById(deptEmtName + "_showHtml");
	if (!deptShowEmt) return false;
	deptEmt.style.display = "none";
	deptShowEmt.style.display = "none";
	var showValueObj = document.getElementById(deptEmtName + "_showValue");
	if (!showValueObj) {
		showValueObj = document.createElement("Input");
		showValueObj.id = deptEmt.id + "_showValue";
		showValueObj.className = "InputStyle";
		showValueObj.readOnly = true;
		showValueObj.value = deptEmt.item(deptEmt.selectedIndex).text;
		deptEmt.parentNode.appendChild(showValueObj);
		showValueObj.onclick = function () {
			createEdptShowDiv(this);
		}
	}
	return true;
}

//创建部门选择区域
function createEdptShowDiv(deptShowValueObj) {
	var deptEmtId = deptShowValueObj.id.replace("_showValue", "");
	var deptEmt = document.getElementById(deptEmtId);
	if (!deptEmt) return false;
	var deptShowEmt = document.getElementById(deptEmtId + "_showHtml");
	if (!deptShowEmt) return false;

	var deptEmtDivObj = document.getElementById(deptEmtId + "_div");
	if (deptEmtDivObj) deptEmtDivObj.parentNode.removeChild(deptEmtDivObj);

	//区域
	deptEmtDivObj = initDeptShowDiv(deptShowValueObj);
	//内容
	var tableObj = getShowContentTableObj(deptShowEmt);
	deptEmtDivObj.appendChild(tableObj);
	return true;
}

//初始化显示区域
function initDeptShowDiv(deptShowValueObj) {

	var showPageW = 210; //宽度
	var showPageH = 250; //高度
	var Frs = 4;   //影子大小

	//显示的位置
	var Winw = document.body.offsetWidth;
	var Winh = document.body.offsetHeight;
	var scrollTop = document.body.scrollTop;

	showPageW = deptShowValueObj.getBoundingClientRect().right - deptShowValueObj.getBoundingClientRect().left;

	if (showPageW < 180) showPageW = 180;

	var left = deptShowValueObj.getBoundingClientRect().left;
	var top = deptShowValueObj.getBoundingClientRect().bottom + scrollTop;
	if (((left + showPageW + Frs) > Winw) && ((showPageW + Frs) < Winw)) {
		left = Winw - showPageW - Frs;
	}
	if (((scrollTop + Winh + showPageH + Frs) > 2 * Winh) && ((showPageH + Frs) < Winh)) {
		top = 2 * (Winh - showPageH - Frs);
	}
//	if (Winh + scrollTop - top < showPageH) showPageH = Winh + scrollTop - top - 5;
	if (Winh + scrollTop - top < showPageH) {
		if (Winh + scrollTop - top < 150) {
			top = deptShowValueObj.getBoundingClientRect().top + scrollTop - showPageH;
		}	 else {
			showPageH = Winh + scrollTop - top - 5;
		}
	}

	//区域
	var divObj = document.createElement("div");
	divObj.id = deptShowValueObj.id.replace("_showValue", "_div");
	document.body.appendChild(divObj);


	divObj.style.left = left + "px";
	divObj.style.top = top + "px";
	divObj.style.zIndex = 999;
	divObj.style.width = showPageW + "px";                     
	divObj.style.height = showPageH + "px";
	divObj.style.position = "absolute";
	divObj.style.overflowY = "auto";
	//区域边框
	divObj.style.borderWidth = "1px";
	divObj.style.borderStyle = "solid";
	divObj.style.borderColor = "#91c0e3";
	//区域背景
	divObj.style.background = "#fff";

	divObj.setAttribute("show", "show");
	divObj.style.display = "";

	divObj.onmouseover = function () {
		divObj.setAttribute("show", "show");
	};
	divObj.onmouseout = function () {
		divObj.setAttribute("show", "");
		setTimeout(
			function () {
				if (divObj.getAttribute("show") == "show") return false;
				divObj.style.display = "none";
			},
			1000
		);
	};

	return divObj;
}

function getShowContentTableObj(deptShowEmt) {
	var tableObj = document.createElement("table");
	tableObj.width = "100%";
	var count = deptShowEmt.options.length;
	if (count == 0) return tableObj;
	for (var i = 1; i < count; i++) {
		var eoOpt = deptShowEmt.options[i];
		var parentid = eoOpt.getAttribute("parentdeptid");
		var tr = tableObj.insertRow(i-1);
		tr.height = "18px";
		tr.style.cursor = "pointer";
		tr.style.backgroundColor = "#e4f0f9";
		tr.setAttribute("parentid", parentid);
		tr.setAttribute("deptid", eoOpt.value);
		if (parentid != "0" && parentid != "ROOT") tr.style.display = "none";
		var td = tr.insertCell(0);
		if (hasDownDept(deptShowEmt, eoOpt.value)) {
			td.innerHTML = deptRightImg;
			td.id = eoOpt.value;
			td.setAttribute("show", "");
			td.onclick = function () {
				selectDivShowDownDept(this);
			}
		}
		td = tr.insertCell(1);
		td.innerHTML = eoOpt.text;
		td.setAttribute("value", eoOpt.value)
		td.onclick = function () {
			selectDivShowDept(this);
		}
	}
	return tableObj;
}

//判断此部门是否有下级部门
function hasDownDept(deptShowEmt, deptId) {
	//第一级部门总是打开
	if (deptId == "ROOT") return false;
	var count = deptShowEmt.options.length;
	for (var i = 1; i < count; i++) {
		var eoOpt = deptShowEmt.options[i];
		var parentid = eoOpt.getAttribute("parentdeptid");
		if (parentid == deptId) return true;
	}
	return false;
}

//选择部门显示下级部门
function selectDivShowDownDept(tdObj) {
	var showFlg = (tdObj.getAttribute("show") == "");
	var tdHtml = showFlg ? deptDownImg : deptRightImg;
	var displayStr = showFlg ? "" : "none";
	tdObj.setAttribute("show", showFlg ? "none" : "");
	tdObj.innerHTML = tdHtml;
	var hiddenParentIdStr = ";" + tdObj.id + ";";
	var showTrAry = document.getElementsByTagName("tr");
	var count = showTrAry == null ? 0 : showTrAry.length;
	for (var i = 0; i < count; i++) {
		var trObj = showTrAry[i];
		var parentid = trObj.getAttribute("parentid");
		if (hiddenParentIdStr.indexOf(";" + parentid + ";") == -1) continue;
		trObj.style.display = displayStr;
		if (showFlg) continue;
		//隐藏时把所有子对象都隐藏，并且替换图片
		hiddenParentIdStr += trObj.getAttribute("deptid") + ";";
		if(trObj.firstChild.innerHTML == "") continue;
		trObj.firstChild.innerHTML = deptRightImg;
	}
}

//选择部门
function selectDivShowDept(tdObj) {
	var deptId = tdObj.getAttribute("value");
	var divObj = tdObj.parentNode.parentNode.parentNode.parentNode;
	var depEmtId = divObj.id.substr(0, divObj.id.length - 4);
	var showDeptObj = document.getElementById(depEmtId + "_showValue");
	showDeptObj.value = tdObj.innerHTML;
	var deptEmt = document.getElementById(depEmtId);
	deptEmt.value = deptId;
	try {
		deptEmt.onchange();
    } catch(ex) {
    }
	if (divObj) divObj.parentNode.removeChild(divObj);
//	divObj.setAttribute("show", "");
//	divObj.style.display = "none";
}

// 20120116 lihao 打开画面中带有链接的onclick方法
function actOpenWindowBtn(linkName,width,height) {
    //调整页面的 URL
    var hrefObj = document.getElementById(linkName);
    var strHrefUrl = hrefObj.href
    // lihao 20120625 不允许打开多个审批单
    openWindow(strHrefUrl, width, height, "traceWindow");
    
}

/* 
 * 附件部品向父画面显示添加的新的附件
 * fileNameList 要显示的文件名列表数组 
 * author: sissi 20120523
 * 
 */ 
function addFileByAttachment(fileNameList) {
	var obj = document.getElementsByName("FileList")[0];
	if (!obj) return false;
	//删除原来父窗口列表中的子项，需要保留第0项
	while(obj.length > 1) {
		obj.remove(1);
	}
	//如果当前窗口中没有子项，则父窗口的列表不显示
	if (fileNameList.length == 0) {
		obj.style.display = "none";
		return true;
	}
	obj.style.display = "";
	//拷贝当前窗口中的子项到父窗口
	for (var i = 0; i < fileNameList.length; i++) {
		var eItem = document.createElement ("OPTION");
		obj.options.add (eItem);
		eItem.innerHTML = fileNameList[i];
		eItem.value = i;
	}
	return true;
}

/* 
 * 用来遍历指定对象所有的属性名称和值 可以用于调试js代码时使用
 * obj 需要遍历的对象 
 * author: sissi 20120523
 * 
 */ 
function showAllPrpos(obj) { 
    // 用来保存所有的属性名称和值 
    var props = ""; 
    // 开始遍历 
    for(var p in obj){  
        // 方法 
        if(typeof(obj[p])=="function"){  
            obj[p](); 
        }else{  
        if (obj[p] != null)
            // p 为属性名称，obj[p]为对应属性的值 
            props+= p + "=" + obj[p] + "\n"; 
        }  
    }  
    // 最后显示所有的属性 
//    prompt("传入对象的属性包括：", props); 
    alert(props);
}

/**
 * 设置KEY-VALUE对应的形如MAP的对象
 * 
 * @param m_key key
 * @param m_value value
 *
 * @return map对象
 */
function createObject(m_key, m_value) {
	var obj = new Object();
	obj.k = m_key;
	obj.v = m_value;
	return obj;
}

/**
 * 字符串转为json对象
 * 
 * @param str JSON对象或数组的字符串
 *
 * @return 转换后的json对象
 */
function jsonStrToObject(str) {
	return jsonToObject(str);
}

/**
 * json对象转为字符串
 * 
 * @param obj JSON对象或数组
 *
 * @return 转换后的字符串
 */
function jsonObjectToString(obj) {
	var relationStr = jsonToString(obj);
	relationStr = relationStr.replace(/\\/g, "");
	relationStr = relationStr.replace(":\"[{", ":[{");
	relationStr = relationStr.replace("}]\"}", "}]}");
	//去除第一个和最后一个双引号
	relationStr = relationStr.substring(1, relationStr.length -1);
	return relationStr;
}

/**
 * 获取对象id值
 * @param obj 对象
 */
function getObjId(obj) {
    return getObjAttr(obj, "id");
}

/**
 * 获取对象属性
 * @param obj dom对象
 * @param attrName 属性名称
 */
function getObjAttr(obj, attrName) {
    if(obj) {
        return $(obj).attr(attrName);
    }
}

/**
 * 返回门户主页
 */
function returnPortal() {
	//取得topmenu的ifame对象，执行portal连接
	var objlistPage =parent.TopMenu.document;
	var gotoUrl = objlistPage.getElementById('portal').href;
	window.location.href =gotoUrl;
}

/**
 * 画面收藏
 */
function faveriatePage(functionId) {
    if (window.frames.length == parent.frames.length) {
        alert("Save failed!");
    }else{
        window.parent.faveriatePage(functionId);
        $(".collection1")[0].src = "/htoa/image/comm/BLUE/star_1.png";
    }

}

function portal_close() {
    var showDivObj;
    var menuObj = $("#portal_menu_temp");
    showDivObj = menuObj.children("div");
    showDivObj.stop().animate({'top':'-680px'}, 1000); // 向上滑动 - 隐藏
}


//跳转门户
function portalClick(portalIndexId, oaappWebPath) {
    var myUserId= window.parent.userId;
    var myEndPoint =window.parent.endPointTop; 
    if (portalIndexId == "DEFAULT_DESKTOP_JSP") {
        window.parent.location = oaappWebPath + "jsp/portalMid.jsp?portalIndexId=" + portalIndexId;
    } else {
        window.parent.desktop.location = oaappWebPath + "jsp/portalMid.jsp?portalIndexId=" + portalIndexId;
    }
    window.parent.saveDefaultPortal(portalIndexId,myUserId);

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
 * 审批浏览页面打开jsp画面
 * @param linkName
 * @param openJspValue 打开的jsp画面
 */
function checkOpenAppWin(indexId, openJspValue) {
    var strHrefUrl = openJspValue + "?traceInstanceIndexId=" + indexId;
    var href = window.location.href;
    href = href.substring(0, href.indexOf("WebObjects"))
    strHrefUrl = href + strHrefUrl;
    openWindow(strHrefUrl, window.screen.availWidth, window.screen.availHeight, "");
}

/**
 * 审批打开画面关闭
 */
function traceWinClose() {
	try {
    if (window.opener != null) {
        if (window.opener.document.getElementById("actForm") != null) {
            window.opener.document.getElementById("actForm").submit();
        } else {
            window.opener.location.reload();
        }
    }
	}catch(e){

	}
    window.close();
}
//蓝页面鼠标悬浮按钮变白
function bt_over(bt) {
    var imgs = bt.getElementsByTagName("img");
    var bton = bt.getElementsByTagName("input");
    bton.item(0).style.backgroundImage = "url(/htoa/image/comm/"+style+"/wt_mid_border.png)";
    imgs.item(0).src = "/htoa/image/comm/"+style+"/wt_left_border.png";
    imgs.item(1).src = "/htoa/image/comm/"+style+"/wt_right_border.png";
}
 //蓝页面鼠标移出按钮恢复
function bt_out(bt) {
    var imgs = bt.getElementsByTagName("img");
    var bton = bt.getElementsByTagName("input");
    bton.item(0).style.backgroundImage = "url(/htoa/image/comm/"+style+"/middle_small_btn.png)";      
    imgs.item(0).src = "/htoa/image/comm/"+style+"/left_border.png";
    imgs.item(1).src = "/htoa/image/comm/"+style+"/right_border.png";
}
var buttonObj;
function big_button_over(obj) {
    try {
        buttonObj = obj;
        hiddenDic();
    } catch(e) {
    a = obj.getElementsByTagName("img");
    vspan = obj.getElementsByTagName("span");
    a[0].src ="/htoa/image/comm/"+style+"/left_big_btned.png";
    a[1].src = "/htoa/image/comm/"+style+"/right_big_btned.png";
    b = obj.getElementsByTagName("input");
    b[0].style.color = "#ffffff";
    b[0].style.backgroundImage = "url(/htoa/image/comm/"+style+"/middle_big_btned.png)"
    vspan[0].style.backgroundImage = "url(/htoa/image/comm/"+style+"/middle_big_btned.png)"
    }
}
function big_button_out(obj) {
    a = obj.getElementsByTagName("img");
    vspan = obj.getElementsByTagName("span");
    
    a[0].src = "/htoa/image/comm/"+style+"/left_big_btn.png";
    a[1].src = "/htoa/image/comm/"+style+"/right_big_btn.png";
    b = obj.getElementsByTagName("input");
    b[0].style.color = "#7c7c7c";
    b[0].style.backgroundImage = "url(/htoa/image/comm/"+style+"/middle_big_btn.png)"
    vspan[0].style.backgroundImage = "url(/htoa/image/comm/"+style+"/middle_big_btn.png)"
    
}

function ch() {
    hiddenPageSelectUlFlg = true;
    document.getElementById("select_ul").style.display = "none";
    b = document.getElementById("select");
    b.style.border = "0px solid #D8D8D8";
    b.style.background = "#ffffff";
    c = document.getElementById("button_select");
    c.style.background = "url(/htoa/image/comm/"+style+"/select.gif)";
    document.getElementById("image1").src = "/htoa/image/comm/"+style+"/write.gif";
    document.getElementById("image2").src = "/htoa/image/comm/"+style+"/write.gif";
    var pageStr = $("#yema").html();
    var currentPage = pageStr.split("/");
    document.getElementById("currentPageNumber").value = currentPage[0];
    $("#goBtn").click();
//    document.getElementById("goBtn").click();
    //document.getElementsByTagName("form")[0].submit();
}

function over(obj) {// alert(obj)
    //	obj.style.background="#DDF0FE"
}
function out(obj) {
    //	obj.style.background="#ffffff"
}

function enter(obj) {
    if (isFirefox = navigator.userAgent.indexOf("Firefox") > 0) {
        var a = document.getElementById("yema").textContent;
        document.getElementById("yema").textContent = obj.textContent;
        var image = document.getElementById("select_ul").getElementsByTagName("img");

        for (var i = 0; i < image.length; i++) {
            image[i].src = "/htoa/image/comm/"+style+"/block_w.gif";
        }
        obj.getElementsByTagName("img")[0].src = "/htoa/image/comm/"+style+"/block_b.gif";

        //if (obj.textContent == "1/12") {
        //    document.getElementById("image_last").src = "/htoa/image/CN/BLUE/last.png";
        //    document.getElementById("image_next").src = "/htoa/image/CN/BLUE/next.png";
        //}
        //else if (obj.textContent == "12/12") {
        //    document.getElementById("image_last").src = "/htoa/image/CN/BLUE/b_last2.png";
        //    document.getElementById("image_next").src = "/htoa/image/CN/BLUE/b_next2.png";
        //}
        //else {
        //    document.getElementById("image_last").src = "/htoa/image/CN/BLUE/b_last2.png";
        //    document.getElementById("image_next").src = "/htoa/image/CN/BLUE/next.png";
        //}
    }
    else {
        var a = document.getElementById("yema").innerText;
        document.getElementById("yema").innerText = obj.innerText;
        var image = document.getElementById("select_ul").getElementsByTagName("img");

        for (var i = 0; i < image.length; i++) {
            image[i].src = "/htoa/image/comm/"+style+"/block_w.gif";
        }
        obj.getElementsByTagName("img")[0].src = "/htoa/image/comm/"+style+"/block_b.gif";

        //if (obj.innerText == "1/12") {
        //    document.getElementById("image_last").src = "/htoa/image/CN/BLUE/last.png";
        //    document.getElementById("image_next").src = "/htoa/image/CN/BLUE/next.png";
        //}
        //else if (obj.innerText == "12/12") {
        //    document.getElementById("image_last").src = "/htoa/image/CN/BLUE/b_last2.png";
        //    document.getElementById("image_next").src = "/htoa/image/CN/BLUE/b_next2.png";
        //}
        //else {
        //    document.getElementById("image_last").src = "/htoa/image/CN/BLUE/b_last2.png";
        //    document.getElementById("image_next").src = "/htoa/image/CN/BLUE/next.png";
        //}
    }

}

function change() {
    hiddenPageSelectUlFlg = false;
    a = document.getElementById("select_ul");
    a.style.display = "block";
    a.style.background = "#ffffff";
    b = document.getElementById("select");

//    b.style.background = "url(/htoa/image/comm/"+style+"/mid_border.png)";
    b.style.background = "url(/htoa/image/comm/"+style+"/middle_small_btn.png)";

    c = document.getElementById("button_select");
//    c.style.background = "url(/htoa/image/comm/"+style+"/select.gif)";
    c.style.background = "url(/htoa/image/comm/"+style+"/select.png)";

    document.getElementById("image1").src = "/htoa/image/comm/"+style+"/left_border.png";
    document.getElementById("image2").src = "/htoa/image/comm/"+style+"/right_border.png";
    clickPageRunning = "show";

}

function last() {
    var image = document.getElementById("select_ul").getElementsByTagName("img");
    for (var i = 0; i < image.length; i++) {
        str = image[i].src;
        a = str.substr(str.length - 11);
        if (a == "block_b.gif" && i !== 0) {

            enter(image[i - 1].parentNode);
            ch();
            break;
        }
        else if (a == "block_b.gif" && i == 0) {
            alert("已经到了第一页");

        }
    }


}
function nextw() {
    var image = document.getElementById("select_ul").getElementsByTagName("img");
    for (var i = 0; i < image.length; i++) {
        str = image[i].src;
        a = str.substr(str.length - 11);
        if (a == "block_b.gif" && i !== (image.length - 1)) {

            enter(image[i + 1].parentNode);
            ch();
            break;
        }
        else if (a == "block_b.gif" && i == (image.length - 1)) {
            alert(suredelete);

        }

    }

}

/**
 * OaPutptTabButton部品 tab页切换JS方法
 * 2015-02-06 qiaoguoyu 新增
 * @param index  当前点击的tab页
 */
function selectTab(index) {
    var tabBtnLength =  $(".tab_btn_div").length;
    $(".tab_btn_div").each(function(i){
        var btnDiv = $(this).children();
        if(btnDiv.length == 3) {
            if(i==index) {
                $(btnDiv[0]).attr("class", "tab_btn_sel_left");
                $(btnDiv[1]).attr("class", "tab_btn_sel");
                $(btnDiv[2]).attr("class", "tab_btn_sel_right");
            } else if(i == 0) {
                $(btnDiv[0]).attr("class", "tab_btn_left");
                $(btnDiv[1]).attr("class", "tab_btn");
                $(btnDiv[2]).attr("class", "tab_btn_middle");
            } else if(i == tabBtnLength - 1) {
                $(btnDiv[0]).attr("class", "tab_btn_middle");
                $(btnDiv[1]).attr("class", "tab_btn");
                $(btnDiv[2]).attr("class", "tab_btn_right");
            } else {
                $(btnDiv[0]).attr("class", "tab_btn_middle");
                $(btnDiv[1]).attr("class", "tab_btn");
                $(btnDiv[2]).attr("class", "tab_btn_middle");
            }
        }
    });
}


function repeat_table_init() {
    if (document.getElementById("button_middle") != null) {
        select_tab(1);
    }
    if (document.getElementById("repeat_table") != null) {
        row_color();
    }
    if (document.getElementById("repeat_table2") != null) {
        row_color2();
    }
    //if(document.getElementById("nav_left")!=null){select_nav(3);}        画面内嵌套小菜单样式再各自画面单独处理  2015-02-02   ty
     //resizeHeight();
}
/**
 * 当改变画面尺寸时执行方法
 *
 * 用于控制滚动条的显示及菜单的显示位置
 */
$(window).resize(function(){
        resizeHeight();
});
/**
 * 根据画面尺寸控制滚动条显示长度
 *
 */
function resizeHeight() {
	var scrollBoxHeight = $(window).height(); // $(window).height() document.documentElement.clientHeight;
    if($(".scroll_box_1")!=null){
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
try {       
       // var ttop = $(".scroll_box_1").offset().top;       
        var scrollHeight;
        if (ieFlg == "IE8") {
            scrollHeight = scrollBoxHeight - 80;
        } else if (ieFlg == "IE9") {
            scrollHeight = scrollBoxHeight- 50;
        } else if (ieFlg == "IE10") {
            scrollHeight = scrollBoxHeight - 70;
        } else if (ieFlg == "IE11") {
            scrollHeight = scrollBoxHeight - 50;
        } else if (window.navigator.userAgent.indexOf("Firefox") > 0) {
            scrollHeight = scrollBoxHeight - 60;
         } else if (window.navigator.userAgent.indexOf("Safari") > 0) {
                scrollHeight = scrollBoxHeight-30;
        } else {
            scrollHeight = scrollBoxHeight - 50;
        }
        $(".scroll_box_1").css("height", scrollHeight);
        obj = $(".scroll_box_1")[0];
	if(obj.scrollHeight>obj.clientHeight||obj.offsetHeight>obj.clientHeight){ 
         $(".scroll_box_1").css("height", scrollHeight-20);
  	} 
    } catch(ex) {
    }  
}   
//    if($(".scroll_box_3")!=null){
//    try {
//		var ttop = $(".scroll_box_3").offset().top;
//		$(".scroll_box_3").css("height", scrollBoxHeight-ttop-40);
//        } catch(ex) {
//        }
//   }
}
/**
 * 根据画面尺寸控制滚动条显示长度
 *
 */
function resizeWidth(v) {
        v = v-20;
    $(".scroll_box_1").css("width", v+2);
    $(".R_clumn_1_box").css("width", v);
    $(".middle-content").css("width", v);
    try {
        resizeWidthView();
        } catch(ex) {
      }
}


 // 表格奇偶行背景色
function row_color(){
    var table1=document.getElementById("repeat_table");
    var Ptr=table1.getElementsByTagName("tr");
    for (var i=1;i<Ptr.length+1;i++) {
        $(Ptr[i-1]).addClass((i%2>0)?"tt2":"tt1");
    }
    for(var i=0;i<Ptr.length;i++) {
        Ptr[i].onmouseover=function(){
//        this.tmpClass=this.className;
//        this.className = "tt3";
            $(this).addClass("tt3");
          }
        Ptr[i].onmouseout=function(){

            $(this).removeClass("tt3");
//        this.className=this.tmpClass;
        };
    }

   }
function row_color2(){
    var table1=document.getElementById("repeat_table2");
    var Ptr=table1.getElementsByTagName("tr");
    for (var i=1;i<Ptr.length+1;i++) {
        Ptr[i-1].className = (i%2>0)?"tt2":"tt1";
    }
    for(var i=0;i<Ptr.length;i++) {
        Ptr[i].onmouseover=function(){
        this.tmpClass=this.className;
        this.className = "tt3";
          }
        Ptr[i].onmouseout=function(){
        this.className=this.tmpClass;
        };
    }

   }

//标签点击变化
function select_tab(n){
  a=document.getElementById("button_middle").getElementsByTagName("img");
	b=document.getElementById("button_middle").getElementsByTagName("input");
    e=document.getElementById("button_middle").getElementsByTagName("div");
    for(i=0;i<a.length;i++){
		a[i].src="htoa/image/CN/BLUE/select_background.png";
}
		a[0].src="htoa/image/CN/BLUE/selected_no_left.png";
		a[a.length-1].src="htoa/image/CN/BLUE/selected_no_right.png";
		for(j=0;j<b.length;j++){
		b[j].style.color="#555555";
		b[j].style.background="url(htoa/image/CN/BLUE/selected_no_middle.png)";
		}
	c=e[n].getElementsByTagName("img");
	c[0].src="htoa/image/CN/BLUE/selected_left.png";
	c[1].src="htoa/image/CN/BLUE/selected_right.png";
	d=e[n].getElementsByTagName("input");
	d[0].style.color="#ffffff";
	d[0].style.background="url(htoa/image/CN/BLUE/selected_middle.png)";
}

//左导航选择变色
function select_nav(n){
     var table = document.getElementById("nav_left");
     var Ptr = table.getElementsByTagName("td");
     var thisTr= document.getElementById("td"+n);
     for(var i = 0;i < Ptr.length; i++){
        Ptr.item(i).className = "tt1";
     }
    thisTr.className = "tt4";
}

function submitButton(linkType) {
	$("#functionName").val(linkType);
	$("form#actForm").submit();
}
/** 文件上传部品使用方法 add by JiangLiye20150304 start*/
function uploadSubmit(obj) {
    var textFileId = obj.id + "_text";
    $("#" + textFileId).val(obj.value);
}
/** 文件上传部品使用方法 add by JiangLiye20150304 end*/
/**
 * 点击按钮左侧执行动作
 * @param obj 当前点击图片
 */
function clickBtnL(obj) {
    $(obj).next().find(":submit").click();
}
/**
 * 点击按钮右侧图片执行动作
 * @param obj  当前点击图片
 */
function clickBtnR(obj) {
    $(obj).prev().find(":submit").click();
}
/**
 * 点击按钮回到页面顶部 （论坛、日记、计划查看画面） add by  lihao  2015-04-27
 * @param obj  当前点击图片
 */

function changetotop() {
   document.getElementById("scroll_box_1").scrollTop = 0;
   //parent.document.documentElement.scrollTop = 0;
}

/**
 * 点击连接到页面底部 （论坛、日记、计划查看画面） add by  lihao  2015-04-27
 * @param obj  当前点击图片
 */

function changeToEnd() {
    try {
        document.getElementById("scroll_box_1").scrollTop = document.getElementById("scroll_box_1").offsetHeight;
        if (document.getElementById("bbs_out_div")) {
            document.getElementById("scroll_box_1").scrollTop = document.getElementById("bbs_out_div").offsetHeight;
        }
    } catch(e) {
    }
   
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
 * 隐藏顶部的“更多”菜单
 *
 */
function hiddenTopMoreMenu() {
	//取得桌面上的菜单域
//    var menuObj = $("#moreMenu", window.parent.desktop.document);
    var menuObj = $("#moreMenu");
	if (menuObj.length > 0) menuObj.hide();
}

