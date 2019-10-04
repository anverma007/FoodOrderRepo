package com.example.demo.dto;

import com.example.demo.entity.OrderDetails;

public class DTOFoodOrder
{
	private OrderDetails orderDetails;
	private String status;
	private boolean error;
	private boolean success;
	private String message;
		
	public DTOFoodOrder() {
		super();
	}
	
	
	public DTOFoodOrder(OrderDetails orderDetails, String status, boolean error, boolean success, String message) {
		super();
		this.orderDetails = orderDetails;
		this.status = status;
		this.error = error;
		this.success = success;
		this.message = message;
	}


	public OrderDetails getOrderDetails() {
		return orderDetails;
	}


	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
