package com.baidu.parse.pojo;

public class Pic {

	private String id;
	
	private String picurl;
	
	private String description;
	
	private String app;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	@Override
	public String toString() {
		return "Pic [id=" + id + ", picurl=" + picurl + ", description="
				+ description + ", app=" + app + "]";
	}

	
	
	
}
