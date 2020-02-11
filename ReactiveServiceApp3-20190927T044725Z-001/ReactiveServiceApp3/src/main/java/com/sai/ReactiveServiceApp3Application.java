package com.sai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class ReactiveServiceApp3Application {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveServiceApp3Application.class, args);
	}

}
