package com.founder.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Record {
	@JsonProperty(value = "SY_INFOTYPE")  
	int SY_INFOTYPE;//信息类型   1:新闻、2:论坛、3:博客、4:微博、5:APP、6:微信、7:电子报、8:境外、9:视频、
	@JsonProperty(value = "IR_GROUPFLAG")
	int IR_GROUPFLAG;//是否回帖  0：主贴， 1：回帖
	@JsonProperty(value = "IR_URLTIME")
	String IR_URLTIME; //发布时间
	@JsonProperty(value = "IR_URLTITLE")
	String IR_URLTITLE;//标题
	@JsonProperty(value = "IR_ABSTRACT")
	String IR_ABSTRACT;//原文摘要
	@JsonProperty(value = "IR_URLNAME")
	String IR_URLNAME;//url地址
	@JsonProperty(value = "IR_SITENAME")
	String IR_SITENAME;//网站名称--------来源
	@JsonProperty(value = "RID")
	String RID;//主键ID
	@JsonProperty(value = "IR_AUTHORS")
	String IR_AUTHORS;//作者
	@JsonProperty(value = "IR_CHANNEL")
	String IR_CHANNEL;//频道名称 ---------栏目名？？？
	@JsonProperty(value = "IR_CONTENT")
	String IR_CONTENT;//正文
	
	@Override
	public String toString() {
		return "Record [SY_INFOTYPE=" + SY_INFOTYPE + ", IR_GROUPFLAG=" + IR_GROUPFLAG + ", IR_URLTIME=" + IR_URLTIME
				+ ", IR_URLTITLE=" + IR_URLTITLE + ", IR_ABSTRACT=" + IR_ABSTRACT + ", IR_URLNAME=" + IR_URLNAME
				+ ", IR_SITENAME=" + IR_SITENAME + ", RID=" + RID + ", IR_AUTHORS=" + IR_AUTHORS + ", IR_CHANNEL=" + IR_CHANNEL + ", IR_CONTENT="
				+ IR_CONTENT + "]";
	}
	public String getIR_CONTENT() {
		return IR_CONTENT;
	}
	public void setIR_CONTENT(String iR_CONTENT) {
		IR_CONTENT = iR_CONTENT;
	}
	public int getSY_INFOTYPE() {
		return SY_INFOTYPE;
	}
	public void setSY_INFOTYPE(int sY_INFOTYPE) {
		SY_INFOTYPE = sY_INFOTYPE;
	}
	public int getIR_GROUPFLAG() {
		return IR_GROUPFLAG;
	}
	public void setIR_GROUPFLAG(int iR_GROUPFLAG) {
		IR_GROUPFLAG = iR_GROUPFLAG;
	}
	public String getIR_URLTIME() {
		return IR_URLTIME;
	}
	public void setIR_URLTIME(String iR_URLTIME) {
		IR_URLTIME = iR_URLTIME;
	}
	public String getIR_URLTITLE() {
		return IR_URLTITLE;
	}
	public void setIR_URLTITLE(String iR_URLTITLE) {
		IR_URLTITLE = iR_URLTITLE;
	}
	public String getIR_ABSTRACT() {
		return IR_ABSTRACT;
	}
	public void setIR_ABSTRACT(String iR_ABSTRACT) {
		IR_ABSTRACT = iR_ABSTRACT;
	}
	public String getIR_URLNAME() {
		return IR_URLNAME;
	}
	public void setIR_URLNAME(String iR_URLNAME) {
		IR_URLNAME = iR_URLNAME;
	}
	public String getIR_SITENAME() {
		return IR_SITENAME;
	}
	public void setIR_SITENAME(String iR_SITENAME) {
		IR_SITENAME = iR_SITENAME;
	}
	public String getRID() {
		return RID;
	}
	public void setRID(String rID) {
		RID = rID;
	}
	public String getIR_AUTHORS() {
		return IR_AUTHORS;
	}
	public void setIR_AUTHORS(String iR_AUTHORS) {
		IR_AUTHORS = iR_AUTHORS;
	}
	public String getIR_CHANNEL() {
		return IR_CHANNEL;
	}
	public void setIR_CHANNEL(String iR_CHANNEL) {
		IR_CHANNEL = iR_CHANNEL;
	}
	
	
}
