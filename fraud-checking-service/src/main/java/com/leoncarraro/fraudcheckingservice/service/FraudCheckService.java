package com.leoncarraro.fraudcheckingservice.service;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.leoncarraro.fraudcheckingservice.domain.entity.FraudCheck;
import com.leoncarraro.fraudcheckingservice.repository.FraudCheckRepository;

@Service
@AllArgsConstructor
@Slf4j
public class FraudCheckService {

	private final FraudCheckRepository fraudCheckRepository;

	public boolean isFraudulentCustomer(final Long customerId) {
		FraudCheck fraudCheck = FraudCheck.builder() //
				.customerId(customerId) //
				.isFraudulent(false) //
				.createdAt(LocalDateTime.now()) //
				.build();

		fraudCheckRepository.save(fraudCheck);

		return fraudCheck.isFraudulent();
	}

}
