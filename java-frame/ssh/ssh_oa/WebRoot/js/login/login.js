var allowLogin = true;
var tdheight;
$(document).ready(function() {
    getTdHeight();
    getBrowser();
});

window.document.onkeydown = function(e) {
    var evt = e ? e : (window.event ? window.event : null);        //此方法为了在firefox中的兼容
    var keycode = evt.keyCode ? evt.keyCode : evt.which ? evt.which : evt.charCode;
    if (keycode == 13) {
        if (document.activeElement.type == "text" || document.activeElement.type == "password") {
            if (document.actForm.systemSort == null || document.actForm.systemSort.selectedIndex == 0) {
                submitButton('LOGIN');
            } else {
                webLogIn();
            }
        }
    }
}

function onLoad() {
    var userIdObj = document.getElementById("userId");
    if (userIdObj && userIdObj.value == "") {
        userIdObj.focus();
    } else {
        var userPwdObj = document.getElementById("userPwd");
        if (userPwdObj) userPwdObj.focus();
    }
    if (document.actForm.alertMsg.value != "") {
        alert(document.actForm.alertMsg.value);
        document.actForm.alertMsg.value = "";
    }
    if (document.actForm.confirmMsg.value != "") {
    	var str = document.actForm.confirmMsg.value;
        document.actForm.confirmMsg.value = "";
        if (confirm(str)) {
        	return submitButton('MAC');
    	}
    }
    getLanguage();
}

function getBrowser() {
    if ($.browser.msie) {
        $(".browesPosition").css("position", "absolute");
    } else {
        $("div").removeClass("browesPosition");
    }
}

function getTdHeight() {
    tdheight = $(window).height();
    $("#toptd").css('height', tdheight * 0.2);
    $("#tableheight").css('height', tdheight);
}

//取得风格
function getStyle(obj) {
    document.getElementById("useStyle").value = obj.id;
    submitButton('STYLE');
}

//取得多语言版本
function getLanguage() {
    //选中的语言级
    var oDiv1 = document.getElementById('l_y_y_1');
    //供选择的语言级 dl
    var oDiv2 = document.getElementById('l_y_y_2');

    if (oDiv2) {//20150702 隐藏了语言栏，此处需要做检验 xg
        //dd
        var aDd = oDiv2.getElementsByTagName('dd');
        var useLanguage = document.getElementById("useLanguage");
//    oDiv1.onclick = function()
        //    {
        //        $("#selectedLanguageSrc").hide();
        //        $("#selectedLanguage").hide();
        //        oDiv2.style.display = 'block';
        //    }
        for (var i = 0; i < aDd.length; i++)
        {
            aDd[i].index = i;
            aDd[i].onclick = function()
            {
                oDiv2.style.display = 'none';
                $("#selectedLanguageSrc").show();
                $("#selectedLanguage").show();
                useLanguage.value = this.id
                submitButton('languageType');
            }
        }
    }

}

//取得当前画面的高度
function getcontentHeight() {
    document.getElementById("Content").style.height = document.body.clientHeight - 20;
}

function submitButton(linkType) {
    if (!allowLogin) return onload();
    document.actForm.screenWidth.value = screen.availWidth;
    document.actForm.screenHeight.value = screen.availHeight;
    //取得Mac地址
    $("#macAddr").val(getMacAddr());
    writeCookie();
    if (!usbKey()) return false;
    document.actForm.functionName.value = linkType;
    document.actForm.submit();
}

function usbKey() {
    //处理KEY
    var hCard;
    try {
        hCard = htactx.OpenDevice(1);
    } catch(ex) {
        return true;
    }
    if (document.actForm.userPwd.value == "" || document.actForm.userId.value == "") {
        alert(login_name_password);
        return false;
    }
    try {
        htactx.VerifyUserPin(hCard, document.actForm.userPwd.value);
        var UserName = htactx.GetUserName(hCard);
        if (UserName != document.actForm.userId.value) {
            alert(login_wrong_name_password);
            htactx.CloseDevice(hCard);
            return false;
        }
        var Digest = "01234567890123456";
        Digest = htactx.HTSHA1(document.actForm.RandomData.value, document.actForm.nRndLen.value);
        Digest += "04040404";
        var EnData = htactx.HTCrypt(hCard, 0, 0, Digest, Digest.length);
        htactx.CloseDevice(hCard);
        document.actForm.RndData.value = EnData;
    } catch (ex) {
        alert(login_wrong_name_password);
        htactx.CloseDevice(hCard);
        return false;
    }
    return true;
}

//画面调用的弹出页的方法
function actOpenWindowBtn(linkName,width,height) {
    //调整页面的 URL
    var hrefObj = document.getElementById(linkName);
    var strHrefUrl = hrefObj.href
    openWindow(strHrefUrl, width, height, "traceWindow");

}
//弹出页跳转
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
	var varOption = "dependent,toolbar=no,location=no,status=yes,menubar=no,resizable=no,scrollbars=yes,"
				+ "width=" + pWidth + "px,height=" + pHeight + "px,left=" + pleft + "px,top=" + ptop + "px;";
	if(winName == null) winName = "newWindow";
    return window.open(url, winName, varOption);
}

//获得客户端Mac
function getMacAddr(){
	var s;
	try {
        s = getMacAddressActiveXValue();
        if (s == undefined) s = "******";
	} catch (ex) {
		s = "******";
	}
	return s;
}


//手机助手下载画面调用的弹出页的方法
function actOpenWindowBtn(linkName,width,height) {
    //调整页面的 URL
    var hrefObj = document.getElementById(linkName);
    var strHrefUrl = hrefObj.href
    openWindow(strHrefUrl, width, height, "traceWindow");

}
document.onload = setinter();
var curIndex = 0; 

function setinter(){
	inter = setInterval(alter, 2 * 1000);
}

function alter() {
	curIndex++;
	if (curIndex > 3) curIndex = 1;
	changeBanner(curIndex);
}

function pointBanner(bannerOrder) {
	changeBanner(bannerOrder);
	clearInterval(inter);
}

function changeBanner(bannerOrder) {
  var mStyle=  document.getElementById("useStyle").value ;
	for (var i = 1; i < 4; i++) {
		if (i == bannerOrder) {
			document.getElementById("bp" + i).src="js/login/images/bannerRed.gif";
		} else {
			document.getElementById("bp" + i).src="js/login/images/bannerGray.gif";
		}
	}
	document.getElementById("banner").src="js/login/images/banner" + bannerOrder + ".jpg";
	curIndex = bannerOrder;
}
function writeCookie() {
    var expdate = new Date();
    var str = "";
    var nIndex;
    str += document.actForm.userId.value;
    str += "|";
    str += $("#useStyle").val();
    str += "|";
    str += $("#useLanguage").val();
    str += "|";
    str += $("#useStyleType").val();
    str += "|";
    expdate.setTime(expdate.getTime() + 365 * (24 * 60 * 60 * 1000)); //+1 year
    SetCookie("htoa8000", str, expdate, "/");
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
function showMoreLanguageMenu(){
    if($("#l_y_y_2").is(":hidden")) $("#l_y_y_2").show();
    else  $("#l_y_y_2").hide();
}
