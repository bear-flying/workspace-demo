package com.emp.service;

import java.util.List;

import com.emp.dao.EmpDao;
import com.emp.pojo.Emp;


public class EmpService {

	private EmpDao dao = new EmpDao();

	public List<Emp> queryAll(int page,int pageSize) {
		// TODO Auto-generated method stub
		String hql = " from Emp ";
		
		return dao.queryPage(hql, page, pageSize);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		Long count = dao.getCount(Emp.class);
		
		return count.intValue();
	}

	public void add(Emp emp) {
		// TODO Auto-generated method stub
		dao.addOne(emp);
		
	}

	public Emp findOne(int id) {
		// TODO Auto-generated method stub
		
		return dao.findOneByGet(Emp.class, id);
	}

	public void modify(Emp emp) {
		// TODO Auto-generated method stub
		dao.modify(emp);
	}

	public void remove(String ids) {
		// TODO Auto-generated method stub
		dao.deleAll(Emp.class, ids);
	}

}
