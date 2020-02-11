package com.sai.controller;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sai.model.Movie;
import com.sai.repository.MovieRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MovieController {
	
	@Autowired
	MovieRepository movieRepository;
	
	Movie mymovie;
	
	@GetMapping("/fetch")
	public Flux<Movie> fetchAllMovies() {
		return movieRepository.findAll()
				               .log();//db.movie.find({})
	}
	
	
	@PostMapping("/save")
	public Mono<String> addMovie(@RequestBody Movie movie) {
		Mono<Movie> mono= movieRepository.save(movie);
		return mono.filter(t1 -> t1 != null)
				   .thenReturn("Movie Created");		
	}

}
