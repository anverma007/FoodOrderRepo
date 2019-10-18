package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.exception.CustomerRegistrationFailedException;
import com.example.demo.repository.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	CustomerRepo customerRepo;
	
	public List<Customer> findAllCustomers() {
	
		List<Customer> customersList = customerRepo.findAll();
		
		return customersList;
	}

	public Customer insertData(Customer customer) throws CustomerRegistrationFailedException {
		try{
			return customerRepo.save(customer);			
		}
		catch(Exception e){
			throw new CustomerRegistrationFailedException("Customer registration failed");
		}
		
	}

}
