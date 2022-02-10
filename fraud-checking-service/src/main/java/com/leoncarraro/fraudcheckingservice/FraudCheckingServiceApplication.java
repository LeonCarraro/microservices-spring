package com.leoncarraro.fraudcheckingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FraudCheckingServiceApplication {

	public static void main(final String[] args) {
		SpringApplication.run(FraudCheckingServiceApplication.class, args);
	}

}
