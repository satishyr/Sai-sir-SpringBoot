package com.sai.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("CartService")
public interface CartClient {

	@GetMapping("/fetch/cart/items")
	List<String> cartItems();
	
}
