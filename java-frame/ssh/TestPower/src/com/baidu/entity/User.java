package com.baidu.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User {

	private Integer id;
	private String name;
	private String password; 
	private Integer age;
	private Set<Dept> dept = new HashSet<Dept>();
	private String rname;
	private Integer errorcount;
	private Date errortime;
	
	
	public Integer getErrorcount() {
		return errorcount;
	}

	public void setErrorcount(Integer errorcount) {
		this.errorcount = errorcount;
	}

	public Date getErrortime() {
		return errortime;
	}

	public void setErrortime(Date errortime) {
		this.errortime = errortime;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Set<Dept> getDept() {
		return dept;
	}

	public void setDept(Set<Dept> dept) {
		this.dept = dept;
	}

	
	
}
