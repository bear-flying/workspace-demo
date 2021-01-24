package com.ccc.dto;

import java.util.Set;


public class Student {
	private int sid;
	private String sname;
	private int age;
	private Grade grade;
	private Set<Courses> cou;
	
	
	public Set<Courses> getCou() {
		return cou;
	}

	public void setCou(Set<Courses> cou) {
		this.cou = cou;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public int getSid() {
		return sid;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
