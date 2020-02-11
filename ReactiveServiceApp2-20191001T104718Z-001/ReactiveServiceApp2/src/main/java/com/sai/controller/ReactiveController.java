package com.sai.controller;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class ReactiveController {
	
    @RequestMapping(path="/flux1",produces=MediaType.APPLICATION_STREAM_JSON_VALUE,method=RequestMethod.GET)
	public Flux<Integer> fetchFluxIntegerValues() {
		return Flux.range(1,50)
				   //.delayElements(Duration.ofSeconds(1))
				   .log();
	}

}
