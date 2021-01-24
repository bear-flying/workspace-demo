package com.baidu.parse.controller;

import java.util.List;

import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.parse.pojo.App;
import com.baidu.parse.service.IParseService;
import com.baidu.utils.HtmlThread;

@Controller
@RequestMapping("parse")
public class ParseController {

	@Autowired
	private IParseService parseService;

	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：解析10086网站的所有APP应用的相关信息 并存入数据库
	 * 时间：2016年1月12日
	 * 作者：1405javab 姜宇
	 */
	@RequestMapping("parseAll")
	public void parseAll(){	
		try {
			//抓去总页数
			Parser parser = new Parser("http://mm.10086.cn/android/software/qbrj?p=1");
			parser.setEncoding("UTF-8");
			HasAttributeFilter hasAttributeFilter = new HasAttributeFilter("class","last");
			TagNameFilter tagNameFilter = new TagNameFilter("a");
			NodeList nlist = parser.parse(new AndFilter(tagNameFilter,hasAttributeFilter));
			TagNode tagNode = (TagNode)nlist.elementAt(0);
			int totalPage = Integer.parseInt(tagNode.getAttribute("href").split("=")[1]);
			//定义每个线程抓取的页数
			int threadPageNum = 15;
			//计算机启动线程数量
			int threadNum = totalPage/threadPageNum+(totalPage%threadPageNum==0?0:1);
			//循环抓取每个线程的应用
			for (int i = 0; i < threadNum; i++) {
				HtmlThread htmlThread = new HtmlThread("线程"+i,i*15+1,parseService);
				htmlThread.start();
			}
		} catch (ParserException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：转到增删查改操作页面
	 * 时间：2016年1月15日
	 * 作者：1405javab 姜宇
	 * @return
	 */
	@RequestMapping("appAction")
	public String appAction(Model model){
		
		List<App> list = parseService.seletApps();
		
		model.addAttribute("applist", list);
		
		return "app/applist";
	}
	

	
	
	
	
}
