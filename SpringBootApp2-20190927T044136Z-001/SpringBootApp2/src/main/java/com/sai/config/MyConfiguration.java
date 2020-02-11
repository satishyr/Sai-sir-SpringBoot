package com.sai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MyConfiguration {
	
	@Bean
	@Profile("uat")
	public void loadConfigurationForUAT() {
		System.out.println("In loadConfigurationForUAT()");
	}
	
	@Bean
	@Profile("qa")
	public void loadConfigurationForQA() {
		System.out.println("In loadConfigurationForQA()");
	}

}
