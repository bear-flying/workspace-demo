package com.jiangyu.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Brand entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_brand")
public class Brand  implements java.io.Serializable {


    // Fields    
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="id")
     private Integer id;
     private String dname;
//     @OneToMany
//     @JoinColumn(name="brand_id")
//     private Set<Goods> goodses = new HashSet<Goods>();


    // Constructors

    /** default constructor */
    public Brand() {
    }

	/** minimal constructor */
    public Brand(String dname) {
        this.dname = dname;
    }
    
//    /** full constructor */
//    public Brand(String dname, Set goodses) {
//        this.dname = dname;
//        this.goodses = goodses;
//    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return this.dname;
    }
    
    public void setDname(String dname) {
        this.dname = dname;
    }

//    public Set<Goods> getGoodses() {
//        return this.goodses;
//    }
//    
//    public void setGoodses(Set<Goods> goodses) {
//        this.goodses = goodses;
//    }
   








}