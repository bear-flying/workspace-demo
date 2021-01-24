package com.founder.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.founder.dao.E5DaoBase;
import com.founder.pojo.XyArticleEntity;
import com.founder.publish.FlowNode;

@Component
public class XyArticleDao extends E5DaoBase {
	
	public XyArticleDao() {
		super();
	}

	// 插入表 xy_article 
	public boolean insertArticle(XyArticleEntity article){
		return getSessionTemplateMysql().insert("com.founder.mapper.XyArticle.insertArt", article) > 0;
	}

	// 插入表 xy_original
	public boolean insertOriginalArticle(XyArticleEntity article) {
		return getSessionTemplateMysql().insert("com.founder.mapper.XyArticle.insertOriginalArt", article) > 0;
	}

	@SuppressWarnings("unchecked")
	public List<FlowNode> getFlowNodeList(int flowID){
		return (List<FlowNode>)getSessionTemplateMysql().selectList("com.founder.mapper.XyArticle.getFlowNodes", flowID);
		
	}
	
	
}
