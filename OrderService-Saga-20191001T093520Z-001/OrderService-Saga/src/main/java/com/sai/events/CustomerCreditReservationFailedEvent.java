package com.sai.events;

import com.sai.model.Order;

public class CustomerCreditReservationFailedEvent implements DomainEvent{

	private int orderId;
	private Order order;
	
	public CustomerCreditReservationFailedEvent() {
		
	}
	
	public CustomerCreditReservationFailedEvent(int orderId,Order order) {
		this.orderId = orderId;
		this.order = order;
	}
	
	public Order getOrder() {
		return order;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	
	
}
