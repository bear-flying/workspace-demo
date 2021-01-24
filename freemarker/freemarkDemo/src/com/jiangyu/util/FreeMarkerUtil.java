package com.jiangyu.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.apache.commons.io.output.FileWriterWithEncoding;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerUtil {

	//getTemplate("01.ftl")
	public Template getTemplate(String name){
		
		try {
			//通过FreeMarker的Configuration读取相应的ftl
			Configuration cfg = new Configuration();
			//设定去哪里读取相应的ftl模版文件(相对路径)
			cfg.setClassForTemplateLoading(this.getClass(), "../../../");
			
			//在模版文件目录中找到名称为name的文件
			Template temp = cfg.getTemplate(name, "UTF-8");
			return temp;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void print(String name,Map<String,Object> root){
		
		try {
			//通过Template可以将模版文件输出到相应的流
			Template temp = this.getTemplate(name);
			temp.process(root, new PrintWriter(System.out));
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void fprint(String name,Map<String,Object> root,String outFileName){
		FileWriterWithEncoding out = null;
		try {
			//通过Template可以将模版文件输出到相应的流
			out = new FileWriterWithEncoding(new File(outFileName),"UTF-8");
			Template temp = this.getTemplate(name);
			temp.process(root, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(out!=null) out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
