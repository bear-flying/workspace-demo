package com.baidu.parse.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {

	private String id;
	
	private String appname;//应用名称
	
	private String version;//版本
	
	private String appicon;//应用图标所在路径
	
	private String apkurl;//应用下载路径
	
	private String description;//描述
	
	private String filesize;//文件大小
	
	private Date updatetime;//更新时间
	
	private String developer;//开发者
	
	private String apptype;//应用类型
	
	private double price;//价格
	
	private String downloadNums;//下载量
	
	private String platform;//所属平台
	
	private String status;//应用状态
	
	private String codeurl;//二维码图片路径
	
	private List<Pic> picList = new ArrayList<Pic>();
	
	private List<Comment> commentList = new ArrayList<Comment>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAppicon() {
		return appicon;
	}

	public void setAppicon(String appicon) {
		this.appicon = appicon;
	}

	public String getApkurl() {
		return apkurl;
	}

	public void setApkurl(String apkurl) {
		this.apkurl = apkurl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFilesize() {
		return filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getApptype() {
		return apptype;
	}

	public void setApptype(String apptype) {
		this.apptype = apptype;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDownloadNums() {
		return downloadNums;
	}

	public void setDownloadNums(String downloadNums) {
		this.downloadNums = downloadNums;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCodeurl() {
		return codeurl;
	}

	public void setCodeurl(String codeurl) {
		this.codeurl = codeurl;
	}

	public List<Pic> getPicList() {
		return picList;
	}

	public void setPicList(List<Pic> picList) {
		this.picList = picList;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return "App [id=" + id + ", appname=" + appname + ", version="
				+ version + ", appicon=" + appicon + ", apkurl=" + apkurl
				+ ", description=" + description + ", filesize=" + filesize
				+ ", updatetime=" + updatetime + ", developer=" + developer
				+ ", apptype=" + apptype + ", price=" + price
				+ ", downloadNums=" + downloadNums + ", platform=" + platform
				+ ", status=" + status + ", codeurl=" + codeurl + ", picList="
				+ picList + ", commentList=" + commentList + "]";
	}
	
	
	
	
}
