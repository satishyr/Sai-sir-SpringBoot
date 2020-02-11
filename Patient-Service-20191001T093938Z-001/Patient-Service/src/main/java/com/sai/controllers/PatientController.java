package com.sai.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.entities.Patient;
import com.sai.repositories.PatientRepository;

@RestController
public class PatientController {
	
	@Autowired
	PatientRepository patientRepository;
	
    @GetMapping("/api/v1/fetch/patients")
	public List<String> findAllPatientNames() {
		List<Patient> patientList = patientRepository.findAll();
		List<String> patientNamesList= new ArrayList<>();
		for(Patient patient : patientList) {
			patientNamesList.add(patient.getName());
		}
		System.out.println("Patient names submitted");
		return patientNamesList;
	}
	
}
