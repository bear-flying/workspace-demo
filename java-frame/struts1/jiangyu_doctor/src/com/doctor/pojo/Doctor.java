package com.doctor.pojo;

import org.apache.struts.action.ActionForm;
/**
 * 作者：1405javab姜宇
 * 时间：2015-09-07
 * 功能：医生主要信息的javabean
 */
public class Doctor extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private int age;
	private String content;
	private int xid;
	
	private String jname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getXid() {
		return xid;
	}

	public void setXid(int xid) {
		this.xid = xid;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", age=" + age
				+ ", content=" + content + ", xid=" + xid + ", jname=" + jname
				+ "]";
	}
	
	
	
}
