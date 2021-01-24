package com.bwie.generic;

import java.util.ArrayList;
import java.util.List;

/*
 *  T : type
 *  E : element
 *  K : key 
 *  V : value
 */
public class Order<T> {

	private int orderId ;
	
	private String orderName ;
	
	private T t ;
	
	private List<T> list = new ArrayList<T>();
	
	public void add()
	{
		list.add(t);
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	
	
}

