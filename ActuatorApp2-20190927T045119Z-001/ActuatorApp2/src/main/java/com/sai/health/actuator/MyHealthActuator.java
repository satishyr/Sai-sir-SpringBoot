package com.sai.health.actuator;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MyHealthActuator implements HealthIndicator {
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public Health health() {
		String responseData=null;
		try {
		responseData=restTemplate.getForObject(new URI("http://localhost:8080/hello"),String.class);
		return Health.up().withDetail("Response",responseData).build();
		}catch(Exception e1) {
		return Health.down(e1).build();
		}
	}

}
