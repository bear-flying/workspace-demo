//******************************************************
// USER NAME			大连华天
// SYSTEM NAME		OA8000
// SUB SYSTEM NAME	COMMON COMPONENT
// FILE NAME			OaPubptPersonnelSelector.js
/**
* 窗口共通处理
* @AUTHOR	sissi
* @VERSION 	2004.10.18 新建
* @VERSION 	2012.11.22 sissi 修改 加入jquery支持，修改为6.0版
*/
//******************************************************
var m_name;
var m_showName;
var m_idList;
var openFlg = true;

/**
 * 点击选择按钮时，传入参数并打开新的窗口
 * 2014-07-30 qiaoguoyu 增加对单条信息的最大发送人数的限制
     * @param waitSelectIdList       待选择的用户范围
     * @param waitSelectDeptIdList   待选择的部门范围
     * @param nameElementId          存放选中用户姓名字符串隐含域ID
     * @param idNameElementId        存放选中用户ID和姓名对应字符串隐含域ID
     * @param idElementId            存放选中用户id字符串隐含域ID
     * @param hideAllFlg             是否隐藏全体用户
     * @param hideAllUserSelectFlg   是否隐藏从全体人员中选择人员
     * @param hideDeptUserSelectFlg  是否隐藏按部门选择人员
     * @param hideRoleUserSelectFlg  是否隐藏按岗位选择人员
     * @param hideGroupUserSelectFlg 是否隐藏按通讯组选择人员
     * @param hideDeptSelectFlg      是否隐藏部门选择
     * @param hideRoleSelectFlg      是否隐藏岗位选择
     * @param hideGroupSelectFlg     是否隐藏通讯组选择
     * @param includeHrAccount       是否包含HR用户 true 全部用户 false 不包括HR用户
     * @param noSelectShowTitle      选择空的时候显示的文字
     * @param allGroupFlag           是否选择集团用户 true 集团用户 false 子公司用户
     * @param showDefaultDeptFlg           是否显示默认部门
	 * @param defaultDeptId          默认部门Id
	 * @param isLimitUserCount       是否限制单条信息的最大发送人数
 */
function showSelectWindow(nameElementId, idNameElementId, idElementId, 
			waitSelectIdList,waitSelectDeptIdList,
			hideAllFlg, hideAllUserSelectFlg, 
			hideDeptUserSelectFlg, hideRoleUserSelectFlg, 
			hideGroupUserSelectFlg, hideDeptSelectFlg, 
			hideRoleSelectFlg, hideGroupSelectFlg,
			includeHrAccount,noSelectShowTitle,allGroupFlag,gotoUrlId,showDefaultDeptFlg,defaultDeptId, isLimitUserCount) {
	var gotoUrl = document.getElementById(gotoUrlId).href;
	showSelectWindowTrace(gotoUrl,nameElementId,idNameElementId,idElementId,waitSelectIdList,waitSelectDeptIdList,hideAllFlg,hideAllUserSelectFlg,hideDeptUserSelectFlg,hideRoleUserSelectFlg,hideGroupUserSelectFlg,hideDeptSelectFlg,hideRoleSelectFlg,hideGroupSelectFlg,includeHrAccount,noSelectShowTitle,allGroupFlag,showDefaultDeptFlg,defaultDeptId,isLimitUserCount);

}

/**
     * 点击选择按钮时，传入参数并打开新的窗口
     * 2014-07-30 qiaoguoyu 增加对单条信息的最大发送人数的限制
     * @param waitSelectIdList       待选择的用户范围
     * @param waitSelectDeptIdList   待选择的部门范围
     * @param nameElementId          存放选中用户姓名字符串隐含域ID
     * @param idNameElementId        存放选中用户ID和姓名对应字符串隐含域ID
     * @param idElementId            存放选中用户id字符串隐含域ID
     * @param hideAllFlg             是否隐藏全体用户
     * @param hideAllUserSelectFlg   是否隐藏从全体人员中选择人员
     * @param hideDeptUserSelectFlg  是否隐藏按部门选择人员
     * @param hideRoleUserSelectFlg  是否隐藏按岗位选择人员
     * @param hideGroupUserSelectFlg 是否隐藏按通讯组选择人员
     * @param hideDeptSelectFlg      是否隐藏部门选择
     * @param hideRoleSelectFlg      是否隐藏岗位选择
     * @param hideGroupSelectFlg     是否隐藏通讯组选择
     * @param includeHrAccount       是否包含HR用户 true 全部用户 false 不包括HR用户
     * @param noSelectShowTitle      选择空的时候显示的文字
     * @param allGroupFlag           是否选择集团用户 true 集团用户 false 子公司用户
     * @param showDefaultDeptFlg           是否显示默认部门
	 * @param defaultDeptId          默认部门Id
	 * @param isLimitUserCount       是否限制单条信息的最大发送人数
 */
