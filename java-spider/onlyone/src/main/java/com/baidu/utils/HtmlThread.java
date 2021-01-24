package com.baidu.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.util.NodeList;

import com.baidu.parse.pojo.App;
import com.baidu.parse.pojo.Comment;
import com.baidu.parse.pojo.Pic;
import com.baidu.parse.service.IParseService;

public class HtmlThread extends Thread{
	
	private String threadName ;
	
	private int startPage; //每个线程抓取的起始页
	
	private IParseService parseService;
	

	public HtmlThread(String threadName, int startPage, IParseService parseService) {
		super();
		this.threadName = threadName;
		this.startPage = startPage;
		this.parseService = parseService;
	}



	public int getStartPage() {
		return startPage;
	}



	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}



	public HtmlThread(String threadName) {
		super();
		this.threadName = threadName;
	}



	public String getThreadName() {
		return threadName;
	}



	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}



	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run(){
		
		try {
			//循环抓取每一页上所有的应用数据
			for (int i = startPage; i <= startPage+15; i++) {
				Parser parser = new Parser("http://mm.10086.cn/android/software/qbrj?p="+i);
				parser.setEncoding("UTF-8");
				
				HasAttributeFilter attributeFilter = new HasAttributeFilter("class", "autoword");
				TagNameFilter nameFilter = new TagNameFilter("a");
				//每页12个超链接(可以连接到smallparse里面的应用)  都在nodeList里面
				NodeList nodeList =	parser.parse(new AndFilter(nameFilter, attributeFilter));
				
				//循环迭代出来这些超链接 逐个解析
				for (int j = 0; j < nodeList.size(); j++) {
					TagNode tagNode =	(TagNode) nodeList.elementAt(j);
					//System.out.println(threadName+"----"+tagNode.getAttribute("title")+"==="+tagNode.getAttribute("href"));
					String url = "http://mm.10086.cn/"+tagNode.getAttribute("href");
					
					SmallParse sparse = new SmallParse(url);
					App app = sparse.parseApp(tagNode.getAttribute("title"));
					List<Comment> comments = sparse.parseComment(app.getId());
					List<Pic> pics = sparse.ParseDynamicImg(app.getId());
					
					//生成二维码
					String QrURL = "D:\\Program Files\\GongZuo2\\apache-tomcat-7.0.54\\webapps\\onlyone\\qr\\"+app.getId()+".png";
					String ccbPath = "D:\\Program Files\\GongZuo2\\apache-tomcat-7.0.54\\webapps\\onlyone\\download\\"+app.getAppicon();
					Qrcodeimg.createQRCode(app.getApkurl(),QrURL, ccbPath);
					app.setCodeurl(QrURL);
					
					//System.out.println(app+"---"+comments+"---"+pics);
					app.setPicList(pics);
					app.setCommentList(comments);
					
//					parseService.addApp(app);
//					if(pics!=null){
//						for (Pic pic : pics) {
//							//System.out.println(pic);
//							parseService.addPic(pic);
//						}
//					}
//					if(comments!=null){
//						for (Comment comment : comments) {
//							System.out.println(comment);
//							parseService.addComment(comment);
//						}
//					}
					
					//上面抓取完毕 下面将APP对象传入freemarker模版里面 生成带有数据的静态页面
					//使用主键返回，html页面的名称使用APP对象的ID.html,这样比较简单，
					//而且，网站首页的推荐应用的链接也相对简单，直接ID.html
					FreeMarkerUtil fm = new FreeMarkerUtil();
					Map map = new HashMap();
					map.put("app", app);
					map.put("updatetime", app.getUpdatetime().toLocaleString().substring(0, 11));
					map.put("comments", comments);//commentDate????  666行${items.commentDate}
					
					map.put("pics", pics);
					
					fm.fprint("template.ftl", map, "D:\\Program Files\\GongZuo2\\apache-tomcat-7.0.54\\webapps\\onlyone\\WEB-INF\\html\\"+app.getId()+".html");
				}
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
