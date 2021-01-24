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


/**
 * Goods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_goods")
public class Goods  implements java.io.Serializable {


    // Fields    
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="id")
     private Integer id;
	 @ManyToOne
	 @JoinColumn(name="brand_id")
     private Brand brand;
     private String name;
     private Double price;
     private Date datea;


    // Constructors

    /** default constructor */
    public Goods() {
    }

    
    /** full constructor */
    public Goods(Brand brand, String name, Double price, Date datea) {
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.datea = datea;
    }

   
    // Property accessors

    public Goods(String name, Double price, Date datea) {
		super();
		this.name = name;
		this.price = price;
		this.datea = datea;
	}


	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price
				+ ", datea=" + datea + "]";
	}


	public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Brand getBrand() {
        return this.brand;
    }
    
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDatea() {
        return this.datea;
    }
    
    public void setDatea(Date datea) {
        this.datea = datea;
    }
   








}