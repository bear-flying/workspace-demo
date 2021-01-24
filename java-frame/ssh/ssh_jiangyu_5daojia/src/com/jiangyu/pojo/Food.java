package com.jiangyu.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_food")
public class Food {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private double price;
	
	@ManyToOne
	@JoinColumn(name="sid")
	private Shop shops;
	@ManyToOne
	@JoinColumn(name="cid")
	private Category categorys;

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Shop getShops() {
		return shops;
	}

	public void setShops(Shop shops) {
		this.shops = shops;
	}

	public Category getCategorys() {
		return categorys;
	}

	public void setCategorys(Category categorys) {
		this.categorys = categorys;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", price=" + price + "]";
	}

	
	
	
	
	
}
