package com.jiangyu.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="c_food")
public class Food {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;

//	@ManyToMany
//	@JoinTable(name="c_order_food",
//			joinColumns=@JoinColumn(name="food_id"),
//			inverseJoinColumns=@JoinColumn(name="order_id"))
//	private List<Order> orders = new ArrayList<Order>();
	
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

//	public List<Order> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<Order> orders) {
//		this.orders = orders;
//	}

	public Food(Integer id) {
		super();
		this.id = id;
	}

	public Food() {
		super();
	}
	
	
	
	
}
