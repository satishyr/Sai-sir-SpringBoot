package com.sai.events;

import java.io.Serializable;

import com.sai.entities.Customer;

public class CreditLimitExceededEvent implements Serializable{
	
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
