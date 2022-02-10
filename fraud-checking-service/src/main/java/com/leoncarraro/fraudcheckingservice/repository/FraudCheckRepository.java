package com.leoncarraro.fraudcheckingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leoncarraro.fraudcheckingservice.domain.entity.FraudCheck;

@Repository
public interface FraudCheckRepository extends JpaRepository<FraudCheck, Long> {}
