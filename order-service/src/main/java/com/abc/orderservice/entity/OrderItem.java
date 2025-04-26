package com.abc.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderitem_tbl")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderitemid;
	
	private int mobileid;
	private int qty;
	private double itemtotal;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "orderid")
	private Order order;

	public int getOrderitemid() {
		return orderitemid;
	}

	public void setOrderitemid(int orderitemid) {
		this.orderitemid = orderitemid;
	}

	public int getMobileid() {
		return mobileid;
	}

	public void setMobileid(int mobileid) {
		this.mobileid = mobileid;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderItem(int orderitemid, int mobileid, int qty, double itemtotal, Order order) {
		super();
		this.orderitemid = orderitemid;
		this.mobileid = mobileid;
		this.qty = qty;
		this.itemtotal = itemtotal;
		this.order = order;
	}

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}

