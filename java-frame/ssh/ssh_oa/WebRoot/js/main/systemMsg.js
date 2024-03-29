﻿//******************************************************
// USER NAME			大连华天
// SYSTEM NAME		OA8000
// SUB SYSTEM NAME	JS COMMON COMPONENT
// FILE NAME			systemMsg.js
/**
 * 窗口提交数据前的提示处理
 * @AUTHOR	sissi
 * @VERSION 	2004.08.03 新建
 */
//******************************************************

//常用标题及提示
//Modified by xiaogang 2011-12-31 
var title_system_send = "系统发送";
var title_exist_car = "此时段内，此车已被占用。继续申请？";


var online_people = "人";
var title_error_msg = "错误：";

var title_year = "年";
var title_month = "月";
var title_day = "日";
var title_day_style = "日";

var no_select = "不选";

var sort_asc = "升序";
var sort_desc = "降序";
var align_left = "左对齐";
var align_center = "居中";
var align_right = "右对齐";

var title_no_set = "未设置";

var title_select_please = "<<请选择>>";

var title_menu_expand = "展开菜单";
var title_menu_folded = "收起菜单";

var select_user_currentDept = "显示当前部门人员";
var select_user_currentInnerDept = "显示子部门人员";

var title_data_waiting = "正在提取数据...";
var title_deteFile = "确实要删除数据吗？";

var title_office_save_word = "是否要保存文档？";
var title_trace_save = "是否要保存流程？";

var title_insert_content = "请输入内容。";
var title_template_name = "请输入模板名称。";
var title_input_button_name = "请输入按钮名称。";

var title_addMindUser = "请设置加签人员。";
var title_set_insert_page = "请设置录入画面。";

var title_inputNumber = "请输入正确的数字。";

var title_field_name = "字段：";
var title_field_title_repeat = " 数据表字段设置重复。";
var title_field_type_not_right = " 与数据表原字段类型不符。";

var title_select_only_one = "此项操作只能选择一条数据。";
var title_select_no_select = "请选择数据行。";

var title_need_old_password = "请输入原密码";
var title_need_new_password = "请输入新密码";
var title_need_new_again_password = "请再次输入新密码";
var title_password_twos_not_right = "两次输入的新密码不同，请重新输入。";
var title_update_password_inner_key = "请插入KEY后再进行密码修改。";
var titel_user_or_password_error = "用户名或密码错误，请重新输入。";

var title_select = "选择";
var title_select_role = "岗位选择";
var title_select_user = "人员选择";
var title_select_dept = "部门选择";
var title_select_category = "选择类别";
var title_select_data_field = "数据字段选择";

var title_select_view = "请选择视图。";
var title_select_data = "请选择数据。";
var title_select_persons = "请选择人员。";
var title_select_city = "请选择区域。";
var title_CRM_selectClient = "请选择客户。";
var title_select_table_css = "请选择表格样式。";
var title_select_meeting_room = "请选择会议室。";
var title_select_meeting_resource = "请选择资源。";
var title_select_meeting_reserver = "请选择预订会议。";

var title_select_action_page = "请选择激活页面。";

var title_traceWait = "系统正在运行中，请等待……";

var title_input_process_name = "请输入另存流程的名称。";
var title_input_not_null_process_name = "流程名称不能为空。\n请输入另存流程的名称";

var title_select_show_field = "请选择显示字段。";
var title_all_datas = "所有数据";
var title_data_over_process = "流程已完成的数据";
var title_data_in_process = "流程未完成的数据";

var title_state_trace_select = "选择审批状态";
var title_state_trace_in = "审批中";
var title_state_trace_pass = "已通过审批";
var title_state_trace_no_pass = "未通过审批";
var title_state_back_to_start = "退文";  //update by chenwen at 20141225 增加退文汉字
var title_state_trace_doc = "归档";
var title_state_trace_no_submit = "未提交";

var title_inprotance_select = "选择重要度";
var title_inprotance_general = "一般";
var title_inprotance_important = "重要";
var title_inprotance_emergency = "紧急";

var title_onlineMark = "【在线】";//【Online】

var title_wrong_sqlServer = "SQL不正确。";
var title_wrong_lessTwo = "请确保您查询列在两个以上。";
var title_no_exit_table = "数据库不存在此表！";
var title_no_sqlServer = "没有输入SQL语句。";

var title_same_field_name = " 字段有重复定义，请检查。";
var title_templateContent = "请先定义模板内容。";

var title_insert_new_field = "插入新的字段";

