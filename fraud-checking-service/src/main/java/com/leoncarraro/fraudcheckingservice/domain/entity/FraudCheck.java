package com.leoncarraro.fraudcheckingservice.domain.entity;

import com.leoncarraro.fraudcheckingservice.constant.DatabaseConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(schema = DatabaseConstants.SCHEMA_FRAUD_CHECKING_SERVICE, name = DatabaseConstants.TABLE_FRAUD_CHECK)
public class FraudCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private boolean isFraudulent;

    private LocalDateTime createdAt;

}
