package cn.itcast.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FMutil {
	
	/**
	 * ftl是freemarker的后缀名
	 * @param ftlName:模板的名字（模子）已知
	 * @param fileName:生成之后页面的名字（月饼）未知
	 * @param map数据（面）已知
	 * @throws Exception
	 */
	public void ouputFile(String ftlName, String fileName,  Map<String, Object> map) throws Exception{
		//创建fm的配置
		Configuration config = new Configuration();
		//指定默认编码格式
		config.setDefaultEncoding("UTF-8");
		//设置模板的包路径
		config.setClassForTemplateLoading(this.getClass(), "/ftl");
		//获得包的模板
		Template template = config.getTemplate(ftlName);
		//指定文件输出的路径
		String path = "D:/fm";
		//定义输出流，注意的必须指定编码
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path+"/"+fileName)),"UTF-8"));
		//生成文件
		template.process(map, writer);
	}

}
