package com.sai.rabbit.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.sai.events.CreditLimitExceededEvent;
import com.sai.events.CreditReservedEvent;

@Component
public class RabbitMessageReciever {
	
	@RabbitListener(queues="CreditRejectedQueue")
	public void recieveCreditExceededEvent(CreditLimitExceededEvent creditLimitExceededEvent) {
		System.out.println("Recieved creditExceededEvent...!");
	}
	
	@RabbitListener(queues="CreditApprovedQueue")
	public void recieveCreditApprovedEvent(CreditReservedEvent creditReservedEvent) {
		System.out.println("Recieved creditApprovedEvent...!");
	}
	
}
