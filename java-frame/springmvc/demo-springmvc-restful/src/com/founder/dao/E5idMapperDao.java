package com.founder.dao;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.founder.dao.E5DaoBase;

@Component
public class E5idMapperDao extends E5DaoBase{
	
	private static Log logger = LogFactory.getLog(E5idMapperDao.class);
	
	public E5idMapperDao() {
		super();
	}
	
	public int getDocIDByName(String docIdName){
		Object docId = getSessionTemplateMysql().
				selectOne("com.founder.mapper.E5idMapper.getDocIDByName", docIdName);
		if(docId == null){
			System.out.println("E5idMapperDao docId is null");
			return 0;
		}else{
			return (int)docId;
		}
	}
	
	public  int updateIdByName(Map<String, String> param){
		int rs = getSessionTemplateMysql().
				update("com.founder.mapper.E5idMapper.updateDocIdByName", param);
		if(rs == 0){
			System.out.println("E5idMapperDao updateIdByName is null");
			logger.info("E5idMapperDao updateIdByName is null");
		}
		return rs;
	}
	
	
	/**
	 * 此函数执行在一个事务中(spring配置是REQUIRES_NEW)
	 * @param param
	 * @return
	 */
	public int getArticleID(Map<String, String> param){
		
		int articleID = (Integer)getSessionTemplateMysql().selectOne("com.founder.mapper.E5idMapper.getID", param.get("docID"));
		getSessionTemplateMysql().update("com.founder.mapper.E5idMapper.updateID", param);
		return articleID;
		
	}
	
	/**
	 * 此函数执行在一个事务中(spring配置是REQUIRES_NEW)
	 * @param param
	 * @return
	 */
	public int getAttachID(Map<String, String> param){
		
		int attrID = (Integer)getSessionTemplateMysql().selectOne("com.founder.mapper.E5idMapper.getID", param.get("docID"));
		getSessionTemplateMysql().update("com.founder.mapper.E5idMapper.updateID", param);
		return attrID;
		
	}
	
}
