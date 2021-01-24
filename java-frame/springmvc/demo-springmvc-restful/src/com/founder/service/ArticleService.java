package com.founder.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.founder.dao.E5idMapperDao;
import com.founder.dao.XyArticleDao;
import com.founder.pojo.ResponseArticle;
import com.founder.pojo.ResponseIds;
import com.founder.pojo.Record;
import com.founder.pojo.ResponseState;
import com.founder.pojo.XyArticleEntity;
import com.founder.publish.CommonArticlePublisher;
import com.founder.publish.FlowNode;
import com.founder.task.ImpArticleHandler;
import com.founder.util.Const;

@Service
public class ArticleService {
	
	private static Log logger = LogFactory.getLog(ArticleService.class);
	@Resource
	private E5idMapperDao e5idMapperDao;
	
	@Resource
	private XyArticleDao xyArticleDao;
	
	@Autowired
	private ImpArticleHandler impArticleHandler;
	
	@Autowired
	private CommonArticlePublisher commonArticlePublisher;
	
	@Value("${article.siteID}")
	private int siteID;
	@Value("${article.autoPublish}")
	private int autoPublish;//0自动发布   1不自动发布
	
	//WEB发布库
	@Value("${id.ArticleDocID}")
	private String articleDocID;//DocID1
	@Value("${id.ArticleDoclibID}")
	private int articleDoclibID;//1
	@Value("${id.ArticleFolderID}")
	private int articleFolderID;//1
	
	//原稿库
	@Value("${id.OriginalDoclibID}")
	private int originalDoclibID;//2
	@Value("${id.OriginalFolderID}")
	private int originalFolderID;//2
	
	/**
	 * 根据稿件数量 获取E5ID
	 * @param articleCount
	 * @return
	 */
	public ResponseIds getArtIds(int articleCount){
		
		ResponseState reponseState = null;
		ResponseIds articleIds = new ResponseIds();
		Map<String, String> param = new HashMap<String, String>();
		param.put("increasement", String.valueOf(articleCount+1));
		param.put("docID", articleDocID);
		List<Integer> ids = articleIds.getArticleIds();
		try {
			int minArticleID = e5idMapperDao.getArticleID(param);
			for(int i=0;i<articleCount;i++){
				ids.add(minArticleID+i);
			}
			if(ids.size()>0){
				reponseState = impArticleHandler.getIdsRepState(true,ids);
			}else{
				reponseState = impArticleHandler.getIdsRepState(false,ids);
			}
			articleIds.setArticleIds(ids);;
			articleIds.setReponseState(reponseState);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articleIds;
	}
	
	/**
	 * 稿件入库
	 * @param records
	 * @return
	 */
	public ResponseArticle insertAtricle(Record[] records){
		ResponseArticle responseArticle = new ResponseArticle();
		List<ResponseState> artList = responseArticle.getArticleStates();
		Map<String, String> param = new HashMap<String, String>();
		ResponseState reponseState = null;
		XyArticleEntity articleEntity = null;
		try {
			for (Record record : records) {
				articleEntity = new XyArticleEntity();
				articleEntity.setA_siteID(siteID);
				articleEntity.setRecord(record);
				
				//设置流程，无审核流程,设置为第二个流程节点的对应值，并调用发布处理
				articleEntity.setSys_currentflow(1);;
				List<FlowNode> nodes = xyArticleDao.getFlowNodeList(1);
				if(autoPublish==0){
					articleEntity.setSys_currentnode(nodes.get(1).getCurrentNode());
					articleEntity.setSys_currentstatus(nodes.get(1).getCurrentStatus());
					articleEntity.setA_status(Const.STATUS_PUB_ING);
				}else{
					articleEntity.setSys_currentnode(nodes.get(0).getCurrentNode());
					articleEntity.setSys_currentstatus(nodes.get(0).getCurrentStatus());
					articleEntity.setA_status(Const.STATUS_PUB_NOT);
				}
				//判断栏目是否存在
				boolean columnFlag = true;
				articleEntity.setA_columnID(1);
				articleEntity.setA_columnAll("1");
				articleEntity.setA_column("第一频道");
				
				//处理稿件ID
				param.put("increasement", "1");
				param.put("docID", articleDocID);
				int articleID = e5idMapperDao.getArticleID(param);
				articleEntity.setSys_documentid(articleID);
				Double order = impArticleHandler.getNewOrder(articleEntity);
				articleEntity.setA_order(order);
				param.clear();
				//int articleID = articleEntity.getSys_documentid();
				//插入数据库
				boolean insertFlag = false;
				if(columnFlag){
					logger.info("------>指定的栏目存在，入库到发布库...");
					articleEntity.setSys_doclibid(articleDoclibID);
					articleEntity.setSys_folderid(articleFolderID);
					insertFlag = xyArticleDao.insertArticle(articleEntity);
					//发布
					if(insertFlag&&autoPublish==0){
						commonArticlePublisher.publishArticle(articleEntity);
					}
				}else{
					logger.info("------>指定的栏目不存在，入库到原稿库...");
					articleEntity.setSys_doclibid(originalDoclibID);
					articleEntity.setSys_folderid(originalFolderID);
					insertFlag = xyArticleDao.insertOriginalArticle(articleEntity);
				}
				//根据入库情况 返回状态信息
				if(insertFlag){
					reponseState = impArticleHandler.getImpRepState(true,articleID);
				}else{
					reponseState = impArticleHandler.getImpRepState(false,articleID);
				}
				artList.add(reponseState);
			}
			responseArticle.setArticleStates(artList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return responseArticle;
	}
	
	/*
	public int insertAtricle(Record record, String fieldName){
		XyArticleEntity articleEntity = new XyArticleEntity();
		articleEntity.setRecord(record);
		
		int id = e5idMapperDao.getDocIDByName(fieldName);
		if (id == 0) {
			System.out.println("ArticleService insertArticle id is failure");
			logger.info("ArticleService insertArticle id is failure");
			return 0;
		}

		Map<String, String> param = new HashMap<String, String>();
		param.put("incr", "1");
		param.put("docID", fieldName);
		// 自增
		e5idMapperDao.updateIdByName(param);

		articleEntity.setSys_documentid(id);
		Double order = ArticleHandler.getNewOrder(articleEntity);
		articleEntity.setA_order(order);

		Boolean flag = xyArticleDao.insertArticle(articleEntity);
		return flag ? id : 0;
	}
	*/
}
