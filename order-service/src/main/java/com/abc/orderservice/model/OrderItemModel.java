package com.abc.orderservice.model;

public class OrderItemModel {
	
	private int itemid;
	private Mobile mobile;
	private int qty;
	private double itemtotal;
	
	
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public Mobile getMobile() {
		return mobile;
	}
	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getItemtotal() {
		return itemtotal;
	}
	public void setItemtotal(double itemtotal) {
		this.itemtotal = itemtotal;
	}
	public OrderItemModel(int itemid, Mobile mobile, int qty, double itemtotal) {
		super();
		this.itemid = itemid;
		this.mobile = mobile;
		this.qty = qty;
		this.itemtotal = itemtotal;
	}
	public OrderItemModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
