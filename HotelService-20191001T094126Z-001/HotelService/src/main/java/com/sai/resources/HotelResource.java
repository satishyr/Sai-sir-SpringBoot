package com.sai.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.client.CustomerClient;
import com.sai.entities.Customer;

@RestController
public class HotelResource {
	
	@Autowired
	CustomerClient customerClient;
	
	@GetMapping("/v1/fetch/all")
	public List<String> fetchCustomersName() {
		List<Customer> customerList = customerClient.fetchCustomers();
		List<String> customerNamesList = new ArrayList<>();
		for(Customer cust : customerList) {
			customerNamesList.add(cust.getName());
		}
		return customerNamesList;
	}

}
