package com.jiangyu.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="d_bee")
public class Bee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	private String name;
	
	private String hobby;
	
	private String gender;
	
	private Date datea;
	
	@ManyToOne
	@JoinColumn(name="kind_id")
	private BeeKind beeKind;

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

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getDatea() {
		return datea;
	}

	public void setDatea(Date datea) {
		this.datea = datea;
	}

	public BeeKind getBeeKind() {
		return beeKind;
	}

	public void setBeeKind(BeeKind beeKind) {
		this.beeKind = beeKind;
	}

	@Override
	public String toString() {
		return "Bee [id=" + id + ", name=" + name + ", hobby=" + hobby
				+ ", gender=" + gender + ",datea=" + datea
				+ "]";
	}
	
	
	
}
