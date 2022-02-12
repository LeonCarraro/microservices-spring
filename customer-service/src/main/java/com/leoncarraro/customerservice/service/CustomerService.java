package com.leoncarraro.customerservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leoncarraro.amqp.component.RabbitMQMessageProducer;
import com.leoncarraro.amqp.configuration.AMQPConfiguration;
import com.leoncarraro.clientsopenfeign.clients.fraudcheckingservice.FraudCheckingServiceClient;
import com.leoncarraro.clientsopenfeign.clients.notificationservice.NotificationVO;
import com.leoncarraro.customerservice.domain.dto.CustomerDTO;
import com.leoncarraro.customerservice.domain.entity.Customer;
import com.leoncarraro.customerservice.domain.vo.CustomerVO;
import com.leoncarraro.customerservice.repository.CustomerRepository;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerService {

	private final RabbitMQMessageProducer rabbitMQMessageProducer;

	private final AMQPConfiguration amqpConfiguration;

	private final FraudCheckingServiceClient fraudCheckingServiceClient;

	private final CustomerRepository customerRepository;

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

		NotificationVO notificationVO = NotificationVO.builder() //
				.customerId(customer.getId()) //
				.message(String.format("Notification message for customer %s", customer.getFirstName())) //
				.build();

		rabbitMQMessageProducer.publish(notificationVO, //
				amqpConfiguration.getRabbitmq().getExchange().getName(), //
				amqpConfiguration.getRabbitmq().getRoutingKey().getInternalNotification());

		return CustomerDTO.builder() //
				.id(customer.getId()) //
				.build();
	}

}
