package com.sai.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sai.entities.LoginDetails;

public interface LoginDetailsRepository extends CrudRepository<LoginDetails,Integer>{
   
	Optional<LoginDetails>  findByUnameAndUpass(String username,String password);
}
