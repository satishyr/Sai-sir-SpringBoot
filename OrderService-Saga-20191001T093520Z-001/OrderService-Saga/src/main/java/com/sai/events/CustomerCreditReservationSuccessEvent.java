package com.sai.events;

import com.sai.model.Order;

public class CustomerCreditReservationSuccessEvent implements DomainEvent{

	private int orderId;
	private Order order;
	
	public CustomerCreditReservationSuccessEvent() {
		
	}
	
	public CustomerCreditReservationSuccessEvent(int orderId,Order order) {
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

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	
}
