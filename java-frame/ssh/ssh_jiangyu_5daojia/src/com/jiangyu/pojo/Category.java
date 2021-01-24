package com.jiangyu.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_category")
public class Category {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;

	//private List<Food> foodss;
	
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

//	public List<Food> getFoodss() {
//		return foodss;
//	}
//
//	public void setFoodss(List<Food> foodss) {
//		this.foodss = foodss;
//	}
	
	
	
}
