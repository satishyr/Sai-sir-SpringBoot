package com.sai.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.sai.entities.Customer;

@FeignClient("CustomerService")
public interface CustomerClient {

	@GetMapping("/v1/all")
	List<Customer> fetchCustomers();
	
}
