package com.javasky.stock.order.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.javasky.stock.order.pojo.Order;
import com.javasky.stock.order.service.OrderService;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Order> list = new ArrayList<Order>();
	private Order order = new Order();

	public String query() {

		OrderService service = new OrderService();
		
		list = service.query();
		
		return SUCCESS;
	}
	
	public String saveOrder(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String[] materIds = request.getParameterValues("materId");
		String[] counts = request.getParameterValues("count");
		
		OrderService service = new OrderService();
		service.saveOrder(order, materIds, counts);
		
		return "updateInfo";
	}
	
	
	
	public List<Order> getList() {
		return list;
	}

	public void setList(List<Order> list) {
		this.list = list;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
