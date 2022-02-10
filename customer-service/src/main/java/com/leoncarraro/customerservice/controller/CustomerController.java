package com.leoncarraro.customerservice.controller;

import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leoncarraro.customerservice.domain.dto.CustomerDTO;
import com.leoncarraro.customerservice.domain.vo.CustomerVO;
import com.leoncarraro.customerservice.service.CustomerService;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class CustomerController {

	private final CustomerService customerService;

	@PostMapping
	public CustomerDTO create(@Valid @RequestBody final CustomerVO customerVO) {
		long countCreate = System.currentTimeMillis();
		CustomerDTO customerDTO = customerService.create(customerVO);
		log.info("Created customer in [{}ms]", System.currentTimeMillis() - countCreate);
		return customerDTO;
	}

}
