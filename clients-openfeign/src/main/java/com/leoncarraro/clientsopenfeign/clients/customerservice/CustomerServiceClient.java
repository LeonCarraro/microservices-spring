package com.leoncarraro.clientsopenfeign.clients.customerservice;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "CUSTOMER-SERVICE", path = "/api/customers")
public interface CustomerServiceClient {}
