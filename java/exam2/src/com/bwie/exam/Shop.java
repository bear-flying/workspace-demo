package com.bwie.exam;

public class Shop {

	private String name ;
	
	public String press ;
	
	public String price ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Shop [name=" + name + ", press=" + press + ", price=" + price
				+ "]";
	}
	
	
	
}
