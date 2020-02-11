package com.sai.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.client.CartClient;

@RestController
public class OrderResource {
	
	@Autowired
	CartClient cartClient;

	@GetMapping("/items")
	public List<String> fetchCartItems() {
		return cartClient.cartItems();
	}
	
	
}
