package com.jiangyu.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.jiangyu.pojo.CRole;
import com.jiangyu.utils.JiangYuSpringDao;
@Repository
public class RoleDao extends JiangYuSpringDao<CRole> implements IRoleDao {

	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		
		super.setSessionFactory(sessionFactory);
		
	}
	
}
