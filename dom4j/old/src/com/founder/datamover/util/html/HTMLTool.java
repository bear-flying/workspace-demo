package com.founder.datamover.util.html;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.tidy.Configuration;
import org.w3c.tidy.Tidy;
import com.founder.datamover.util.jpublish.template.ComponentHelper;
import com.founder.datamover.util.jpublish.util.DumpStringStream;


public class HTMLTool {
	
	//日志
	public static Logger logger = Logger.getLogger(HTMLTool.class.getName());
	
	
	/**
	 * <p>Title: HTMLTool</p>
	 * <p>Description: HTMLTool工具，用来将HTML转换成XHTML</p>
	 * <p>Copyright: Copyright (c) 2005</p>
	 * <p>Company: 北京北大方正集团公司</p>
	 * @author 周祖胜
	 * @version 1.0
	 */
	/**
     * 将一段HTML转换为XHTML
     * @param content String
     * @param xmlPI boolean
     * @return String
     */
    public static String convertString2XML(String content, boolean xmlPI){
        if(ComponentHelper.isXML(content)){
        	return content;
        }
        
        if (content.indexOf("<O:P>") != -1 || content.indexOf("<o:p>") != -1) {
        	content = content.replaceAll("<O:P", "<P");
        	content = content.replaceAll("</O:P", "</P");
        	content = content.replaceAll("<o:p", "<p");
        	content = content.replaceAll("</o:p", "</p");
        	content = content.replaceAll("<\\?XML:NAMESPACE", "<P");
        	content = content.replaceAll("<\\?xml:namespace", "<p");
		}

        content = content.replaceAll("x:str", "");
        content = content.replaceAll("u1:str", "");
        
        content = translate(content);

        DumpStringStream stream = new DumpStringStream(content, "UTF-8");
        Tidy tidy = new Tidy();
        
        tidy.setXHTML(true); //产生xhtml
        tidy.setXmlPi(xmlPI); //是否输出<?xml version="1.0"?>
        tidy.setTidyMark(false); //不输出tidy的标识
        tidy.setQuiet(true); //不在标准输出窗口输出警告
        tidy.setShowWarnings(false); //不在标准输出窗口输出警告
        tidy.setWord2000(true); //清除word2000中多余的tag
        tidy.setWrapAttVals(false);
        tidy.setDocType("omit"); //不输出Doctype
        tidy.setCharEncoding(Configuration.UTF8); //输出使用UTF8
        tidy.setNumEntities(true); //所有实体引用转换为&#num;格式
        tidy.setWraplen(0x7FFFFFFF); //设置成不wrap 行
        tidy.setAltText("<v:imagedata");
        try{
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            Document doc = tidy.parseDOM(stream, null);
            setCharset(doc, "UTF-8", false); //这里不强制加上字符集
            setBodyNameSpace(doc,"http://www.w3.org/1999/xhtml",true); //为body强制加上命名空间
            tidy.pprint(doc, os);
            stream.close();
            content = os.toString("UTF-8");
            content  = detranslate(content);
            return content;
        }catch (IOException ex){
        	logger.error("",ex);
        }
        return "";
    }
    
    
    /**
     * 为body加上命名空间
     * 2005-9-23  14:54:19
     * wuxing
     * @param doc 源文件
     * @param strNameSpace 指定的命名空间
     * @param force 如果没有body或者body没有xmlns属性 是否强行加上
     */
    protected static void setBodyNameSpace(Document doc, String strNameSpace,boolean force){
        if (doc == null){
            return;
        }
        Element body = findElement(doc, "body");
        if (body == null){
            if (force){ //如果要求强制加上，才追加{
            	body = doc.createElement("body");
                body.setAttribute("xmlns",strNameSpace);
                try{
                	if (doc.getFirstChild() == null){
                		doc.appendChild((Node) body);
                	}else{
                		doc.insertBefore(body, doc.getFirstChild());
                	} 
                }catch(Exception ex){
                }
            }
            return;
        }

        String namespace = body.getAttribute("xmlns");
        if(namespace == null || namespace.length() <= 0)
        {
            body.setAttribute("xmlns",strNameSpace);
        }
        else if(force)
        {
            body.setAttribute("xmlns",strNameSpace);
        }
    }
    
    
    
