package com.abc.orderservice.model;

import java.time.LocalDate;

public class Mobile {
	
	private int mobileid;
	private String mobilename;
	private double price;
	private LocalDate mfd;
	private String companyname;
	public int getMobileid() {
		return mobileid;
	}
	public void setMobileid(int mobileid) {
		this.mobileid = mobileid;
	}
	public String getMobilename() {
		return mobilename;
	}
	public void setMobilename(String mobilename) {
		this.mobilename = mobilename;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getMfd() {
		return mfd;
	}
	public void setMfd(LocalDate mfd) {
		this.mfd = mfd;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public Mobile(int mobileid, String mobilename, double price, LocalDate mfd, String companyname) {
		super();
		this.mobileid = mobileid;
		this.mobilename = mobilename;
		this.price = price;
		this.mfd = mfd;
		this.companyname = companyname;
	}
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
