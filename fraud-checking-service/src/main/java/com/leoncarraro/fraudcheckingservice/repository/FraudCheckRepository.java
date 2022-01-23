package com.leoncarraro.fraudcheckingservice.repository;

import com.leoncarraro.fraudcheckingservice.domain.entity.FraudCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudCheckRepository extends JpaRepository<FraudCheck, Long> {
}
