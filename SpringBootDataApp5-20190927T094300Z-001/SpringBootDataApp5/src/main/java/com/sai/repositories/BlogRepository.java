package com.sai.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sai.entities.Blog;

public interface BlogRepository extends CrudRepository<Blog,Integer>{

}
