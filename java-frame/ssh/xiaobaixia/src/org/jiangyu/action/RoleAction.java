package org.jiangyu.action;

import java.util.List;

import org.jiangyu.pojo.Role;
import org.jiangyu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.xiaobaixia.jiangyu.ssh3.utils.JiangYuBaseAction;








import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends JiangYuBaseAction implements ModelDriven<Role> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Autowired
	private RoleService roleService ;

	private Role model = new Role();

	@Override
	public Role getModel() {
		return model;
	}

	public String findAll(){
		System.out.println("~~findAll~~");
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "found";
	}
	
	public String toAdd(){
		
		return "toadd";
		
	}
	
	public String add(){
		System.out.println("~~add~~");
		roleService.add(model);
		return "success";
		
	}
	
	public String findOne(){
		System.out.println("~~add~~");
		Role role = roleService.findOne(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "foundone";
		
	}
	
	public String remove(){
		System.out.println("~~remove~~");
		Role role = roleService.findOne(model.getId());
		roleService.remove(role);
		return "success";
		
	}
	
	public String modify(){
		System.out.println("~~modify~~");
		roleService.modify(model);
		return "success";
		
	}
	
	
	
}
