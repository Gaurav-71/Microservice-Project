package com.example.admissionselectionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaClient
public class AdmissionSelectionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmissionSelectionServiceApplication.class, args);
	}

}
