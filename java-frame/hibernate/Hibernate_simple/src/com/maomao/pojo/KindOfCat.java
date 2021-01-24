package com.maomao.pojo;

import java.util.HashSet;
import java.util.Set;

public class KindOfCat {

	private Integer kid;
	private String kind;
	private Set<Cat> cats = new HashSet<Cat>();
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
	public Set<Cat> getCats() {
		return cats;
	}
	public void setCats(Set<Cat> cats) {
		this.cats = cats;
	}
	@Override
	public String toString() {
		return "KindOfCat [kid=" + kid + ", kind=" + kind + "]";
	}
	
	
}
