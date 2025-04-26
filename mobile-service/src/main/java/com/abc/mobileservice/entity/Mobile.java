package com.abc.mobileservice.entity;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="mobile_tbl")
public class Mobile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mobile_id;
	private String mobile_name;
	private double price;
	private LocalDate mfd;
	private String company_name;
	
	
	public int getMobileid() {
		return mobile_id;
	}
	public void setMobileid(int mobileid) {
		this.mobile_id = mobileid;
	}
	public String getMobilename() {
		return mobile_name;
	}
	public void setMobilename(String mobilename) {
		this.mobile_name = mobilename;
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
		return company_name;
	}
	public void setCompanyname(String companyname) {
		this.company_name = companyname;
	}
	public Mobile(int mobileid, String mobilename, double price, LocalDate mfd, String companyname) {
		super();
		this.mobile_id = mobileid;
		this.mobile_name = mobilename;
		this.price = price;
		this.mfd = mfd;
		this.company_name = companyname;
	}
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}

