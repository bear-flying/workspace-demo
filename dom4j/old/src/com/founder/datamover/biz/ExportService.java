package com.founder.datamover.biz;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.dom4j.CDATA;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.founder.datamover.dao.ArticleDao;
import com.founder.datamover.po.Article;
import com.founder.datamover.po.Attachement;
import com.ibatis.dao.client.DaoManager;
import com.sun.jndi.toolkit.url.UrlUtil;

public class ExportService{
	
	private static Log log = LogFactory.getLog(ExportService.class);
	
	private DaoManager dm;
	private ArticleDao artDao;
	private String attDir;
	private String outputDir;
	private String backupDir;
	private int siteId;
	private int articleType;
	private String httpAddr;
	private List<Map<String,String>> sourceList;
	private int index =0;
	
	
	public ExportService(String attDir,String outputDir,String backupDir,int siteId,int articleType,String httpAddr,List<Map<String,String>> sourceList){
		this.dm = com.founder.persistence.DaoConfig.getDaoManager();
		this.artDao = (ArticleDao)dm.getDao(ArticleDao.class);
		this.attDir = attDir;
		this.outputDir = outputDir;
		this.backupDir = backupDir;
		this.siteId = siteId;
		this.articleType = articleType;
		this.httpAddr = httpAddr;
		this.sourceList = sourceList;
	}
	
	// 执行导出xml任务
	public void execute(){
		for(int i=0;i<sourceList.size();i++){
			Map<String,String> sourceMap = sourceList.get(i);
			String sqlId = sourceMap.get("SqlId");
			if(sqlId!=null &&sqlId.trim().length()>0){
				while(true){
					Map<String,Integer> map = new HashMap<String,Integer>();
					map.put("index", index);
					map.put("count",1500);
					int flag = batchCreate(sqlId,map);
					index+=1500;
					if(flag<=0){
						break;
					}
					
				}
			}
		}
	}
	
