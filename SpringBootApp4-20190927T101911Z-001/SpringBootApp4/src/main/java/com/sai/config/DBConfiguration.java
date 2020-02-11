package com.sai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sai.custom.conditional.DBCondition;

@Configuration
public class DBConfiguration {
	
	@Bean
	@DBCondition(dbType="UAT")
	public void setupDBForUAT() {
		System.out.println("In setupDBForUAT()");
	}
	
	@Bean
	@DBCondition(dbType="PROD")
	public void setupDBForProd() {
		System.out.println("In setupDBForProd()");
	}

}
