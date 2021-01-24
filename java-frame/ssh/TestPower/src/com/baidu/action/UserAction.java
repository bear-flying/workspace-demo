package com.baidu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.baidu.entity.Dept;
import com.baidu.entity.Power;
import com.baidu.entity.Role;
import com.baidu.entity.User;
import com.baidu.service.UserService;
import com.baidu.utils.FileUtils;

public class UserAction {
	private UserService userService;
	private String msg;
	private File upload;
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	
	/**
	 * 
	 * 	作者:赵起瑞
	 * 	时间:2016-1-8
	 * 	功能:登陆成功到主页main
	 */
	public String login(){
		System.out.println("list---------------------");
		String name= request.getParameter("name");
		String password = request.getParameter("password");
		if(name==null||"".equals(name)){
			msg="用户名不能为空，请输入";
			
		}else{
			if(password==null||"".equals(password)){
				msg="密码不能为空，请输入";
			}else{
				User user =userService.getUserByName(name);
				request.getSession().setAttribute("name", name);
				request.getSession().setAttribute("user", user);
				if(user==null){
					msg="用户名不存在，请重新登陆！！";
					
				}else{
					Date date = new Date();
					long t1 = date.getTime();
					long t2 = user.getErrortime().getTime();
					long t=(t1-t2)/1000/60;
					user.setErrortime(new Date());
					//判断次数是否大于3
					if(user.getErrorcount()>=3){
						//判段时间是否大于20分钟
						if(t>=20){
							//判段密码
							if(user.getPassword().equals(password)){
								//更新数据
								user.setErrorcount(0);
								userService.updateUser(user);
								return "list";
							}else{
								user.setErrorcount(1);
								userService.updateUser(user);
								msg="密码错误，您好有两次机会了，请慎重";
								
							}
						}else{
							msg="账户被锁定，"+(20-t)+"分钟后自定解锁";
							
						}
						
					}else{
						//判段密码
						if(user.getPassword().equals(password)){
							//更新数据
							user.setErrorcount(0);
							userService.updateUser(user);
							return "list";
						}else{
							user.setErrorcount(user.getErrorcount()+1);
							userService.updateUser(user);
							if(user.getErrorcount()==3){
								msg="账户已经锁定，请在20分钟后再登陆";
							}else{
								msg="密码错误，你还剩"+(3-user.getErrorcount())+"次机会了，请慎重";
							}
						}
						
					}
				}
			}
			
			
		}
		
		
		return "error";
	}
	/**
	 * 
	 * 	作者:赵起瑞
	 * 	时间:2016-1-8
	 * 	功能:ztree
	 */
	public String toShowLeft(){
		User user = (User) request.getSession().getAttribute("user");
		Integer id = user.getId();
		List<Power> list =userService.getPowersById(id+"");
		
		
		request.getSession().setAttribute("powers", list);
		String json = JSONArray.fromObject(list).toString();
		request.setAttribute("json", json);
		return "toleft";
		
		
	}
	/**
	 * 导出excel
	 * @return
	 */
	public void exportExcel(){
		List<Role> list =userService.getRoleList();
		HSSFWorkbook work = new HSSFWorkbook();
		HSSFSheet s = work.createSheet("角色列表");
		HSSFRow r = s.createRow(0);
		r.createCell(0).setCellValue("角色id");
		r.createCell(1).setCellValue("角色名称");
		for(int x=0;x<list.size();x++){
			Role rb = list.get(x);
			HSSFRow cr = s.createRow(x+1);
			cr.createCell(0).setCellValue(rb.getRid());
			cr.createCell(1).setCellValue(rb.getRname());
		}
		//response.setCharacterEncoding("utf-8");
		FileUtils.downloadFile(request,response,work,"角色导出.xls");
	}
	/**
	 * 到导入页面
	 * @return
	 */
	public String toimportExcel(){
		
		return "toimport";
	}
	/**
	 * 导入
	 * @return
	 * @throws Exception 
	 */
	public String importExcel() throws Exception{
		System.out.println(upload);
		Role role = new Role();
		List<Role> list = new ArrayList<Role>();
		InputStream in = new FileInputStream(upload);
		//xls的文件
		HSSFWorkbook work = new HSSFWorkbook(in);
		int sheets = work.getNumberOfSheets();
		for(int i = 0; i<sheets;i++){
			//获取sheet
			HSSFSheet ss = work.getSheetAt(i);
			int rowNum = ss.getLastRowNum();
			for(int x=0;x<=rowNum;x++){
				//获取行
				HSSFRow row = ss.getRow(x+1);
				 HSSFCell c1 = row.getCell(0);
				  double d = c1.getNumericCellValue();
				  int id  = (int) Math.ceil(d);
				 HSSFCell c2 = row.getCell(1);
				 String name = c2.getStringCellValue();
				role.setRid(id);
				role.setRname(name);
				list.add(role);
			}
			
		}
		
		
		userService.saveRole(list);
		
		return getRoleList();
	}
	/**
	 * 
	 * 	作者:赵起瑞
	 * 	时间:2016-1-8
	 * 	功能:用户列表
	 */
	public String getUserList(){
		List<User> list =userService.getUserList();
		for (User user : list) {
			List rnames =userService.getRnames(user.getId());
			String r =rnames.toString().replace(" ", "");
			user.setRname(r.substring(1, r.length()-1));
		}
		request.getSession().setAttribute("list", list);
		String json = JSONArray.fromObject(list).toString();
		request.setAttribute("json", json);
		return "userList";
	}
	/**
	 * 
	 * 	作者:赵起瑞
	 * 	时间:2016-1-8
	 * 	功能:查看角色
	 */
	@SuppressWarnings("unchecked")
	public String ckjs(){
		String id = request.getParameter("id");
		
		User user = userService.getUserById(id);
		List list = userService.getRnames(Integer.parseInt(id));
		String rnames = list.toString().replace(" ", "");
		user.setRname(rnames.substring(1, rnames.length()-1));
		 request.setAttribute("user", user);
		return "ckjs";
	}
	/**
	 * 
	 * 	作者:赵起瑞
	 * 	时间:2016-1-8
	 * 	功能:查看部门
	 */
	@SuppressWarnings("unchecked")
	public String ckbm(){
		String id = request.getParameter("id");
		
		User user = userService.getUserById(id);
		List<Dept> list = userService.getDeptsById(id);
		Set<Dept> depts =new HashSet<Dept>();
		for(Dept dept:list){
			depts.add(dept);
		}
		user.setDept(depts);
		request.setAttribute("user", user);
		return "ckbm";
	}
	public String ckqx(){
		String id = request.getParameter("id");
		
		User user = userService.getUserById(id);
		List<Power> powers = userService.getPowersById(id);
		String json = JSONArray.fromObject(powers).toString();
		
		request.setAttribute("user", user);
		request.setAttribute("json", json);
		return "ckqx";
	}
	/**
	 * 
	 * 	作者:赵起瑞
	 * 	时间:2016-1-8
	 * 	功能:部门列表
	 */
	public String getDeptList(){
		List<Dept> list =userService.getDeptList();
		request.setAttribute("list", list);
		String json = JSONArray.fromObject(list).toString();
		request.setAttribute("json", json);
		return "deptList";
	}
	/**
	 * 
	 * 	作者:赵起瑞
	 * 	时间:2016-1-8
	 * 	功能:职位列表
	 */
	public String getRoleList(){
		List<Role> list =userService.getRoleList();
		request.setAttribute("list", list);
		
		return "roleList";
	}
	/**
	 * 
	 * 	作者:赵起瑞
	 * 	时间:2016-1-8
	 * 	功能:根据部门查看员工列表
	 */
	public String ckyg(){
		String did = request.getParameter("deptid");
		
		List<User> list =userService.getUserList(did);
		for (User user : list) {
			List rnames =userService.getRnames(user.getId());
			String r =rnames.toString().replace(" ", "");
			user.setRname(r.substring(1, r.length()-1));
		}
		request.setAttribute("list", list);
		
		return "ckyg";
	}
	