function showSelectWindowTrace(gotoUrl,nameElementId, idNameElementId, idElementId, 
			waitSelectIdList,waitSelectDeptIdList,
			hideAllFlg, hideAllUserSelectFlg, 
			hideDeptUserSelectFlg, hideRoleUserSelectFlg, 
			hideGroupUserSelectFlg, hideDeptSelectFlg, 
			hideRoleSelectFlg, hideGroupSelectFlg,
			includeHrAccount,noSelectShowTitle,allGroupFlag,showDefaultDeptFlg,defaultDeptId,isLimitUserCount) {
	var varOption = getVarOption(nameElementId, idNameElementId, idElementId);
        gotoUrl += "?&nameElementId=" + nameElementId;
        gotoUrl += "&idNameElementId=" + idNameElementId;
        gotoUrl += "&idElementId=" + idElementId;
        gotoUrl += "&waitSelectIdList=" + waitSelectIdList;
        gotoUrl += "&waitSelectDeptIdList=" + waitSelectDeptIdList;
        gotoUrl += "&hideAllFlg=" + hideAllFlg;
        gotoUrl += "&hideAllUserSelectFlg=" + hideAllUserSelectFlg;
        gotoUrl += "&hideDeptUserSelectFlg=" + hideDeptUserSelectFlg;
        gotoUrl += "&hideRoleUserSelectFlg=" + hideRoleUserSelectFlg;
        gotoUrl += "&hideGroupUserSelectFlg=" + hideGroupUserSelectFlg;
        gotoUrl += "&hideDeptSelectFlg=" + hideDeptSelectFlg;
        gotoUrl += "&hideRoleSelectFlg=" + hideRoleSelectFlg;
        gotoUrl += "&hideGroupSelectFlg=" + hideGroupSelectFlg;
        gotoUrl += "&includeHrAccount=" + includeHrAccount;
        gotoUrl += "&noSelectShowTitle=" + noSelectShowTitle;
        gotoUrl += "&allGroupFlag=" + allGroupFlag;
		gotoUrl += "&showDefaultDeptFlg=" + showDefaultDeptFlg;
		gotoUrl += "&defaultDeptId=" + defaultDeptId;
		gotoUrl += "&isLimitUserCount=" + isLimitUserCount;
	window.open(gotoUrl, "selectorPersonWin", varOption);	
}

/**
     * 点设置窗口参数和公共参数
     *
     * @param nameElementId          存放选中用户姓名字符串隐含域ID
     * @param idNameElementId        存放选中用户ID和姓名对应字符串隐含域ID
     * @param idElementId            存放选中用户id字符串隐含域ID
 */
function getVarOption(nameElementId, idNameElementId, idElementId) {
	m_name = nameElementId;
	m_showName = idNameElementId;
	m_idList = idElementId;		
	//设置显示画面的样式
	var winWidth = window.screen.availWidth; 
	var winHeight = window.screen.availHeight;
	var pleft = (winWidth - 520) / 2;
	var ptop = (winHeight - 500) / 2;
	var varOption = "dependent,toolbar=no,location=no,status=no,menubar=no,resizable=no,scrollbars=no,width=625px,height=600px,left=" + pleft + ",top=" + ptop + ";";
	return varOption;
}
function test() {
	var gotoUrl = document.getElementById("gop").href
	showSelectWindowTrace(gotoUrl,"a","b","c","","",false,false,false,false,false,false,false,false,false,"f");
}