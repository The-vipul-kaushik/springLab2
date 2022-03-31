package com.spring.lab2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.lab2.model.Trainee;

public interface TraineeRepository extends JpaRepository<Trainee, Integer> {

	public abstract List<Trainee> findByTraineeName(String name); 
	
}
