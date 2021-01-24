package com.bee.service;

import java.util.List;

import com.bee.dao.KindOfBeeDao;
import com.bee.pojo.KindOfBee;

public class KindOfBeeService {

	private KindOfBeeDao dao = new KindOfBeeDao();
	
	public List<KindOfBee> findAll() {
		// TODO Auto-generated method stub
		String hql = " from KindOfBee ";
		
		return dao.findAll(hql);
	}


}
