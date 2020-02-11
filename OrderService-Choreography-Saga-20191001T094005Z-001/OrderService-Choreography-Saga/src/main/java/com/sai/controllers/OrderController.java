package com.sai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sai.services.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/create/order")
	public String createOrder(@RequestParam(name="custid") int id,@RequestParam(name="orderamt") double orderamount) {
		boolean order_status=orderService.createOrder(id,orderamount);
		return order_status == true ? "Order Created" : "Fail to create order"; 
	}

}
