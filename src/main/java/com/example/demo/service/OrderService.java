package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.OrderDetails;
import com.example.demo.exception.NullPointerServiceException;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService 
{
	
	@Autowired
	OrderRepository order_Repo;

	public void insertOrder(OrderDetails order) {
		order_Repo.save(order);
	}

	public OrderDetails findOrderList(int orderId) throws NullPointerServiceException {
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
	
}
