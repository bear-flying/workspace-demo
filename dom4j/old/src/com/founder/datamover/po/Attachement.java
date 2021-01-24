package com.founder.datamover.po;

public class Attachement implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	// 附件的文件名
	private String attPath;
	
	// 附件的输入流
	private byte[] attIs;
	
	// 附件的描述信息
	private String title;

	public String getAttPath() {
		return attPath;
	}

	public void setAttPath(String attPath) {
		this.attPath = attPath;
	}

	public byte[] getAttIs() {
		return attIs;
	}

	public void setAttIs(byte[] attIs) {
		this.attIs = attIs;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
