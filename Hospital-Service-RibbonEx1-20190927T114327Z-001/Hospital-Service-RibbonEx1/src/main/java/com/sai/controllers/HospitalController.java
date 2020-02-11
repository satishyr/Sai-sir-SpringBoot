package com.sai.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.sai.services.PatientService;

@RestController
public class HospitalController {
	
	@Autowired
	PatientService patientService;
    
	@GetMapping("/api/v1/hospital/fetch/patients")
	public List<String> fetchPatientNames() {
		return patientService.fetchPatientNamesList();
	}
	
	

}
