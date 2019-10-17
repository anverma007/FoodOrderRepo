package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Item;
import com.example.demo.entity.OrderDetails;
import com.example.demo.exception.CustomerRegistrationFailedException;
import com.example.demo.exception.NullPointerServiceException;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService 
{
	@Autowired
	CustomerRepo cRepo;

	@Autowired
	ItemRepository item_Repo;
	
	@Autowired
	OrderRepository order_Repo;
	
	
	public Customer insertData(Customer customer) throws CustomerRegistrationFailedException {
		try
		{
			return cRepo.save(customer);
			
		}
		catch(Exception e)
		{
			throw new CustomerRegistrationFailedException("Customer registration failed");
		}
		
	}

	public void insertItem(Item item) {
		 item_Repo.save(item);		
	}

	public void insertOrder(OrderDetails order) 
	{
		order_Repo.save(order);
	}

	public OrderDetails findOrderList(int orderId) throws NullPointerServiceException 
	{
		OrderDetails orderList=order_Repo.findByorderId(orderId);
		
		if(orderList==null)
		{
			throw new NullPointerServiceException("Order not found");
		}
		else
			return orderList;
	}

	public List<OrderDetails> findOrders() {
		List<OrderDetails> orders = order_Repo.findAll();
		return orders;
	}

	public List<Customer> findCustomers() {
		List<Customer> allCustomers = cRepo.findAll();
		return allCustomers;
	}

	public List<Item> findAllItems() {
		
		List<Item> allItems = item_Repo.findAll();
		return allItems;
	}
	
	
}
