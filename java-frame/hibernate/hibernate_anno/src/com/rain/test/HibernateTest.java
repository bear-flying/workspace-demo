package com.rain.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.hibernate.Session;

import com.rain.entity.ContractDetailEntity;
import com.rain.entity.ContractEntity;
import com.rain.handler.HibernateUtil;

public class HibernateTest extends TestCase{
	
	
	public void task01(){
		
		Session session = HibernateUtil.getSession();
		//System.out.println(session);
		
		//¿ªÆôÊÂÎñ
		session.beginTransaction();
		try{
			ContractEntity ce = new ContractEntity();
			ce.setContractNo("CN002");
			ce.setContractTxn(1000.50D);
			ce.setContractDate(new Date());
			ce.setFlag(0);
			
			session.save(ce);
			
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.close();
	}
	
	public void task02(){
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		try{
			Set<ContractDetailEntity> details = new HashSet<ContractDetailEntity>();
			ContractEntity contractEntity = (ContractEntity) session.get(ContractEntity.class, 1L);
			ContractDetailEntity cde = new ContractDetailEntity();
			cde.setContractNo(contractEntity.getContractNo());
			cde.setContractEntity(contractEntity);
			details.add(cde);
			cde = new ContractDetailEntity();
			cde.setContractNo(contractEntity.getContractNo());
			cde.setContractEntity(contractEntity);
			details.add(cde);
			
			contractEntity.setContractDetails(details);
			
			session.update(contractEntity);
			
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.close();
		
	}
	
	
	
	
	
}
