package com.leoncarraro.clientsopenfeign.clients.fraudcheckingservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "FRAUD-CHECKING-SERVICE", path = "/api/frauds-checking")
public interface FraudCheckingServiceClient {

	@GetMapping(value = "/{customerId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	boolean isFraudulentCustomer(@PathVariable(name = "customerId") final Long customerId);

}
