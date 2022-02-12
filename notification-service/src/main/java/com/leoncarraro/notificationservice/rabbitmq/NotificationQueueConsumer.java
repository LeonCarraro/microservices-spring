package com.leoncarraro.notificationservice.rabbitmq;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.leoncarraro.amqp.configuration.AMQPConfiguration;
import com.leoncarraro.clientsopenfeign.clients.notificationservice.NotificationVO;
import com.leoncarraro.notificationservice.service.NotificationService;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationQueueConsumer {

	private final NotificationService notificationService;

	private final AMQPConfiguration amqpConfiguration;

	@RabbitListener(queues = "${application.amqp.rabbitmq.queue.name}")
	public void consume(final NotificationVO notificationVO) throws InterruptedException {
		log.info("Received message from {}", amqpConfiguration.getRabbitmq().getQueue().getName());
		notificationService.send(notificationVO);
		log.info("Message consumed succesfully");
	}

}
