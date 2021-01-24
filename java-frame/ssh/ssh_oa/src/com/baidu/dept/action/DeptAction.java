package com.baidu.dept.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.baidu.base.service.SelectDataService;
import com.baidu.dept.bean.Dept;
import com.baidu.dept.service.DeptService;
import com.baidu.user.bean.User;
import com.baidu.util.Page;
import com.baidu.util.PageView;
import com.baidu.util.QueryResult;
import com.baidu.util.Request;
import com.baidu.util.Response;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DeptAction extends ActionSupport {
	
	private Dept dept;
	private DeptService deptService;
	private SelectDataService selectDataService;
	
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public DeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	
	public SelectDataService getSelectDataService() {
		return selectDataService;
	}

	public void setSelectDataService(SelectDataService selectDataService) {
		this.selectDataService = selectDataService;
	}

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-13下午4:08:04
	 * 功能：转到部门列表页面
	 * @return
	 */
	public String listPage(){
		return "list";
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-13下午4:08:25
	 * 功能：转到部门添加页面
	 * @return
	 */
	public String editPage(){
		return "edit";
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-13下午4:08:53
	 * 功能：转到depttree.jsp页面
	 * @return
	 */
	public String findTree(){
		
		return "depttree";
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-13下午4:09:36
	 * 功能：添加部门
	 */
	public void add(){	
		//System.out.println(dept.getId());
		deptService.save(dept);

	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-13下午4:09:57
	 * 功能：转到修改部门页面
	 * @return
	 */
	public String toModify(){
		String mid = Request.getParameter("id");
		Dept dept = deptService.getEntityById(new Integer(mid));
		ActionContext.getContext().getValueStack().push(dept);
		return "modify";
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-13下午4:10:20
	 * 功能：AJAX获取所有部门 展示在ztree上
	 */
	public void findDepts(){
		
		List list = selectDataService.queryForList("select id \"id\",name \"name\",'0' \"pId\" from t_dept");
		Response.write(JSONArray.fromObject(list).toString());
	}

	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-13下午4:10:55
	 * 功能：Ajax获取一个部门名称
	 */
	public void findonepid(){
		String mid = Request.getParameter("id");
		Dept dept = deptService.getEntityById(new Integer(mid));
		Response.write(dept.getDeptName());
		
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-13下午4:11:30
	 * 功能：AJAX修改部门
	 */
	public void modify(){
		try {
			deptService.update(dept);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 作者：1405javab 姜宇
	 * 时间：2015-12-13下午4:11:45
	 * 功能：AJAX删除部门
	 */
	public void remove(){
		String mid = Request.getParameter("id");
		deptService.deleteById("id", mid);
	}
	
   /** 
	* 分页查询返回部门数据列表
	* @Title: listData 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws 
	*/ 	
	public void listData(){
		HttpServletRequest request = ServletActionContext.getRequest();
		//当前页
		int page= Integer.parseInt(Request.getParameter("page")==null?"1":Request.getParameter("page"));
		//每页显示条数
		int rows= Integer.parseInt(Request.getParameter("rows")==null?"10":Request.getParameter("rows"));		
		//总条数
//		int totalCount = (int) deptService.getCount();		
		Map map =selectDataService.getListForPage(request, "select a.id,a.name,b.name pname,c.realname firstuser,d.realname seconduser,e.realname secretary from t_dept a,t_dept b,t_user c,t_user d,t_user e where a.pid =b.id and a.firstuser =c.id and a.seconduser =d.id and a.secretary =e.id");
		
		JSONObject json = new JSONObject();
		json.put("total", ((Page)map.get("p")).getTotal());
		json.put("rows", map.get("resoultList"));
		
//		QueryResult result =	deptService.getScrollData((page-1)*rows, rows);
//		
//		JSONObject json = new JSONObject();
//		json.put("total", result.getTotalrecord());
//		json.put("rows", result.getResultlist());
		
		Response.write(json.toString());

		
	}
	
	public void listAll(){
		List<Dept> depts =	deptService.findAll();
		Response.write(JSONArray.fromObject(depts).toString());
	}


}
