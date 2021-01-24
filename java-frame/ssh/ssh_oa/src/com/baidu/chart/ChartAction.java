package com.baidu.chart;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFCreationHelper;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.util.IOUtils;
import org.apache.struts2.ServletActionContext;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.baidu.asset.bean.Asset;
import com.baidu.asset.service.AssetDetailService;
import com.baidu.asset.service.AssetService;
import com.baidu.base.service.SelectDataService;
import com.baidu.mail.bean.Mail;
import com.baidu.mail.service.MailService;
import com.baidu.util.Response;
import com.opensymphony.xwork2.ActionSupport;

public class ChartAction extends ActionSupport{
	
	
	private Asset asset = new Asset();
	private Mail mail = new Mail();
	
	private AssetService assetService;
	private SelectDataService selectDataService;
	private AssetDetailService assetDetailService;
	private MailService mailService;

	
	
	public AssetDetailService getAssetDetailService() {
		return assetDetailService;
	}

	public void setAssetDetailService(AssetDetailService assetDetailService) {
		this.assetDetailService = assetDetailService;
	}

	public SelectDataService getSelectDataService() {
		return selectDataService;
	}

	public void setSelectDataService(SelectDataService selectDataService) {
		this.selectDataService = selectDataService;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public Mail getMail() {
		return mail;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
	}

	public MailService getMailService() {
		return mailService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	public AssetService getAssetService() {
		return assetService;
	}

	public void setAssetService(AssetService assetService) {
		this.assetService = assetService;
	}

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-14下午7:35:29
	 * 功能：转到list页面
	 * @return
	 */
	public String listPage(){
		return "list";
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-17下午2:44:49
	 * 功能：获得不同部门发送邮件统计
	 */
	public void findmails(){
		List list = selectDataService.queryForList("select d.name,count(*) num from t_mail m,t_dept d,t_user u " +
				"where u.deptid = d.id and m.sender = u.realname group by d.name");
		JSONArray array = JSONArray.fromObject(list);

		Response.write(array.toString());
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-17下午2:44:49
	 * 功能：获得不同部门发送邮件统计
	 */
	public void findAssets(){
		List list = selectDataService.queryForList("select " +
				"decode(a.status,'1','在库','2','出库','禁用') status," +
				"sum(b.num) result from t_asset a,t_assetdetail b " +
				"where a.id = b.assetid group by status");
		JSONArray array = JSONArray.fromObject(list);
		
		Response.write(array.toString());
	}

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-30上午11:16:40
	 * 功能：每周六晚上2点定时备份系统数据，将备份的数据文件生成到dmp文件中，
	 * 		并且保存到tomcat目录下项目目录下的back文件夹中
	 */
	public void findQuartzDmps(){
		Runtime runtime=Runtime.getRuntime();
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getSession().getServletContext().getRealPath("")+"\\back\\"+new Date()+".dmp";
		try{
			
			runtime.exec("cmd /c start exp xiaobaixia/xiaobaixia@orcl file="+path);
		}catch(Exception e){
			System.out.println("Error!");
		}
	}
	
	/**
	 * 
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-30下午1:24:15
	 * 功能：每天晚上2点在服务器生成今天公司邮件发送报表（利用柱状图统计不同部门的邮件发送数量）
	 * 	       报表展示：用jfreechart生成统计图片，然后利用poi将图片生成到excel中
	 * 
	 */
	public void findQuartzMails() {
		
		List<Map> list = selectDataService.queryForList("select d.name,count(*) num from t_mail m,t_dept d,t_user u " +
				"where u.deptid = d.id and m.sender = u.realname  group by d.name");
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    
		//创建主题样式  
		StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
		//设置标题字体  
		standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));  
		//设置图例的字体  
		standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));  
		//设置轴向的字体  
		standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));  
		//应用主题样式  
		ChartFactory.setChartTheme(standardChartTheme); 
		
		for (Map map : list) {
	    	dataset.addValue(new Integer(map.get("NUM").toString()),map.get("NAME").toString(),"部门");  
		}
		//JFreeChart画图  
	    JFreeChart chart = ChartFactory.createBarChart("MailTable", "dept", "count",
	    		dataset, PlotOrientation.VERTICAL, true, false, false);
	  
	    HttpServletRequest request = ServletActionContext.getRequest();
	    //tomcat路径
	    String path = request.getSession().getServletContext().getRealPath("")+"\\back\\";
	    //图片名称
	    String img = UUID.randomUUID().toString().replace("-", "")+".jpg";
	    //EXCEL名称
	    String excel = UUID.randomUUID().toString().replace("-", "")+".xls";
	    //图片文件生成路径
    	String imgpath = path+img;
		//EXCEL文件生成路径
    	String excelpath = path+excel;
    	
    	
    	
    	FileOutputStream fos = null;
    	FileInputStream fis =null;
    	FileOutputStream exfos = null;
	    try {
	    	fos = new FileOutputStream(imgpath);
	    	// 由ChartUtilities生成图片文件   导出到一个outputStream中去  
			ChartUtilities.writeChartAsJPEG(fos, chart, 400, 300);
			
			File file = new File(excelpath);
			file.createNewFile();
			
			fis = new FileInputStream(imgpath);  
			byte[] bytes = IOUtils.toByteArray(fis);  
			
			HSSFWorkbook wb = new HSSFWorkbook(); 
			
			HSSFSheet sheet =wb.createSheet("sheet1");
			
			int pictureIndex = wb.addPicture(bytes, HSSFWorkbook.PICTURE_TYPE_JPEG);  
			
			HSSFCreationHelper helper = (HSSFCreationHelper) wb.getCreationHelper();  
			  
			
			HSSFPatriarch patriarch = sheet.createDrawingPatriarch();  
			  
			HSSFClientAnchor clientAnchor = helper.createClientAnchor();  
			  
			clientAnchor.setCol1(5);  
			clientAnchor.setRow1(4);  
			  
			
			
			HSSFPicture picture = patriarch.createPicture(clientAnchor, pictureIndex);  
			picture.resize();  
			
			exfos = new FileOutputStream(excelpath);
			wb.write(exfos);
			
			fis.close(); 
			fos.close();
			exfos.close();
	    } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	    
	}
	
	
}