var title_check_field_name = "字段名称仅能够使用字母和数字，且不能使用数字开头，请输入正确的字段名称。";
var title_check_list_table_name = "主表名称仅能够使用字母和数字，且不能使用数字开头，请输入正确的主表名称。";
var title_same_field_name_in_system = "定义的字段名称与系统字段相冲突，请重新定义。";
var title_same_table_name = "主表名称已经存在，请输入新的主表名称。";
var title_same_table_name_in_system = "主表名称为系统使用表名，请输入新的主表名称。";

var title_limite_upload_file_num = "您上传的文件数量超过了限制数: ";
var title_trace_open_exist = "当前已经存在打开的审批单，请先关闭审批窗口后再继续其他操作。";

var title_office_mainSend = "主  送：";
var title_office_copySend = "抄  送：";
var title_office_title = "主题词：";
var title_office_new_doc = "新文档.doc";
var title_office_no_file = "没有打开的文档。";
var title_office_save_error = "文档保存失败。";
var title_office_no_save_to_url = "不能保存到URL：";
var title_office_attachment_save_as = "附件另存为：";
var title_office_must_file_name = "您必须输入文件名！";
var title_office_add_mark_failed = "书签添加失败。\n";
var title_office_add_mark_success = "书签添加成功。";
var title_office_error_red_format = "套红出错。\n";
var title_office_no_in_edit_file = "您没有正在编辑的文档。";
var title_office_wrong_file_type = "无法取得要建立文件的类型。";
var title_office_select_red_format = "请选择要使用的套红格式。";
var title_office_no_exit_mark_name = "Word 模板中不存在书签名称：";
var title_office_select_insert_field = "请选择要插入域的字段";
var title_office_select_insert_range = "请先选择域值要插入的范围，然后在“请选择要插入域的字段”中选择要插入的字段后再点击该按钮。";

var title_stepProperties = "步骤基本属性";
var title_field_read_write_properties = "字段读写属性";
var title_jump_to = "跳转到";
var title_delStep = "删除该步骤";
var title_newStep = "新建步骤";
var title_add_over_node = "增加结束结点";
var title_add_free_node = "增加自由流程结点";
var title_no_select = "无选择";

var title_saveLayer = "保存布局";

var title_role_rank_larger = " 的岗位级别不能大于或等于其下级: ";
var title_role_rank_smaller = " 的岗位级别不能小于或等于其上级: ";

//邮件地址格式检验提示
var emailAddr_server_error = "邮件地址缺少邮件服务器域名。";
var emailAddr_serverName_error = "邮件地址服务器名部分填写不正确。";

//单点登录失败提示
var sso_login_error = "无法登录您所选择的系统。";

//弱密码不能保存提示
var can_not_save_weak_password = "不能保存强度为弱的密码";

//登录检验弹出窗口提示
var login_popwin_msg = "您打开了弹出窗口屏蔽功能，否则一些页面的功能可能不正常，\n 请通过IE设置允许本站点弹出窗口或者在首页点击“加入信任站点”。";


//文档中心的提示信息
var file_BatchDownLoad = "批量下载";
var file_DownLoad = "下载";
var file_DownLoadAll = "是否下载所选文件?";

//自定义流水号的提示信息
var title_autonum_selectTemplate = "请设置所选模板。";
var title_autonum_inputUserSetStyle = "请设置编号样式。";

var check_input_color = "提示：\n\n无效的颜色值！";

var title_selectedOneData = "当前操作仅能选择一条数据，请重新选择。";

var title_trace_no_form = "没有符合条件的表单。";

var title_COMMSELDbField = "请选择数据表字段";
var title_COMMSELFormField = "请选择关联字段";
var title_relation = "关联设置";

//add by 赵健 工作日程计划中，无回复提示
var no_reply_data = "暂无回复";
// add by JiangLiye:20120627 审批时只能打开一个审批单进行操作
var title_onlyone_trace = "当前已经存在打开的审批单，请先关闭审批窗口后才能够打开新的审批单继续审批。";
//2014-07-30 qiaoguoyu 增加对单条信息的最大发送人数的限制 start
var title_out_limit_count = "您选择的人数超出了限制：";

//增加对单条信息的最大发送人数的限制 END
// 对齐方式列表
var alignAry = new Array(
        new Array("默认值", ""),
        new Array("左对齐", "left"),
        new Array("居中", "center"),
        new Array("右对齐", "right")
        );
