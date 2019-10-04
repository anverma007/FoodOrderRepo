package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer 
{
	@Id
	@GeneratedValue
	private int cust_Id;
	
	private String cust_Name;
	private String location;
	 
	public int getCust_Id() {
		return cust_Id;
	}
	public void setCust_Id(int cust_Id) {
		this.cust_Id = cust_Id;
	}
	public String getCust_Name() {
		return cust_Name;
	}
	public void setCust_Name(String cust_Name) {
		this.cust_Name = cust_Name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
