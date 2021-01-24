package com.zh.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zh.dao.CheckDao;
import com.zh.po.Book;
import com.zh.po.Type;
import com.zh.service.BookService;
import com.zh.utils.PageBean;

public class BookAction extends ActionSupport implements ModelDriven<Book> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6425174539574402213L;
	
	private Book book = new Book();
	private List<Type> list;
	private PageBean<Book> pagebean;
	private CheckDao check = new CheckDao();
	private BookService service = new BookService();
	
	/**
	 * 功能：展示列表
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public String list(){
		
		System.out.println("-----------------------------进入List-----------------------------");
		
		String pages = ServletActionContext.getRequest().getParameter("page");
		
		int page =1;int pageSize = 3;
		
		System.out.println(pages);
		
		if(pages != null && !"".equals(pages.trim()))
			page = Integer.parseInt(pages);
		
		pagebean = service.getList(page, pageSize);
		
		System.out.println("-----------------------------List结束-----------------------------");
		
		return "list";		
	}
	
	/**
	 * 功能：跳转到添加页面
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public String toAdd(){
		
		list = service.getTypes();
		
		return "add";
	}
	
	/**
	 * 功能：添加数据
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public String add(){
		
		System.out.println("OOOO"+book);
		
		service.insert(book);
		
		return list();
	}
	
	/**
	 * 功能：跳转到更新页面
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public String toUpdate(){
		
		String id = ServletActionContext.getRequest().getParameter("oid");
		
		list = service.getTypes();
		
		Book book2 = service.getObject(id);
		try {
			BeanUtils.copyProperties(book, book2);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return "update";
	}
	
	/**
	 * 功能：更新数据
	 * 作者：张强
	 * 日期：2015-9-22
	 * @user lenovo	
	 */
	public String update(){
		
		service.update(book);
		
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
		
		int id = book.getId()!=null?book.getId():-1;
		String name = book.getName();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		if(name != null && !"".equals(name.trim())){
			
			if(name.matches("\\w{3,8}")){
				if(check.checkName(id,name))
					writer.write("图书已存在!");
				else
					writer.write("");
			}else{
				writer.write("图书名称应为3-8位!");
			}
			
		}else{
			writer.write("图书名称不能为空!");
		}			
		
		writer.flush();
		writer.close();
	}
	
	/**
	 * 功能：检查价格是否为数字
	 * 作者：张强
	 * 日期：2015-9-22
	 * @throws IOException 
	 * @user lenovo	
	 */
	public void checkPrice() throws IOException{
		
		System.out.println("---------------进入checkPrice---------------");
		
		String price = ServletActionContext.getRequest().getParameter("prices");
		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter writer = response.getWriter();
		
		System.out.println(price);
		
		if(price != null && !"".equals(price.trim())){
			if(!price.matches("\\d+(.\\d+)?")){
				writer.write("价格格式不正确!");
			}
				
		}else{
			writer.write("价格不能为空!");
		}
			
		
		writer.flush();writer.close();
	}
	
	
	public List<Type> getList() {
		return list;
	}

	public void setList(List<Type> list) {
		this.list = list;
	}

	public PageBean<Book> getPagebean() {
		return pagebean;
	}

	public void setPagebean(PageBean<Book> pagebean) {
		this.pagebean = pagebean;
	}

	public Book getModel() {
		return book;
	}
	
	
}
