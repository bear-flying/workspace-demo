package com.jiangyu.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.xiaobaixia.jiangyu.springmvc.ssh4.utils.JiangYuHibernateDao;

import com.jiangyu.pojo.Goods;
@Repository
public class GoodsDao extends JiangYuHibernateDao<Goods> implements IGoodsDao {

	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
}
