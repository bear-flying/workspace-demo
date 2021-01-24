package com.zh.dao;

import java.util.List;

import org.hibernate.Session;

import com.zh.utils.HibernateUtils;

public class CheckDao {


	
	/**
	 * 功能：检查名称是否重复
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	@SuppressWarnings("unchecked")
	public Boolean checkName(Integer id,String name){
	
		Session session = HibernateUtils.getFactory().openSession();		
		List list = session.createQuery("from Book b where b.name = ? and b.id != ?").setParameter(0, name).setParameter(1, id).list();
		
		if(list.size()>0)
			return true;
		return false;
	}	
}
