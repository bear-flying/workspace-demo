package com.founder.pojo;

public class Databasic {
	int allpages;
	int pageno;
	int pagesize;
	int allcount;
	
	
	@Override
	public String toString() {
		return "Databasic [allpages=" + allpages + ", pageno=" + pageno + ", pagesize=" + pagesize + ", allcount="
				+ allcount + "]";
	}
	public int getAllpages() {
		return allpages;
	}
	public void setAllpages(int allpages) {
		this.allpages = allpages;
	}
	public int getPageno() {
		return pageno;
	}
	public void setPageno(int pageno) {
		this.pageno = pageno;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getAllcount() {
		return allcount;
	}
	public void setAllcount(int allcount) {
		this.allcount = allcount;
	}
	
	
	
}
