package com.jiangyu.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * CEmp entity. @author MyEclipse Persistence Tools
 */

public class CEmp implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set CRoles = new HashSet(0);

	// Constructors

	/** default constructor */
	public CEmp() {
	}

	/** minimal constructor */
	public CEmp(String name) {
		this.name = name;
	}

	/** full constructor */
	public CEmp(String name, Set CRoles) {
		this.name = name;
		this.CRoles = CRoles;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getCRoles() {
		return this.CRoles;
	}

	public void setCRoles(Set CRoles) {
		this.CRoles = CRoles;
	}

}