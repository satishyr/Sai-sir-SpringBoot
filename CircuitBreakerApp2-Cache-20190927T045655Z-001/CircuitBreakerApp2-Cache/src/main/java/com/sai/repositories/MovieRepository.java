package com.sai.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sai.entities.Movie;

public interface MovieRepository extends CrudRepository<Movie,Integer>{

	Movie findByTitle(String title);
	
}
