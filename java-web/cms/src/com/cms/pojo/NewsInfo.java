package com.cms.pojo;

import java.sql.Date;

public class NewsInfo {

	private int id;
	private String newsTitle;
	private String newsAuthor;
	private int typeId;
	private String newsContent;
	private Date createDatetime;
	private Date updateDatetime;
	
	private String name;//新闻类型（news_type）表

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsAuthor() {
		return newsAuthor;
	}

	public void setNewsAuthor(String newsAuthor) {
		this.newsAuthor = newsAuthor;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public Date getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public Date getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "NewsInfo [id=" + id + ", newsTitle=" + newsTitle
				+ ", newsAuthor=" + newsAuthor + ", typeId=" + typeId
				+ ", newsContent=" + newsContent + ", createDatetime="
				+ createDatetime + ", updateDatetime=" + updateDatetime
				+ ", name=" + name + "]";
	}

	public NewsInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewsInfo(int id, String newsTitle, String newsAuthor, int typeId,
			String newsContent, Date createDatetime, Date updateDatetime) {
		super();
		this.id = id;
		this.newsTitle = newsTitle;
		this.newsAuthor = newsAuthor;
		this.typeId = typeId;
		this.newsContent = newsContent;
		this.createDatetime = createDatetime;
		this.updateDatetime = updateDatetime;
	}

	public NewsInfo(String newsTitle, String newsAuthor, int typeId,
			String newsContent, Date createDatetime, Date updateDatetime) {
		super();
		this.newsTitle = newsTitle;
		this.newsAuthor = newsAuthor;
		this.typeId = typeId;
		this.newsContent = newsContent;
		this.createDatetime = createDatetime;
		this.updateDatetime = updateDatetime;
	}
	

}
