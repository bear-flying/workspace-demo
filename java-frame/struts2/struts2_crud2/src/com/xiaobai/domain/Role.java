package com.xiaobai.domain;

public class Role {

	private int id;
	private String rname;
	@Override
	public String toString() {
		return "Role [id=" + id + ", rname=" + rname + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	
	
}
