package com.maomao.pojo;

public class Cat {

	private Integer cid;
	private String name;
	private String sex;
	private String hobby;
	private String birthday;
	private KindOfCat kindOfCat = new KindOfCat();
	
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
		return "Cat [cid=" + cid + ", name=" + name + ", sex=" + sex
				+ ", hobby=" + hobby + ", birthday=" + birthday + "]";
	}
	public KindOfCat getKindOfCat() {
		return kindOfCat;
	}
	public void setKindOfCat(KindOfCat kindOfCat) {
		this.kindOfCat = kindOfCat;
	}
	
	
	
}
