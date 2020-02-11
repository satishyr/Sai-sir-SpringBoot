package com.sai.events;

import com.sai.model.Order;

public class OrderApprovedEvent implements DomainEvent{

	private Order order;
	
	public OrderApprovedEvent() {	
	}
	
	public OrderApprovedEvent(Order order) {
		this.order = order;
	}
	
	public Order getOrder() {
		return order;
	}
}
