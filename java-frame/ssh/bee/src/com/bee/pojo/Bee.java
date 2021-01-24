package com.bee.pojo;


public class Bee {

	private Integer cid;
	private String name;
	private String sex;
	private String hobby;
	private String birthday;
	private String filepath;
	private KindOfBee kindOfBee = new KindOfBee();
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getBirthday() {
		return birthday.substring(0, 10);
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Bee [cid=" + cid + ", name=" + name + ", sex=" + sex
				+ ", hobby=" + hobby + ", birthday=" + birthday + "]";
	}
	public KindOfBee getKindOfBee() {
		return kindOfBee;
	}
	public void setKindOfBee(KindOfBee kindOfBee) {
		this.kindOfBee = kindOfBee;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	

}
