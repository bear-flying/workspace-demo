package com.cms.dao;



import java.util.List;

import com.cms.pojo.Newstype;
import com.xiaobai.utils.BaseDao;
import com.xiaobai.utils.PageBean;

public class NewstypeDao {

	private BaseDao dao = new BaseDao();
	
	public PageBean<Newstype> query(int page,int pageSize) {

		return dao.queryByPage2(Newstype.class, "a_news_type", "", page, pageSize);
	
	}

	public void add(String sql, Newstype n) {
		// TODO Auto-generated method stub
		dao.executeUpdate(sql, n.getName());
	}

	public Newstype queryOne(String sql, int id) {
		// TODO Auto-generated method stub
		return dao.queryOne(Newstype.class, sql, id);
	}

	public void alter(String sql, Newstype n) {
		// TODO Auto-generated method stub
		dao.executeUpdate(sql, n.getName(),n.getId());
	}

	public void drop(String sql, int id) {
		// TODO Auto-generated method stub
		dao.executeUpdate(sql, id);
	}

	public List<Newstype> queryAll(String sql) {
		// TODO Auto-generated method stub
		return dao.queryAll(Newstype.class, sql);
	}

	
	
}
