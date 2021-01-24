package com.baidu.parse.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.output.FileWriterWithEncoding;





import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkerTest {

	public  void createHtml(){
		
		try {
			//创建配置
			Configuration configuration =new Configuration();
			
			configuration.setClassForTemplateLoading(this.getClass(), "../../../");
			
			//获取模板文件
			Template template = configuration.getTemplate("template.ftl");
			
			
			Map map = new HashMap();
			map.put("name", "aaa");
//			
//			User user1  =new User("11", "11");
//			User user2  =new User("22", "22");
			
			List list = new ArrayList();
//			list.add(user1);
//			list.add(user2);
			map.put("list", list);
			
			
			FileWriterWithEncoding out = new FileWriterWithEncoding(new File("tomcat\\app\\html\\id.html"), "UTF-8");
			
			template.process(map, out);
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		FreemarkerTest test = new FreemarkerTest();
		test.createHtml();
		
	}
}
