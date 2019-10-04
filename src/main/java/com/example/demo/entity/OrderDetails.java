package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class OrderDetails 
{
	@Id
	@GeneratedValue
	private int orderId;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Customer customer;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Item> item;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", customer=" + customer + ", item=" + item + "]";
	}
	
	
	
}
