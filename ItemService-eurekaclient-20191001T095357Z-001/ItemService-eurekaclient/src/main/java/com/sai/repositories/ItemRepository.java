package com.sai.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sai.entities.Item;

public interface ItemRepository extends CrudRepository<Item,Integer>{

}