	public int batchCreate(String sqlId,Map<String,Integer> map){
		int count = 0;
		List<Article> artList =null;
		try {
			if(articleType==1){
				artList = artDao.getMuliArticleList(sqlId,map);//组图稿
			}else{
				artList = artDao.getArticleList(sqlId,map);
			}
			count = artList.size();
			if(artList!=null && artList.size()>0){			
				log.info("当前要转换生成的稿件总数为 " + artList.size() + "条");
				long l1 = System.currentTimeMillis();
				
				//创建xml目录，按照栏目路径创建
				File xmlDir = null;
				if(articleType==1){
					xmlDir = new File(outputDir + File.separator + sqlId+"muli");
				}else{
					xmlDir = new File(outputDir + File.separator + sqlId);
				}
				File backDir = new File(backupDir);
				org.apache.commons.io.FileUtils.forceMkdir(xmlDir);
				org.apache.commons.io.FileUtils.forceMkdir(backDir);
				log.info("当前SQLMap保存xml的目录为："+xmlDir.toString());
				log.info("当前同名xml的目录为："+backDir.toString());
				
				//循环生成xml
				for(int j=0;j<artList.size();j++){
					Article art = artList.get(j);
					art.setCurrSqlId(sqlId);
					
					log.info("正在生成XML入库文件：articleId = "+art.getDocId());
					Document doc = DocumentHelper.createDocument();
					Element root = doc.addElement("FounderEnpML");
					//root.addElement("Version").addText("2.0.2");
			        
			        //准备生成头文件
			        buildPackage(root,art);
			        boolean flag = buildArticle(root,art);
			        if(!flag){
			        	continue;
			        }
			        //写Xml文件
			        File xmlFile = new File(xmlDir.getPath() + File.separator + art.getDocId() + ".xml");
			        log.info("XML入库文件正在准备写入磁盘："+xmlFile.toString());
			        writeXML(doc,xmlFile);
			        log.info("XML入库文件写入成功！");
			        
			        //生成一个同名文件
			        File buckupFile = new File(backDir.getPath() + File.separator + art.getDocId() + ".xml");
			        buckupFile.createNewFile();
//			        int doxmls = 0;
//			        try{
//			        	doxmls = artDao.doxml(new java.lang.Integer(art.getDocId()));
//			        }catch (Exception e){
//			        	log.error(art.getDocId()+" 将稿件置为已导出失败！",e);
//			        }
//			        if(doxmls == 1){
//			        	log.info(art.getDocId()+" 将稿件置为已导出成功！");
//			        }else{
//			        	log.error(art.getDocId()+" 将稿件置为已导出失败！");
//			        }
//			        
				}
				long l2 = System.currentTimeMillis();
				log.info("当前要转换生成xml花费的时间为 " + (l2-l1) + "ms,共计"+artList.size()+"条记录");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			log.error("",e);
		}
		return count;
	}
	
	
	/**
	 * 生成Package元素下的XML内容
	 * 
	 * */
	private void buildPackage(Element root,Article article) throws Exception{
		Element ePackage = root.addElement("Package");
		if(articleType==1){
			ePackage.addElement("ArticleType").addText("1");
		}else{
			ePackage.addElement("ArticleType").addText("0");
		}
		
		if(siteId!=0){
			ePackage.addElement("SiteId").addText(String.valueOf(siteId));
		}else{
			ePackage.addElement("SiteId").addText("1");
		}
		
	}
	
	/**
	 * 生成Article元素下的XML内容
	 * 
	 * */
	private boolean buildArticle(Element root,Article article) {
		//if(article.getContent().trim().replaceAll("</?[^<]+>", "").length()<=16&&articleType==0){
		//	log.info("当前稿件的正文内容小于16个字符，停止导出ID: "+article.getDocId()+"的稿件。");
		//	return false;
		//}
		List<Attachement> attList = article.getAttachementList();
		Element eArticle = root.addElement("Article");
		eArticle.addElement("Subtitle").add(convertCDATA(article.getSubTitle()));
		eArticle.addElement("Abstract").add(convertCDATA(article.getArtAbstract()));
		eArticle.addElement("keyword").add(convertCDATA(article.getKeyword()));
		eArticle.addElement("Tag").add(convertCDATA(""));
		try {
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String pubTime = fm.format(Long.parseLong(article.getPubTime())*1000);
			eArticle.addElement("Nsdate").add(convertCDATA(pubTime));
		} catch (Exception e) {		
			eArticle.addElement("Nsdate").add(convertCDATA(article.getPubTime()));
		}
		
		//if(articleType==1&&article.getAuthor().trim().equals("邵阳新闻在线")){
		//	eArticle.addElement("Source").add(convertCDATA("邵阳新闻在线"));
		//	eArticle.addElement("Region").setText("1");
		//	eArticle.addElement("Author").add(convertCDATA(""));	
		//}else{
			eArticle.addElement("Source").add(convertCDATA(article.getSourceName()));
			eArticle.addElement("Region").setText("1");
			eArticle.addElement("Author").add(convertCDATA(article.getAuthor()));
		//}
		
		eArticle.addElement("Editor").add(convertCDATA(""));
		eArticle.addElement("Liability").add(convertCDATA(""));
		if(article.getTitle() != null && !"".equals(article.getTitle())){
			eArticle.addElement("Title").add(convertCDATA(article.getTitle()));
		}else{
			eArticle.addElement("Title").add(convertCDATA(article.getLinkTitle()));
		}
		
		String smallTitlePic = article.getSmallTitlePic();
		if(smallTitlePic==null||smallTitlePic.trim().equals("")){		
			eArticle.addElement("SmallTitlePic").add(convertCDATA(""));
		}else{
			buildTitlePic(article.getDocId(),eArticle,smallTitlePic);
		}
		
		eArticle.addElement("MiddleTitlePic").add(convertCDATA(""));
		eArticle.addElement("BigTitlePic").add(convertCDATA(""));
		eArticle.addElement("ColumnID").setText(article.getTargetNodeId());

		eArticle.addElement("Content").add(convertCDATA(article.getContent()));
		
		Element eAttachement = eArticle.addElement("Attachement");

		if(articleType==1){
			List<Attachement> morepicList = article.getMorepicList();
			for(int i=0;i<morepicList.size();i++){
				Attachement att = morepicList.get(i);
				buildAttachement(article.getDocId(),eAttachement,att.getAttPath(),att.getTitle(),"1");
			}
		}else{
			for(int i=0;i<attList.size();i++){
				Attachement att = (Attachement)attList.get(i);
				buildAttachement(article.getDocId(),eAttachement,att.getAttPath(),"","0");
			}
		}
		return true;
	}
	
	private String createjabbarMark(Article article){
		String jabbarMarkStr = null;
		if(article.getDocId()!=null && article.getDocId().trim().length()>0){	
			jabbarMarkStr = article.getCurrSqlId()+"_"+article.getDocId();
		}else{
			//此时说明原数据库中没有可作为主键的字段，此时取稿件的发布时间
			if(article.getPubTime()!=null){
				String[] parsePatterns = {"yyyy-MM-dd HH:mm:ss"};
				try {
					Date date = org.apache.commons.lang.time.DateUtils.parseDate(article.getPubTime(), parsePatterns);
					jabbarMarkStr = article.getCurrSqlId()+"_"+org.apache.commons.lang.time.DateFormatUtils.format(date, "yyyyMMddHHmmss");
				} catch (ParseException e) {
					jabbarMarkStr = "";
					log.error("",e);
				}
			}
		}
		return jabbarMarkStr;
	}
	
	
	/**
	 * 生成Attachement元素下的XML内容
	 * 
	 * */
	private Attachement buildAttachement(String docId,Element eAttachement,String attPath,String title,String type){
		
		Attachement attachement = new Attachement();
		try{
			Element eFile = eAttachement.addElement("file");
			eFile.addAttribute("type", type);
			eFile.addElement("attdesc", title);	
			eFile.addElement("filename").addText(attPath);
			String attDirPath = attDir+attPath;
			if(attPath.startsWith("/Public")){
				attPath = attPath.substring(7);
				attDirPath = attDir+attPath;
			}else if(attPath.startsWith("Public")){
				attPath = attPath.substring(6);
				attDirPath = attDir+attPath;
			}
			if(attPath.startsWith("/data")){
				attPath = attPath.substring(5);
				attDirPath = attDir+attPath;
			}else if(attPath.startsWith("data")){
				attPath = attPath.substring(4);
				attDirPath = attDir+attPath;
			}else if(attPath.startsWith("http")){
				String ext = attPath.substring(attPath.lastIndexOf(".")+1, attPath.length());
				if(ext == null || ext.length() == 0 || ext.length() > 4){
					ext = "jpg";
				}
				String savepath = attDir+"/httpfile/"+docId+"_"+System.currentTimeMillis()+"."+ext;
				download(attPath,savepath);
				attDirPath = savepath;
			}else if(attPath.startsWith("/d")){
				String ext = attPath.substring(attPath.lastIndexOf(".")+1, attPath.length());
				if(ext == null || ext.length() == 0 || ext.length() > 4){
					ext = "jpg";
				}
				String savepath = attDir+"/httpfile/"+docId+"_"+System.currentTimeMillis()+"."+ext;
				download(httpAddr+attPath,savepath);
				attDirPath = savepath;
			}
			
			
			File attFile = new File(attDirPath);
			log.info("附件路径："+attDirPath);

			byte[] attByte = getBytesFromFile(attFile);
//			eFile.addElement("filecode").add(convertCDATA(""));
			eFile.addElement("filecode").add(convertCDATA(convertBASE64(attByte)));
			
		}catch(Exception e){
			log.error("",e);
		}
		return attachement;
	}
	
	private void buildTitlePic(String docId,Element eArticle,String smallTitlePic){
		
		try{
			String attDirPath = attDir+smallTitlePic;
			if(smallTitlePic.startsWith("/Public")){
				smallTitlePic = smallTitlePic.substring(7);
				attDirPath = attDir+smallTitlePic;
			}else if(smallTitlePic.startsWith("Public")){
				smallTitlePic = smallTitlePic.substring(6);
				attDirPath = attDir+smallTitlePic;
			}
			if(smallTitlePic.startsWith("/data")){
				smallTitlePic = smallTitlePic.substring(5);
				attDirPath = attDir+smallTitlePic;
			}else if(smallTitlePic.startsWith("data")){
				smallTitlePic = smallTitlePic.substring(4);
				attDirPath = attDir+smallTitlePic;
			}else if(smallTitlePic.startsWith("http")){
				String ext = smallTitlePic.substring(smallTitlePic.lastIndexOf(".")+1, smallTitlePic.length());
				if(ext == null || ext.length() == 0 || ext.length() > 4){
					ext = "jpg";
				}
				String savepath = attDir+"/httpfile/"+docId+"_"+System.currentTimeMillis()+"."+ext;
				download(smallTitlePic,savepath);
				attDirPath = savepath;
			}else if(smallTitlePic.startsWith("/d")){
				String ext = smallTitlePic.substring(smallTitlePic.lastIndexOf(".")+1, smallTitlePic.length());
				if(ext == null || ext.length() == 0 || ext.length() > 4){
					ext = "jpg";
				}
				String savepath = attDir+"/httpfile/"+docId+"_"+System.currentTimeMillis()+"."+ext;
				download(httpAddr+smallTitlePic,savepath);
				attDirPath = savepath;
			}
			
			
			File attFile = new File(attDirPath);
			log.info("附件 标题图片路径："+attDirPath);
			
			byte[] attByte = getBytesFromFile(attFile);
			eArticle.addElement("SmallTitlePic").add(convertCDATA(convertBASE64(attByte)));
		}catch(Exception e){
			log.error("",e);
		}
	}
	
	
	private byte[] getBytesFromFile(File f) {
        byte[] ret = null;
		if (f != null && f.exists()) {
			FileInputStream stream = null;
			ByteArrayOutputStream out = null;
			try {
	            stream = new FileInputStream(f);
	            out = new ByteArrayOutputStream(1000);
	            byte[] b = new byte[1000];
	            int n;
	            while ((n = stream.read(b)) != -1){
	            	out.write(b, 0, n);
	            }
	            ret = out.toByteArray();
	        }catch (IOException e) {
	        	log.error("",e);
	        }finally{
	        	try {
					stream.close();
				} catch (IOException e) {
					log.error(e.getMessage());
				}
	            try {
					out.close();
				} catch (IOException e) {
					log.error(e.getMessage());
				}
	        }
        }
        return ret;
    }
	
	/**
	 * 写入XML文件
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
	 * 将图片添加到正文的上方
	 * 
	 * */
	private String addPicture(String content,List<Attachement> attList){
		if(attList!=null && attList.size()>0){
			StringBuffer contentSb = new StringBuffer();
			int index1 = -1;
			int index2 = -1;
			for(int i=0;i<attList.size();i++){
//				Attachement att = attList.get(i);
//				contentSb.append("<table width=\"90%\" height=\"189\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\"><tr><td align=\"center\">");
//				contentSb.append("<img src=\"").append(att.getAttPath()).append("\"");
//				if(att.getTitle()!=null && att.getTitle().trim().length()>0){
//					contentSb.append(" alt=\"").append(att.getTitle()).append("\"");
//				}
//				contentSb.append(" style=\"border:3px solid #999999; \">");
//				contentSb.append("</td></tr></table>");	
				if(content.indexOf("<img", i)>0){
					index1 = content.indexOf("<img", i);
					index2 = content.indexOf(" />", i);
					String sub1 = content.substring(0,index1);
					String sub2 = content.substring(index2+3);
					contentSb.append(sub1).append(sub2);
				}
//				if(index1<0||index2<0){
//					return contentSb.append(content).toString();
//				}		    
			}
//			contentSb.append(content);		
			return contentSb.toString();
		}else{
			return content;
		}
	}
	
	/**
	 * 将字节码转换为BASE64码。转换前首先进行压缩
	 * 
	 * */
	private String convertBASE64(byte[] b){
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
	    String base64Code = encoder.encode(b);
	    return base64Code;
	}
	
	/**
	 * 将String转换成CDATA类型
	 * 
	 * */
	private CDATA convertCDATA(String oldStr){
    	return DocumentHelper.createCDATA(oldStr);
    }
	
	public static void download(String urlpath,String savepath) {
		if(!urlpath.startsWith("http")){
			return;
		}
		HttpClient c = new DefaultHttpClient();
		c.getParams().setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);
		c.getParams().setIntParameter(CoreConnectionPNames.SO_TIMEOUT, 10000);
		c.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.RFC_2965);
		c.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);
