package com.sai.rabbit.config;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueConfig {
	
	@Autowired
	AmqpAdmin amqpAdmin;
	
	@PostConstruct
	public void createQueues() {
		amqpAdmin.declareQueue(new Queue("CreateOrderQueue",true));
		amqpAdmin.declareQueue(new Queue("CreditApprovedQueue",true));
		amqpAdmin.declareQueue(new Queue("CreditRejectedQueue",true));
	}

}
