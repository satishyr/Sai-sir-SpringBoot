package com.sai.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sai.entities.Patient;

public interface PatientRepository extends CrudRepository<Patient,Integer>{
    List<Patient> findAll();
}
