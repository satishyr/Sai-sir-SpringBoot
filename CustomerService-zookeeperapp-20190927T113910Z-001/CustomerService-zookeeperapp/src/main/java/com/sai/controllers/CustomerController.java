package com.sai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.entities.Customer;
import com.sai.repositories.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/v1/all")
	public List<Customer> all() {
		return customerRepository.findAll();
	}
	
}
