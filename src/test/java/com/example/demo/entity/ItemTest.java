package com.example.demo.entity;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class ItemTest {

	Item item;
	@Before
	public void setup() {
		item = new Item();
		item.setItem_Id(1);
		item.setItem_Name("Book");
		item.setPrice(121.50);
	}
	
	@Test
	public void getCust_IdTest() {
		int id = item.getItem_Id();
		assertNotNull(id);
	}
	
	@Test
	public void getCust_NameTest() {
		String name = item.getItem_Name();	
		assertNotNull(name);
	}
	
	@Test
	public void getLocationTest() {
		double price = item.getPrice();
		assertNotNull(price);
	}
}
