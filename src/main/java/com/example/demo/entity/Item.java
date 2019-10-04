package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item 
{
	@Id
	@GeneratedValue
	private int item_Id;
	private String item_Name;
	private double price;
	
	public int getItem_Id() {
		return item_Id;
	}
	public void setItem_Id(int item_Id) {
		this.item_Id = item_Id;
	}
	public String getItem_Name() {
		return item_Name;
	} 
	public void setItem_Name(String item_Name) {
		this.item_Name = item_Name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
