package com.leoncarraro.notificationservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leoncarraro.clientsopenfeign.clients.notificationservice.NotificationVO;
import com.leoncarraro.notificationservice.service.NotificationService;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class NotificationController {

	private final NotificationService notificationService;

	@PostMapping
	public void sendNotification(@RequestBody final NotificationVO notificationVO) throws InterruptedException {
		log.info("Sending notification...");
		long count = System.currentTimeMillis();

		notificationService.send(notificationVO);

		log.info("Notification for customer with id {} sent in {}ms", //
				notificationVO.getCustomerId(), //
				System.currentTimeMillis() - count);
	}

}
