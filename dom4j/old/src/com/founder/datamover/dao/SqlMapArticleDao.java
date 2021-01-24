package com.founder.datamover.dao;

import java.util.List;
import java.util.Map;

import com.founder.datamover.po.Article;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

public class SqlMapArticleDao extends SqlMapDaoTemplate implements ArticleDao{
	
	public SqlMapArticleDao(DaoManager daoManager) {
		super(daoManager);
	}

	/**
	 * 获取稿件信息
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public List<Article> getArticleList(String sqlId,Map<String,Integer> map) throws Exception{
		return queryForList(sqlId,map);
	}
	
	@SuppressWarnings("unchecked")
	public List<Article> getMuliArticleList(String sqlId,
			Map<String, Integer> map) throws Exception {
		// TODO Auto-generated method stub
		return queryForList(sqlId+"muli",map);
	}
	
	public int doxml(Integer id){
		return update("doxml", id );
	}
	
	public String getTargetNode(Integer id){
		String sName = "";
		String sNamePath = "";
		while(true){
			sName = (String)queryForObject("getCategoryName",id);
			sNamePath = sName+"~"+sNamePath;
			id = (Integer)queryForObject("getCategoryParent",id);
			if(id == null || id==0){
				break;
			}
		}
		return sNamePath;
	}

	
}
