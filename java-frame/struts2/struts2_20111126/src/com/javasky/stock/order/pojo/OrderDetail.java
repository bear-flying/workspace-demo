package com.javasky.stock.order.pojo;
//订单明细
public class OrderDetail {

	private String id;

	/**
	 * 原料ID
	 */
	private String materId;

	/**
	 * 订单ID
	 */
	private String orderId;
	
	
	private String materName;// 为了传输原料数据 add by daniel 2011/11/26
	
	private Double count;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMaterId() {
		return materId;
	}

	public void setMaterId(String materId) {
		this.materId = materId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Double getCount() {
		return count;
	}

	public void setCount(Double count) {
		this.count = count;
	}

	public String getMaterName() {
		return materName;
	}

	public void setMaterName(String materName) {
		this.materName = materName;
	}

}
