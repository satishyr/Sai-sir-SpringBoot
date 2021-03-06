package com.sai.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sai.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Integer>{

	List<Customer> findAll();
}
