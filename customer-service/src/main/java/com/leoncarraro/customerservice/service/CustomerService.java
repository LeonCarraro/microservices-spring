package com.leoncarraro.customerservice.service;

import com.leoncarraro.clientsopenfeign.clients.fraudcheckingservice.FraudCheckingServiceClient;
import com.leoncarraro.customerservice.domain.dto.CustomerDTO;
import com.leoncarraro.customerservice.domain.entity.Customer;
import com.leoncarraro.customerservice.domain.vo.CustomerVO;
import com.leoncarraro.customerservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final FraudCheckingServiceClient fraudCheckingServiceClient;

    @Transactional
    public CustomerDTO create(CustomerVO customerVO) {
        Customer customer = Customer.builder()
                .firstName(customerVO.getFirstName())
                .lastName(customerVO.getLastName())
                .email(customerVO.getEmail())
                .build();

        log.info("Customer: {}", customer);

        // TODO: Check if email is not in use

        customer = customerRepository.save(customer);

        boolean isFraudulentResponse = fraudCheckingServiceClient.isFraudulentCustomer(customer.getId());

        if (Boolean.TRUE.equals(isFraudulentResponse)) {
            throw new IllegalStateException("Fraudulent customer");
        }

        // TODO: Send notification

        return CustomerDTO.builder()
                .id(customer.getId())
                .build();
    }

}
