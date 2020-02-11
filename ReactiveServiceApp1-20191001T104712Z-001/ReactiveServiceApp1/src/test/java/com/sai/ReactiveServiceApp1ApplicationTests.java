package com.sai;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReactiveServiceApp1ApplicationTests {

	@Test
	@Ignore
	public void doTest_Flux() {
		Flux<String> courseFlux=Flux.just("CoreJava","Spring","SpringBoot");
	    courseFlux.subscribe(System.out::println,t1 -> {
	    	System.out.println(t1.getMessage());
	    });
	}
	
	@Test
	@Ignore
	public void doTest_Mono() {
		Mono<String> mono=Mono.just("Hello");
		mono.subscribe(System.out::println);
	}
	
	@Test
	@Ignore
	public void doTest_FluxMethods() {
		Flux<String> courseFlux=
			 Flux.just("corejava","spring","springboot")
			     //.concatWith(Flux.error(new RuntimeException("Error encountered....!")))
			     .concatWith(Flux.just("hello"));
			     //.log();
		
		courseFlux.subscribe(System.out::println,t1 -> {
			System.out.println("Error message: "+t1.getMessage());
		}, () -> {
			System.out.println("Data stream completed");
		});
	}
	
	@Test
	@Ignore
	public void doTest_FluxMap() {
		
		ArrayList<Integer> myList = new ArrayList<>();
		
		Flux<Integer> fluxInteger = Flux.just(1,2,3,4)
				                    .map(i -> i*2)
				                    .log();
		
		fluxInteger.subscribe(myList::add);
		
		for(Integer i1:myList) {
			System.out.println(i1);
		}
	}
	
	@Test
	public void test_InternalFuncOfSubscriber() {
		Flux<Integer> fluxInteger = Flux.range(1, 100)
				                    .log();
		
		fluxInteger.subscribe(new Subscriber<Integer>() {
			
			private Subscription s;
			private int count=1;

			@Override
			public void onSubscribe(Subscription s) {
				this.s=s;
				System.out.println("In onSubscribe()......!");
				//s.request(Long.MAX_VALUE);
				s.request(2);//back pressure
			}

			@Override
			public void onNext(Integer t) {
				System.out.println("In onNext()....."+t);
				count++;
				if(count == 2) {
					s.request(2);//requesting for another 2 data chunks
					count=1;
				}
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("In onError()...."+t.getMessage());
			}

			@Override
			public void onComplete() {
			System.out.println("In onComplete().......");	
			}
			
		});
	}
	

}