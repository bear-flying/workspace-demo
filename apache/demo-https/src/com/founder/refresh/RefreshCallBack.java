package com.founder.refresh;

import java.util.ArrayList;
import java.util.List;

public class RefreshCallBack {

	private String url;
	
	private List<String> email = new ArrayList<String>();
	
	private String acptNotice = "true";
	
	public RefreshCallBack() {
		super();
	}

	public RefreshCallBack(List<String> email) {
		super();
		this.email = email;
	}

	public RefreshCallBack(String url, List<String> email) {
		super();
		this.url = url;
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<String> getEmail() {
		return email;
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}

	public String getAcptNotice() {
		return acptNotice;
	}

	public void setAcptNotice(String acptNotice) {
		this.acptNotice = acptNotice;
	}
	
}
