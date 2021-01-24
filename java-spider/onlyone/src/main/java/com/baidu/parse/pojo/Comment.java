package com.baidu.parse.pojo;

import java.util.Date;

/**
 * 
 * @author 飞天猫熊
 * 功能：评论表
 * 时间：2016年1月11日
 * 作者：1405javab 姜宇
 */
public class Comment {

	private String id;
	
	private String commentUser;
	
	private Date commentDate;
	
	private String commentNum;
	
	private String comment;
	
	private String appid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCommentUser() {
		return commentUser;
	}

	public void setCommentUser(String commentUser) {
		this.commentUser = commentUser;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(String commentNum) {
		this.commentNum = commentNum;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", commentUser=" + commentUser
				+ ", commentDate=" + commentDate + ", commentNum=" + commentNum
				+ ", comment=" + comment + ", appid=" + appid + "]";
	}
	
	
	
}
