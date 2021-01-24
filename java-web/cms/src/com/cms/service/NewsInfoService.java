package com.cms.service;

import java.util.List;

import com.cms.dao.NewsInfoDao;

import com.cms.pojo.NewsInfo;

import com.xiaobai.utils.PageBean;


public class NewsInfoService {

	NewsInfoDao dao = new NewsInfoDao();
	
	public List<NewsInfo> query() {

		String sql = "select i.id,i.news_title newsTitle,i.news_author newsAuthor,i.type_id typeId," +
				"i.news_content newsContent,i.create_datetime createDatetime,i.update_datetime updateDatetime,t.name name from a_news_info i left join a_news_type t on i.type_id = t.id";
		
		return dao.query(sql);
	}

	public void add(NewsInfo n) {
		// TODO Auto-generated method stub
		String sql = "insert into a_news_info(news_title,news_author,type_id,news_content,create_datetime,update_datetime) values (?,?,?,?,?,?)";
		
		dao.add(sql,n);
	}

	public NewsInfo queryOne(int id) {
		// TODO Auto-generated method stub
		String sql = "select id,news_title newsTitle,news_author newsAuthor,type_id typeId,news_content newsContent,create_datetime createDatetime,update_datetime updateDatetime from a_news_info where id = ?";
		
		return dao.queryOne(sql,id);
	}

	public void alter(NewsInfo n) {
		// TODO Auto-generated method stub
		String sql = "update a_news_info set news_title=?,news_author=?,type_id=?,news_content=?,create_datetime=?,update_datetime=? where id = ?";
		
		dao.alter(sql,n);
	}

	public void drop(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from a_news_info where id = ?";
		
		dao.drop(sql,id);
	}

	public void dropByTypeId(int typeId) {
		
		String sql = "delete from a_news_info where type_id = ?";
		
		dao.drop(sql, typeId);
	}
	
	public PageBean<NewsInfo> queryByPage(int page, int pageSize,
			NewsInfo n) {
		
		String sql = "select i.id,i.news_title newsTitle,i.news_author newsAuthor,i.type_id typeId," +
				" i.news_content newsContent,i.create_datetime createDatetime,i.update_datetime updateDatetime,t.name name " +
				" from a_news_info i left join a_news_type t on i.type_id = t.id "+condition(n)+" limit ?,?";
		String count = " select count(*) from a_news_info "+condition(n);
		
		return dao.queryByPage(page,pageSize,sql,count);
	}

	private String condition(NewsInfo n) {
		
		if(n==null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(" where 1 = 1 ");
		
		if(n.getNewsTitle()!=null && ! n.getNewsTitle().trim().equals("")){
			sb.append(" and news_title like '%"+n.getNewsTitle().trim()+"%' ");
		}
		if(n.getNewsAuthor()!=null && ! n.getNewsAuthor().trim().equals("")){
			sb.append(" and news_author like '%"+n.getNewsAuthor().trim()+"%' ");
		}
		if(n.getNewsContent()!=null && ! n.getNewsContent().trim().equals("")){
			sb.append(" and news_content like '%"+n.getNewsContent().trim()+"%' ");
		}

		return sb.toString();
	}

	
}
