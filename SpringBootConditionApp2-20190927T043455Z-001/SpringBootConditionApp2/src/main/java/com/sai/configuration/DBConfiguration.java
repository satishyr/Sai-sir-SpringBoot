package com.sai.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sai.annotations.DatabaseCondition;

@Configuration
public class DBConfiguration {
	
	@Bean
	@DatabaseCondition(dbName="mongo")
	public void setupMongoDB() {
		System.out.println("In setupMongoDB()");
	}
	
	@Bean
	@DatabaseCondition(dbName="cassandra")
	public void setupCassandraDB() {
		System.out.println("In setupCassandraDB()");
	}
	
	@Bean
	@DatabaseCondition(dbName="oracle")
	public void setupOracleDB() {
		System.out.println("In setupOracleDB()");
	}

}
