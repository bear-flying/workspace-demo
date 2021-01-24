package com.jiangyu.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.jiangyu.pojo.CEmp;
import com.jiangyu.utils.JiangYuSpringDao;
@Repository
public class EmpDao extends JiangYuSpringDao<CEmp> implements IEmpDao  {

	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		
		super.setSessionFactory(sessionFactory);
		
	}
	
}
