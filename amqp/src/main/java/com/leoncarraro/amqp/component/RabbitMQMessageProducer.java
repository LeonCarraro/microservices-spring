package com.leoncarraro.amqp.component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class RabbitMQMessageProducer {

	private final AmqpTemplate amqpTemplate;

	public void publish(final Object payload, final String exchange, final String routingKey) {
		log.info("Publishing message to '{}' using routing key '{}'", exchange, routingKey);
		log.info("Payload: {}", payload);

		amqpTemplate.convertAndSend(exchange, routingKey, payload);

		log.info("Published message to '{}' using routing key '{}'", exchange, routingKey);
	}

}
