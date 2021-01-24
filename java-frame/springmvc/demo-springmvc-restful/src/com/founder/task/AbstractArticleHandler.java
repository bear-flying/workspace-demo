package com.founder.task;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

import com.sun.jndi.toolkit.url.UrlUtil;
import com.founder.pojo.XyArticleEntity;
import com.founder.util.Const;
import com.founder.util.FilePathUtil;
import com.founder.util.UUIDGenerator;

public abstract class AbstractArticleHandler {

	public static Log logger = LogFactory.getLog(AbstractArticleHandler.class);
	
	public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static final SimpleDateFormat formatTime = new SimpleDateFormat("yyyyMM/dd");
	
	
	/**
	 * 获取排序a_order
	 * @param oldArticle
	 * @return
	 */
	public double getNewOrder(XyArticleEntity xyArticleEntity, String articleTime) {
		String orderTime = xyArticleEntity.getA_pubTime();
		
		if(orderTime==null) return 0;
		
		Timestamp pubTime = Timestamp.valueOf(orderTime);
		
		Calendar ca = Calendar.getInstance();
		ca.setTime(pubTime);
		
		double order = createDisplayOrder(ca, 0, 0, xyArticleEntity.getSys_documentid(), articleTime);
		return order;
	}
	
	/**
	 * 排序a_order算法
	 * @param cd
	 * @param daycnt
	 * @param ord
	 * @param id
	 * @return
	 */
	public double createDisplayOrder(Calendar cd, int daycnt, int ord, long id, String articleTime) {
		if (cd == null)
		    cd = Calendar.getInstance();

        int nHour = cd.get(Calendar.HOUR_OF_DAY);
        int nMinute = cd.get(Calendar.MINUTE);

		cd.set(Calendar.HOUR_OF_DAY, 0);
		cd.set(Calendar.MINUTE, 0);
		cd.set(Calendar.SECOND, 0);
		cd.set(Calendar.MILLISECOND, 0);

		Calendar dd = Calendar.getInstance();
		
		if(articleTime.trim().equals("")||articleTime==null){
			dd.set(2000, 2, 12, 0, 0, 0); 
		}else{
			String[] atime = articleTime.trim().split("-");
			dd.set(Integer.parseInt(atime[0]), Integer.parseInt(atime[1]), Integer.parseInt(atime[2]), 0, 0, 0);
		}
		
        dd.set(java.util.Calendar.HOUR_OF_DAY, 0);
        dd.set(java.util.Calendar.MINUTE, 0);
        dd.set(java.util.Calendar.SECOND, 0);
        dd.set(java.util.Calendar.MILLISECOND, 0);

		long tt = cd.getTimeInMillis() - dd.getTimeInMillis();
		double ret = 0;
		
		ret = (long) ( (double) (tt) / 8640.0)
				+ daycnt * 10000
				+ (double)ord * 1000 
				+ (double)nHour*10.0 + (double)nMinute*0.1
				+ (double)(id % 1000000)*0.0000001;
		return ret * -1;
	}
	
	protected FileNamePair generateFilePath(String attPath, String storeBase, String createDate){
		
		String ext = attPath.substring(attPath.lastIndexOf(".")+1, attPath.length());
		if(ext == null || ext.length() == 0 || ext.length() > 4){
			ext = Const.IMG_JPG;
		}
		
		String recordPath = "xy";
		if(createDate==null||"".equals(createDate.trim())){
			createDate = formatTime.format(new Date());
		}else{
			System.out.println(createDate);
			createDate = getTimePath(createDate);
		}
		
		recordPath = FilePathUtil.normalPath(recordPath, createDate);
		recordPath = FilePathUtil.normalPath(recordPath, UUIDGenerator.generate() + "." + ext);
		
		String absPath = FilePathUtil.normalPath(storeBase, "pic");
		absPath = FilePathUtil.normalPath(absPath, recordPath);
		
		FileNamePair fileNamePair = new FileNamePair(absPath, "图片存储;" + recordPath);
		fileNamePair.recordPath = "../../xy/image.do?path=" + fileNamePair.recordPath;
		return fileNamePair;
		
	}
	

	/**
	 * 下载图片到翔宇存储
	 * @param urlpath
	 * @param savepath
	 */
	public static void download(String urlpath,String savepath) {
		if(!urlpath.startsWith("http")){
			return;
		}
		HttpClient c = new DefaultHttpClient();
		c.getParams().setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);
		c.getParams().setIntParameter(CoreConnectionPNames.SO_TIMEOUT, 10000);
		c.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.RFC_2965);
		c.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);
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
			logger.error("",e);
		}finally{
			IOUtils.closeQuietly(fos);
			IOUtils.closeQuietly(is);
		}
		long t2 = System.currentTimeMillis();
		logger.info("下载文件【"+urlpath+"】到【"+savepath+"】完成，花费"+((t2-t1)/1000)+"秒");
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public static void createFile(String file){
		File f = new File(file);
		if(f.exists())
			f.delete();
		try {
			f.createNewFile();
		} catch (IOException e) {
			logger.error("建立文件"+file+"出错,等待5秒重建");
			e.printStackTrace();
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

	/**
	 * 生成抽图文件
	 */
	public void extracting(String attrPath, String infoPath){
		try {
			int index = attrPath.indexOf(";");
			if(index > -1){
				String path = attrPath.substring(index + 1);
				path = path.replace("/", "~");
				File infoDir = new File(infoPath);
				if(!infoDir.exists()){
					infoDir.mkdirs();
				}
				File infoFile = new File(infoDir, path);
				if(!infoFile.exists()){
					infoFile.createNewFile();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 拼接时间路径
	 * @author 飞天猫熊
	 * @param pubTime
	 * @return
	 */
	protected String getTimePath(String pubTime) {
		String pathTime = null;
		try {
			if(pubTime==null||"".equals(pubTime)){
				pubTime = format.format(new Date());
			}
			pathTime = pubTime.trim().substring(0, 10);
			String[] atime = pathTime.split("-");
			pathTime = "/"+atime[0]+atime[1]+"/"+atime[2]+"/";
		} catch (Exception e) {
			System.out.println("拼接时间路径出错!");
			e.printStackTrace();
		}
		
		return pathTime;
	}
	
	class FileNamePair{
		
		public String abstractPath;
		
		public String recordPath;
		
		FileNamePair(String abstractPath, String recordPath){
			this.abstractPath = abstractPath;
			this.recordPath = recordPath;
		}

		public String toString() {
			StringBuffer buf = new StringBuffer();
			buf.append("{abstractPath: " + abstractPath + ", ");
			buf.append("recordPath: " + recordPath + "}");
			return buf.toString();
		}
	}
	
	
}
