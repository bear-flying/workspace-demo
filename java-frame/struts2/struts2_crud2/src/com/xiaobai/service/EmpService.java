package com.xiaobai.service;

import java.util.List;

import com.xiaobai.dao.EmpDao;
import com.xiaobai.domain.Emp;
import com.xiaobai.utils.PageBean;

public class EmpService {

	private EmpDao dao = new EmpDao();
	
	public List<Emp> findAll() {
		// TODO Auto-generated method stub
		String sql = " select a.*,b.rname rname from b_emp a left join b_role b on a.rid = b.id ";
		
		return dao.findAll(sql);
	}

	public Emp findById(int id) {
		// TODO Auto-generated method stub
		String sql = " select * from b_emp where id = ? ";
		
		return dao.findById(sql,id);
	}

	public void drop(int i) {
		// TODO Auto-generated method stub
		String sql = " delete from b_emp where id = ? ";
		 
		dao.drop(sql,i);
	}

	public void add(Emp emp) {
		// TODO Auto-generated method stub
		String sql = " insert into b_emp(name,sex,hobby,rid) values(?,?,?,?) ";
		dao.add(sql,emp);
	}

	public int getTotalNums(){
		
		String sql = " select count(*) from b_emp ";
		return dao.getTotalNums(sql);
	}

	public PageBean<Emp> findByPage(int page, int pageSize) {
		String sql = " select a.*,b.rname rname from b_emp a left join b_role b on a.rid = b.id ";
		
		return dao.findByPage(sql,page,pageSize);
	}

	public void alter(Emp emp) {
		// TODO Auto-generated method stub
		String sql = " update b_emp set name=?,sex=?,hobby=?,rid=? where id=?";
		
		dao.alter(sql,emp);
	}
	
}
