package com.cms.dao;

import java.util.List;

import com.cms.pojo.NewsInfo;
import com.xiaobai.utils.BaseDao;
import com.xiaobai.utils.PageBean;

public class NewsInfoDao {

	BaseDao dao = new BaseDao();
	
	public List<NewsInfo> query(String sql) {
		// TODO Auto-generated method stub
		return dao.queryAll(NewsInfo.class, sql);
	}

	public void add(String sql, NewsInfo n) {
		// TODO Auto-generated method stub
		dao.executeUpdate(sql, n.getNewsTitle(),n.getNewsAuthor(),n.getTypeId(),n.getNewsContent(),n.getCreateDatetime(),n.getUpdateDatetime());
		
	}

	public NewsInfo queryOne(String sql, int id) {
		// TODO Auto-generated method stub
		return dao.queryOne(NewsInfo.class, sql, id);
	}

	public void alter(String sql, NewsInfo n) {
		// TODO Auto-generated method stub
		dao.executeUpdate(sql, n.getNewsTitle(),n.getNewsAuthor(),n.getTypeId(),n.getNewsContent(),n.getCreateDatetime(),n.getUpdateDatetime(),n.getId());
	}

	public void drop(String sql, int id) {
		// TODO Auto-generated method stub
		dao.executeUpdate(sql, id);
	}

	public PageBean<NewsInfo> queryByPage(int page, int pageSize, String sql,
			String count) {
		// TODO Auto-generated method stub
		return dao.queryByPage(NewsInfo.class, sql, count, page, pageSize);
	}

}