// 字体列表
var familyAry = new Array(
        new Array("默认值", ""),
        new Array("宋体", "宋体"),
        new Array("黑体", "黑体"),
        new Array("Arial", "Arial"),
        new Array("雅黑", "微软雅黑")
        );
// 字号列表
var sizeAry = new Array(
        new Array("默认值", ""),
        new Array("一号", "28pt"),
        new Array("二号", "21pt"),
        new Array("三号", "16pt"),
        new Array("四号", "14pt"),
        new Array("五号", "10pt"),
        new Array("六号", "7pt")
        );
// 对齐方式列表
var borderStyleAry = new Array(
        new Array("默认值", ""),
        new Array("实线", "solid"),
        new Array("嵌入", "inset"),
        new Array("凸线", "ridge"),
        new Array("凹线", "groove"),
        new Array("虚线", "dotted"),
        new Array("双线", "double"),
        new Array("开端", "outset"),
        new Array("破折号", "dashed")
        );
		

//删除数据前的提示
function deleteData() {
	var list = $("input[type='checkbox']");
	//sissi 20140709 增加删除前的选择数据行校验 start
	if (list.length > 0) {
		var findCheckFlg = false;
		for (var i = 0; i < list.length; i++) {
			if (list[i].checked) {
				findCheckFlg = true;
				break;
			}
		}
		if (!findCheckFlg) {
			alert("请选择数据行。");
			return false;
		}
	}
	//sissi 20140709 增加删除前的选择数据行校验 end
    if (confirm("确实要删除数据吗？")) submitButton("DELETE");
}

//删除数据前的提示，主要用于类别设置画面
//add by gucheng 2014-07-16
function deleteCategoryData() {
    if (confirm("确实要删除数据吗？")) submitButton("DELETE");
}

//sissi 20140709 增加：修改用户激活权限
function changeUserActive(recordNum) {
    if (confirm("确实要修改该用户的激活状态吗？")) submitButton("ACTIVE" + recordNum);
}

//邮件放入垃圾箱前的提示
function deleteEmail() {
    if (confirm("确实要将邮件删除吗？")) submitButton("WASTE");
}

//删除全部数据 
function deleteAllData() {
    if (confirm("确实要删除全部数据吗？")) submitButton("DELETEALL");
}

//对文件的操作
function deleteFile() {
    if (confirm("确实要删除所选文件或文件夹吗？")) submitButton("DELETE");
}


//删除会议纪要及会议
function deleteSummary() {
    if (confirm("确实要删除会议及纪要吗?")) submitButton("DELETESUMMARY");
}

//清空已删除邮件前的提示
function clearMail() {
    if (confirm("确实要删除全部已删除邮件吗？")) submitButton("DELETE");
}

//对论坛的操作--主贴
function deleteForumIndex() {
    if (confirm("确实要删除当前贴及全部跟贴吗？")) submitButton("DELETE");
}

//对回复的删除
function deleteForumDetail(site) {
    if (confirm("确实要删除当前回复吗？")) submitButton("DELETEDETAIL" + site);
}

//对投票的操作
function deleteVoting() {
    if (confirm("确实要删除当前投票吗？")) submitButton("DELETE");
}

//对日记的操作--主贴
function deleteDaily() {
    if (confirm("确实要删除当前日记及全部回复吗？")) submitButton("DELETE");
}

//对工作计划的操作--主贴
function deletePlan() {
    if (confirm("确实要删除当前计划及全部回复吗？")) submitButton("DELETE");
}

//对大事记的操作--主贴
function deleteEvent() {
    if (confirm("确实要删除当前事件及全部回复吗？")) submitButton("DELETE");
}

//收藏前的提示
function archiveData() {
    if (confirm("确实要将所选数据收藏吗？")) submitButton("ARCHIVE");
}

//车辆报废的操作
function scrapCar() {
    if (confirm("确认当前所选车辆要停用吗？")) submitButton("SCRAP");
}

//档案撤消借阅前的提示
function cancelBorrowData() {
    if (confirm("确实要撤消借阅吗？")) submitButton("CANCEL");
}

/**
 * 删除档案前的提示
 * qiaoguoyu at 2012.07.06 add
 * @param site 行号
 */
function deleteRecordData(site) {
    if (confirm("确实要删除档案吗？")) submitButton("DELETE" + site);
}

//归入档案前的提示
function recordData() {
    if (confirm("确实要将所选数据归入档案吗？")) submitButton("RECORD");
}

//任务管理删除任务前的提示
function taskDelete() {
    if (confirm("确认要删除当前任务及子任务吗？")) submitButton("DELETE");
}	

