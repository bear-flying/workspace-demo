package cn.itcast.webmagic.test;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;


public class SimpleProcessor implements PageProcessor {

    //解析页面
    public void process(Page page) {
        //解析返回的数据page，并且把解析的结果放到ResultItems中
        page.putField("author", page.getHtml().css("div.mt>h1").all());
    }

    private Site site = Site.me();
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new SimpleProcessor())
                //初始访问url地址
                .addUrl("https://www.jd.com/moreSubject.aspx")
                .run();
    }
}
