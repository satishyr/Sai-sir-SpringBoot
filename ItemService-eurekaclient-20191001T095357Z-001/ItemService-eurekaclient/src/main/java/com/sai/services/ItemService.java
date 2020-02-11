package com.sai.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.entities.Item;
import com.sai.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	public Iterable<Item> fetchAll() {
		return itemRepository.findAll();
	}
}
