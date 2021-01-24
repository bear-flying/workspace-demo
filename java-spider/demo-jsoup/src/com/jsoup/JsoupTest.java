package com.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author 姜宇
 */
public class JsoupTest {

	public static void main(String[] args) {
		parseStr();
		getArticleOthers();
		getArticle();
		 
	}
	
	/**
	 * 使用Jsoup
	 * 给HTML字符串中的一些标签添加属性
	 */
	public static void parseStr(){
		String contentstr = "<p><span><img src='../../xy/image.do?path=图片存储;xy/201702/22/46bbd498-e01b-438a-a221-120144121820.jpg'/></span></p>";

		Document doc = Jsoup.parse(contentstr);

		Elements imgs = doc.select("img");
		Element p = null;
		
//		Iterator<Element> iterator = esd.iterator();  
//		while (iterator.hasNext()){  }  
		for (int i = 0; i < imgs.size(); i++) {

			Element img = imgs.get(i);

			//给IMG标签添加样式
			img.removeAttr("style");
			img.attr("style", "max-width: 100%;");

			p = img.parent();
			String parentTag = p.tagName();
			if (parentTag.equalsIgnoreCase("span")) {
				p = p.parent();
			}
			//给IMG标签之前的第一个P标签添加样式
			if (p.tagName().equalsIgnoreCase("p")) {
				p.removeAttr("style");
				p.attr("style", "text-align: center");
			}

		}
		System.out.println(doc.body());//得到结果，但是被BODY标签包含着
		System.out.println(doc.body().html());//得到结果
		/**
		 * 结果字符串：
		 * <p style="text-align: center"><span><img src="../../xy/image.do?path=图片存储;xy/201702/22/46bbd498-e01b-438a-a221-120144121820.jpg" style="max-width: 100%;"></span></p>
		 *
		 */
	}
	
	
	/**
	 * 使用Jsoup实现爬虫
	 * 获取博客上的文章标题和连接
	 */
    public static void getArticleOthers(){
        Document doc = null;
        try {
            doc = Jsoup.connect("http://www.cnblogs.com/zyw-205520/").get();
            Elements listDiv = doc.getElementsByAttributeValue("class", "postTitle");
            for(Element element : listDiv){
                Elements links = element.getElementsByTag("a");
                for(Element link : links){
                    String linkHref = link.attr("href");
                    String linkText = link.text().trim();
                    System.out.println(linkHref);
                    System.out.println(linkText);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取指定博客文章的内容
    /**
	 * 使用Jsoup实现爬虫
	 * 获取博客上的文章内容
	 */
    public static void getArticle(){
        Document doc = null;
        try {
            doc = Jsoup.connect("http://www.cnblogs.com/zyw-205520/archive/2012/12/20/2826402.html").get();
            Elements listDiv = doc.getElementsByAttributeValue("class", "postBody");
            for(Element element : listDiv){
                System.out.println(element.html());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	
	
	
}
