package com.example.demo_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCrudApplication.class, args);
	}

}
