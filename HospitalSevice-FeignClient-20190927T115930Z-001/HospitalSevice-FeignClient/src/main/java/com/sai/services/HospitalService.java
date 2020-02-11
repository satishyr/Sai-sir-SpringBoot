package com.sai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.feign.clients.PatientFeignClient;

@Service
public class HospitalService {

	@Autowired
	PatientFeignClient patientFeignClient;
	
	public List<String> fetchAllPatientNames() {
		return patientFeignClient.patientNames();
	}
	
}
