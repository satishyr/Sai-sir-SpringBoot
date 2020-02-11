package com.sai.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sai.model.Order;

public interface OrderRepository extends CrudRepository<Order,Integer>{

}
