package com.xiaobai.dao;

import java.util.List;

import com.xiaobai.domain.Emp;
import com.xiaobai.utils.BaseDao;
import com.xiaobai.utils.PageBean;

public class EmpDao {

	private BaseDao dao = new BaseDao();
	
	public List<Emp> findAll(String sql) {
		// TODO Auto-generated method stub
		return dao.queryAll(Emp.class, sql);
	}

	public Emp findById(String sql, int id) {
		// TODO Auto-generated method stub
		return dao.queryOne(Emp.class, sql, id);
	}

	public void drop(String sql, int i) {
		// TODO Auto-generated method stub
		dao.executeUpdate(sql, i);
	}

	public void add(String sql, Emp emp) {
		// TODO Auto-generated method stub
		dao.executeUpdate(sql, emp.getName(),emp.getSex(),emp.getHobby(),emp.getRid());
	}

	public int getTotalNums(String sql){
		return dao.getTotalNums(sql);
	}

	public PageBean<Emp> findByPage(String sql, int page, int pageSize) {
		// TODO Auto-generated method stub
		return dao.queryPage(Emp.class, sql, page, pageSize);
	}

	public void alter(String sql, Emp emp) {
		// TODO Auto-generated method stub
		dao.executeUpdate(sql, emp.getName(),emp.getSex(),emp.getHobby(),emp.getRid(),emp.getId());
	}
	
}
