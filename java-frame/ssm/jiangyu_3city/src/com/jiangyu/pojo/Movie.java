package com.jiangyu.pojo;

import java.util.List;

public class Movie {
    private Integer id;

    private String name;

    private Double price;

    private String addressId;

    private Type type;

    private String datea;
    
    private List<Cinema> cinemalist;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId == null ? null : addressId.trim();
    }
    
    public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getDatea() {
        return datea;
    }

    public void setDatea(String datea) {
        this.datea = datea == null ? null : datea.trim();
    }

	public List<Cinema> getCinemalist() {
		return cinemalist;
	}

	public void setCinemalist(List<Cinema> cinemalist) {
		this.cinemalist = cinemalist;
	}
    
    
    
}