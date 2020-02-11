package com.sai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.entities.Item;
import com.sai.services.ItemService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@GetMapping("/api/v1/items")
	public List<Item> items() {
		Iterable<Item> iterable = itemService.fetchAll();
        Iterator<Item> iterator=iterable.iterator();
        ArrayList<Item> itemList = new ArrayList<>();
        while(iterator.hasNext()) {
        	itemList.add(iterator.next());
        }
        return itemList;
	}
	
}
