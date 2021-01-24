package com.founder.task;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.founder.pojo.ResponseState;
import com.founder.pojo.XyArticleEntity;

@Component
public class ImpArticleHandler extends AbstractArticleHandler {
	
	public static Log logger = LogFactory.getLog(ImpArticleHandler.class);
	
	//稿件排序时间
	@Value("${article.order}")
	private String articleTime;

	
	public ImpArticleHandler() {
		super();
	}
	
	public double getNewOrder(XyArticleEntity xyArticleEntity) {
		return super.getNewOrder(xyArticleEntity, articleTime);
	}
	
	/**
	 * 获取e5ID 返回消息
	 * @param flag
	 * @param articleID
	 * @return
	 */
	public ResponseState getIdsRepState(boolean flag, List<Integer> ids){
		ResponseState reponseState = new ResponseState();
		if(flag){
			reponseState.setCode(200);
			reponseState.setState("success");
			reponseState.setMessage("get articleIds success! These ID are:"+listToString(ids,',')+"...");
		}else{
			reponseState.setCode(400);
			reponseState.setState("failure");
			reponseState.setMessage("get articleIds failure!");
		}
		return reponseState;
	}


	/**
	 * 稿件入库 返回消息
	 * @param flag
	 * @param articleID
	 * @return
	 */
	public ResponseState getImpRepState(boolean flag, int articleID) {
		
		ResponseState reponseState = new ResponseState();
		if(flag){
			reponseState.setCode(200);
			reponseState.setState("success");
			reponseState.setMessage("import articleID:"+articleID+" success!");
		}else{
			reponseState.setCode(400);
			reponseState.setState("failure");
			reponseState.setMessage("import articleID:"+articleID+" failure!");
		}
		return reponseState;
	}
	
	public String listToString(List<Integer> list, char separator) {    
		return org.apache.commons.lang.StringUtils.join(list.toArray(),separator);    
	}
	
}
