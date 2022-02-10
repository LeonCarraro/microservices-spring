package com.leoncarraro.clientsopenfeign.clients.notificationservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationVO {

	private Long customerId;

	private String message;

}
