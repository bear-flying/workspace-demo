package com.bee.vo;

public class Food {

	private int id;
	private String img;
	private String name;
	private String introduce;
	private double price;
	private String city;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Food [id=" + id + ", img=" + img + ", name=" + name
				+ ", introduce=" + introduce + ", price=" + price + ", city="
				+ city + "]";
	}
	public Food(String img, String name, String introduce, double price) {
		super();
		this.img = img;
		this.name = name;
		this.introduce = introduce;
		this.price = price;
	}
	
	
}
