package com.jiangyu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="d_beeofkind")
public class BeeKind {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer kid;
	
	private String bkind;

	

	public Integer getKid() {
		return kid;
	}



	public void setKid(Integer kid) {
		this.kid = kid;
	}



	public String getBkind() {
		return bkind;
	}



	public void setBkind(String bkind) {
		this.bkind = bkind;
	}



	@Override
	public String toString() {
		return "BeeKind [kid=" + kid + ", bkind=" + bkind + "]";
	}
	
	
	
	
}
