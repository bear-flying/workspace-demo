package com.baidu.asset.bean;

public class Img {

	private String id;
	
	private String name;
	
	private String path;
	
	private Asset asset;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public Img(String name, String path) {
		super();
		this.name = name;
		this.path = path;
	}

	public Img() {
		super();
	}
	
	
	
}
