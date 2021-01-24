package com.founder.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.founder.pojo.JsonArticleEntity;
import com.founder.pojo.Record;
import com.founder.service.ArticleService;
import com.founder.util.ParseJson;

public class StartRun {
	private static String[] springXmls = {
		"classpath:applicationContext.xml"};
	
	private static ApplicationContext factory = new ClassPathXmlApplicationContext(springXmls);
	
	public static void main(String[] args) {
		try {
			JsonArticleEntity jsonArticleEntity = ParseJson.parseJsonStr2JsonObject();
			Record[] records = jsonArticleEntity.getResult().getDatas().getDetails().getRecord();
			int length = records.length;
			if(length <= 0 ){
				System.out.println("the record is null");
				return ;
			}
			ArticleService articleService = (ArticleService)getBean("articleService");
			//int articleid = articleService.insertAtricle(records[0], "DocID1");
			//System.out.println(articleid);
		} catch (Exception e) {
			System.out.println("启动系统失败:" + e);
			e.printStackTrace();
		}

	}
	
	public static Object getBean(String beanName){
		
		return factory.getBean(beanName);
		
	}
	

}
