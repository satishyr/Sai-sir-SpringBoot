package com.sai.feign.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("PATIENTSERVICE")
public interface PatientFeignClient {
	
	@GetMapping("/api/v1/fetch/patients")
	List<String> patientNames();

}
