package com.leoncarraro.customerservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leoncarraro.clientsopenfeign.clients.fraudcheckingservice.FraudCheckingServiceClient;
import com.leoncarraro.clientsopenfeign.clients.notificationservice.NotificationServiceClient;
import com.leoncarraro.clientsopenfeign.clients.notificationservice.NotificationVO;
import com.leoncarraro.customerservice.domain.dto.CustomerDTO;
import com.leoncarraro.customerservice.domain.entity.Customer;
import com.leoncarraro.customerservice.domain.vo.CustomerVO;
import com.leoncarraro.customerservice.repository.CustomerRepository;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerService {

	private final CustomerRepository customerRepository;

	private final FraudCheckingServiceClient fraudCheckingServiceClient;

	private final NotificationServiceClient notificationServiceClient;

	@Transactional
	public CustomerDTO create(final CustomerVO customerVO) {
		Customer customer = Customer.builder() //
				.firstName(customerVO.getFirstName()) //
				.lastName(customerVO.getLastName()) //
				.email(customerVO.getEmail()) //
				.build();

		log.info("Customer: {}", customer);

		// TODO: Check if email is not in use

		customer = customerRepository.save(customer);

		boolean isFraudulentResponse = fraudCheckingServiceClient.isFraudulentCustomer(customer.getId());

		if (isFraudulentResponse) {
			throw new IllegalStateException("Fraudulent customer");
		}

		// TODO: Make it async. i.e: add to a queue
		notificationServiceClient.sendNotification( //
				NotificationVO.builder() //
						.customerId(customer.getId()) //
						.message(String.format("Notification message for customer %s", customer.getFirstName())) //
						.build());

		return CustomerDTO.builder() //
				.id(customer.getId()) //
				.build();
	}

}