	/**
	 * 
	 * 	作者:赵起瑞
	 * 	时间:2016-1-8
	 * 	功能:选择员工
	 */
	public String xzyg(){
		String did = request.getParameter("deptid");
		
		List<User> list =userService.getUserList();
		String ids =userService.getIdByDeptid(did);
		request.setAttribute("list", list);
		request.setAttribute("deptid", did);
		request.setAttribute("ids", ids);
		return "xzyg";
	}
	/**
	 * 
	 * 	作者:赵起瑞
	 * 	时间:2016-1-8
	 * 	功能:选择职位
	 */
	public String xzzw(){
		String deptid = request.getParameter("deptid");
		
		List<Role> list =userService.getRoleList();
		String ids =userService.getRidByDeptid(deptid);
		request.setAttribute("list", list);
		request.setAttribute("deptid", deptid);
		request.setAttribute("ids", ids);
		return "xzzw";
	}
	
	/**
	 * 
	 * 	作者:赵起瑞
	 * 	时间:2016-1-8
	 * 	功能:保存员工
	 */
	public String saveyg(){
		String did = request.getParameter("did");
		String[] ids = request.getParameterValues("ck");
		userService.saveyg(did,ids);
		return getDeptList();
	}
	/**
	 * 
	 * 	作者:赵起瑞
	 * 	时间:2016-1-8
	 * 	功能:保存职位
	 */
	public String savezw(){
		String did = request.getParameter("deptid");
		String[] ids = request.getParameterValues("ck");
		userService.savezw(did,ids);
		return getDeptList();
	}
	
	/**
	 * 
	 * 	作者:赵起瑞
	 * 	时间:2016-1-8
	 * 	功能:查看权限列表
	 */
	public String getPowerList(){
		
		List<Power> list =userService.getPowerList();
		request.setAttribute("list", list);
		return "powerList";
	}
	
	/**
	 * 
	 * 	作者:赵起瑞
	 * 	时间:2016-1-8
	 * 	功能:到分配权限列表
	 */
	public String toxzqx(){
		
		String rid = request.getParameter("rid");
		List<Power> list = userService.getPowerListByRid(rid);
		String json = JSONArray.fromObject(list).toString();
		
		request.setAttribute("json", json);
		request.setAttribute("rid", rid);
		return "toxzqx";
	}
	
	/**
	 * 
	 * 	作者:赵起瑞
	 * 	时间:2016-1-8
	 * 	功能:保存权限
	 */
	public String saveQx(){
		
		String rid = request.getParameter("rid");
		String ids = request.getParameter("ids");
		String[] pids = ids.split(",");
		userService.saveQx(rid,pids);
		return "saveQx";
	}
	
	
	
	
	
//*******************************************************
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
