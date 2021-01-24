package com.baidu.mail.bean;

import java.util.Date;
/**
 * 
 * @author作者：姜宇
 * 时间：2015-12-23上午9:06:11
 * 功能：邮件表
 */
public class Mail {

	private Integer id;
	
	private String title;//主题
	
	private String content;//内容
	
	private Date sendTime;//发送时间
	
	private String sender;//发送人
	
	private String sendeStatus;//发送状态（草稿 已发送 删除）

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSendeStatus() {
		return sendeStatus;
	}

	public void setSendeStatus(String sendeStatus) {
		this.sendeStatus = sendeStatus;
	}
	
	
	
}
