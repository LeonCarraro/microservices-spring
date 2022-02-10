package com.leoncarraro.customerservice.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.leoncarraro.customerservice.constant.DatabaseConstants;

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
