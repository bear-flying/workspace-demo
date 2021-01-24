package com.baidu.mail.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.baidu.base.service.SelectDataService;
import com.baidu.mail.bean.Mail;
import com.baidu.mail.bean.MailReceiver;
import com.baidu.mail.service.MailReceiverService;
import com.baidu.mail.service.MailService;
import com.baidu.user.bean.User;
import com.baidu.util.Page;
import com.baidu.util.Response;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

public class MailAction extends ActionSupport implements ModelDriven<Mail> {
	
	private Mail mail = new Mail();
	
	private MailService mailService;
	private MailReceiverService mailReceiverService;
	private SelectDataService selectDataService;
	
	public Mail getMail() {
		return mail;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
	}

	public MailService getMailService() {
		return mailService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	public MailReceiverService getMailReceiverService() {
		return mailReceiverService;
	}

	public void setMailReceiverService(MailReceiverService mailReceiverService) {
		this.mailReceiverService = mailReceiverService;
	}

	public SelectDataService getSelectDataService() {
		return selectDataService;
	}

	public void setSelectDataService(SelectDataService selectDataService) {
		this.selectDataService = selectDataService;
	}

	@Override
	public Mail getModel() {
		// TODO Auto-generated method stub
		return mail;
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-13下午4:29:56
	 * 功能：转到mailtree.jsp页面
	 * @return
	 */
	public String findTree(){
		
		return "mailtree";
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-23上午10:12:25
	 * 功能：发送邮件（新增邮件）
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		mailService.save(mail);
		return SUCCESS;
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-23上午11:02:43
	 * 功能：转到list.jsp页面 --->邮件模块主页面
	 */
	public String listPage(){
		return "list";
	}

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-23上午11:02:43
	 * 功能：转到receivebox.jsp页面---> 当前用户（已读和未读的）邮件列表页面
	 */
	public String receivePage(){
		return "receivebox";
	}
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-23上午10:20:43
	 * 功能：查询当前用户（已读和未读的）邮件
	 */
	public void receiveList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User)request.getSession().getAttribute("user");
		Map map =selectDataService.getListForPage(request, 
			"select a.id,a.receivestatus,b.title, " +
					"b.content,b.sendtime,b.sender "+
					"from t_mail_receiver a left join t_mail b "+ 
					"on a.mailid = b.id where a.reveiverid = '"+user.getId()+"' "+
					"and b.sendestatus = '发送' and a.receivestatus = '未读' or a.receivestatus ='已读' "+
					"order by a.receivestatus asc ");
		
		JSONObject json = new JSONObject();
		json.put("total", ((Page)map.get("p")).getTotal());
		json.put("rows", map.get("resoultList"));

		Response.write(json.toString());
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-23上午11:02:43
	 * 功能：转到sendbox.jsp页面---> 当前用户（已发送的）邮件列表页面
	 */
	public String sendPage(){
		return "sendbox";
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-23上午10:20:43
	 * 功能：查询当前用户（已发送的）邮件
	 */
	public void sendList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User)request.getSession().getAttribute("user");
		Map map =selectDataService.getListForPage(request, 
			"select distinct b.id,b.title,b.content,b.sendtime,b.sender "+ 
				"from t_mail_receiver a ,t_mail b where b.sender = '"+user.getRealname()+"' "+
				"and a.receivestatus != '删除' "+
				"and b.sendestatus = '发送' order by b.sendtime asc");

		JSONObject json = new JSONObject();
		json.put("total", ((Page)map.get("p")).getTotal());
		json.put("rows", map.get("resoultList"));

		Response.write(json.toString());
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-23上午11:02:43
	 * 功能：转到draftbox.jsp页面---> 当前用户（邮件草稿）列表页面
	 */
	public String draftPage(){
		return "draftbox";
	}

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-23上午10:20:43
	 * 功能：查询当前用户的 草稿 邮件
	 */
	public void draftList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User)request.getSession().getAttribute("user");
		Map map =selectDataService.getListForPage(request, 
			"select a.* from t_mail a where a.sender = '"+user.getRealname()+"' "+
				"and a.sendestatus = '草稿' "+
				"order by a.sendtime asc");

		JSONObject json = new JSONObject();
		json.put("total", ((Page)map.get("p")).getTotal());
		json.put("rows", map.get("resoultList"));

		Response.write(json.toString());
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-23上午11:02:43
	 * 功能：转到rubbishbox.jsp页面---> 当前用户（邮件垃圾箱）列表页面
	 */
	public String rubbishPage(){
		return "rubbishbox";
	}

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-23上午10:20:43
	 * 功能：查询当前用户（垃圾箱的  删除状态的）邮件
	 */
	public void rubbishList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User)request.getSession().getAttribute("user");
		Map map =selectDataService.getListForPage(request,
			"select id,title,content,sendtime,sender from t_mail "+
			"where sendestatus = '删除' union all "+
			"select b.id,b.title,b.content,b.sendtime,b.sender  "+
			"from t_mail_receiver a left join t_mail b  "+
			"on a.mailid = b.id where a.reveiverid = '"+user.getId()+"' "+
			"and a.receivestatus = '删除' ");

		JSONObject json = new JSONObject();
		json.put("total", ((Page)map.get("p")).getTotal());
		json.put("rows", map.get("resoultList"));

		Response.write(json.toString());
	}
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-23上午11:02:43
	 * 功能：转到writebox.jsp页面---> 新建邮件  添加页面
	 */
	public String writePage(){
		return "writebox";
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-23下午4:07:35
	 * 功能：把收件箱中的邮件放进垃圾箱
	 */
	public void changeToRubbish(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String aid = request.getParameter("id");
		selectDataService.update("update t_mail_receiver set receivestatus ='删除' where id="+aid);
		
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-23下午4:07:35
	 * 功能：把草稿箱和发件箱中的邮件放进垃圾箱
	 */
	public void changeToRubbish2(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String aid = request.getParameter("id");
		selectDataService.update("update t_mail set sendestatus ='删除' where id="+aid);
		
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-24下午4:16:15
	 * 功能：发送邮件
	 */
	//1，日期是怎样自动转化格式的  
	//2，Integer-----varchar2
	//3, IFRAME
	public void sendMail(){
		mail.setSendTime(new Date());
		mailService.save(mail);
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("userid");
		if(id!=null){
			String[] ids = id.split(",");
			for (String reveiverid : ids) {
				MailReceiver mailer = new MailReceiver(mail,new Integer(reveiverid),"未读");
				mailReceiverService.save(mailer);
			}
		}
		
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-24下午4:16:15
	 * 功能：新增草稿
	 */
	public void toDraftbox() {
		mail.setSendTime(new Date());
		mail.setSendeStatus("草稿");
		mailService.save(mail);
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-25上午8:52:11
	 * 功能：查询当前用户未读邮件的个数 
	 */
	public void findNoreadmail() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		//selectDataService.
		List<MailReceiver> list = mailReceiverService.findEntityByHQL(" from MailReceiver m where " +
				" m.reveiverid=? and m.receiveStatus ='未读'", new Integer(id));
		Response.write(String.valueOf(list.size()));
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-23下午4:07:35
	 * 功能：在垃圾箱中 批量彻底删除邮件
	 */
	public void delMail(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids = request.getParameter("id");
		String[] aids = ids.split(",");
		selectDataService.remove("delete from t_mail where id in ("+aids+")");
		
	}

}
