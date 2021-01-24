package com.rain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "DB_CONTRACT_DETAIL")
public class ContractDetailEntity {

	private Long id;

	private String contractNo;

//	private Long contractId;
	
	private ContractEntity contractEntity;
	
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="CON_ID")
	public ContractEntity getContractEntity() {
		return contractEntity;
	}

	public void setContractEntity(ContractEntity contractEntity) {
		this.contractEntity = contractEntity;
	}

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="generator_normal")
	@TableGenerator(
			name="generator_normal",
			table="GENERATOR_TABLE",
			pkColumnName="GEN_PK",
			pkColumnValue="DB_CONTRACT_DETAIL",
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
	
//	@Column(name="CON_ID")
//	public Long getContractId() {
//		return contractId;
//	}
//
//	public void setContractId(Long contractId) {
//		this.contractId = contractId;
//	}

}
