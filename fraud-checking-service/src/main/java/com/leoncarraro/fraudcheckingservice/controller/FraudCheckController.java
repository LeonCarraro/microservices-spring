package com.leoncarraro.fraudcheckingservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leoncarraro.fraudcheckingservice.service.FraudCheckService;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class FraudCheckController {

	private final FraudCheckService fraudCheckService;

	@GetMapping("/{customerId}")
	public boolean isFraudulentCustomer(@PathVariable final Long customerId) {
		long countIsFraudulentCheck = System.currentTimeMillis();
		boolean isFraudulent = fraudCheckService.isFraudulentCustomer(customerId);
		log.info("Fraud checked in [{}ms]", System.currentTimeMillis() - countIsFraudulentCheck);
		return isFraudulent;
	}

}
