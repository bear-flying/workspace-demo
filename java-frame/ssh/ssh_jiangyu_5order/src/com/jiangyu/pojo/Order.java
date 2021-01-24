package com.jiangyu.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="c_order")
public class Order {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String tel;
	
	private Date datea;
	
	@ManyToOne
	@JoinColumn(name="time_id")
	private Time times;
	
	@ManyToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	@ManyToMany
	@JoinTable(name="c_order_food",
			joinColumns=@JoinColumn(name="order_id"),
			inverseJoinColumns=@JoinColumn(name="food_id"))
	private Set<Food> foods = new HashSet<Food>();;

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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getDatea() {
		return datea;
	}

	public void setDatea(Date datea) {
		this.datea = datea;
	}

	public Time getTimes() {
		return times;
	}

	public void setTimes(Time times) {
		this.times = times;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Food> getFoods() {
		return foods;
	}

	public void setFoods(Set<Food> foods) {
		this.foods = foods;
	}

	public Order() {
		super();
	}

	public Order(Integer id, String name, String tel, Date datea) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.datea = datea;
	}

	
	
	
}
