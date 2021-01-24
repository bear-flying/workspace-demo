package com.baidu.salary.bean;

public class Salary {

	private Integer id;
	private String workername; //员工姓名
	private Integer basicsalary; //基本工资
	private Integer gradesalary; //绩效工资
	private Integer socialsecurity; //社保
	private Integer publicgold; //公积金
	private Integer crosspay; //税前工资
	private Integer netpay; //税后工资
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWorkername() {
		return workername;
	}
	public void setWorkername(String workername) {
		this.workername = workername;
	}
	public Integer getBasicsalary() {
		return basicsalary;
	}
	public void setBasicsalary(Integer basicsalary) {
		this.basicsalary = basicsalary;
	}
	public Integer getGradesalary() {
		return gradesalary;
	}
	public void setGradesalary(Integer gradesalary) {
		this.gradesalary = gradesalary;
	}
	public Integer getSocialsecurity() {
		return socialsecurity;
	}
	public void setSocialsecurity(Integer socialsecurity) {
		this.socialsecurity = socialsecurity;
	}
	public Integer getPublicgold() {
		return publicgold;
	}
	public void setPublicgold(Integer publicgold) {
		this.publicgold = publicgold;
	}
	public Integer getCrosspay() {
		return crosspay;
	}
	public void setCrosspay(Integer crosspay) {
		this.crosspay = crosspay;
	}
	public Integer getNetpay() {
		return netpay;
	}
	public void setNetpay(Integer netpay) {
		this.netpay = netpay;
	}
	
	
	
}
