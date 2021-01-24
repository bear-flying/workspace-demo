package com.founder.datamover.biz;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.founder.util.StringValueUtils;

public class ConfigService {
	
	private static Log log = LogFactory.getLog(ConfigService.class);
	
	
	//private static final File CONFIG_FILE = new File(System.getProperty("user.dir") + File.separatorChar + "conf" + File.separator + "config.xml");
	private static final File CONFIG_FILE = new File("../"+"conf" + File.separator + "config.xml");
	
	private String attDir;
	private String outputDir;
	//同名文件路径
	private String backupDir;
	private int siteId;
	private int articleType;
	private String httpAddr;
	private List<Map<String,String>> sourceList = new ArrayList<Map<String,String>>();
	
	//为Accesss数据库准备的
	private String accessDsName;
	private String accessTargetNode;
	
	
	public ConfigService(){
		Document doc = loadXML();
		parseParam(doc);
	}
	
	/**
	 * 得到附件的根目录
	 * @return
	 */
	public String getAttDir() {
		return attDir;
	}

	/**
	 * 得到xml的生成目录
	 * 
	 * */
	public String getOutputDir(){
		return outputDir;
	}
	
	
	public String getBackupDir() {
		return backupDir;
	}

	public void setBackupDir(String backupDir) {
		this.backupDir = backupDir;
	}

	/**
	 * 取得目标站点Id
	 */
	public int getSiteId(){
		return siteId;
	}
	
	public int getArticleType() {
		return articleType;
	}

	public String getHttpAddr() {
		return httpAddr;
	}

	public void setHttpAddr(String httpAddr) {
		this.httpAddr = httpAddr;
	}

	/**
	 * 得到源的配置列表
	 * 
	 * */
	public List<Map<String,String>> getSourceList(){
		return sourceList;
	}
	
	
	/**
	 * 解析配置参数
	 * 
	 * */
	@SuppressWarnings("unchecked")
	private void parseParam(Document doc){
		Element root = doc.getRootElement();
		this.attDir = root.element("AttDir").getTextTrim();
		this.outputDir = root.element("OutputDir").getTextTrim();
		this.backupDir = root.element("BackupDir").getTextTrim();
		this.siteId = StringValueUtils.getInt(root.element("SiteId").getTextTrim());
		this.articleType = StringValueUtils.getInt(root.element("ArticleType").getTextTrim());
		this.httpAddr = root.element("HttpAddr").getTextTrim();
		this.accessDsName = root.element("AccessDsName").getTextTrim();
		this.accessTargetNode = root.element("AccessTargetNode").getTextTrim();
		Iterator<Element> sourceIt = root.element("SourceConfig").elementIterator("Source");
		while(sourceIt.hasNext()){
			Element source = sourceIt.next();
			String sqlId = source.attributeValue("sqlId");
			String nodePath = source.attributeValue("targetNode");
			Map<String,String> map = new HashMap<String,String>();
			map.put("SqlId", sqlId);
			map.put("TargetNode", nodePath);
			sourceList.add(map);
		}
	}
	
	public String getAccessDsName() {
		return accessDsName;
	}

	public String getAccessTargetNode() {
		return accessTargetNode;
	}

	/**
	 * 加载配置文件
	 * 
	 * */
	private Document loadXML(){
		
        Document doc = null;
        FileInputStream fis = null;
        InputStreamReader reader = null;
        SAXReader builder = new SAXReader();
        try{
            //如果文件不存在 则新建一个文件
            if (CONFIG_FILE.exists()){
                fis = new FileInputStream(CONFIG_FILE);
                reader = new InputStreamReader(fis, "utf-8");
                doc = builder.read(reader);
            }
        }catch (Exception ex){
            log.error("",ex);
        }finally{
            if (fis != null){
                try{fis.close();}catch (IOException ex1){}
            }
            if (reader != null){
                try{reader.close();}catch (IOException ex2){}
            }
        }
        return doc;
    }
}
