package com.cms.service;



import java.util.List;

import com.cms.dao.NewstypeDao;
import com.cms.pojo.Newstype;
import com.xiaobai.utils.PageBean;

public class NewstypeService {

	NewstypeDao dao = new NewstypeDao();
	
	public PageBean<Newstype> query(int page,int pageSize) {

		
		return dao.query(page,pageSize);
	}

	public void add(Newstype n) {
		// TODO Auto-generated method stub
		String sql = "insert into a_news_type(name) values (?)";
		
		dao.add(sql,n);
	}

	public Newstype queryOne(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from a_news_type where id = ?";
		
		return dao.queryOne(sql,id);
	}

	public void alter(Newstype n) {
		// TODO Auto-generated method stub
		String sql = "update a_news_type set name = ? where id = ?";
		
		dao.alter(sql,n);
	}

	public void drop(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from a_news_type where id = ?";
		
		dao.drop(sql,id);
	}

	public List<Newstype> queryAll() {
		
		String sql = " select * from a_news_type";
		return dao.queryAll(sql);
	}

	

	
}
