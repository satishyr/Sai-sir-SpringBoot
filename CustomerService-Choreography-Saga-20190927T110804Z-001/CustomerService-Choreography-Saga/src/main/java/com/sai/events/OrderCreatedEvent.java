package com.sai.events;

import java.io.Serializable;

import com.sai.entities.Order;

public class OrderCreatedEvent implements Serializable{
	
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	

}
