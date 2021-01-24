package com.maomao.service;

import java.util.List;

import com.maomao.dao.KindOfCatDao;
import com.maomao.pojo.KindOfCat;

public class KindOfCatService {

	private KindOfCatDao dao = new KindOfCatDao();
	
	public List<KindOfCat> findAll() {
		// TODO Auto-generated method stub
		String hql = " from KindOfCat ";
		
		return dao.findAll(hql);
	}

}
