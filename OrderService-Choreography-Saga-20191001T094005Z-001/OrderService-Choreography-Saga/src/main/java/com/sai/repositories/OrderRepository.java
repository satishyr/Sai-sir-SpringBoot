package com.sai.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sai.entity.Order;

public interface OrderRepository extends CrudRepository<Order,Integer>{

}
