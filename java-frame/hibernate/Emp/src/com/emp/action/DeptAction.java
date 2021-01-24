package com.emp.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.emp.pojo.Dept;
import com.emp.service.DeptService;
import com.emp.utils.BaseAction;
import com.emp.utils.JiangYuPageUtil;
import com.opensymphony.xwork2.ModelDriven;

public class DeptAction extends BaseAction implements ModelDriven<Dept> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DeptService ds = new DeptService();
	private JiangYuPageUtil<Dept> jiangYu = new JiangYuPageUtil<Dept>();
	private Dept dept = new Dept();
	
	public String findAll(){
		System.out.println("~~~~fingAll~~~~");
		Integer page = (jiangYu.getCurrentPageNo()==null?1:jiangYu.getCurrentPageNo());
		Integer pageSize = 3;
		List<Dept> list = ds.findAll(page,pageSize);
		int result = ds.getCount();
		jiangYu = JiangYuPageUtil.page("Emp", null, "dept!findAll.action", result, page, pageSize, list);
		return "found";
	}

	public String findOne(){
		System.out.println("~~~~findOne~~~~");
		dept = ds.findOne(dept.getDid());
		return "foundOne";
	}
	public String modify(){
		System.out.println("~~~~modify~~~~");
		ds.modify(dept);
		return "success";
	}
	public String toAdd(){
		System.out.println("~~~~toAdd~~~~");
		return "append";
	}
	public String add(){
		System.out.println("~~~~add~~~~");
		ds.add(dept);
		
		return "success";
	}
	public String remove(){
		System.out.println("~~~~remove~~~~");
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids = request.getParameter("ids");
		String[] ss = ids.split(",");
		for (String s : ss) {
			System.out.println(s);
			ds.remove(new Integer(s));
		}
		
		return "success";
	}
	
	public JiangYuPageUtil<Dept> getJiangYu() {
		return jiangYu;
	}

	public void setJiangYu(JiangYuPageUtil<Dept> jiangYu) {
		this.jiangYu = jiangYu;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public Dept getModel() {
		// TODO Auto-generated method stub
		return dept;
	}
	
	
	
}
