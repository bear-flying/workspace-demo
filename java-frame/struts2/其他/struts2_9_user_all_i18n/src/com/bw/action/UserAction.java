package com.bw.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;

import com.bw.entity.User;
import com.bw.model.UserModel;
import com.bw.service.UserService;
import com.bw.utils.ToolPage;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

	private UserModel userModel;
	
	private List list;
	
	private UserService service = new UserService();
	
	
	/**
	 * 功能：添加的国际化
	 * 作者：sdw
	 * 时间：2015-3-23
	 */
	public String change() throws Exception {
	     
		return "toAdd";
	  }  
	
	
	
	/**
	 * 功能：到添加页面
	 * 作者：sdw
	 * 时间：2015-3-23
	 */
	public String toAdd() throws Exception {
		System.out.println("-------UserAction----toAdd------");
		
		
		
		return "toAdd";
	}
	
	/**
	 * 功能：添加
	 * 作者：sdw
	 * 时间：2015-3-23
	 */
	public String add() throws Exception {
		System.out.println("-------UserAction----add------");
		
		//收集数据
		//爱号
		String[] h = userModel.getHobby();
		String hobby = "";
		for (String string : h) {
			hobby += string+",";
		}
		hobby = hobby.substring(0,hobby.length()-1);
		
		//装载数据
		User user = new User();
		BeanUtils.copyProperties(user, userModel);
		user.setHobby(hobby);
		//System.out.println("hobby="+user.getHobby());
		
		
		//调用业务
		service.add(user);
		//跳转
		return SUCCESS;
	}
	
	/**
	 * 功能：列表
	 * 作者：sdw
	 * 时间：2015-3-23
	 */
	public String list() throws Exception {
		System.out.println("-------UserAction----list------");
		int pageSize = 5;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String page = request.getParameter("currentPage")!=null?request.getParameter("currentPage"):"0";
		Integer currentPage = Integer.parseInt(page);
		list = service.getListPage(currentPage, pageSize);
		
		String url = "user!list.action";
		
		int listCount = service.getListCount();
		ToolPage.page(request, currentPage, pageSize, url, listCount, list);
		
		return "list";
	}
	
	/**
	 * 功能：删除
	 * 作者：sdw
	 * 时间：2015-3-23
	 */
	public String deletea() throws Exception {
		System.out.println("-------UserAction----deletea------");
		//获取id
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		System.out.println("id_del="+id);
		
		//业务
		service.delete(id);
		
		return SUCCESS;
	}
	
	/**
	 * 功能：删除
	 * 作者：sdw
	 * 时间：2015-3-23
	 */
	public String toUpdate() throws Exception {
		System.out.println("-------UserAction----toUpdate------");
		//获取id
		Integer id = userModel.getId();
		System.out.println("id_update="+id);
		
		//业务
		User user = service.getUserById(id);
		
		//装作用域userModel
		BeanUtils.copyProperties(userModel, user);
		
		
		return "toUpdate";
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	
	
	
	
	
	
	
}
