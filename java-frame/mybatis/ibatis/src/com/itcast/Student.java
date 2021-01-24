package com.itcast;

import java.sql.Date;

public class Student {
	private int sid=0;
	private String sname=null;
	private String major=null;
	private Date birth=null;
	private float score=0;
	public int getSid() {
		return sid;
	}
	@Override
	public String toString() {
		//重载toString方法，方便调用
        String content = "sid=" + sid +" "+ "sname=" + sname+" " + "major=" +major+" "+"birth=" +birth+" "+"score=" +score; 
        return content;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
}
