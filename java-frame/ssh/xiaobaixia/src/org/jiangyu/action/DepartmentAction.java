package org.jiangyu.action;

import java.util.List;

import org.jiangyu.pojo.Department;
import org.jiangyu.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.xiaobaixia.jiangyu.ssh3.utils.JiangYuBaseAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
@Controller
@Scope("prototype")
public class DepartmentAction extends JiangYuBaseAction implements ModelDriven<Department> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Department model = new Department();
	
	private Long parentId;
	
	@Autowired
	private DepartmentService departmentService;
	
	public String findAll(){
		System.out.println("~~findAll~~");
		
		List<Department> deptList = departmentService.findAll();
		
		ActionContext.getContext().put("deptList", deptList);
		
		return "found";
	}
	
	public String toAdd(){
		System.out.println("~~toAdd~~");
		
		List<Department> departmentList = departmentService.findAll();
		
		ActionContext.getContext().put("departmentList", departmentList);
		
		return "append";
	}
	
	public String add(){
		System.out.println("~~add~~");
		System.out.println("===="+parentId);
		if(parentId!=null){
			Department parent = departmentService.findOne(parentId);
			
			model.setParent(parent);
		}
		departmentService.add(model);
		return "success";
	}
	
	public String findOne(){
		System.out.println("~~findOne~~");
		
List<Department> departmentList = departmentService.findAll();
		
		ActionContext.getContext().put("departmentList", departmentList);
		
		Department department = departmentService.findOne(model.getId());
		
		ActionContext.getContext().getValueStack().push(department);
				
		return "foundone";
	}
	
	public String remove(){
		System.out.println("~~remove~~");
		
		departmentService.remove(model.getId());
		
		return "success";
	}
	
	public String modify(){
		System.out.println("~~modify~~");
		
		departmentService.modify(model);
		
		return "success";
	}
	
	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	
	
}
