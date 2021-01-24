package com.baidu.salary.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.baidu.asset.bean.Asset;
import com.baidu.base.service.SelectDataService;
import com.baidu.salary.bean.Salary;
import com.baidu.salary.service.SalaryService;
import com.baidu.user.bean.User;
import com.baidu.util.DateUtil;
import com.baidu.util.MailUtils;
import com.baidu.util.MessageUtil;
import com.baidu.util.Page;
import com.baidu.util.Response;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SalaryAction extends ActionSupport implements ModelDriven<Salary> {
	
	private Salary salary = new Salary();
	
	private SalaryService salaryService;
	private SelectDataService selectDataService;
	private String filepath;
	
	
	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public SalaryService getSalaryService() {
		return salaryService;
	}

	public void setSalaryService(SalaryService salaryService) {
		this.salaryService = salaryService;
	}

	public SelectDataService getSelectDataService() {
		return selectDataService;
	}

	public void setSelectDataService(SelectDataService selectDataService) {
		this.selectDataService = selectDataService;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public Salary getModel() {
		// TODO Auto-generated method stub
		return salary;
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-23上午10:12:25
	 * 功能：发送邮件（新增邮件）
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		salaryService.save(salary);
		return SUCCESS;
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-23上午11:02:43
	 * 功能：转到list.jsp页面 --->工资页面
	 */
	public String listPage(){
		return "list";
	}

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-25下午2:39:35
	 * 功能：查询工资列表
	 */
	public void salaryList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map map =selectDataService.getListForPage(request, "select * from t_salary");
		
		JSONObject json = new JSONObject();
		json.put("total", ((Page)map.get("p")).getTotal());
		json.put("rows", map.get("resoultList"));

		Response.write(json.toString());
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-28上午8:55:36
	 * 功能：手机和邮件群发
	 */
	public void sendPhoneAndMail() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String[] names = request.getParameterValues("names");
		for (String name : names) {
			//此处无法转成USER等 只能转成MAP
			List<Map> list = (List<Map>)selectDataService.queryForList("select u.mail,u.phone,s.* from t_user u,t_salary s where u.realname = s.workername and u.realname = '"+name+"'");
		
			Map user = list.get(0);
			String mail = (String)user.get("MAIL");
			MailUtils.sendMail(mail, salary.toString());
//			MessageUtil.sendMsg((String)user.get("PHONE"), salary.toString());
		}
		
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-25下午3:35:54
	 * 功能：导入工资 excel工资表
	 */
	public void importSalarys(){
		try {
			//获取上传的excel
			HttpServletRequest request = ServletActionContext.getRequest();
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
			
			//获取表头信息TABLE_NAME, TABLE_TYPE, COMMENTS 每一个list是一个Map 放一行数据
			//			T_SALARY     ID         ID
			//			T_SALARY   WORKERNAME   员工姓名
			//			T_SALARY   BASICSALARY  基本工资 ……
			List<Map> list =selectDataService.queryForList("select * from user_col_comments where table_name ='T_SALARY'");
			
			Map cn_enmap =new HashMap();//中英文表头集合
			
			for(Map map:list){
				cnColList.add(map.get("COMMENTS").toString());
				cn_enmap.put(map.get("COMMENTS").toString(), map.get("COLUMN_NAME").toString());
			}
			
			FileInputStream inputStream =new FileInputStream(path+filepath);
			
			HSSFWorkbook workbook =new HSSFWorkbook(inputStream);
			//循环解析每一个sheet
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				HSSFSheet sheet = workbook.getSheetAt(i);
				int rownum =sheet.getPhysicalNumberOfRows();
				//循环解析每一行
				String sql ="insert into t_salary (";
				String colSql="";
				for (int j = 1; j < rownum; j++) {
					String valueSql=" values ( ";
					HSSFRow row = sheet.getRow(j);
					int cellnum =	row.getPhysicalNumberOfCells();
					
					if(j==1){//解析表头一行
						for (int k = 0; k < cellnum; k++) {
							HSSFCell cell = row.getCell(k);
							colSql+=cn_enmap.get(cell.getStringCellValue())+",";
						}
						colSql =colSql.substring(0, colSql.length()-1)+" ) ";
					}else{
						//循环解析每一行数据
						for (int k = 0; k < cellnum; k++) {
							HSSFCell srcCell = row.getCell(k);
							// 不同数据类型处理  
					        int srcCellType = srcCell.getCellType();  
					        Object value = "";
					        
					        if (srcCellType == HSSFCell.CELL_TYPE_NUMERIC) {  
//					               if (HSSFDateUtil.isCellDateFormatted(srcCell)) {  
//					                    distCell.setCellValue(srcCell.getDateCellValue());  
//					                } else {  
//					                    distCell.setCellValue(srcCell.getNumericCellValue());  
//					                }  
					        	value = srcCell.getNumericCellValue();
					        } else if (srcCellType == HSSFCell.CELL_TYPE_STRING) {  
//					                distCell.setCellValue(srcCell.getRichStringCellValue()); 
					            value =srcCell.getStringCellValue()==null?"":srcCell.getStringCellValue();
					        } else if (srcCellType == HSSFCell.CELL_TYPE_BOOLEAN) { 
					        	value = srcCell.getBooleanCellValue();
					        } else if (srcCellType == HSSFCell.CELL_TYPE_ERROR) {  
//					                distCell.setCellErrorValue(srcCell.getErrorCellValue());  
					        } else if (srcCellType == HSSFCell.CELL_TYPE_FORMULA) {  
//					                distCell.setCellFormula(srcCell.getCellFormula());  
					        } else if (srcCellType == HSSFCell.CELL_TYPE_BLANK) {  
				                // nothing21  
					        } else { 
					        	
					        }  
							
							valueSql+="'"+value+"',";
							
						}
						valueSql =valueSql.substring(0, valueSql.length()-1)+" ) ";
						System.out.println(sql+colSql+valueSql);
						selectDataService.update(sql+colSql+valueSql);
					}
				}
			}
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
