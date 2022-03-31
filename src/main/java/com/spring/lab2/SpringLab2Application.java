package com.spring.lab2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SpringLab2Application {

	private static final Logger LOG = LoggerFactory.getLogger(SpringLab2Application.class);
			
	public static void main(String[] args) {
		
		LOG.info("STARTED");
		SpringApplication.run(SpringLab2Application.class, args);
		LOG.info("END");
	}

}
