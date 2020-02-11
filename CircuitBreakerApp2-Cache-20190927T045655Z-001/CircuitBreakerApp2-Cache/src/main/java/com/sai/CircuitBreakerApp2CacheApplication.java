package com.sai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableHystrix
@EnableCaching
public class CircuitBreakerApp2CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuitBreakerApp2CacheApplication.class, args);
	}
	
	@Bean
	CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("movie");
	}

}
