package com.sai.custom.actutor.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="customEndPoint",enableByDefault=true)
public class MyCustomEndPoint {

	@ReadOperation(produces= {MediaType.TEXT_HTML_VALUE})
	public String returnResponse() {
		return "Hello from MyCustomEndPoint";
	}
	
	@ReadOperation
	public Greeting greeting() {
		Greeting greeting = new Greeting();
		greeting.message = "Hello.......!";
		return greeting;
	}
	
	
	class Greeting {
		String message;
	}
}
