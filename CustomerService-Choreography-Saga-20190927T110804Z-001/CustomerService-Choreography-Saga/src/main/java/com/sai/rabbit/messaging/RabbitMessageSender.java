package com.sai.rabbit.messaging;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sai.events.CreditLimitExceededEvent;
import com.sai.events.CreditReservedEvent;
import com.sai.events.OrderCreatedEvent;

@Component
public class RabbitMessageSender {
	
	@Autowired
	AmqpTemplate amqpTemplate;
	
	public void publishCreateConsumerCreditApprovedEvent(CreditReservedEvent creditReservedEvent) {
		amqpTemplate.convertAndSend("CreditApprovedQueue",creditReservedEvent);
		System.out.println("CreditReservedEventCreated......!");
	}
	
	public void publishCreateConsumerCreditExceededEvent(CreditLimitExceededEvent creditLimitExceededEvent) {
		amqpTemplate.convertAndSend("CreditRejectedQueue",creditLimitExceededEvent);
		System.out.println("CreditLimitExceededEventCreated......!");
	}

}