//		setProxy(c);
		mkdirs(savepath);
		createFile(savepath);
		InputStream is = null;
		FileOutputStream fos = null;
		long t1 = System.currentTimeMillis();
		try{
			is = getStream(c,urlpath);
			fos = new FileOutputStream(savepath);
			IOUtils.copy(is, fos);
		}catch (Exception e) {
			log.error("",e);
		}finally{
			IOUtils.closeQuietly(fos);
			IOUtils.closeQuietly(is);
		}
		long t2 = System.currentTimeMillis();
		log.info("下载文件【"+urlpath+"】到【"+savepath+"】完成，花费"+((t2-t1)/1000)+"秒");//，还有"+t.getQueue().size()+"个任务待处理,已下载"+t.getCompletedTaskCount()+"完个文件");
	}

	private static InputStream getStream(HttpClient c ,String urlpath){
		HttpResponse response = null;
		try {
			urlpath = UrlUtil.encode(urlpath, "gbk");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		HttpGet get = new HttpGet(urlpath);

		InputStream d = null;
		try {
			response = c.execute(get);
			HttpEntity entity = response.getEntity();
			System.out.println(entity.getContentLength());
			
			if(entity != null){
				d = entity.getContent();
			}
//			gm.releaseConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	private static void createFile(String file){
		File f = new File(file);
		if(f.exists())
			f.delete();
		try {
			f.createNewFile();
		} catch (IOException e) {
			log.error("建立文件"+file+"出错,等待5秒重建");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			createFile(file);
		}
	}
	
	public static void mkdirs(String path){
		path = path.replaceAll("\\\\", "/");
		int last = path.lastIndexOf("/");
		File filepath = new File(path.substring(0,last));
		if(!filepath.exists())
			filepath.mkdirs();
	}

	public static void main(String[] args){
		String attPath = "http://www.cena.com.cn/uploads/allimg/111206/1517190.jpg";
		String savepath = "";
		savepath = System.currentTimeMillis()+"."+attPath.substring(attPath.lastIndexOf(".")+1, attPath.length());
		download(attPath, "c:/"+savepath);
		
		
	}

	
}
