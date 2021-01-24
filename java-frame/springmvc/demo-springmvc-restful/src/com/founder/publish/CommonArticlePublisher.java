package com.founder.publish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.founder.pojo.XyArticleEntity;


@Component
public class CommonArticlePublisher implements IPublisher {
	
	@Autowired
	protected Publisher pubSender;//必须用注解  用set方法 无效
	
	public void setSender(Publisher pubSender) {
		this.pubSender = pubSender;
	}
	
	@Override
	public void publishArticle(XyArticleEntity articleEntity) {
		if (articleEntity.getA_columnID() > 0) {
			ArticleMsg msg = getArticleMsg(articleEntity);
			sendMsg("pubSender", msg);
		}

	}

	@Override
	public void articleRevoke(XyArticleEntity articleEntity) {
		if (articleEntity.getA_columnID() > 0) {
			ArticleMsg msg = getArticleMsg(articleEntity);
			sendMsg("revokeSender", msg);
		}

	}

	// 发送消息。捕捉异常
	public void sendMsg(String senderName, Object msg) {
		try {
			pubSender.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 从稿件组织消息数据
	private ArticleMsg getArticleMsg(XyArticleEntity articleEntity) {
		if (articleEntity.getSys_documentid() == 0)
			return null;
		ArticleMsg msg = new ArticleMsg(articleEntity.getSys_doclibid(), articleEntity.getSys_documentid(), 
				articleEntity.getA_columnID(),
				String.valueOf(articleEntity.getA_columnID()), 
				articleEntity.getA_type(), 
				1);
		return msg;
	}

}
