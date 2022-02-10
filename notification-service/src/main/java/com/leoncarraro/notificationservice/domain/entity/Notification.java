package com.leoncarraro.notificationservice.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.leoncarraro.notificationservice.constant.DatabaseConstants;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(schema = DatabaseConstants.SCHEMA_NOTIFICATION_SERVICE, name = DatabaseConstants.TABLE_NOTIFICATION)
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long customerId;

	private String message;

	private boolean sent;

}
