package com.founder.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.pojo.JsonArticleEntity;
import com.founder.pojo.Record;
import com.founder.pojo.ResponseArticle;
import com.founder.pojo.ResponseIds;
import com.founder.pojo.ResponseState;
import com.founder.service.ArticleService;
import com.founder.test.mqTest;
import com.founder.util.ParseJson;

@Controller
@RequestMapping("/article/*")
public class ArticleController {
	@Resource
	ArticleService articleService;
	
	@RequestMapping(value = "/hello", method=RequestMethod.GET, produces = "text/plain;charset=UTF-8")  
    public @ResponseBody  
    String hello() {  
		mqTest mt = new mqTest();
		mt.init();
        return "你好！hello";  
    }  
	
	@RequestMapping(value = "/say/{msg}", method=RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
    public @ResponseBody  
    String say(@PathVariable(value = "msg") String msg) {  
		String a = "{\"msg\":\"you say:'" + msg + "'\"}";  
		System.out.println(a);
        return a;  
    }  
	
	/**
	 * 获取指定个数的稿件id
	 * @param count
	 * @return
	 */
	@RequestMapping(value="/art/{count:\\d+}", method=RequestMethod.GET)
	@ResponseBody
	public String getArticleIds(@PathVariable("count") int count){
		System.out.println(count);
		
		ResponseIds articleIds = articleService.getArtIds(count);
		String resultStr = ParseJson.parseObject2JsonStr(articleIds);
		
		return resultStr;
		
	}
	
	/**
	 * 稿件入库，接收JSON串
	 * @param request
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="article", method=RequestMethod.POST, produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public String impArticle(HttpServletRequest request, @RequestBody String code) throws Exception{
		
		System.out.println("------------>"+code);
		
		//String parameter = request.getParameter("columnId");
		
		JsonArticleEntity jsonArticleEntity = ParseJson.parseJsonStr2Object(code);
		Record[] records = jsonArticleEntity.getResult().getDatas().getDetails().getRecord();
		int length = records.length;
		if(length <= 0 ){
			System.out.println("the record is null");
			return ParseJson.parseObject2JsonStr(new ResponseState(0, "failure", "exception:the record is null"));
		}
		ResponseArticle respArticle = articleService.insertAtricle(records);
		String resultStr = ParseJson.parseObject2JsonStr(respArticle);
		System.out.println(resultStr);
		return resultStr; 
         
		
		
		
//		for (Enumeration e = request.getSession().getAttributeNames(); e.hasMoreElements();) {
//			String attrib = new String(e.nextElement().toString());
//			System.out.println("SessionAttribute: " + attrib);
//			System.out.println(request.getSession().getAttribute(attrib));
//			System.out.println("-");
//		}

		/*
		Map<String, String[]> map = request.getParameterMap();
		Set<Entry<String, String[]>> set = map.entrySet();  
        Iterator<Entry<String, String[]>> it = set.iterator();  
        String str = "";
        while (it.hasNext()) {  
            Entry<String, String[]> entry = it.next();  
  
            System.out.println("KEY:"+entry.getKey());  
            str+=entry.getKey();
            for (String i : entry.getValue()) {  
                System.out.println(i);  
                if(!"".equals(i)){
                	str+="=";
                	str+=i;
                }
                str+="&";
            }  
        }  
        System.out.println("------->"+str.substring(0,str.length()-1));
        */
        
	}
	
    
}
