package com.example.demo.entity;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class OrderDetailsTest {

	OrderDetails orderDetails;
	
	@Before
	public void setup() {
		orderDetails = new OrderDetails();
		orderDetails.setOrderId(1);
		Item e = new Item();
		List<Item> itemList = new ArrayList<>();
		itemList.add(e);
		orderDetails.setItem(itemList);
		
		Customer customer = new Customer();
		customer.setCust_Name("Alok");
		orderDetails.setCustomer(customer);
		
	}
	
	
	@Test
	public void getOrderIdTest() {
		int id = orderDetails.getOrderId();
		assertNotNull(id);
	}
	
	@Test
	public void getItemTest() {
		List<Item> itemList = orderDetails.getItem();
		assertNotNull(itemList);
	}

	@Test
	public void getCustomerTest() {
		Customer cust = orderDetails.getCustomer();
		assertNotNull(cust);
	}


}
