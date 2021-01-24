package com.javasky.stock.order.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {

	private String id;
	private Date orderDate;
	private String orderNo;
	private Integer flag;

	private String orderDateString;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getOrderDateString() {
		return orderDateString;
	}

	public void setOrderDateString(String orderDateString) {
		try {
			this.orderDate = new SimpleDateFormat("yyyy-MM-dd").parse(orderDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.orderDateString = orderDateString;
	}

}
