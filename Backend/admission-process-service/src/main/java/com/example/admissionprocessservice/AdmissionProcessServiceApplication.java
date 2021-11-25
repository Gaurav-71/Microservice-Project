package com.example.admissionprocessservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdmissionProcessServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmissionProcessServiceApplication.class, args);
	}

}
