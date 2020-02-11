package com.sai.events;

import com.sai.model.Order;

public class OrderCreatedEvent implements DomainEvent{
	
	private Order order;
	
	public OrderCreatedEvent() {
		
	}
	
	public OrderCreatedEvent(Order order) {
		this.order=order;
	}
	
	public Order getOrder() {
		return order;
	}

}
