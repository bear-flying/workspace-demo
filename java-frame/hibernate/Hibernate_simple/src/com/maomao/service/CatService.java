package com.maomao.service;

import java.util.List;

import com.maomao.dao.CatDao;
import com.maomao.pojo.Cat;

public class CatService {

	private CatDao dao = new CatDao();

	public List<Cat> queryAll(int page,int pageSize) {
		// TODO Auto-generated method stub
		String hql = " from Cat ";
		
		return dao.queryPage(hql, page, pageSize);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		Long count = dao.getCount(Cat.class);
		
		return count.intValue();
	}

	public void add(Cat cat) {
		// TODO Auto-generated method stub
		dao.addOne(cat);
		
	}

	public Cat findOne(int id) {
		// TODO Auto-generated method stub
		
		return dao.findOneByGet(Cat.class, id);
	}

	public void modify(Cat cat) {
		// TODO Auto-generated method stub
		dao.modify(cat);
	}

	public void remove(String ids) {
		// TODO Auto-generated method stub
		dao.deleAll(Cat.class, ids);
	}

}