//删除部门主页类别的提示
function deleteDeptCatagory() {
    if (confirm("确实要删除当前主页类别吗？删除当前主页类别同时将删除类别下的部门主页及文章。")) submitButton("DELETE");
}

//删除部门主页文章类别的提示
function deleteBlogCategory() {
    if (confirm("确实要删除当前类别吗？删除文章类别同时将删除类别下的文章。")) submitButton("DELETE");
}

//作废申请的提示
function concelApplicants() {
    return confirm("确认要作废该申请吗？\n如果需要由前审批人或申请人修改后再提交请点击“退文”按钮。");
}

function confirmMenu() {
    return confirm("你确实要重新生成菜单吗?");
}

function confirmAllMenu() {
    return confirm("你确实要对它的所有菜单进行操作吗？");
}

//初始密码更改保存提示
function updateInitPwd() {
    if (confirm("初始化密码将被改变，是否保存修改？")) submitButton("SAVE");
} 

//删除细表的行
function delectListTableTr() {
    return confirm("确定要删除当前行吗？");
}

//删除细表的行
function checkTblNameComfirm() {
    return confirm("确定要使用此表名吗？");
}

//删除数据前的提示 彻底删除数据及相关文件
function removeDataFromSystem() {
    if (confirm("确实要删除数据及相关文件吗？")) submitButton("REMOVEFROMSYS");
}

//关闭任务前的提示。修改任务状态为关闭 
function closeTaskList(linkType) {
    if (confirm("确实要关闭任务吗？")) submitButton(linkType);
}

//删除任务前的提示
function deleteTaskList() {
    if (confirm("确实要删除任务吗？")) submitButton("DELETE");
}

//完成任务前的提示
function completeTaskList() {
    if (confirm("确实要完成任务吗？")) submitButton("COMPLETE");
}
//提交或者保存审批单前的提示
function completeTrace() {
    return (confirm("确实要继续？"));
}

//对工作计划的删除
function deleteWorkDetail(site) {
    if (confirm("确实要删除数据吗？")) submitButton("DELETEDETAIL" + site);
}


//删除预约数据前的提示
function deleteBooksData() {
    if (confirm("确认要取消预约吗？")) submitButton("DELETE");
}

//结束会议前提示
function finishMeeting() {
    if (confirm("确实要结束会议吗？")) submitButton("FINISH");
}

//取消会议前提示   add by jinfei 20141011 
function cancelMeeting() {
    if (confirm("确实要取消会议吗？")) submitButton("CANCEL");
}


//删除信息评论前的提示
function deleteMsgCommentary(site) {
    if (confirm("确认要删除该评论吗？")) submitButton("DELETE" + site);
}
//投票前的确认
function votingSure() {
    if (confirm("确定要投票吗？")) submitButton("VOTING");
}

//移动帖子
function moveForumIndex() {
    if (confirm("确认要移动吗？")) submitButton("MOVE");
}
//车辆报废
function scrapCar(){
    if (confirm("确定要停用吗？")) submitButton("SCRAP");
}

//信息发布后台删除查询的全部信息
function deleteAllMsgData() {
    if (confirm("确认要删除全部查询到的信息吗？")) submitButton("DELETEALL");
}

//删除相册
function deletePhotoAlbum() {
    if (confirm("删除相册会将该相册下的所有相片同时删除，确认继续吗？")) submitButton("DELETE");
}
//删除数据前的提示 没选择数据则全部删除 zhoukai
function deleteDataAll() {
	var list = $("input[type='checkbox']");
	if (list.length > 1) {
		var findCheckFlg = false;
		for (var i = 0; i < list.length; i++) {
			if (list[i].checked) {
				findCheckFlg = true;
				break;
			}
		}
		if (!findCheckFlg) {
           if(confirm("确定删除当前查询的数据所有吗？")) submitButton("DELETEALL");
		}
        else{
           if (confirm("确实要删除数据吗？")) submitButton("DELETE");
        }
    }
    else{
        alert("当前没有数据");
        return false;
    }

}


var title_canont_operate_sysmsg = "系统消息不可操作。";
//星座
var star_month = new Array("水瓶座","双鱼座","白羊座","金牛座","双子座","巨蟹座","狮子座","处女座","天秤座","天蝎座","射手座","魔蝎座");
//性别
var sexual = new Array("男","女");

var trace_sql = "独立sql视图";

var illegal_String = "不允许出现非法字符";
