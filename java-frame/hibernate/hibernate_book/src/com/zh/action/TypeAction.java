package com.zh.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.zh.dao.CheckDao;
import com.zh.po.Type;
import com.zh.service.TypeService;
import com.zh.utils.PageBean;

public class TypeAction extends ActionSupport implements ModelDriven<Type> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8515276615234994583L;
	
	private Type type = new Type();
	private PageBean<Type> pagebean;
	private CheckDao check = new CheckDao();
	private TypeService service = new TypeService();
	
	/**
	 * 功能：展示列表
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public String list(){
		
		String pages = ServletActionContext.getRequest().getParameter("page");
		
		int page =1;int pageSize = 3;
		
		if(pages != null && !"".equals(pages.trim()))
			page = Integer.parseInt(pages);
		
		pagebean = service.getList(page, pageSize);
		
		return "list";		
	}
	
	/**
	 * 功能：跳转到添加页面
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public String toAdd(){
		
		return "add";
	}
	
	/**
	 * 功能：添加数据
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public String add(){
		
		System.out.println("=========="+type);
		
		service.insert(type);
		
		return list();
	}
	
	/**
	 * 功能：跳转到更新页面
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public String toUpdate(){
				
		System.out.println("-----------------------------进入toUpdate-----------------------------");
		
		String id = ServletActionContext.getRequest().getParameter("oid");
		
		Type type2 = service.getObject(id);
		
		try {
			BeanUtils.copyProperties(type, type2);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		System.out.println("-----------------------------toupdate结束-----------------------------");
		
		return "update";
	}
	
	/**
	 * 功能：更新数据
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public String update(){
		
		System.out.println("-----------------------------进入Update-----------------------------");
		
		System.out.println(type);
		
		service.update(type);
		
		System.out.println("-----------------------------Update结束-----------------------------");
		
		return list();
	}
	
	/**
	 * 功能：删除/批量删除
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public String delete(){
		
		String ids = ServletActionContext.getRequest().getParameter("oid");
		
		service.delAll(ids);
		
		return list();
	}
	
	/**
	 * 功能：检查名称是否重复
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public void checkName() throws IOException{
		
		System.out.println("---------------进入checkName-----------------");
		
		int id = type.getId()!=null?type.getId():-1;
		String name = type.getName();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		if(name != null && !"".equals(name.trim())){
			
			if(name.matches("\\w{3,8}")){
				if(check.checkName(id,name))
					writer.write("类型已存在!");
				else
					writer.write("");
			}else{
				writer.write("类型名称应为3-8位!");
			}
			
		}else{
			writer.write("类型名称不能为空!");
		}			
		
		writer.flush();
		writer.close();
	}
	
	
	
	
	public PageBean<Type> getPagebean() {
		return pagebean;
	}

	public void setPagebean(PageBean<Type> pagebean) {
		this.pagebean = pagebean;
	}
	public Type getModel() {
		return type;
	}

	
}
