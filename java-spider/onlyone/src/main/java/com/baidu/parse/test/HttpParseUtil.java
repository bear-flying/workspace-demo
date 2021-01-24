package com.baidu.parse.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.SimpleNodeIterator;
/**
 * 
 * @author 飞天猫熊
 * 功能：HttpParse工具类
 * 时间：2016年1月8日
 * 作者：1405javab 姜宇
 */
public class HttpParseUtil {

	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：获取节点类型的元素值  附带属性   例：<title id="xxx">xxxxx</title>
	 * 时间：2016年1月8日
	 * 作者：1405javab 姜宇
	 */
	public static NodeList catchOneTagElement(Parser parser,String tag,Map<String,String> map){
		
		parser.reset();
		
		TagNameFilter tagNameFilter =new TagNameFilter(tag);
		
		AndFilter andFilter = null;
		
		NodeList nodelist = null;
		
		if(map!=null){
			Set<String> set = map.keySet();
			Iterator<String> it = set.iterator();
			while(it.hasNext()){
				String next = it.next();
				HasAttributeFilter attributeFilter = new HasAttributeFilter(next, map.get(next));
				andFilter = new AndFilter(tagNameFilter, attributeFilter);
			}
			try {
				nodelist = parser.parse(andFilter);
			} catch (ParserException e) {
				e.printStackTrace();
			}
		}else{
			try {
				nodelist = parser.parse(tagNameFilter);
			} catch (ParserException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return nodelist;
	}
	
	
	public static List<String> processNodeList(NodeList nodelist, String keyword) {
		
		SimpleNodeIterator iterator = nodelist.elements();
		List<String> list = new ArrayList<String>();
		while (iterator.hasMoreNodes()) {
			Node node = iterator.nextNode();
			NodeList childList = node.getChildren();
			
			if (null == childList){//孩子节点为空，说明是值节点
				
				if(node instanceof ImageTag){//如果是IMG标签
					ImageTag image  = (ImageTag)node;
					list.add(image.getImageURL());
				}else{
					String result = node.toPlainTextString();//得到双标签值节点的值
					
					//if (result.indexOf(keyword) != -1){//若包含关键字，则简单打印出来文本
					//System.out.println(result);
					if(!result.trim().equals("")){
						list.add(result);
					}
					
					//}
				}
				
					
			} else {//孩子节点不为空，继续迭代该孩子节点
				processNodeList(childList, keyword);
			}
		}
		
		return list;
	}
	
	
	
	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：单个元素值获取
	 * 时间：2016年1月9日
	 * 作者：1405javab 姜宇
	 * @param nodelist
	 * @return
	 */
	public String processNodeList(NodeList nodelist) {
		
		String result;
		try {
			SimpleNodeIterator iterator = nodelist.elements();
			result = null;
			while (iterator.hasMoreNodes()) {
				Node node = iterator.nextNode();

				NodeList childList = node.getChildren();
				System.out.println(childList);
				if (null == childList){
					result = node.toPlainTextString();
				} else {
					processNodeList(childList);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
