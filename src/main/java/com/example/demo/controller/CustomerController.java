package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.exception.CustomerRegistrationFailedException;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/")
	public String fromCustomer() {
		return "Hello, Welcome to FoodOrder (From Customer)";
	}
	
	@PostMapping("/storeCustomer")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) throws CustomerRegistrationFailedException
	{
		Customer c=null;
		c=customerService.insertData(customer);	
		return new ResponseEntity<Customer>(c, HttpStatus.OK);
	}
	
	
	@GetMapping("/all-customers")
	public ResponseEntity<List<Customer>> findAllCustomers(){
		
		List<Customer> allCustomers = customerService.findAllCustomers();
		
		return new ResponseEntity<List<Customer>>(allCustomers, HttpStatus.OK);
	}
}