    protected static void setCharset(Document doc, String strCharset,boolean force){
    	if (doc == null){
    		return;
    	}
    	Element head = findElement(doc, "head");
    	if (head == null){
    		if (force){ //如果要求强制加上，才追加
    			head = doc.createElement("head");
    			doc.insertBefore(head, doc.getFirstChild());
    			Element meta = doc.createElement("meta");
    			meta.setAttribute("http-equiv", "Content-Type");
    			meta.setAttribute("content", "text/html; charset=" + strCharset);
    			head.appendChild(meta);
    		}	
    		return;
    	}

    	NodeList list = head.getElementsByTagName("meta");
    	int len = list.getLength();
    	for (int i = 0; i < len; i++){
			Element meta = (Element) list.item(i);
			String name = meta.getAttribute("http-equiv");
			if ("Content-Type".equalsIgnoreCase(name)){
				//改变现有值
				meta.setAttribute("content", "text/html; charset=" + strCharset);
				return;
			}
    	}

    	//前面没有找到，如果要求强制加上，才追加
    	if (force){
			Element meta = doc.createElement("meta");
			meta.setAttribute("http-equiv", "Content-Type");
			meta.setAttribute("content", "text/html; charset=" + strCharset);
			head.appendChild(meta);
    	}
    }
    
    
    
    
    protected static Element findElement(Document doc, String name){
        if (doc == null){
            return null;
        }
        Element elem = doc.getDocumentElement();
        if (elem != null){
            Node node = elem.getFirstChild();
            while (node != null){
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    if (node.getNodeName().equals(name)){
                        return (Element) node;
                    }
                }
                node = node.getNextSibling();
            }
        }
        return null;
    }
    
    
    private static String translate(String content){
        content = content.replaceAll("<span style=\"font-size:0pt;\"> </span>","s_st_sst_ss_sss");
        content = content.replaceAll("<span style=\"font-size:1pt;\"> </span>","s_st_sst_ss_sst");
        content = content.replaceAll("<span class=\"zwblankclass\" > </span>","s_st_sst_ss_ssk");
        content = content.replaceAll("<source>","s_st_sst_ss_source");
        content = content.replaceAll("</source>","s_st_sst_ss_sour");
        content = content.replaceAll("<images>","s_st_sst_ss_images");
        content = content.replaceAll("</images>","s_st_sst_ss_imag");
        content = content.replaceAll("<category>","s_st_sst_ss_category");
        content = content.replaceAll("</category>","s_st_sst_ss_catego");
        content = content.replaceAll("<title>","s_st_sst_ss_title");
        content = content.replaceAll("</title>","s_st_sst_ss_tit");

        content = content.replaceAll("<author>","s_st_sst_ss_author");
        content = content.replaceAll("</author>","s_st_sst_ss_auth");
        content = content.replaceAll("<pubdate>","s_st_sst_ss_pubdate");
        content = content.replaceAll("</pubdate>","s_st_sst_ss_pubda");
        content = content.replaceAll("<link>","s_st_sst_ss_link");
          content = content.replaceAll("</link>","s_st_sst_ss_li");

          content = content.replaceAll("<text>","s_st_sst_ss_text");
          content = content.replaceAll("</text>","s_st_sst_ss_te");
          content = content.replaceAll("<description>","s_st_sst_ss_description");
          content = content.replaceAll("</description>","s_st_sst_ss_descripti");
          content = content.replaceAll("<item>","s_st_sst_ss_item");
          content = content.replaceAll("</item>","s_st_sst_ss_it");
        return content;
      }

      private static String detranslate(String content){
        content = content.replaceAll("s_st_sst_ss_sss","<span style=\"font-size:0pt;\"> </span>");
        content = content.replaceAll("s_st_sst_ss_sst","<span style=\"font-size:1pt;\"> </span>");
        content = content.replaceAll("s_st_sst_ss_ssk","<span class=\"zwblankclass\" > </span>");
        content = content.replaceAll("s_st_sst_ss_source","<source>");
        content = content.replaceAll("s_st_sst_ss_sour","</source>");
        content = content.replaceAll("s_st_sst_ss_images","<images>");
        content = content.replaceAll("s_st_sst_ss_imag","</images>");
        content = content.replaceAll("s_st_sst_ss_category","<category>");
        content = content.replaceAll("s_st_sst_ss_catego","</category>");
        content = content.replaceAll("s_st_sst_ss_title","<title>");
        content = content.replaceAll("s_st_sst_ss_tit","</title>");

        content = content.replaceAll("s_st_sst_ss_author","<author>");
        content = content.replaceAll("s_st_sst_ss_auth","</author>");
        content = content.replaceAll("s_st_sst_ss_pubdate","<pubdate>");
        content = content.replaceAll("s_st_sst_ss_pubda","</pubdate>");
        content = content.replaceAll("s_st_sst_ss_link","<link>");
        content = content.replaceAll("s_st_sst_ss_li","</link>");

        content = content.replaceAll("s_st_sst_ss_text","<text>");
        content = content.replaceAll("s_st_sst_ss_te","</text>");
        content = content.replaceAll("s_st_sst_ss_description","<description>");
        content = content.replaceAll("s_st_sst_ss_descripti","</description>");
        content = content.replaceAll("s_st_sst_ss_item","<item>");
        content = content.replaceAll("s_st_sst_ss_it","</item>");
        return content;
      }
    
    
    
}
