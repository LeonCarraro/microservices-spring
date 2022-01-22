package com.leoncarraro.customerservice.domain.entity;

import com.leoncarraro.customerservice.constant.DatabaseConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(schema = DatabaseConstants.SCHEMA_CUSTOMER_SERVICE, name = DatabaseConstants.TABLE_CUSTOMER)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

}
