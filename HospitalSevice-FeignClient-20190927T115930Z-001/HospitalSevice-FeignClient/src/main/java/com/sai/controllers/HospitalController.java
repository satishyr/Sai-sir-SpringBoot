package com.sai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.services.HospitalService;

@RestController
public class HospitalController {

	@Autowired
	HospitalService hospitalService;
	
	@GetMapping("/all/patient/names")
	public List<String> patientNames() {
		return hospitalService.fetchAllPatientNames();
	}
	
}
