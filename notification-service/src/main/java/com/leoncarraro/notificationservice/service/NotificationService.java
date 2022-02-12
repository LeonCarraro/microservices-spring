package com.leoncarraro.notificationservice.service;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.leoncarraro.clientsopenfeign.clients.notificationservice.NotificationVO;
import com.leoncarraro.notificationservice.domain.entity.Notification;
import com.leoncarraro.notificationservice.repository.NotificationRepository;

@Service
@AllArgsConstructor
public class NotificationService {

	private final NotificationRepository notificationRepository;

	public void send(final NotificationVO notificationVO) throws InterruptedException {
		// Simulating a slow notification push
		Thread.sleep(500);

		Notification notification = Notification.builder() //
				.customerId(notificationVO.getCustomerId()) //
				.message(notificationVO.getMessage()) //
				.sent(true) //
				.build();

		notificationRepository.save(notification);
	}

}
