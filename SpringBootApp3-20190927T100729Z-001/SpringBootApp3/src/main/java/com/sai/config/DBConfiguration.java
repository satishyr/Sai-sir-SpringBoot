package com.sai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.sai.condition.ProdDBCondition;
import com.sai.condition.UATDBCondition;

@Configuration
public class DBConfiguration {
	
	@Bean
	@Conditional(UATDBCondition.class)
	public void setupDBForUAT() {
		System.out.println("In setupDBForUAT()");
	}
	
	@Bean
	@Conditional(ProdDBCondition.class)
	public void setupDBForProd() {
		System.out.println("In setupDBForProd()");
	}

}
