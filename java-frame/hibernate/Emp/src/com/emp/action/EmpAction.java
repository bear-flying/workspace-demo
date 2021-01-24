package com.emp.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.emp.pojo.Dept;
import com.emp.pojo.Emp;
import com.emp.service.EmpService;
import com.emp.service.DeptService;
import com.emp.utils.BaseAction;
import com.emp.utils.JiangYuPageUtil;

import com.opensymphony.xwork2.ModelDriven;

public class EmpAction extends BaseAction implements ModelDriven<Emp> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EmpService cs = new EmpService();
	private DeptService ks = new  DeptService();
	
	private List<Dept> list;
	private Emp emp = new Emp();
	private JiangYuPageUtil<Emp> jiangYu = new JiangYuPageUtil<Emp>();
	
	public String findAll(){
		System.out.println("~~~~fingAll~~~~");
		Integer page = (jiangYu.getCurrentPageNo()==null?1:jiangYu.getCurrentPageNo());
		Integer pageSize = 3;
		List<Emp> list = cs.queryAll(page,pageSize);
		int result = cs.getCount();
		//System.out.println(result);
		jiangYu = JiangYuPageUtil.page("Emp", null, "emp!findAll.action", result, page, pageSize, list);
		
		return "found";
	}
	
	public String toAdd(){
		//JSP页面在web-inf下的时候 必须经由Action才能转到
		System.out.println("~~~~toAdd~~~~");
		
		list = ks.findAll();
		//System.out.println(list);
		return "append";
	}
	
	public String add(){

		System.out.println("~~~~add~~~~");

		cs.add(emp);
		
		return "success";
	}
	
	public String findOne(){
		
		System.out.println("~~~~findOne~~~~");
		
		emp = cs.findOne(emp.getId());
		list = ks.findAll();
		return "foundOne";
	}
	
	public String modify(){
		
		System.out.println("~~~~modify~~~~");
		
		cs.modify(emp);
		
		return "success";
	}
	
	public String remove(){
		
		System.out.println("~~~~remove~~~~");
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids = request.getParameter("ids");
		cs.remove(ids);
		
		return "success";
	}

	public Emp getModel() {
		// TODO Auto-generated method stub
		return emp;
	}

	public List<Dept> getList() {
		return list;
	}

	public void setList(List<Dept> list) {
		this.list = list;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public JiangYuPageUtil<Emp> getJiangYu() {
		return jiangYu;
	}

	public void setJiangYu(JiangYuPageUtil<Emp> jiangYu) {
		this.jiangYu = jiangYu;
	}

	

}
