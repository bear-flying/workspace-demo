package com.founder.test;

//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;

public class FastJonTest {
	public static String jsonStr = "{" + "\"result\": {" + "\"datas\": {" + "\"rcode\": \"200\"," + "\"details\": {"
			+ "\"record\": [" + "{" + "\"SY_INFOTYPE\": 1," + "\"IR_GROUPFLAG\": 0,"
			+ "\"IR_URLTIME\": \"2015-12-11 16:18:07\"," + "\"IR_URLTITLE\": \"市交通银行增派驻村扶贫力量\","
			+ "\"IR_ABSTRACT\": \"12月10日,交通银行怀化分行增加队员易凯到沅陵北溶乡碣滩村,加强扶贫攻坚力量。\","
			+ "\"IR_URLNAME\": \"http://www.ylxw.net/Info.aspx?ModelId=1&Id=80029\"," + "\"IR_SITENAME\": \"沅陵新闻网\","
			+ "\"RID\": \"2677354\"," + "\"IR_CHANNEL\": \"新闻中心_要闻快报\"," +"\"IR_CONTENT\":\"稿件正文内容\""+ "}" + "]" + "}," + "\"rstate\": \"success\","
			+ "\"databasic\": {" + "\"allpages\": 161," + "\"pageno\": 1," + "\"pagesize\": 2," + "\"allcount\": 322"
			+ "}" + "}" + "}" + "}";
	/*
	public static void main(String[] args) {
		//public static final JSONObject parseObject(String text)； // 把JSON文本parse成JSONObject
		//JSONObject jsonObject = JSON.parseObject(jsonStr);
		//Object object = jsonObject.get("result");
		JSONObject jsonObject = JSON.parseObject(jsonStr);
		jsonObject = 
				jsonObject.getJSONObject("result").getJSONObject("datas").getJSONObject("details");
		JSONArray jsonArray = jsonObject.getJSONArray("record");
		int size = jsonArray.size();
		Object object = jsonArray.get(0);
		System.out.println(object);
	}
	*/
}
