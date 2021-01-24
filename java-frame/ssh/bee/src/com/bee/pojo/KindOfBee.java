package com.bee.pojo;

import java.util.HashSet;
import java.util.Set;


public class KindOfBee {

	private Integer kid;
	private String kind;
	private Set<Bee> bees = new HashSet<Bee>();
	
	public Integer getKid() {
		return kid;
	}
	public void setKid(Integer kid) {
		this.kid = kid;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public Set<Bee> getBees() {
		return bees;
	}
	public void setBees(Set<Bee> bees) {
		this.bees = bees;
	}
	@Override
	public String toString() {
		return "KindOfBee [kid=" + kid + ", kind=" + kind + "]";
	}
	
	
}
