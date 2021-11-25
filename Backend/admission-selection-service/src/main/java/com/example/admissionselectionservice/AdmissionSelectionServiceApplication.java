package com.example.admissionselectionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdmissionSelectionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmissionSelectionServiceApplication.class, args);
	}

}
