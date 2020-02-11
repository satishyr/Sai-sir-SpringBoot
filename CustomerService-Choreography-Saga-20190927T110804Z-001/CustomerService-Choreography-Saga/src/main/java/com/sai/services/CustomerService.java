package com.sai.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.entities.Customer;
import com.sai.events.CreditReservedEvent;
import com.sai.rabbit.messaging.RabbitMessageSender;
import com.sai.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	RabbitMessageSender rabbitMessageSender;
	
	public Customer fetchCustomerDetailsByID(int custid) {
		Optional<Customer> customer=customerRepository.findById(custid);
//	    if(customer.isPresent()) {
//	    Customer cust = customer.get();
//	    //ToDo: To implement database logic
//	    } else {
//	    return null;//no customer matched for given id 	
//	    }
		return customer.get();
	}

}
