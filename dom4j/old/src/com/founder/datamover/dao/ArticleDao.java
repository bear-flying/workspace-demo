package com.founder.datamover.dao;

import java.util.List;
import java.util.Map;

import com.founder.datamover.po.Article;

public interface ArticleDao {
	
	/**
	 * 获取文章稿件信息
	 * 
	 * */
	public List<Article> getArticleList(String sqlId,Map<String,Integer> map) throws Exception;
	/**
	 * 获取组图稿件信息
	 * 
	 * */
	public List<Article> getMuliArticleList(String sqlId,Map<String,Integer> map) throws Exception;
	
	public int doxml(Integer id);
	
	public String getTargetNode(Integer id);
	
}
