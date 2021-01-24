package com.emp.pojo;

import java.util.Set;

public class Dept {

	private Integer did;
	private String deptn;
	private Set<Emp> emps;
	
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDeptn() {
		return deptn;
	}
	public void setDeptn(String deptn) {
		this.deptn = deptn;
	}
	@Override
	public String toString() {
		return "Dept [did=" + did + ", deptn=" + deptn + "]";
	}
	public Set<Emp> getEmps() {
		return emps;
	}
	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}
	
	
}
