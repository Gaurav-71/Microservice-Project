package com.example.admissionapplicationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaClient
public class AdmissionApplicationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmissionApplicationServiceApplication.class, args);
	}

}
