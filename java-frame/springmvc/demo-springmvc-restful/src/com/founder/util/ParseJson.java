package com.founder.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.founder.pojo.ResponseIds;
import com.founder.pojo.JsonArticleEntity;
import com.founder.pojo.Record;
import com.founder.pojo.ResponseState;


public class ParseJson {
	
	private static Log logger = LogFactory.getLog(ParseJson.class);
	
	
	public static String jsonStr = "{" + "\"result\": {" + "\"datas\": {" + "\"rcode\": \"200\"," + "\"details\": {"
			+ "\"record\": [" + "{" + "\"SY_INFOTYPE\": 1," + "\"IR_GROUPFLAG\": 0,"
			+ "\"IR_URLTIME\": \"2015-12-11 16:18:07\"," + "\"IR_URLTITLE\": \"市交通银行增派驻村扶贫力量\","
			+ "\"IR_ABSTRACT\": \"12月10日,交通银行怀化分行增加队员易凯到沅陵北溶乡碣滩村,加强扶贫攻坚力量。\","
			+ "\"IR_URLNAME\": \"http://www.ylxw.net/Info.aspx?ModelId=1&Id=80029\"," + "\"IR_SITENAME\": \"沅陵新闻网\","
			+ "\"RID\": \"2677354\"," + "\"IR_CHANNEL\": \"新闻中心_要闻快报\"," +"\"IR_CONTENT\":\"稿件正文内容\""+ "}" + "]" + "}," + "\"rstate\": \"success\","
			+ "\"databasic\": {" + "\"allpages\": 161," + "\"pageno\": 1," + "\"pagesize\": 2," + "\"allcount\": 322"
			+ "}" + "}" + "}" + "}";

	public static JsonArticleEntity parseJsonStr2JsonObject(){
		ObjectMapper mapper = new ObjectMapper();
		JsonArticleEntity jsonArticleEntity = new JsonArticleEntity();
		
		try {
			jsonArticleEntity = mapper.readValue(jsonStr, JsonArticleEntity.class);
			
		} catch (Exception e) {
			logger.info("解析出错！");
			System.out.println("解析出错！");
			return jsonArticleEntity = new JsonArticleEntity();
		}
		
		return jsonArticleEntity;
	}
	
	
	public static JsonArticleEntity parseJsonStr2Object(String jsonStr){
		ObjectMapper mapper = new ObjectMapper();
		JsonArticleEntity jsonArticleEntity = new JsonArticleEntity();
		
		try {
			jsonArticleEntity = mapper.readValue(jsonStr, JsonArticleEntity.class);
			
		} catch (Exception e) {
			logger.info("解析出错！");
			System.out.println("解析出错！");
			e.printStackTrace();
		}
		
		return jsonArticleEntity;
	}
	
	public static String parseObject2JsonStr(Object object){
		ObjectMapper mapper = new ObjectMapper();
		String resultJson = "";
		try {
			resultJson = mapper.writeValueAsString(object);
		} catch (Exception e) {
			logger.info("解析出错！");
			System.out.println("解析出错！");
		}
		return resultJson;
	}
	
	

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		System.out.println(jsonStr);
		ObjectMapper mapper = new ObjectMapper();
		JsonArticleEntity jsonArticleEntity = mapper.readValue(jsonStr, JsonArticleEntity.class);
		Record[] records = jsonArticleEntity.getResult().getDatas().getDetails().getRecord();
		for (Record record: records) {
			System.out.println(record);
		}
		
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		ids.add(4);
		ResponseIds articleIds = new ResponseIds();
		ResponseState reponseState = new ResponseState();
		reponseState.setMessage("get articleIds success!");
		articleIds.setArticleIds(ids);
		articleIds.setReponseState(reponseState);
		String str = ParseJson.parseObject2JsonStr(articleIds);
		
		System.out.println(str);
	}
	
}
