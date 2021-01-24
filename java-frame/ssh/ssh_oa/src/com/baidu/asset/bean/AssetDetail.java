package com.baidu.asset.bean;

public class AssetDetail {

	private Integer id;
	
	private String name;
	
	private String model;
	
	private Integer num;
	
	private String content;
	
	private Asset asset;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public AssetDetail(Integer id, String name, String model, Integer num,
			String content, Asset asset) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.num = num;
		this.content = content;
		this.asset = asset;
	}

	
	
	public AssetDetail(String name, String model, Integer num, String content) {
		super();
		this.name = name;
		this.model = model;
		this.num = num;
		this.content = content;
	}

	public AssetDetail() {
		super();
	}
	
	
	
}
