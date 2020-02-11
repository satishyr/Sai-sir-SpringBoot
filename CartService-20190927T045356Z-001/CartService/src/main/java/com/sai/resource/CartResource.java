package com.sai.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartResource {

	private ArrayList<String> cartItemList=new ArrayList<>();
	
	public CartResource() {
		cartItemList.add("item1");
		cartItemList.add("item2");
		cartItemList.add("item3");
	}
	
	@GetMapping("/fetch/cart/items")
	public List<String> fetchCartItems() {
		return cartItemList;
	}
	
}
