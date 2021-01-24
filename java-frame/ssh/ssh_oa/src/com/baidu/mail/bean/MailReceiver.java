package com.baidu.mail.bean;
/**
 * 
 * @author作者：姜宇
 * 时间：2015-12-23上午9:07:55
 * 功能：邮件--收件人中间表
 */
public class MailReceiver {

	private Integer id;
	private Mail mail;//邮件表外键（一个收件人对应多个邮件）
	private Integer reveiverid;//收件人表外键 这里用用户表代替
	private String receiveStatus;//邮件状态（已读 未读 删除）

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Mail getMail() {
		return mail;
	}
	public void setMail(Mail mail) {
		this.mail = mail;
	}
	public Integer getReveiverid() {
		return reveiverid;
	}
	public void setReveiverid(Integer reveiverid) {
		this.reveiverid = reveiverid;
	}
	public String getReceiveStatus() {
		return receiveStatus;
	}
	public void setReceiveStatus(String receiveStatus) {
		this.receiveStatus = receiveStatus;
	}
	public MailReceiver(Mail mail, Integer reveiverid, String receiveStatus) {
		super();
		this.mail = mail;
		this.reveiverid = reveiverid;
		this.receiveStatus = receiveStatus;
	}
	public MailReceiver() {
		super();
	}
	
	
	
}
