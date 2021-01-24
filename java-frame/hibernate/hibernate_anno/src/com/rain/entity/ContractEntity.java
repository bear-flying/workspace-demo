package com.rain.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="DB_CONTRACT")
public class ContractEntity {

	private Long id;
	private String contractNo;
	private Date contractDate;
	private Double contractTxn;
	private int flag;
	
	private Set<ContractDetailEntity> contractDetails = new HashSet<ContractDetailEntity>();
	
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="CON_ID")
	public Set<ContractDetailEntity> getContractDetails() {
		return contractDetails;
	}
	public void setContractDetails(Set<ContractDetailEntity> contractDetails) {
		this.contractDetails = contractDetails;
	}
	

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="generator_normal")
	@TableGenerator(
			name="generator_normal",
			table="GENERATOR_TABLE",
			pkColumnName="GEN_PK",
			pkColumnValue="DB_CONTRACT",
			valueColumnName="GEN_VALUE",
			allocationSize=1
	)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="CON_NO")
	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	
	@Column(name="CON_DATE")
	public Date getContractDate() {
		return contractDate;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}
	
	@Column(name="CON_TXN")
	public Double getContractTxn() {
		return contractTxn;
	}

	public void setContractTxn(Double contractTxn) {
		this.contractTxn = contractTxn;
	}
	
	@Column(name="con_flag")
	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}
