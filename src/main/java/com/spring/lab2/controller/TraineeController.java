package com.spring.lab2.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.spring.lab2.model.Trainee;
import com.spring.lab2.service.TraineeService;



@RestController
@RequestMapping("/train")
public class TraineeController {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TraineeService service;
	
//  http://localhost:8088/train/get-al-trainees
	@GetMapping("/get-all-trainees")
	public ResponseEntity<List<Trainee>> getAllTrainees(){
		LOG.info("get-all-trainees");
		List<Trainee> trainList = service.getAllTrains();
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "All Trainees are found successfully.");
		ResponseEntity<List<Trainee>> response = new ResponseEntity<>(trainList, headers, HttpStatus.OK);
		return response;
	}

	//  http://localhost:8088/train/insert-trainee
	@PostMapping("/insert-trainee")
	public ResponseEntity<Trainee> insertTrainee(@RequestBody Trainee t){
		LOG.info("TraineeController insertTrainee");
		service.insertTrain(t);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Trainee inserted successfully.");
		ResponseEntity<Trainee> response = new ResponseEntity<Trainee>(t, headers, HttpStatus.OK);
		return response;
	}
	
//  http://localhost:8088/train/get-trainees-by-name/sonu
	@GetMapping("/get-trainees-by-name/{name}")
	public ResponseEntity<List<Trainee>> getTraineesByName(@PathVariable String name){
		LOG.info("get-trainees-by-name");
		List<Trainee> trainList = service.getTrainsByName(name);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "All Trainees are found successfully.");
		ResponseEntity<List<Trainee>> response = new ResponseEntity<>(trainList, headers, HttpStatus.OK);
		return response;
	}
	
//  http://localhost:8088/train/get-trainees-by-id/1
	@GetMapping("/get-trainees-by-id/{traineeId}")
	public ResponseEntity<Trainee> getTraineesById(@PathVariable int traineeId){
		LOG.info("get-trainees-by-Id");
		Trainee trainee = service.getTrainsById(traineeId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "All Trainees are found successfully.");
		ResponseEntity<Trainee> response = new ResponseEntity<>(trainee, headers, HttpStatus.OK);
		return response;
	}

//  http://localhost:8088/train/delete-trainee-by-id/1
	@DeleteMapping("/delete-trainee-by-id/{traineeId}")
	public ResponseEntity<Trainee> deleteTraineeById(@PathVariable int traineeId){
		LOG.info("delete-trainee-by-Id");
		Trainee trainee = service.deleteTrain(traineeId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "deleted successfully.");
		ResponseEntity<Trainee> response = new ResponseEntity<>(trainee, headers, HttpStatus.OK);
		return response;
	}

//  http://localhost:8088/train/update-trainee
	@PutMapping("/update-trainee")
	public ResponseEntity<Trainee> deleteTraineeById(@RequestBody Trainee t){
		LOG.info("update-trainee");
		Trainee trainee = service.updateTrain(t);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "updated successfully.");
		ResponseEntity<Trainee> response = new ResponseEntity<>(trainee, headers, HttpStatus.OK);
		return response;
	}


	

}
