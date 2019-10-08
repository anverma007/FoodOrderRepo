package com.example.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.FoodOrderApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= FoodOrderApplication.class)
@SpringBootTest
@FixMethodOrder
public class ControllerOrderTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setup()
	{
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void registerCustomerTest() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.post("/storeCustomer").contentType(MediaType.APPLICATION_JSON)
				.content("{\"cust_Name\" : \"Alok\", \"location\" : \"Bangalore\" }")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.cust_Id").exists())
				.andExpect(jsonPath("$.cust_Name").exists())
				.andExpect(jsonPath("$.location").exists())
				.andExpect(jsonPath("$.cust_Name").value("Alok"))
				.andExpect(jsonPath("$.location").value("Bangalore")).andDo(print());
	}
	@Test
	public void saveItemTest() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.post("/storeItem").contentType(MediaType.APPLICATION_JSON)
				.content("{\"item_Name\":\"Parotha\", \"price\":\"15\"}")
				.accept(MediaType.APPLICATION_JSON));
				
	}
	
}


























