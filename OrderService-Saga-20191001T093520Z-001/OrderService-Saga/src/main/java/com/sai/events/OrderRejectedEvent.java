package com.sai.events;

import com.sai.model.Order;

public class OrderRejectedEvent implements DomainEvent{

	private Order order;
	
	public OrderRejectedEvent() {
		
	}
	
	public OrderRejectedEvent(Order order) {
		this.order = order;
	}
	
	public Order getOrder() {
		return order;
	}
	
}
