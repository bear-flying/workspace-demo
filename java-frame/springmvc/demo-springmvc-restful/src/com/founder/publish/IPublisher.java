package com.founder.publish;

import com.founder.pojo.XyArticleEntity;

public interface IPublisher {
	
	/**
	 * 发布
	 */
	public void publishArticle(XyArticleEntity articleEntity) throws Exception;

	/**
	 * 撤稿
	 */
	public void articleRevoke(XyArticleEntity articleEntity) throws Exception;
	
	
}
