package com.sai.rabbit.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sai.entities.Customer;
import com.sai.events.CreditReservedEvent;
import com.sai.events.OrderCreatedEvent;

@Component
public class RabbitMessageReciever {
	
	@Autowired
	RabbitMessageSender rabbitMessageSender;
	
	@RabbitListener(queues="CreateOrderQueue")
	public void recieveOrderCreatedEvent(OrderCreatedEvent orderCreatedEvent) {
		System.out.println("Recieved ordercreatedevent....!");
		 
		CreditReservedEvent creditReservedEvent = new CreditReservedEvent();
		creditReservedEvent.setCustomer(new Customer());//dummy
		    
		  //Published creditapprovedevent to messagebroker
	    rabbitMessageSender.publishCreateConsumerCreditApprovedEvent(creditReservedEvent);
		   
	}
	
}
