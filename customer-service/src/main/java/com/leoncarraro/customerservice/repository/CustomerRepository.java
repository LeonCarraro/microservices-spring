package com.leoncarraro.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leoncarraro.customerservice.domain.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {}
