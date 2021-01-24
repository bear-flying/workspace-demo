package com.jiangyu.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * CRole entity. @author MyEclipse Persistence Tools
 */

public class CRole implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String remark;
	private Set CEmps = new HashSet(0);

	// Constructors

	/** default constructor */
	public CRole() {
	}

	/** minimal constructor */
	public CRole(String name, String remark) {
		this.name = name;
		this.remark = remark;
	}

	/** full constructor */
	public CRole(String name, String remark, Set CEmps) {
		this.name = name;
		this.remark = remark;
		this.CEmps = CEmps;
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

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getCEmps() {
		return this.CEmps;
	}

	public void setCEmps(Set CEmps) {
		this.CEmps = CEmps;
	}

}