package com.jiangyu.test;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.output.FileWriterWithEncoding;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class TestFreeMarker{

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args)  throws Exception {
		//创建FreeMarker配置实例
		Configuration cfg = new Configuration();
		
//		URL resource = TestFreeMarker.class.getResource("templates");
//		System.out.println(resource);
		cfg.setDirectoryForTemplateLoading(new File(//setClassForTemplateLoading(this.getClass(), "../../../");
				"D:\\workspace\\java-eclipse\\freemarkDemo\\WebContent\\templates"));
		
		//创建数据模型
		Map root = new HashMap();
		root.put("user", "小白侠");
		root.put("num0", 1);
		root.put("飞天猫熊", "123/321");
		
		//javabean可以自动转化   类似于我们前面学习的EL表达式
		/**
		 * User u = new User();
		 * u.setUname("姜宇");
		 * root.put("user1", u);
		 */
		
		//加载模版文件
		Template t =cfg.getTemplate("abc.ftl");
		
		//向freemarker模版中写入数据
//		Writer out = new OutputStreamWriter(System.out);
//		t.process(root, out);
		
		FileWriterWithEncoding out = null;
		//通过一个文件输出流，就可以写到相应的文件中
		out = new FileWriterWithEncoding(new File(
				"D:/workspace/java-eclipse/freemarkDemo/WebContent/templates/static.htm"),
				"UTF-8");
		
		t.process(root, out);
		out.flush();
		
	}
	
}
