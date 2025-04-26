package com.abc.orderservice.entity;


import java.time.LocalDate;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_tbl")
public class Order {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	
	private LocalDate orderdate;
	private double orderamount;
	private String orderstatus;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderitems;
	
	
	private int customerid;


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


	public List<OrderItem> getOrderitems() {
		return orderitems;
	}


	public void setOrderitems(List<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}


	public int getCustomerid() {
		return customerid;
	}


	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}


	public Order(int orderid, LocalDate orderdate, double orderamount, String orderstatus, List<OrderItem> orderitems,
			int customerid) {
		super();
		this.orderid = orderid;
		this.orderdate = orderdate;
		this.orderamount = orderamount;
		this.orderstatus = orderstatus;
		this.orderitems = orderitems;
		this.customerid = customerid;
	}


	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}

