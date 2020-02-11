package com.sai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.patient.client.PatientClient;

@Service
public class PatientService {

	@Autowired
	PatientClient patientClient;
	
	public List<String> fetchPatientNamesList() {
		return patientClient.fetchPatientNames();
	}
	
}
