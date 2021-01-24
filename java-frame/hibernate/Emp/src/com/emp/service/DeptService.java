package com.emp.service;

import java.util.List;

import com.emp.dao.DeptDao;
import com.emp.pojo.Dept;


public class DeptService {

	private DeptDao dao = new DeptDao();
	
	public List<Dept> findAll() {
		// TODO Auto-generated method stub
		String hql = " from Dept ";
		
		return dao.findAll(hql);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		
		return dao.getCount(Dept.class).intValue();
	}

	public List<Dept> findAll(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		String hql = " from Dept ";
		
		return dao.queryPage(hql, page, pageSize);
	}

	public Dept findOne(Integer did) {
		// TODO Auto-generated method stub
		return dao.findOneByGet(Dept.class, did);
	}

	public void modify(Dept dept) {
		// TODO Auto-generated method stub
		dao.modify(dept);
	}

	public void add(Dept dept) {
		// TODO Auto-generated method stub
		dao.addOne(dept);
	}

	public void remove(Integer a) {
		// TODO Auto-generated method stub
		dao.removeById(a, Dept.class);
	}

}
