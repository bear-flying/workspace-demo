package com.founder.datamover;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.CDATA;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.founder.datamover.biz.ConfigService;
import com.founder.datamover.biz.ExportService;
import com.founder.datamover.po.Article;
import com.founder.datamover.po.Attachement;

public class StartAccess {
	
	private static Log log = LogFactory.getLog(StartAccess.class);

	public static void main(String[] args) throws Exception{
		ConfigService config = new ConfigService();
		StartAccess service = new StartAccess();
		List<Article> artList = service.queryAll(config);
		service.makeXmlFile(config,artList);
	}
	
	private List<Article> queryAll(ConfigService config){
		List<Article> artList = new ArrayList<Article>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager.getConnection("jdbc:odbc:"+config.getAccessDsName(), "", "");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select db_headline as title,db_day as pubtime,db_content as content,db_author as author,db_lanmu as keyword,db_source as sourcename,add_datetime as createtime FROM �˴��");
			while (rs.next()) {
				Article article = new Article();
				article.setCurrSqlId("RenDaJianBao");
				article.setTitle(rs.getString("title"));
				//article.setPubTime(rs.getString("pubtime"));
				article.setContent(rs.getString("content"));
				article.setAuthor(rs.getString("author"));
				article.setKeyword(rs.getString("keyword"));
				article.setSourceName(rs.getString("sourcename"));
				article.setCreateTime(org.apache.commons.lang.time.DateFormatUtils.format(rs.getTimestamp("createtime"), "yyyyMMddHHmmss"));
				artList.add(article);
			}
		} catch (Exception el) {
			el.printStackTrace();
		}finally{
			org.apache.commons.dbutils.DbUtils.closeQuietly(conn, stmt, rs);
		}
		return artList;
	}
	
	private void makeXmlFile(ConfigService config,List<Article> artList) throws Exception{
		log.info("��ǰҪת����ɵĸ������Ϊ " + artList.size() + "��");
		long l1 = System.currentTimeMillis();
		
		//����xmlĿ¼��������Ŀ·������
		File xmlDir = new File(config.getOutputDir() + File.separator + config.getAccessTargetNode());
		org.apache.commons.io.FileUtils.forceMkdir(xmlDir);
		log.info("��ǰSQLMap����xml��Ŀ¼Ϊ��"+xmlDir.toString());
		
		//ѭ�����xml
		for(int j=0;j<artList.size();j++){
			Article art = artList.get(j);
			
			log.info("�������XML����ļ���articleId = "+art.getDocId());
			Document doc = DocumentHelper.createDocument();
			Element root = doc.addElement("FounderEnpML");
			root.addElement("Version").addText("2.0.2");
	        
	        //׼�����ͷ�ļ�
	        buildPackage(root,config.getAccessTargetNode());
	        buildArticle(root,art);
	        
	        //дXml�ļ�
	        File xmlFile = new File(xmlDir.getPath() + File.separator + UUID.randomUUID().toString() + ".xml");
	        log.info("XML����ļ�����׼��д����̣�"+xmlFile.toString());
	        writeXML(doc,xmlFile);
	        log.info("XML����ļ�д��ɹ���");
		}
	}
	
	
	/**
	 * ���PackageԪ���µ�XML����
	 * 
	 * */
	private void buildPackage(Element root,String targetNode) throws Exception{
		Element ePackage = root.addElement("Package");
		ePackage.addElement("SourceSystem").add(convertCDATA("�˴�ϵͳ"));
		ePackage.addElement("TargetLib").addText("2");
		ePackage.addElement("ArticleType").addText("1");
		ePackage.addElement("TargetNode").add(convertCDATA(targetNode));
		ePackage.addElement("TargetNodeId").addText("");
		ePackage.addElement("PublishStat").addText(String.valueOf(1));
		ePackage.addElement("ObjectType").addText("1");
		ePackage.addElement("Action").addText("1");
		ePackage.addElement("UserName").add(convertCDATA("ϵͳ����Ա"));
		ePackage.addElement("SiteId").addText("");
	}
	
	/**
	 * ���ArticleԪ���µ�XML����
	 * 
	 * */
	private void buildArticle(Element root,Article article) throws Exception{
		Element eArticle = root.addElement("Article");
		eArticle.addElement("DocID").add(convertCDATA(article.getDocId()));
		eArticle.addElement("JabbarMark").add(convertCDATA(createjabbarMark(article)));
		eArticle.addElement("Loginname").add(convertCDATA("sa"));
		eArticle.addElement("Introtitle").add(convertCDATA(article.getIntroTitle()));
		eArticle.addElement("Subtitle").add(convertCDATA(article.getSubTitle()));
		eArticle.addElement("Abstract").add(convertCDATA(article.getArtAbstract()));
		eArticle.addElement("Attr").add(convertCDATA(String.valueOf(article.getAttr())));
		eArticle.addElement("WordCount").add(convertCDATA(String.valueOf(article.getWordCount())));
		eArticle.addElement("Importance").add(convertCDATA(String.valueOf(article.getImportance())));
		eArticle.addElement("keyword").add(convertCDATA(article.getKeyword()));
		eArticle.addElement("piccount").add(convertCDATA(String.valueOf(article.getAttachementList().size())));
		eArticle.addElement("Nsdate").add(convertCDATA(article.getPubTime()));
		eArticle.addElement("Source").add(convertCDATA(article.getSourceName()));
		eArticle.addElement("SourceUrl").add(convertCDATA(article.getSourceUrl()));
		eArticle.addElement("Author").add(convertCDATA(article.getAuthor()));
		eArticle.addElement("Title").add(convertCDATA(article.getTitle()));
		eArticle.addElement("NodePath").add(convertCDATA(""));
		eArticle.addElement("Url").add(convertCDATA(article.getUrl()));
		eArticle.addElement("Content").add(convertCDATA(article.getContent()));
		eArticle.addElement("ExpirationTime").add(convertCDATA(article.getExpirationTime()));
		eArticle.addElement("hasTitlePic").addText("0");
		eArticle.addElement("IsTop").addText(String.valueOf(article.getIsTop()));
		eArticle.addElement("Attachement");
		
		
		
	}
	
	private String createjabbarMark(Article article){
		String jabbarMarkStr = article.getCurrSqlId()+"_"+article.getCreateTime();
		return jabbarMarkStr;
	}

	/**
	 * д��XML�ļ�
	 * 
	 * */
	private void writeXML(Document doc, File filename){
        OutputFormat of = OutputFormat.createPrettyPrint();
        of.setEncoding("UTF-8");
        FileOutputStream fos = null;
        XMLWriter xmlout = null;
        try{
        	fos = new FileOutputStream(filename);
            xmlout = new XMLWriter(new OutputStreamWriter(fos, "UTF-8"), of);
            xmlout.write(doc);
            xmlout.flush();
        }catch (Exception ex){
        	log.error("",ex);
        }finally{
            if (fos != null){
                try{
                	fos.close();
                }catch (IOException ex1){
                	log.error("",ex1);
                }
            }
            if (xmlout != null){
                try{
                    xmlout.close();
                }catch (IOException ex2){
                	log.error("",ex2);
                }
            }
        }
    }
	
	/**
	 * ��Stringת����CDATA����
	 * 
	 * */
	private CDATA convertCDATA(String oldStr){
    	return DocumentHelper.createCDATA(oldStr);
    }
}
