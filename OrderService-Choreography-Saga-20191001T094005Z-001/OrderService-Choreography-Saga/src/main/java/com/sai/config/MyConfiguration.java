package com.sai.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
	
	@Bean
	public Queue orderQueue() {
		System.out.println("In orderQueue.........");
		return new Queue("OrderQueue");
	}
	
	@Bean
	public Queue creditApprovedQueue() {
		return new Queue("CreditApprovedQueue");
	}
	
	@Bean
	public Queue creditRejectedQueue() {
		return new Queue("CreditRejectedQueue");
	}
	
	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange("directExchange");
	}
	
	@Bean
	public Binding orderQueueBinding(@Qualifier("orderQueue") Queue orderQueue,DirectExchange directExchange) {
		return BindingBuilder.bind(orderQueue).to(directExchange).with("CO");
	}
	
	@Bean
	public Binding creditApprovedQueueBinding(@Qualifier("creditApprovedQueue") Queue creditApprovedQueue,DirectExchange directExchange) {
		return BindingBuilder.bind(creditApprovedQueue).to(directExchange).with("CA");
	}
	
	@Bean
	public Binding creditRejectedQueueBinding(@Qualifier("creditRejectedQueue") Queue creditRejectedQueue,DirectExchange directExchange) {
		return BindingBuilder.bind(creditRejectedQueue).to(directExchange).with("CR");
	}

}
