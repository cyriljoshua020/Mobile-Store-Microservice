package com.abc.orderservice.model;

import java.time.LocalDate;
import java.util.List;

public class Invoice {
	
	private int orderid;
	private LocalDate orderdate;
	private double orderamount;
	private String orderstatus;
	
	private List<OrderItemModel> orderitems;
	
	private Customer customer;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public LocalDate getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}

	public double getOrderamount() {
		return orderamount;
	}

	public void setOrderamount(double orderamount) {
		this.orderamount = orderamount;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public List<OrderItemModel> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(List<OrderItemModel> orderitems) {
		this.orderitems = orderitems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Invoice(int orderid, LocalDate orderdate, double orderamount, String orderstatus,
			List<OrderItemModel> orderitems, Customer customer) {
		super();
		this.orderid = orderid;
		this.orderdate = orderdate;
		this.orderamount = orderamount;
		this.orderstatus = orderstatus;
		this.orderitems = orderitems;
		this.customer = customer;
	}

	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
