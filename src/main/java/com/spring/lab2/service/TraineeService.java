package com.spring.lab2.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.lab2.repository.TraineeRepository;
import com.spring.lab2.model.Trainee;

@Service
public class TraineeService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TraineeRepository repository;
	
	public List<Trainee> getAllTrains(){
		LOG.info("TraineeService getAllTrains");
		return repository.findAll();
	}
	
	public void insertTrain(Trainee t) {
		LOG.info("TraineeService insertTrain");
		repository.save(t);
	}
	
	public List<Trainee> getTrainsByName(String name){
		return repository.findByTraineeName(name);
	}
	
	public Trainee getTrainsById(int id){
		return repository.findById(id).get();
	}
	
	public Trainee deleteTrain(int id) {
		Trainee t = repository.findById(id).get();
		repository.delete(t);
		return t;
	}
	
	public Trainee updateTrain(Trainee t) {
		repository.save(t);
		return t;
	}
}
