package com.sai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages="com.sai.feign.clients")
public class HospitalSeviceFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalSeviceFeignClientApplication.class, args);
	}

}
