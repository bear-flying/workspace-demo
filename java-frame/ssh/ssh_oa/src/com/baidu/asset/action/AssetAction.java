package com.baidu.asset.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.baidu.asset.ChineseLatter;
import com.baidu.asset.bean.Asset;
import com.baidu.asset.bean.AssetDetail;
import com.baidu.asset.bean.Img;
import com.baidu.asset.service.AssetDetailService;
import com.baidu.asset.service.AssetService;
import com.baidu.asset.service.ImgService;
import com.baidu.base.service.BaseService;
import com.baidu.base.service.SelectDataService;
import com.baidu.user.bean.User;
import com.baidu.util.DateUtil;
import com.baidu.util.FileUtil;
import com.baidu.util.Page;
import com.baidu.util.QueryResult;
import com.baidu.util.Request;
import com.baidu.util.Response;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.rtf.RtfWriter2;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class AssetAction extends ActionSupport implements ModelDriven<Asset> {
	
	
	private Asset asset = new Asset();
	
	private AssetService assetService;
	private SelectDataService selectDataService;
	private BaseService baseService;
	private AssetDetailService assetDetailService;
	private ImgService imgService;
	private String filepath;
	
	
	public AssetDetailService getAssetDetailService() {
		return assetDetailService;
	}

	public void setAssetDetailService(AssetDetailService assetDetailService) {
		this.assetDetailService = assetDetailService;
	}

	public ImgService getImgService() {
		return imgService;
	}

	public void setImgService(ImgService imgService) {
		this.imgService = imgService;
	}

	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
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

	public AssetService getAssetService() {
		return assetService;
	}

	public void setAssetService(AssetService assetService) {
		this.assetService = assetService;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public Asset getModel() {
		// TODO Auto-generated method stub
		return asset;
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-14下午7:30:49
	 * 功能：转到图片上传页面
	 * @return
	 */
	public String uploadPage() {
		return "upload";
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
	 * 时间：2015-12-14下午7:35:29
	 * 功能：easyui获取列表数据
	 * @return
	 */
	public void listData(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map map =selectDataService.getListForPage(request, "select a.*,b.name typename,c.realname username,d.name factoryname from t_asset a,t_assettype b,t_user c,t_factory d where a.typeid = b.id and a.userid = c.id and a.factory = d.id");
		
		JSONObject json = new JSONObject();
		json.put("total", ((Page)map.get("p")).getTotal());
		json.put("rows", map.get("resoultList"));

		Response.write(json.toString());
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-13下午7:49:44
	 * 功能：转到添加页面
	 * @return
	 */
	public String toAdd(){

		return "add";
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-13下午7:49:44
	 * 功能：转到修改页面
	 * @return
	 */
	public String toModify(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Asset as = assetService.getEntityById(asset.getId());
		Map map = selectDataService.getListForPage(request, "select * from t_assetdetail where assetid = '"+as.getId()+"'");
		//? assetDetailService.findEntityByHQL("from AssetDetail a where a.", serializables)
		List<AssetDetail> list = (List<AssetDetail>)map.get("resoultList");
		List<Img> list2 = (List<Img>)selectDataService.queryForList("select * from t_img where aid = '"+as.getId()+"'");
		try {
			BeanUtils.copyProperties(asset,as);
			ActionContext.getContext().put("assetdetaillist", list);
			ActionContext.getContext().put("imglist", list2);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return "edit";
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-17下午2:44:30
	 * 功能：获得所有的厂家
	 */
	public void findFactorys(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map map =selectDataService.getListForPage(request, "select * from t_factory ");
		Object object = map.get("resoultList");
		JSONArray array = JSONArray.fromObject(object);

		Response.write(array.toString());
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-17下午2:44:30
	 * 功能：获得所有的厂家
	 */
	public void findAllTypes(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map map =selectDataService.getListForPage(request, "select * from t_assettype ");
		Object object = map.get("resoultList");
		JSONArray array = JSONArray.fromObject(object);
		
		Response.write(array.toString());
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-17下午2:44:49
	 * 功能：获得指定厂家的资产类型
	 */
	public void findTypes(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Map map =selectDataService.getListForPage(request, "select * from t_assettype where id="+id);
		Object object = map.get("resoultList");
		JSONArray array = JSONArray.fromObject(object);

		Response.write(array.toString());
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-17下午2:45:25
	 * 功能：生成资产编号
	 * @throws ParseException
	 */
	public void getNums() throws ParseException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String numname = request.getParameter("numname");
		String number = ChineseLatter.getNum(numname);
		Response.write(number);
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-17下午2:45:45
	 * 功能：新增资产
	 * @throws Exception
	 */
	public void add() throws Exception{
		assetService.save(asset);
		//String id = asset.getId();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		//资产明细参数
		String[] names = request.getParameterValues("qname");
		String[] models = request.getParameterValues("qmodel");
		String[] nums = request.getParameterValues("qnum");
		String[] contents = request.getParameterValues("qcontent");
		//图片上传参数
		String imgss = request.getParameter("imgss");
		//添加资产明细表
		if(names!=null){
			for(int i=0;i<names.length;i++){
				AssetDetail assetDetail = new AssetDetail(names[i],models[i],new Integer(nums[i]),contents[i]);
				assetDetail.setAsset(asset);
				assetDetailService.save(assetDetail);
				//baseService.save(assetDetail, AssetDetail.class, "yes");
			}
		}
		if(imgss!=null){
			//添加图片表
			String[] images = imgss.split(";");
			for(int j=0;j<images.length;j++){
				String[] ss = images[j].split(",");
				Img img = new Img(ss[0],ss[1]);
				img.setAsset(asset);
				imgService.save(img);
				//baseService.save(img, Img.class, "yes");
			}
		}
		
	}
	
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-17下午7:30:10
	 * 功能：修改
	 */
	public void modify() {
		assetService.update(asset);
		assetDetailService.deleteById("id", asset.getId());
		HttpServletRequest request = ServletActionContext.getRequest();
		//资产明细参数
		String[] names = request.getParameterValues("qname");
		String[] models = request.getParameterValues("qmodel");
		String[] nums = request.getParameterValues("qnum");
		String[] contents = request.getParameterValues("qcontent");
		//添加资产明细表
		if(names!=null){
			for(int i=0;i<names.length;i++){
				AssetDetail assetDetail = new AssetDetail(names[i],models[i],new Integer(nums[i]),contents[i]);
				assetDetail.setAsset(asset);
				assetDetailService.save(assetDetail);
			}
		}
		
		//图片上传参数
		String imgss = request.getParameter("imgss");
		if(imgss!=null){
			//添加图片表
			String[] images = imgss.split(";");
			for(int j=0;j<images.length;j++){
				String[] ss = images[j].split(",");
				Img img = new Img(ss[0],ss[1]);
				img.setAsset(asset);
				imgService.save(img);
			}
		}
		Response.write("true");
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-18上午8:28:22
	 * 功能：修改时删除图片
	 */
	public void delimg(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String[] ids = request.getParameterValues("ids");
		for (String s : ids) {
			selectDataService.delete("delete from t_img where aid="+s);
//			selectDataService.delete("delete from t_assetdetail where assetid="+s);
//			imgService.deleteById("id", s);
		}
//		//查询图片服务器地址
//		List<Img> imgList = imgService.findAll();
//		for (Img img : imgList) {
//			File file = new File(request.getSession().getServletContext().getRealPath("/")+"upload/"+img.getPath());
//			if(file.exists()){
//				System.out.println("要删除的file.path="+file);
//				boolean b = file.delete();
//				if(b){
//					System.out.println("服务器图片删除成功！");
//				}else{
//					System.out.println("服务器图片删除失败！");
//				}
//			}
//		}	
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-14上午7:46:32
	 * 功能：批量删除
	 */
	public void remove(){
		String ids = Request.getParameter("ids");
		String[] split = ids.split(",");
		for (String s : split) {
			assetService.deleteById("id", s);
			
		}
		Response.write("ok");
		
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-23上午7:45:19
	 * 功能：导出Word
	 * @throws Exception
	 */
	public void exportWord() throws Exception{
		FileOutputStream outputStream = new FileOutputStream("E:\\a.doc");
		
		Document document =new Document(PageSize.A4, 50, 50, 50, 50);
		
//		PdfWriter.getInstance(document, outputStream); 导出PDF
		RtfWriter2.getInstance(document, outputStream);
		
		document.open();
		
		//定义中文字体
		BaseFont bfChinese =BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
		Font fontCN = new Font(bfChinese,10,Font.BOLD);
		
		Paragraph paragraph =new Paragraph("资产管理",fontCN);
		paragraph.setAlignment("center");
		
		document.add(paragraph);
		
		Table table =new Table(3);
		for (int i = 0; i < 6; i++) {
			Cell cell = new Cell(new Paragraph(i+"单元格",fontCN));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
		}
		document.add(table);
		
		document.close();
		outputStream.close();
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-20下午7:06:23
	 * 功能：导出excel
	 */
	public void exportAsset(){
		HttpServletRequest request =ServletActionContext.getRequest();
		HttpServletResponse response =ServletActionContext.getResponse();
		
		String fileName ="资产管理";
		
		//获取表头信息 （查询该表的所有字段及字段注释,把字段注释当作表头）
		List<Map> list = selectDataService.queryForList("select * from user_col_comments where table_name ='T_ASSET'");
		
		//中文表头集合
		List<String> cnColList = new ArrayList<String>();
		//中英文表头集合
		Map cn_enmap = new HashMap();//中文—英文 键值对
		
		for(Map map:list){
			cnColList.add(map.get("COMMENTS").toString());
			cn_enmap.put(map.get("COMMENTS").toString(), map.get("COLUMN_NAME").toString());
		}
		
		HSSFWorkbook workbook =new HSSFWorkbook();
		HSSFSheet sheet =workbook.createSheet(fileName);
		
		//添加表头（表头中仅有一个单元格 为标题“资产管理”）
		HSSFRow row =sheet.createRow(0);//第一行
		HSSFCell cell =row.createCell(0);//第一个单元格
		cell.setCellValue(fileName);//给这个单元格赋值
		
		//添加表头的下一行 为jsp页面table中的表头（中文）
		row = sheet.createRow(1);//第二行
		for (int i = 0; i < cnColList.size(); i++) {//给第二行循环添加数据
			cell = row.createCell(i);
			cell.setCellValue(cnColList.get(i));
		}
		
		//添加数据
		List<Map> dataList =selectDataService.queryForList("select a.id,a.num,a.name,b.name typeid,to_char(a.buydate,'yyyy-MM-dd') buydate,d.realname userid,a.price,c.name factory,a.content from t_asset a,t_assettype b,t_factory c,t_user d where a.typeid =b.id(+) and a.userid =d.id(+) and a.factory =c.id(+)");
		for(int i = 0; i < dataList.size(); i++){
			Map dataMap = dataList.get(i);//每一条数据集合
			row =sheet.createRow(i+2);
			for (int j = 0; j < cn_enmap.size(); j++) {
				cell = row.createCell(j);
				//获取中文字段名
				String cnColName = cnColList.get(j);
				//根据中文字段名获取英文字段名
				String enColName = cn_enmap.get(cnColName).toString();
				cell.setCellValue(dataMap.get(enColName)==null?"":dataMap.get(enColName).toString());
				
			}
		}
		
		try {
			String filePath =request.getSession().getServletContext().getRealPath("/")+"poi\\a.xls";
			FileOutputStream outputStream =new FileOutputStream(filePath);
			workbook.write(outputStream);	
			outputStream.close();	
			FileUtil.downloadFile(response, filePath, "a.xls");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-22上午10:45:50
	 * 功能：导入excel
	 */
	public void importAsset(){
		
		try {
			//获取上传的excel
			HttpServletRequest request = ServletActionContext.getRequest();
//			String filepath = request.getParameter("filepath");
			String path = request.getSession().getServletContext().getRealPath("")+"\\poi\\";
			
			File file = new File(filepath);
			//解决文件同名问题
			filepath = UUID.randomUUID().toString().replace("-", "")+filepath.substring(filepath.lastIndexOf("."));
			//定义服务器的新文件
			File newFile = new File(path+filepath);
			//上传
			FileUtils.copyFile(file, newFile);
			
			
			//列头中文字段集合
			List cnColList = new ArrayList();
			
			//获取表头信息TABLE_NAME, TABLE_TYPE, COMMENTS
			List<Map> list =selectDataService.queryForList("select * from user_col_comments where table_name ='T_ASSET'");
			//中英文表头集合
			Map cn_enmap =new HashMap();
			
			for(Map map:list){
				cnColList.add(map.get("COMMENTS").toString());
				cn_enmap.put(map.get("COMMENTS").toString(), map.get("COLUMN_NAME").toString());
			}
			
			//资产类型转换集合
			List<Map> typelist =selectDataService.queryForList("select id,name from t_assettype");
			Map typemap =new HashMap();
			for(Map map:typelist){
				typemap.put(map.get("NAME").toString(), map.get("ID").toString());
			}
			
			//责任人转换集合
			List<Map> userlist =selectDataService.queryForList("select id,realname name from t_user");
			Map usermap =new HashMap();
			for(Map map:userlist){
				usermap.put(map.get("NAME").toString(), map.get("ID").toString());
			}
			
			//厂家转换集合
			List<Map> factorylist =selectDataService.queryForList("select id,name from T_FACTORY");
			Map factorymap =new HashMap();
			for(Map map:factorylist){
				factorymap.put(map.get("NAME").toString(), map.get("ID").toString());
			}
			
			
			
			FileInputStream inputStream =new FileInputStream(path+filepath);
			
			HSSFWorkbook workbook =new HSSFWorkbook(inputStream);
			//循环解析每一个sheet
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				HSSFSheet sheet = workbook.getSheetAt(i);
				
				//获取sheet的有效行数
				int rownum =sheet.getPhysicalNumberOfRows();
				//循环解析每一行(跳过表头行)
				
				String sql ="insert into t_asset2 (";
				String colSql="";
				for (int j = 1; j < rownum; j++) {
					String valueSql=" values ( ";
					HSSFRow row = sheet.getRow(j);
					int cellnum =	row.getPhysicalNumberOfCells();
					//解析列头
					if(j==1){
						//循环解析每一个单元格
						for (int k = 0; k < cellnum; k++) {
							HSSFCell cell = row.getCell(k);
							cnColList.add(cell.getStringCellValue());
							colSql+=cn_enmap.get(cell.getStringCellValue())+",";
						}
						colSql =colSql.substring(0, colSql.length()-1)+" ) ";
					}else{
						//解析数据行
						for (int k = 0; k < cellnum; k++) {
							HSSFCell cell = row.getCell(k);
							String cellValue =cell.getStringCellValue()==null?"":cell.getStringCellValue();
							cnColList.add(cellValue);
							if(cnColList.get(k).equals("资产类型")){
								valueSql+="'"+(typemap.get(cellValue)==null?"":typemap.get(cellValue))+"',";
							}else if(cnColList.get(k).equals("购买日期")){
								valueSql+=(cellValue==null||cellValue.equals("")?"null,":"to_date('"+cellValue+"','yyyy-MM-dd'),");
							}else if(cnColList.get(k).equals("责任人")){
								valueSql+="'"+(usermap.get(cellValue)==null?"":usermap.get(cellValue))+"',";
							}else if(cnColList.get(k).equals("厂家")){
								valueSql+="'"+(factorymap.get(cellValue)==null?"":factorymap.get(cellValue))+"',";
							}else{
								valueSql+="'"+cellValue+"',";
							}
						}
						valueSql =valueSql.substring(0, valueSql.length()-1)+" ) ";
						System.out.println(sql+colSql+valueSql);
						selectDataService.update(sql+colSql+valueSql);
					}
				}
			}
			inputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-23上午7:53:45
	 * 功能：使用反射 实现导出excel
	 */
	public void importAsset2(){
		
		try {
			//获取上传的excel
			
			//解析excel
			
			//列头中文字段集合
			List cnColList = new ArrayList();
			
			//获取表头信息TABLE_NAME, TABLE_TYPE, COMMENTS
			List<Map> list =selectDataService.queryForList("select * from user_col_comments where table_name ='T_ASSET'");
			//中英文表头集合
			Map cn_enmap =new HashMap();
			
			for(Map map:list){
				cnColList.add(map.get("COMMENTS").toString());
				cn_enmap.put(map.get("COMMENTS").toString(), map.get("COLUMN_NAME").toString());
			}
			
			//资产类型转换集合
			List<Map> typelist =selectDataService.queryForList("select id,type_name name from t_assettype");
			Map typemap =new HashMap();
			for(Map map:typelist){
				typemap.put(map.get("NAME").toString(), map.get("ID").toString());
			}
			
			//责任人转换集合
			List<Map> userlist =selectDataService.queryForList("select id,realname name from t_user");
			Map usermap =new HashMap();
			for(Map map:userlist){
				usermap.put(map.get("NAME").toString(), map.get("ID").toString());
			}
			
			//厂家转换集合
			List<Map> factorylist =selectDataService.queryForList("select id,name from T_FACTORY");
			Map factorymap =new HashMap();
			for(Map map:factorylist){
				factorymap.put(map.get("NAME").toString(), map.get("ID").toString());
			}
			
			
			
			FileInputStream inputStream =new FileInputStream("E:\\资产管理.xls");
			
			HSSFWorkbook workbook =new HSSFWorkbook(inputStream);
			//循环解析每一个sheet
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				HSSFSheet sheet = workbook.getSheetAt(i);
				
				//获取sheet的有效行数
				int rownum =sheet.getPhysicalNumberOfRows();
				//循环解析每一行(跳过表头行)
				
				String sql ="insert into t_asset (";
				String colSql="";
				for (int j = 1; j < rownum; j++) {
					String valueSql=" values ( ";
					HSSFRow row = sheet.getRow(j);
					int cellnum =	row.getPhysicalNumberOfCells();
					//解析列头
					if(j==1){
					//循环解析每一个单元格
					for (int k = 0; k < cellnum; k++) {
						HSSFCell cell = row.getCell(k);
						cnColList.add(cell.getStringCellValue());
						colSql+=cn_enmap.get(cell.getStringCellValue())+",";
					}
					colSql =colSql.substring(0, colSql.length()-1)+" ) ";
					}else{
						Asset asset = new Asset();
						Method[] methods = Asset.class.getDeclaredMethods();
						
						//解析数据行
						for (int k = 0; k < cellnum; k++) {
							HSSFCell cell = row.getCell(k);
							String cellValue =cell.getStringCellValue()==null?"":cell.getStringCellValue();
							
							if(cnColList.get(k).equals("资产类型")){
								cellValue =(typemap.get(cellValue)==null?"":typemap.get(cellValue).toString());
							}else if(cnColList.get(k).equals("责任人")){
								cellValue =(usermap.get(cellValue)==null?"":usermap.get(cellValue).toString());
							}else if(cnColList.get(k).equals("厂家")){
								cellValue =(factorymap.get(cellValue)==null?"":factorymap.get(cellValue).toString());
							}else{
								cellValue =cellValue;
							}
							
							String encolName =cn_enmap.get(cnColList.get(k)).toString();
							//大写方法名
							String methodName =("set"+encolName).toUpperCase();
							
							for(Method method:methods){
								if(method.getName().toUpperCase().equals(methodName)){
									Class typeClass = method.getParameterTypes()[0];
									if(!cellValue.equals("")){
										if(typeClass.getSimpleName().equals("Integer")){
											method.invoke(asset, Integer.parseInt((cellValue)));
										}else if(typeClass.getSimpleName().equals("Date")){
											method.invoke(asset, DateUtil.convertStringToDate(cellValue));
										}else{
											method.invoke(asset, cellValue);
										}
									}
								}
							}
				
						}
						System.out.println(asset.toString());
					}
				}
			}
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listAll(){
		List<Asset> assets = assetService.findAll();
		Response.write(JSONArray.fromObject(assets).toString());
	}
	
	
	public void list() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		int page =Integer.parseInt(request.getParameter("page")==null?"1":request.getParameter("page"));

		int rows = Integer.parseInt(request.getParameter("rows")==null?"10":request.getParameter("rows"));//鎺ュ彈鍙傛暟page鍜宺ows
		
		QueryResult<Asset> result =assetService.getScrollData((page-1)*rows,rows);
		
		Response.write(  JSONArray.fromObject(result.getResultlist()).toString());
		
	}


}
