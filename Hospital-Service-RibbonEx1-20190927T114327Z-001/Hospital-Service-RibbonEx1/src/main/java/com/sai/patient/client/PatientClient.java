package com.sai.patient.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class PatientClient {
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<String> fetchPatientNames() {
		List<String> patientNamesList= null;
		try {
			patientNamesList=(List<String>)restTemplate.getForObject(new URI("http://Patient-Service/api/v1/fetch/patients"),List.class);
		} catch (RestClientException | URISyntaxException e) {
			e.printStackTrace();
		}
		return patientNamesList;
	}

}
