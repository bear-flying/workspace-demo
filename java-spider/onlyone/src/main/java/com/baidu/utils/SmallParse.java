package com.baidu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.HasParentFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.baidu.parse.pojo.App;
import com.baidu.parse.pojo.Comment;
import com.baidu.parse.pojo.Pic;

public class SmallParse {

	Parser parser = null;
	
	TagNameFilter tagNameFilter = null;
	NodeList nodeList = null;
	HasAttributeFilter hasAttributeFilter = null;
	AndFilter andFilter  = null;
	HasParentFilter parentFilter = null;


	public SmallParse(String url){	
		try {
			parser = new Parser(url);
			parser.setEncoding("UTF-8");
		} catch (ParserException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：通过解析标题  得到应用名称
	 * 时间：2016年1月11日
	 * 作者：1405javab 姜宇
	 * @return
	 */
	public String parseTitle(){
		parser.reset();
		String appname = null;
		try {
			tagNameFilter = new TagNameFilter("title");
			nodeList = parser.parse(tagNameFilter);
			String nodeValue = nodeList.elementAt(0).toPlainTextString();//获取双标签的内容
			appname = nodeValue.substring(0,nodeValue.lastIndexOf("-"));
			
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return appname;	
	}
	
	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：解析应用图标
	 * 时间：2016年1月11日
	 * 作者：1405javab 姜宇
	 * @return
	 */
	public String parseLogo(){
		parser.reset();
		String appiconName = null;
		try {
			tagNameFilter = new TagNameFilter("img");
			hasAttributeFilter = new HasAttributeFilter("id", "appicon");//img的id="appicon"唯一
			andFilter = new AndFilter(tagNameFilter, hasAttributeFilter);//将两个条件合并
			nodeList= parser.parse(andFilter);
			TagNode tagNode = (TagNode)nodeList.elementAt(0);
			String appiconUrl = tagNode.getAttribute("src");//获取单标签的属性值
			//http://u5.mm-img.mmarket.com:80/rs/res1/21/2013/09/05/a930/482/26482930/logo2140x1408364726173_src.jpg
			appiconName = appiconUrl.substring(appiconUrl.lastIndexOf("/")+1);
			//将图片下载到本地服务器上request.getSession().getServletContext().getRealPath("/")+"\\download"+appiconName
			HttpClientUtil.httpDownload(appiconUrl,"D:\\Program Files\\GongZuo2\\apache-tomcat-7.0.54\\webapps\\onlyone\\download\\"+appiconName);
		} catch (ParserException e) {
			e.printStackTrace();
		}
		return appiconName;
	}
	
	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：解析应用程序下载路径
	 * 时间：2016年1月11日
	 * 作者：1405javab 姜宇
	 * @return
	 */
	public String parseURL(){
		parser.reset();
		tagNameFilter = new TagNameFilter("div");
		hasAttributeFilter = new HasAttributeFilter("class", "mj_cont_left_t");
		andFilter = new AndFilter(tagNameFilter, hasAttributeFilter);
		parentFilter = new HasParentFilter(andFilter);
		
		tagNameFilter = new TagNameFilter("a");
		andFilter = new AndFilter(tagNameFilter, parentFilter);
		
		String attribute = null;
		try {
			nodeList = parser.parse(andFilter);
			TagNode tagNode = (TagNode)nodeList.elementAt(0);
			attribute = tagNode.getAttribute("href");
		} catch (ParserException e) {
			e.printStackTrace();
		}
		return attribute;
		
	} 
	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：解析应用介绍
	 * 时间：2016年1月11日
	 * 作者：1405javab 姜宇
	 * @return
	 */
	public String parseIntroduce() {
		
		parser.reset();
		tagNameFilter = new TagNameFilter("div");
		hasAttributeFilter = new HasAttributeFilter("class", "mj_yyjs font-f-yh");
		andFilter = new AndFilter(tagNameFilter, hasAttributeFilter);
		try {
			nodeList = parser.parse(andFilter);//获取到所有的li(APP应用详情集合)
		} catch (ParserException e) {
			e.printStackTrace();
		}
		return nodeList.elementAt(0).toPlainTextString();
		
	}
	
	
	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：解析应用详情(感兴趣的人数，价格，版本，大小，开发者，所属类别，更新时间，系统支持 等)	
	 * 时间：2016年1月11日
	 * 作者：1405javab 姜宇
	 * @return
	 */
	public List<String> parseDetal(){
		parser.reset();
		tagNameFilter = new TagNameFilter("div");//无序列表(父元素ul的父元素div属性唯一class="mj_info font-f-yh")
		hasAttributeFilter = new HasAttributeFilter("class", "mj_info font-f-yh");
		andFilter = new AndFilter(tagNameFilter, hasAttributeFilter);
		parentFilter = new HasParentFilter(andFilter);
		
		tagNameFilter = new TagNameFilter("ul");
		andFilter = new AndFilter(tagNameFilter, parentFilter);
		parentFilter = new HasParentFilter(andFilter);
		
		tagNameFilter = new TagNameFilter("li");
		andFilter = new AndFilter(tagNameFilter, parentFilter);
		try {
			nodeList = parser.parse(andFilter);//获取到所有的li(APP应用详情集合)
		} catch (ParserException e) {
			e.printStackTrace();
		}
		
		String value = null;
		List<String> list = new ArrayList<String>();
		
		for(int i = 0;i < nodeList.size();i++){
			if(i == 0){
				Node node = nodeList.elementAt(0);
				NodeList children = node.getChildren();
				Node elementAt = children.elementAt(0);
				value = elementAt.toPlainTextString();
				list.add(value);
				//.out.println(value.substring(0,value.length()-3));//<1万
				
				
			}else if(i == 4){
				Node node = nodeList.elementAt(4);
				value = node.toPlainTextString().trim();
				list.add(value);
				//System.out.println(value.substring(value.indexOf("：")+1));//福州合和信息技术有限公司
				
			}else{
				Node node = nodeList.elementAt(i);
				value = node.toPlainTextString();
				list.add(value);
				//System.out.println(value.substring(value.indexOf("：")+1).trim());
			}
		}
		return list;
	}
	
	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：解析并获取本应用的所有轮播图片
	 * 时间：2016年1月11日
	 * 作者：1405javab 姜宇
	 * @return
	 */
	public List<Pic> ParseDynamicImg(String appid) {
		parser.reset();
		tagNameFilter = new TagNameFilter("div");
		hasAttributeFilter = new HasAttributeFilter("class", "mj_lunbo");
		andFilter = new AndFilter(tagNameFilter, hasAttributeFilter);
		parentFilter = new HasParentFilter(andFilter);
		
		tagNameFilter = new TagNameFilter("div");
		andFilter = new AndFilter(tagNameFilter, parentFilter);
		
		List<Pic> list = new ArrayList<Pic>();
		try {
			nodeList = parser.parse(andFilter);//获取所有轮播图片的div
			for (int i = 0; i < nodeList.size(); i++) {
				Node node = nodeList.elementAt(i).getFirstChild();
				if(node instanceof ImageTag){//如果是IMG标签
					ImageTag image  = (ImageTag)node;
					String imageURL = image.getImageURL();
					String fileName = imageURL.substring(imageURL.lastIndexOf("/")+1);
					//HttpClient 可以模拟远程发送请求 和 远程下载数据
					//下载图片//将图片下载到本地服务器上request.getSession().getServletContext().getRealPath("/")+"\\download\\"+appiconName
					HttpClientUtil.httpDownload(imageURL,"D:\\Program Files\\GongZuo2\\apache-tomcat-7.0.54\\webapps\\onlyone\\download\\"+fileName);
					Pic pic = new Pic();
					pic.setApp(appid);
					pic.setId(UUID.randomUUID().toString().replaceAll("-", "").substring(0,29));
					pic.setPicurl(imageURL);
					pic.setDescription(fileName);
					list.add(pic);
				}
			}
			//list = HttpParseUtil.processNodeList(nodeList, null);
		} catch (ParserException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：解析并获得本应用的所有评论信息
	 * 时间：2016年1月11日
	 * 作者：1405javab 姜宇
	 * @return
	 */
	public List<Comment> parseComment(String appid){
		parser.reset();
		tagNameFilter = new TagNameFilter("div");
		hasAttributeFilter = new HasAttributeFilter("class", "mj_pl_list_i_m");
		andFilter = new AndFilter(tagNameFilter, hasAttributeFilter);
		
		List<Comment> list = new ArrayList<Comment>();
		
		try {
			nodeList = parser.parse(andFilter);
			for (int i = 0; i < nodeList.size(); i++) {
				Node node = nodeList.elementAt(i);
				NodeList nlist = node.getChildren();
				Comment comm = new Comment();
				comm.setAppid(appid);
				for(int j=0;j<nlist.size();j++){
					if(j==0){
						Node node2 = nlist.elementAt(0);
						TagNode first = (TagNode)node2.getFirstChild().getFirstChild();
						String attr1 = first.getAttribute("style");
						comm.setCommentNum(attr1.substring(attr1.lastIndexOf(":")+1));
						String attr2 = node2.getLastChild().toPlainTextString();
						comm.setCommentUser(attr2);
					}
					if(j==1){
						String comments = nlist.elementAt(1).toPlainTextString();
						comm.setComment(comments);
					}
					if(j==2){
						Node node3 = nlist.elementAt(2);
						String attr3 = node3.getLastChild().toPlainTextString();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
						Date date = null;
						try {
							date = sdf.parse(attr3);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						comm.setCommentDate(date);
					}
					comm.setId(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 29));
					
				}
				list.add(comm);
			}
			
		} catch (ParserException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：获取解析本应用的App
	 * 时间：2016年1月12日
	 * 作者：1405javab 姜宇
	 * @param title
	 * @return
	 */
	public App parseApp(String title){
		App app = new App();
		app.setId(UUID.randomUUID().toString().replaceAll("-", "").substring(0,30));
		app.setAppname(title);
		List<String> detal = parseDetal();
		for (int i = 0; i < detal.size(); i++) {
			String s = detal.get(i);
			
			
			if(s.indexOf("：")==-1){
				app.setDownloadNums(s);
			}else if((s.split("：")[0]).equals("价　　钱")){
				String s1 = s.split("：")[1].trim().equals("免费")?"0.0":s.split("：")[1].trim().substring(1);
			
				app.setPrice(Double.parseDouble(s1));
			}else if((s.split("：")[0]).equals("版　　本")){
				if(s.split("：").length>=2)
				app.setVersion(s.split("：")[1]);
			}else if((s.split("：")[0]).equals("大　　小")){
				app.setFilesize(s.split("：")[1]);
			}else if((s.split("：")[0]).equals("开 发 者")){
				app.setDeveloper(s.split("：")[1]);
			}else if((s.split("：")[0]).equals("所属类别")){
				app.setApptype(s.split("：")[1]);
			}else if((s.split("：")[0]).equals("更新时间")){
				try {
					app.setUpdatetime(new SimpleDateFormat("yyyy-MM-dd").parse(s.split("：")[1]));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}else if((s.split("：")[0]).equals("系统支持")){
				app.setPlatform(s.split("：")[1]);
			}
			
		}
		app.setAppicon(parseLogo());
		app.setApkurl(parseURL());
		app.setDescription(parseIntroduce());
		return app;
	}
	
	
	/**
	 * 通过类--来获取服务器路径
	 * D:/workspace/java-eclipse/onlyone/target/classes/
	 */
	public String getServerUrl(){
		return this.getClass().getClassLoader().getResource("").getPath().substring(1);
	}
	
}
