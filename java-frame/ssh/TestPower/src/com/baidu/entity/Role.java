package com.baidu.entity;

import java.util.HashSet;
import java.util.Set;

public class Role {

	private Integer rid;
	private String rname;
	private String content;
	private Set<Power> power = new HashSet<Power>();
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public Set<Power> getPower() {
		return power;
	}
	public void setPower(Set<Power> power) {
		this.power = power;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
