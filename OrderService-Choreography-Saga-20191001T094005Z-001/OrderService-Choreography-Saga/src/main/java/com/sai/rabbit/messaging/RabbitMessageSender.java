package com.sai.rabbit.messaging;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sai.events.OrderCreatedEvent;

@Component
public class RabbitMessageSender {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	public void publishCreateOrderEvent(OrderCreatedEvent orderCreatedEvent) {
		rabbitTemplate.convertAndSend("directExchange", "CO",orderCreatedEvent);
		System.out.println("OrderEventCreated......!");
	}

}
