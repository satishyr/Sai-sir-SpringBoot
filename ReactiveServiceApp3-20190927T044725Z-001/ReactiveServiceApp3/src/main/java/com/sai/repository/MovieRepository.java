package com.sai.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.sai.model.Movie;

public interface MovieRepository extends ReactiveCrudRepository<Movie,String> {

}
