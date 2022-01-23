package com.leoncarraro.customerservice.service;

import com.leoncarraro.customerservice.domain.dto.CustomerDTO;
import com.leoncarraro.customerservice.domain.entity.Customer;
import com.leoncarraro.customerservice.domain.vo.CustomerVO;
import com.leoncarraro.customerservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final RestTemplate restTemplate;

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

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE));

        ResponseEntity<Boolean> isFraudulentResponse = restTemplate.exchange(
                "http://FRAUD-CHECKING-SERVICE/api/frauds-checking/" + customer.getId(),
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                Boolean.class);

        if (Boolean.TRUE.equals(isFraudulentResponse.getBody())) {
            throw new IllegalStateException("Fraudulent customer");
        }

        // TODO: Send notification

        return CustomerDTO.builder()
                .id(customer.getId())
                .build();
    }

}
