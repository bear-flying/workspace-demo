package com.founder.datamover.util.html;

import org.apache.log4j.Logger;


public class ContentTools {
	
	//日志
	public static Logger logger = Logger.getLogger(ContentTools.class.getName());
	
	/**
	 * 转换稿件内容格式。将稿件内容通过tidy整理后，转换为翔宇4.0能够识别的稿件内容
	 * 
	 * */
	public static String convertContent(String oldContentStr){
		String newContentStr = null;
		if(oldContentStr != null && !"".equals(oldContentStr)){
			try{
				newContentStr = HTMLTool.convertString2XML(oldContentStr, true);
				if(newContentStr.indexOf("<body xmlns=\"http://www.w3.org/1999/xhtml\">") != -1){
					newContentStr = newContentStr.substring(newContentStr.indexOf("<body xmlns=\"http://www.w3.org/1999/xhtml\">")+43, newContentStr.indexOf("</body>"));
				}
			}catch(Exception e){
				logger.error("",e);
				newContentStr = "暂无稿件内容!";
			}
		}else{
			newContentStr = "暂无稿件内容!";
		}
		return newContentStr;
	}
	
	
	

	
	
}
