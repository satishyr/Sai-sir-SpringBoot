package com.sai.resources;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sai.entities.Movie;
import com.sai.repositories.MovieRepository;

@RestController
public class MovieResource {
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	CacheManager cacheManager;

	@GetMapping("/fetch/movie")
	@HystrixCommand(fallbackMethod="fetchMovieDetailsByTitle_FallBack")
	@CachePut("movie")
	public String fetchMovieDetailsByTitle(@RequestParam("title") String title) {
		Movie movie = movieRepository.findByTitle(title);
		if( movie != null) {
			return movie.getReleaseDate()+" , "+movie.getDuration();
		} else {
			return "Details not matched....!";
		}
	}
	
	public String fetchMovieDetailsByTitle_FallBack(String title) {
	        ValueWrapper valueWrapper = cacheManager.getCache("movie").get(title);
		    String data=null;
	        if(valueWrapper != null) {
		    	data=(String)valueWrapper.get();
		    } else { //if data is not available in cache
		    	data = "No details matched....!";
		    }
	        return data;
 	}
	
}
