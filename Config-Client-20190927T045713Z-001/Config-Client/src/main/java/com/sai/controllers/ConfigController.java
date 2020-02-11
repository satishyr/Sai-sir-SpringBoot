package com.sai.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

	@Value("${myenv}")
	private String environment;
	
	@GetMapping("/fetch/env")
	public String fetchEnvironment() {
		return "Current environment:"+environment;
	}
	
}
