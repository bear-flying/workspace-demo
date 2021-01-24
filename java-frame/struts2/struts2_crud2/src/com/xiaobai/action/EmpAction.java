package com.xiaobai.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xiaobai.domain.Emp;
import com.xiaobai.domain.Role;
import com.xiaobai.service.EmpService;
import com.xiaobai.service.RoleService;
import com.xiaobai.utils.PageBean;
import com.xiaobai.utils.ToolPage;

public class EmpAction extends ActionSupport implements ModelDriven<Emp>{
	/**
	 *    
	 */
	private static final long serialVersionUID = 1L;

	private EmpService es = new EmpService();
	private RoleService rs = new RoleService();
	
	Emp emp;
	List<Role> rolelist;
	PageBean<Emp> pb;
	
	
	public String findAll(){
		
		System.out.println("==========findAll");
		HttpServletRequest request = ServletActionContext.getRequest();
		//emplist = es.findAll();
		String page = request.getParameter("page");
		String pageSize = request.getParameter("pageSize");
		if(page==null){
			page="1";
		}
		if(pageSize==null){
			pageSize="5";
		}
		pb = es.findByPage(new Integer(page),new Integer(pageSize));
		int totalNums = es.getTotalNums();
		String url = "emp!findAll.action";
		ToolPage.page(request, new Integer(page), new Integer(pageSize), url, totalNums);
		return SUCCESS;
	}
	public String tosave(){
		
		System.out.println("==========toSave");
		rolelist = rs.findAll();
		System.out.println("========="+rolelist.size());
		return "save";
	}
	public String add(){
		
		System.out.println("==========add");
		//emp.getRid();
		//ActionContext.getContext().put("rid", rid);
		es.add(emp);
		
		return "toSave";
	}
	public String toUpdate(){
		
		System.out.println("==========toUpdate");
		
		rolelist = rs.findAll();
		//System.out.println(emp);
		emp = es.findById(emp.getId());
		//emp = es.findById(id);
		System.out.println(emp+"------");
		return "one";
	}
	public String toDelete(){
		
		System.out.println("==========toDelete");
		
		System.out.println(emp.getId());
		
		es.drop(emp.getId());
		
		return "delone";
	}
	public String alter(){
		
		System.out.println("==========toAlter");
		es.alter(emp);
		
		return "delone";
	}

	
	public List<Role> getRolelist() {
		return rolelist;
	}

	public void setRolelist(List<Role> rolelist) {
		this.rolelist = rolelist;
	}
	
	
	public PageBean<Emp> getPb() {
		return pb;
	}
	public void setPb(PageBean<Emp> pb) {
		this.pb = pb;
	}

	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public Emp getModel() {
		// TODO Auto-generated method stub
		return emp;
	}
	
	
}
