package com.sai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.entity.Order;
import com.sai.events.OrderCreatedEvent;
import com.sai.rabbit.messaging.RabbitMessageSender;
import com.sai.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	RabbitMessageSender rabbitMessageSender;
	
	public boolean createOrder(int custid,double orderamount) {
		Order order=new Order();
		order.setId(1);//order id
		order.setAmount(orderamount);
		order.setCustid(custid);
		order.setState("P");//Pending state
		
		//ToDo: To implement database call for order creation
		
		OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent();
		orderCreatedEvent.setOrder(order);
		
		//Here we published ordercreated event to messagebroker
		rabbitMessageSender.publishCreateOrderEvent(orderCreatedEvent);
		
		return true;
	}

}
