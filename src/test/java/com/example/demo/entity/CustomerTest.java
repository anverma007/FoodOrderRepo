package com.example.demo.entity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {

	Customer customer;
	
	@Before
	public void setup() {
		customer = new Customer();
		customer.setCust_Id(123);
		customer.setCust_Name("Alok");
		customer.setLocation("Delhi");
	}
	
	@Test
	public void getCust_IdTest() {
		int id = customer.getCust_Id();
		assertNotNull(id);
	}
	
	@Test
	public void getCust_NameTest() {
		String name = customer.getCust_Name();	
		assertNotNull(name);
	}
	
	@Test
	public void getLocationTest() {
		String loc = customer.getLocation();
		assertNotNull(loc);
	}
	
}
