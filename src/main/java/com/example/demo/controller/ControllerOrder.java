package com.example.demo.controller;

import java.util.InputMismatchException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DTOFoodOrder;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Item;
import com.example.demo.entity.OrderDetails;
import com.example.demo.exception.CustomerRegistrationFailedException;
import com.example.demo.exception.NullPointerServiceException;
import com.example.demo.service.OrderService;

@RestController
public class ControllerOrder 
{
	@Autowired
	OrderService service;
	
	DTOFoodOrder dto=new DTOFoodOrder();
	
	
	@GetMapping("/show")
	public String show()
	{
		return "Hello";
	}
	
	@PostMapping("/storeCustomer")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer)
	{
		Customer c=null;
		try {
			c=service.insertData(customer);			
		} 
		catch (CustomerRegistrationFailedException e) 
		{
			System.out.println(e); 
		}	
		return new ResponseEntity<Customer>(c, HttpStatus.OK);
	}
	
	@PostMapping("/storeItem")
	public ResponseEntity<String> saveItem(@RequestBody Item item) 
	{
		service.insertItem(item);
		return new ResponseEntity<String>("Item is inserted", HttpStatus.OK);
	}
	
	@PostMapping("/takeOrder")
	public String placeOrder(@RequestBody OrderDetails order)
	{
		service.insertOrder(order);
		
		return "Order Details are stored";		 
	}
	@GetMapping("/all-orders")
	public ResponseEntity<List<OrderDetails>> findAllOrders(){
		List<OrderDetails> orderDetails = service.findOrders();
		
		return new ResponseEntity<List<OrderDetails>>(orderDetails, HttpStatus.OK);
	}
	
	
	@GetMapping("/orderById/{orderId}")
	public ResponseEntity<DTOFoodOrder> orderList(@PathVariable("orderId") int orderId)
	{
		OrderDetails orderList;
		try {
			orderList = service.findOrderList(orderId);
			if(orderList!=null)
			{
				dto.setOrderDetails(orderList);
				dto.setError(false);
				dto.setStatus(String.valueOf(HttpStatus.OK));
				dto.setMessage("Order detail is available");
				dto.setSuccess(true);
				System.out.println(dto);
				 return new ResponseEntity<DTOFoodOrder>(dto, HttpStatus.OK);
			}
			else
			{
				
				dto.setError(false);
				dto.setStatus(String.valueOf(HttpStatus.BAD_REQUEST));
				dto.setMessage("Wrong order id.	");
				dto.setSuccess(true);
				System.out.println(dto);
				return new ResponseEntity<DTOFoodOrder>(dto, HttpStatus.OK);	
			}			
		}
		catch (NullPointerServiceException e) 
		{
			dto.setOrderDetails(null);
			dto.setError(true);
			dto.setMessage("Order-Id does not exist.");
			dto.setSuccess(false);
			System.out.println(dto);
			 return new ResponseEntity<DTOFoodOrder>(dto, HttpStatus.OK);
		}	
		catch(InputMismatchException e)
		{
			dto.setOrderDetails(null);
			dto.setError(true);
			dto.setMessage("Please enter correct order-Id");
			dto.setSuccess(false);
			System.out.println(dto);
			 return new ResponseEntity<DTOFoodOrder>(dto, HttpStatus.OK);	
		}
		
	}
	@GetMapping("/all-customers")
	public ResponseEntity<List<Customer>> findAllCustomers(){
		List<Customer> allCustomers = service.findCustomers();
		
		return new ResponseEntity<List<Customer>>(allCustomers, HttpStatus.OK);
	}
	
	@GetMapping("/all-items")
	public ResponseEntity<List<Item>> findAllItems(){
		
		List<Item> allItems = service.findAllItems();
		
		return new ResponseEntity<List<Item>>(allItems, HttpStatus.OK);
	}
	
}
