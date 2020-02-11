package com.sai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.sai.fallback.providers.MyFallbackProvider;
import com.sai.zuul.filters.ServiceResponseFilter;

@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayZuulApplication.class, args);
	}
	
	@Bean
	public MyFallbackProvider fallbackProvider() {
		return new MyFallbackProvider();
	}
	
	@Bean
	public ServiceResponseFilter serviceResponseFilter() {
		return new ServiceResponseFilter();
	}

}
