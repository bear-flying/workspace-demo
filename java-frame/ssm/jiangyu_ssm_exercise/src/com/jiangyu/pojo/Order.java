package com.jiangyu.pojo;

import java.util.List;

public class Order {
	
    private Integer id;

    private String name;

    private String tel;

    private String datea;

    private Times times;

    private Address address;
    
    private List<Food> foods;

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
        this.name = name == null ? null : name.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getDatea() {
        return datea;
    }

    public void setDatea(String datea) {
        this.datea = datea == null ? null : datea.trim();
    }

	public Times getTimes() {
		return times;
	}

	public void setTimes(Times times) {
		this.times = times;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	
    
}