package com.abc.consumer.model;

public class Order {
	
	private int orderid;
	private double orderamount;
	private String customername;
	private String email;
	private String mobile;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public double getOrderamount() {
		return orderamount;
	}
	public void setOrderamount(double orderamount) {
		this.orderamount = orderamount;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Order(int orderid, double orderamount, String customername, String email, String mobile) {
		super();
		this.orderid = orderid;
		this.orderamount = orderamount;
		this.customername = customername;
		this.email = email;
		this.mobile = mobile;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}

