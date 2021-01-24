package com.founder.pojo;

public class Datas {
	String rcode;
	Details details;
	String rstate;
	Databasic databasic;
	
	
	@Override
	public String toString() {
		return "Datas [rcode=" + rcode + ", details=" + details + ", rstate=" + rstate + ", databasic=" + databasic
				+ "]";
	}
	public String getRcode() {
		return rcode;
	}
	public void setRcode(String rcode) {
		this.rcode = rcode;
	}
	public Details getDetails() {
		return details;
	}
	public void setDetails(Details details) {
		this.details = details;
	}
	public String getRstate() {
		return rstate;
	}
	public void setRstate(String rstate) {
		this.rstate = rstate;
	}
	public Databasic getDatabasic() {
		return databasic;
	}
	public void setDatabasic(Databasic databasic) {
		this.databasic = databasic;
	}
	
	
	
}
