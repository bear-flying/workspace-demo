package com.founder.refresh;

import java.util.ArrayList;
import java.util.List;

public class RefreshTask {

	private List<String> urls = new ArrayList<String>();
	
	private List<String> dirs = new ArrayList<String>();
	
	private RefreshCallBack callback;

	public RefreshTask() {
		super();
	}

	public RefreshTask(List<String> urls, List<String> dirs,
			RefreshCallBack callback) {
		super();
		this.urls = urls;
		this.dirs = dirs;
		this.callback = callback;
	}

	public List<String> getUrls() {
		return urls;
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}

	public List<String> getDirs() {
		return dirs;
	}

	public void setDirs(List<String> dirs) {
		this.dirs = dirs;
	}

	public RefreshCallBack getCallback() {
		return callback;
	}

	public void setCallback(RefreshCallBack callback) {
		this.callback = callback;
	}
	
}
