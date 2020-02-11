package com.sai.controller;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;
import reactor.core.scheduler.Scheduler.Worker;

@RunWith(SpringRunner.class)
@WebFluxTest
public class ReactiveControllerTest {
	
	@Autowired
	WebTestClient webTestClient;

	@Test
	public void test() throws URISyntaxException {
		Flux<Integer> fluxInteger=webTestClient.get()
		             .uri(new URI("/flux1"))
		             .accept(MediaType.APPLICATION_STREAM_JSON)
		             .exchange()
		             .expectBody(Flux.class)
		             .returnResult().getResponseBody();
		
		StepVerifier.create(fluxInteger)
		            .expectNext(1)
		            .expectNext(2)
		            .verifyComplete();
	}

}
